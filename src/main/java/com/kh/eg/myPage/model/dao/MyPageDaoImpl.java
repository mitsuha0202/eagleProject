package com.kh.eg.myPage.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.SearchCondition;
import com.kh.eg.myPage.model.vo.WinBid;
import com.kh.eg.myPage.model.vo.WishList;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	//1대1 쪽지함 페이징 처리
	@Override
	public int getListCount(SqlSessionTemplate sqlSession, String memberNo) {
		
		return sqlSession.selectOne("MyPage.countMessage", memberNo);
	}
	
	//1대1 문의함 게시글들 조회
	@Override
	public ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, PageInfo pi, String memberNo) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectMessage", memberNo, rowBounds);
	}
	
	//1대1 문의함 게시글 삭제
	@Override
	public int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum) {
		int result = 0;
		for(int i=0; i<deleteNum.length; i++) {
			sqlSession.update("MyPage.deleteReply", deleteNum[i]);
			result = sqlSession.update("MyPage.deleteMessage", deleteNum[i]);
		}
		return result;
	}

	//1대1 문의함 게시글 등록
	@Override
	public int insertMessage(SqlSessionTemplate sqlSession, MyPageBoard myPage) {
		
		return sqlSession.insert("MyPage.insertMessage", myPage);
	}
	
	//쪽지함 검색 페이징 처리
	@Override
	public int getListSearchMessageCount(SqlSessionTemplate sqlSession, HashMap<String, String> hmap) {

		return sqlSession.selectOne("MyPage.countMessageSearch", hmap);
	}
	
	//1대1 게시글 검색
	@Override
	public ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> hmap) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());

		return (ArrayList)sqlSession.selectList("MyPage.searchMessage", hmap, rowBounds);
	}

	//위시리스트 등록해놓은거 검색
	@Override
	public ArrayList<WishList> selectWishList(SqlSessionTemplate sqlSession, String memberNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("MyPage.selectWishList", memberNo);
	}
	
	//위시리스트 삭제
	@Override
	public int wishListDelete(SqlSessionTemplate sqlSession, int[] wishlistno) {
		int result = 0;
		for(int i=0; i<wishlistno.length; i++) {
			result = sqlSession.update("MyPage.deleteWishList",wishlistno[i]);
		}
		return result;
	}

	//게시글 개수 조회
	@Override
	public int countMessage(SqlSessionTemplate sqlSession, String memberNo) {
		
		return  sqlSession.selectOne("MyPage.countMessage", memberNo); 
	}

	//1대1 게시글 상세보기 
	@Override
	public MyPageBoard selectOneBoard(SqlSessionTemplate sqlSession, String boardNo) {
		MyPageBoard myBoard = sqlSession.selectOne("MyPage.selectOneBoard", boardNo);
		myBoard.setrContents((String)sqlSession.selectOne("MyPage.selectOneReply", myBoard.getBoardNo()));
		return myBoard;

	}

	//회원정보 업데이트
	@Override
	public int updateMember(SqlSessionTemplate sqlSession, Member member) {
		
		return sqlSession.update("MyPage.updateMember", member);
	}

	//회원정보 삭제
	@Override
	public int deleteUserInfo(SqlSessionTemplate sqlSession, String mid) {
		WinBid winbid = (WinBid)sqlSession.selectList("MyPage.selectWinbid", mid);
		if(winbid != null) {
			return 0;
		}else {
			return sqlSession.update("MyPage.deleteUserInfo", mid);
		}
	}

	//계좌등록, 변경
	@Override
	public int updateAccount(SqlSessionTemplate sqlSession, Maccount maccount) {
		String mid = String.valueOf(maccount.getMid());
		Maccount temp =  sqlSession.selectOne("MyPage.selectAccount", mid);
		int result = 0;
		if(temp == null) {
			result = sqlSession.insert("MyPage.insertAccount", maccount);
			if(result > 0) {
				sqlSession.update("MyPage.updateMemberAc", maccount);
			}
		}else {
			result = sqlSession.update("MyPage.updateAccount", maccount);
			sqlSession.update("MyPage.updateMemberAc", maccount);
		}
		return result;
	}

	//계좌조회
	@Override
	public Maccount selectAccount(SqlSessionTemplate sqlSession, Member m) {
		String mid = m.getMid();
		return sqlSession.selectOne("MyPage.selectAccount", mid);
	}

	//유저정보 수정시 원래 정보 조회
	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, Member temp) {
		
		return sqlSession.selectOne("MyPage.selectMember", temp);
	}

	//문의게시판 페이징 처리
	@Override
	public int getQueryListCount(SqlSessionTemplate sqlSession, String memberNo) {
		
		return sqlSession.selectOne("MyPage.countQueryBoard", memberNo);
	}

	//문의게시판 조회
	@Override
	public ArrayList<MyPageBoard> selectQueryBoard(SqlSessionTemplate sqlSession, PageInfo pi, String memberNo) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectQueryBoard", memberNo, rowBounds);
	}

	//문의게시판 상세보기
	@Override
	public MyPageBoard selectOneQuery(SqlSessionTemplate sqlSession, String boardNo) {
		
		return sqlSession.selectOne("MyPage.selectOneQuery", boardNo);
	}

	//구매관리 입찰중 물품 갯수 조회
	@Override
	public int countPayListMain(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("MyPage.countPayListMain", userId);
	}

	//구매관리 입찰중 물품 페이징 처리
	@Override
	public int getPayListCount(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.countPayList", mid);
	}
	
	//구매관리 입찰중 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		//물품번호와 회원번호에 따른 결과 조회용 해쉬맵
		HashMap<String, String> searchList = new HashMap<String, String>();
		
		//결과값 담기위한 객체
		PayTable payTable = null;
						
		//결과값 담기 위한 ArrayList
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectContinueBidList", mid, rowBounds); 
				
		for(int i=0; i<list.size(); i++) {
			payTable = new PayTable();
			payTable.setItemNo(list.get(i).getItemNo());
			searchList.put("itemNo", String.valueOf(payTable.getItemNo()));
			int count = sqlSession.selectOne("MyPage.bidCount", searchList);
			list.get(i).setBidCount(count);
			
			ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.searchBidRank", searchList);
			
			for(int j=0; j<temp.size(); j++) {
				if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
					list.get(i).setRowBid(temp.get(j).getRowBid());
				}
			}
		}
		
		return list;
	}
	
	//문의받은게시판 조회
	@Override
	public ArrayList<AnswerBoard> answerBoard(SqlSessionTemplate sqlSession, String memberNo) {
		
		
		return (ArrayList)sqlSession.selectList("MyPage.selectanswerBoard", memberNo);

	}

	//문의게시판 검색 페이징
	@Override
	public int getSearchQueryCount(SqlSessionTemplate sqlSession, HashMap<String, String> hmap) {
		
		return sqlSession.selectOne("MyPage.searchCountQuery", hmap);
	}

	//문의게시판 검색 
	@Override
	public ArrayList<MyPageBoard> searchQuery(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> hmap) {
		
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.searchQuery", hmap, rowBounds);
	}
	
	//문의받은게시판 상세 조회
	@Override
	public ArrayList<AnswerBoard> answerBoardDetail(SqlSessionTemplate sqlSession, String searchTitle) {
		
		
		return (ArrayList)sqlSession.selectList("MyPage.selectdetailanswer", searchTitle);
	}
	//답변페이지 게시판번호 물품번호조회
	@Override
	public AnswerBoard reanswerDetail(SqlSessionTemplate sqlSession, String answerno) {
		// TODO Auto-generated method stub
		return (AnswerBoard)sqlSession.selectOne("MyPage.reanswerDetail",answerno);
	}

	//구매관리 입찰중 물품 차순위 갯수
	@Override
	public int countPayListSecond(SqlSessionTemplate sqlSession, String userId) {
		ArrayList<PayTable> itemNoList = (ArrayList)sqlSession.selectList("MyPage.countSecondSearchItemNo", userId);
		ArrayList<PayTable> list = new ArrayList<PayTable>();
		HashMap<String, String> temp = new HashMap<String, String>();
		temp.put("userId", userId);
		for(int i=0; i<itemNoList.size(); i++) {
			temp.put("itemNo", String.valueOf((itemNoList.get(i).getItemNo())));
			PayTable pay = sqlSession.selectOne("MyPage.countSecondRank", temp);
			list.add(pay);
		}
		
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getRowBid() > 1) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int countWinBidListCount(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.winBidCountList", mid);
	}

	//마감된 경매중 낙찰된 물품 갯수 
	@Override
	public int countExitAuction(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("MyPage.winBidCountList", userId);
	}

	//낙찰된 물품 목록 조회 
	@Override
	public ArrayList<PayTable> selectWinBid(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		//물품번호와 회원번호에 따른 결과 조회용 해쉬맵
		HashMap<String, Integer> searchList = new HashMap<String, Integer>();
				
		//결과값 담기위한 객체
		PayTable payTable = null;
				
		//결과값 담기 위한 ArrayList
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectWinBidList", mid, rowBounds); 
		
		for(int i=0; i<list.size(); i++) {
			payTable = new PayTable();
			payTable.setItemNo(list.get(i).getItemNo());
			searchList.put("itemNo", payTable.getItemNo());
			ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.selectWinBidRank", searchList);
			
			for(int j=0; j<temp.size(); j++) {
				if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
					list.get(i).setRowBid(temp.get(j).getRowBid());
				}
			}
		}
		return list;
	}
	
	//문의받은게시판 - 답변페이지 등록
	@Override
	public int answerBoardInsert(SqlSessionTemplate sqlSession, AnswerBoard answer) {
		// TODO Auto-generated method stub
		int result = 0;
		result = sqlSession.insert("MyPage.answerBoardInsert",answer);
		if(result>0) {
			return sqlSession.update("MyPage.answerBoardUpdate",answer);
					
		}
		return result;
		
	}
	//문의받은게시판 페이징 처리
	@Override
	public int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		int result = sqlSession.selectOne("MyPage.selectSearchResultCount",sc);
		return result;
	}
	
	//문의받은게시판 페이징 처리후 리스트결과
	@Override
	public ArrayList<AnswerBoard> selectSearchResultList(SearchCondition sc, PageInfo pi, SqlSessionTemplate sqlSession){
		ArrayList<AnswerBoard> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("MyPage.selectSearchResultList",sc,rowBounds);
		
		
	
		return list;
	}

	//최고순위 입찰중 물품 갯수 조회
	@Override
	public int countPayListFirst(SqlSessionTemplate sqlSession, String userId) {
		ArrayList<PayTable> itemNo = (ArrayList)sqlSession.selectList("MyPage.searchFirstBidItemNo", userId);
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("userId", userId);
		ArrayList<PayTable> list = null;
		int count = 0;
		for(int i=0; i<itemNo.size(); i++) {
			hmap.put("itemNo", String.valueOf(itemNo.get(i).getItemNo()));			
			list = new ArrayList<PayTable>();
			list = (ArrayList)sqlSession.selectList("MyPage.selectFirstBid", hmap);
			
			if(list.get(i).getRowBid() == 1) {
				count++;
			}
			
			/*for(int j=0; j<list.size(); j++) {
				if(list.get(j).getRowBid() == 1) {
					count++;
				}
			}*/
		}
		return count;
	}
	
	
	
}