package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.WinBid;
import com.kh.eg.myPage.model.vo.WishList;

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
	
	//1대1 게시글 검색
	@Override
	public ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, PageInfo pi, String searchTitle, String memberNo) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchTitle", searchTitle);
		map.put("memberNo", memberNo);
		return (ArrayList)sqlSession.selectList("MyPage.searchMessage", map, rowBounds);
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
		}else {
			result = sqlSession.update("MyPage.updateAccount", maccount);
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

	//쪽지함 페이징 처리
	@Override
	public int getListSearchMessageCount(SqlSessionTemplate sqlSession, String searchTitle, String memberNo) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("searchTitle", searchTitle);
		map.put("memberNo", memberNo);
		return sqlSession.selectOne("MyPage.countMessageSearch", map);
	}

	//구매관리 입찰중 물품 갯수 조회
	@Override
	public int countPayListMain(SqlSessionTemplate sqlSession, String userId) {
		
		return sqlSession.selectOne("MyPage.countPayListMain", userId);
	}

	//구매관리 입찰중 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {

		return null;
	}

	//구매관리 입찰중 물품 페이징 처리
	@Override
	public int getPayListCount(SqlSessionTemplate sqlSession, String mid) {
		HashMap<String, String> itemNoList = null;
		
		PayTable payTable = null;
		
		//물품번호 arrayList로 받아 String 배열에 담고 String 배열을 hashMap에 담는다.
		ArrayList<String> list = (ArrayList)sqlSession.selectList("MyPage.itemNoSearch", mid);
		
		//물품번호 배열
		String[] itemNo = new String[list.size()];
		
		for(int i=0; i<list.size(); i++) {			
			itemNo[i] = list.get(i);
		}
		
		if(list != null) {
			
			for(int i=0; i<itemNo.length; i++) {
				itemNoList = new HashMap<String, String>();
				itemNoList.put("itemNo", itemNo[i]);
				itemNoList.put("mid", mid);
				
				/*
				int equ = (Integer)sqlSession.selectOne("MyPage.countPayListMain", itemNoList);*/
				
				//최고가
				int currentPrice = (Integer)sqlSession.selectOne("MyPage.maxCurrentPrice", itemNoList);
				
				//입찰수
				int count = (Integer)sqlSession.selectOne("MyPage.bidCount", itemNoList);
				
				//판매자 번호
				int saleMemberNo = (Integer)sqlSession.selectOne("MyPage.selectSaleMember", itemNoList);
				
				//입찰순위
				int ranking = (Integer)sqlSession.selectOne("MyPage.selectRanking", itemNoList);
				
				
				sqlSession.selectOne("MyPage.countPayList", mid);				
			}
			return 0;
		}else {
			return 0;
		}

	//문의받은게시판 조회
	@Override
	public ArrayList<AnswerBoard> answerBoard(SqlSessionTemplate sqlSession, String memberNo) {
		
		
		return (ArrayList)sqlSession.selectList("MyPage.selectanswerBoard", memberNo);

	}
	
}