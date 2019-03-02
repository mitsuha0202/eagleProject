package com.kh.eg.myPage.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.common.Ascending;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.RatingMyPage;
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
				
				if(list.get(i).getAuctioncode().equals("AC001")) {
					ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.searchBidRank", searchList);
					
					for(int j=0; j<temp.size(); j++) {
						if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
							list.get(i).setRowBid(temp.get(j).getRowBid());
						}
					}
				}else if(list.get(i).getAuctioncode().equals("AC002")) {
					list.get(i).setRowBid(0);
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
		HashMap<String, String> searchList = new HashMap<String, String>();		
		
		ArrayList<PayTable> itemNo = new ArrayList<PayTable>();
		
		//결과값 담기 위한 ArrayList
		ArrayList<PayTable> list = null;
		int count = sqlSession.selectOne("MyPage.winBidCountList", mid);
		
		searchList.put("mid", mid);
		itemNo = (ArrayList)sqlSession.selectList("MyPage.selectWinBidListSearchItemNo", mid, rowBounds); 

		for(int i=0; i<count; i++) {
			searchList.put("itemNo", String.valueOf(itemNo.get(i).getItemNo()));
			list = (ArrayList)sqlSession.selectList("MyPage.selectWinBidList", searchList, rowBounds);
			if(list.get(i).getAuctioncode().equals("AC001")) {
				/*WinBid winBid = (WinBid)sqlSession.selectOne("MyPage.winBidSelect", searchList);*/
					ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.selectWinBidRank", searchList);
	
					for(int j=0; j<temp.size(); j++) {
						if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
							list.get(i).setRowBid(temp.get(j).getRowBid());
						}
					}	
				
			}else if(list.get(i).getAuctioncode().equals("AC002")) {
				searchList.put("itemNo", String.valueOf(itemNo.get(i).getItemNo()));
				/*WinBid winBid = (WinBid)sqlSession.selectOne("MyPage.winBidSelect", searchList);*/
					ArrayList<PayTable> currentPrice = (ArrayList)sqlSession.selectList("MyPage.selectLuckyWinBid", searchList);
					ArrayList<Integer> price = new ArrayList<Integer>();
					for(int j=0; j<currentPrice.size(); j++) {
						price.add(Integer.parseInt(currentPrice.get(j).getCurrentPrice()));
					}
					// 오름차순 정렬
			        Ascending ascending = new Ascending();
			        Collections.sort(price, ascending);	
			        list.get(i).setCurrentPrice(String.valueOf(price.get(0)));
			
			}
		}
		return list;
	}
	
	//문의받은게시판 - 답변페이지 등록
	@Override
	public int answerBoardInsert(SqlSessionTemplate sqlSession, AnswerBoard answer) {

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
		}
		return count;
	}

	//낙찰 받지 못한 물품 페이징
	@Override
	public int getFalseBidListCount(SqlSessionTemplate sqlSession, String mid) {
		int count = 0;
		
		//아이템번호 리스트
		ArrayList<PayTable> itemNo = (ArrayList)sqlSession.selectList("MyPage.countFalseBidRank", mid);
		//키값 사용할 hashmap
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		ArrayList<PayTable> list = null;
		count = itemNo.size();
			
		return count;
	}

	//낙찰받지 못한 물품 목록
	@Override
	public ArrayList<PayTable> selectFalseBidList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		//아이템번호
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectWinBidListSearchItemNo", mid, rowBounds);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		
		for(int i=0; i<list.size(); i++) {
			PayTable lists = new PayTable();
			map.put("itemNo", String.valueOf(list.get(i).getItemNo()));
			//낙찰된 금액 조회해서 제외하기 
			PayTable pay = sqlSession.selectOne("MyPage.selectFalseBidPay", map);
			map.put("currentPrice", pay.getCurrentPrice());
			lists = sqlSession.selectOne("MyPage.countFalseBid", map);
			
			if(lists != null) {
				list.get(i).setItemName(lists.getItemName());
				list.get(i).setBidNo(lists.getBidNo());
				list.get(i).setCurrentPrice(lists.getCurrentPrice());
				list.get(i).setEndDay(lists.getEndDay());
				list.get(i).setMemberNo(lists.getMemberNo());
				list.get(i).setSaleMemberName(lists.getSaleMemberName());
			}

		}
		return list;
	}
	
	//구매자가 winbid에 거래신청 insert 
	@Override
	public int insertDeal(SqlSessionTemplate sqlSession, String mid, String[] itemNo,
			String[] curList) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		for(int i=0; i<itemNo.length; i++) {
			map.put("itemNo", itemNo[i]);
			PayTable payTable = (PayTable)sqlSession.selectOne("MyPage.selectSaleMemberNo", map);
			map.put("saleMemberNo", payTable.getMemberNo());
			map.put("price", curList[i]);
			
			result1 = sqlSession.insert("MyPage.winBidInsert", map);
			WinBid winBid = sqlSession.selectOne("MyPage.winBidSelect", map);
			map.put("dealNo", winBid.getDealNo());
			result2 = sqlSession.insert("MyPage.winBidDetailInsert", map);
		}
		
		if(result1 > 0 && result2 > 0) {
			result = 1;
		}
		
		return result;
	}

	//입금요청 물품 목록 페이징
	@Override
	public int getPayContinueList(SqlSessionTemplate sqlSession, String mid) {
		int count = 0;
		
		if(sqlSession.selectOne("MyPage.countPayContinueList", mid) == null) {
			count = 0;
		}else {
			count = sqlSession.selectOne("MyPage.countPayContinueList", mid);
		}
		return count;
	}

	//입금요청 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayContinueList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectPayContinueList", mid, rowBounds);
		
		return list;
	}
	
	//마이페이지 - 회원등급확인
	@Override
	public ArrayList<RatingMyPage> selectRating(SqlSessionTemplate sqlSession, String memberNo) {
		
		ArrayList<RatingMyPage> list = (ArrayList)sqlSession.selectList("MyPage.selectRating", memberNo);
		int result = 0;
		if(list != null) {
			if(list.get(0).getAmount()>=1000000 && list.get(0).getCount()>=6) {
				result = sqlSession.update("MyPage.selectMemberRatingVip",memberNo);
			}else if(list.get(0).getAmount()<1000000 && list.get(0).getCount()<6 && list.get(0).getAmount()>=500000 && list.get(0).getCount()>=2) {
				result = sqlSession.update("MyPage.selectMemberRatingGold",memberNo);
			}else {
				result = sqlSession.update("MyPage.selectMemberRatingNormal",memberNo);
			}
		}else {
			System.out.println("list 왔는지 : " + list.size());
		}
		return list;
		
		
		
		
		
	}
	
	

	//배송요청 페이징 처리
	@Override
	public int getDeliveryListCount(SqlSessionTemplate sqlSession, String mid) {
		
		int count = sqlSession.selectOne("MyPage.deliveryListCount", mid);
		
		return count;
	}

	//배송요청 목록 조회
	@Override
	public ArrayList<PayTable> selectDelivery(SqlSessionTemplate sqlSession, String mid, PageInfo pi) {

		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectDeliveryList", mid, rowBounds);
		return list;
	}

	//배송중 페이징 처리
	@Override
	public int getShippingListCount(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getShippingListCount", mid);
	}

	//배송중 목록 조회
	@Override
	public ArrayList<PayTable> selectShipping(SqlSessionTemplate sqlSession, String mid, PageInfo pi) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectShipping", mid, rowBounds);
	}

	//구매결정대기 페이징 처리
	@Override
	public int getWaitingListCount(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getWatingListCount", mid);
	}

	//구매결정대기 목록 조회
	@Override
	public ArrayList<PayTable> selectWaiting(SqlSessionTemplate sqlSession, String mid, PageInfo pi) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectWaiting", mid, rowBounds);
	}

	//수령이후 입금예정 페이징
	@Override
	public int getAfterSend(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getAfterSend", mid);
	}

	//수령이후 입금 목록 조회
	@Override
	public ArrayList<PayTable> selectAfterSend(SqlSessionTemplate sqlSession, String mid, PageInfo pi) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectAfterSend", mid, rowBounds);
	}

	//구매거부 페이징 처리
	@Override
	public int getPurchaseOther(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("currentPrice", currentPrice);
		map.put("saleMemberNo", (String)sqlSession.selectOne("MyPage.selectSaleMemberNo", map));
		
		int result1 = sqlSession.insert("MyPage.noPayInsert", map);
		
		int result2 = 0;
		
		if(result1 > 0) {
			map.put("dealNo", (String)sqlSession.selectOne("MyPage.winBidSelect", map));
		}
		
		if(map.get("dealNo") != null) {
			result2 = sqlSession.insert("MyPage.noPayDetailInsert", map);
		}
		
		int count = 0;
		
		if(result2 > 0) {
			count = sqlSession.selectOne("MyPage.getPurchaseOther", map);
		}
		return count;
	}

	//구매거부 매개변수 없을때 페이징
	@Override
	public int getPurchaseOtherNoParam(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getPurchaseOther", mid);
	}

	//구매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectPurChaseNoParam(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectPurChaseOther", mid, rowBounds);
	}

	//반품 페이징 
	@Override
	public int getReturn(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("currentPrice", currentPrice);
		map.put("saleMemberNo", (String)sqlSession.selectOne("MyPage.selectSaleMemberNo", map));
		
		int result1 = sqlSession.insert("MyPage.returnInsert", map);
		
		int result2 = 0;
		
		if(result1 > 0) {
			map.put("dealNo", (String)sqlSession.selectOne("MyPage.winBidSelect", map));
		}
		
		if(map.get("dealNo") != null) {
			result2 = sqlSession.insert("MyPage.returnDetailInsert", map);
		}
		
		int count = 0;
		
		if(result2 > 0) {
			count = sqlSession.selectOne("MyPage.getReturn", map);
		}
		return count;
	}

	//반품 매개변수 없는 페이징
	@Override
	public int getReturnNoParam(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getReturn", mid);
	}

	//반품 목록 조회
		@Override
		public ArrayList<PayTable> selectReturnList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
			int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
			RowBounds rowBounds = new RowBounds(offset, pi.getLimit());	
			
			return (ArrayList)sqlSession.selectList("MyPage.selectReturnList", mid, rowBounds);
		}
	
	//미입금 페이징 
	@Override
	public int getNoPayment(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("currentPrice", currentPrice);
		map.put("saleMemberNo", (String)sqlSession.selectOne("MyPage.selectSaleMemberNo", map));
		
		int result1 = sqlSession.insert("MyPage.noPaymentInsert", map);
		
		int result2 = 0;
		
		if(result1 > 0) {
			map.put("dealNo", (String)sqlSession.selectOne("MyPage.winBidSelect", map));
		}
		
		if(map.get("dealNo") != null) {
			result2 = sqlSession.insert("MyPage.noPaymentDetailInsert", map);
		}
		
		int count = 0;
		
		if(result2 > 0) {
			count = sqlSession.selectOne("MyPage.getNoPayment", map);
		}
		
		return count;
	}

	//미입금 매개변수 없는 페이징
	@Override
	public int getNoPaymentNoParam(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getNoPayment", mid);
	}

	//미입금 목록 조회
	@Override
	public ArrayList<PayTable> selectNoPaymentList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());	
		return (ArrayList)sqlSession.selectList("MyPage.selectNoPaymentList", mid, rowBounds);
	}

	//판매거부 페이징
	@Override
	public int getRefuseSell(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getRefuseSell", mid);
	}

	//판매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectRefuseSellList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());	
		return (ArrayList)sqlSession.selectList("MyPage.selectRefuseSellList", mid, rowBounds);
	}

	//미수령 신고 페이징
	@Override
	public int getNotReceiving(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("currentPrice", currentPrice);
		map.put("saleMemberNo", (String)sqlSession.selectOne("MyPage.selectSaleMemberNo", map));
		
		int result1 = sqlSession.insert("MyPage.notReceivingInsert", map);
		
		int result2 = 0;
		
		if(result1 > 0) {
			map.put("dealNo", (String)sqlSession.selectOne("MyPage.winBidSelect", map));
		}
		
		if(map.get("dealNo") != null) {
			result2 = sqlSession.insert("MyPage.notReceivingDetailInsert", map);
		}
		
		int count = 0;
		
		if(result2 > 0) {
			count = sqlSession.selectOne("MyPage.getNotReceiving", map);
		}
		
		return count;
	}

	//미수령 매개변수 없는 페이징
	@Override
	public int getNotReceivingNoParam(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getNotReceiving", mid);
	}

	//미수령 신고 목록 조회
	@Override
	public ArrayList<PayTable> selectNotReceivingList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());	
		
		return (ArrayList)sqlSession.selectList("MyPage.selectNotReceivingList", mid, rowBounds);
	}

	//거래완료 페이징
	@Override
	public int getTransactionComplete(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getTransactionComplete", mid);
	}

	//거래완료 목록 조회
	@Override
	public ArrayList<PayTable> selectTransactionComplete(SqlSessionTemplate sqlSession, String mid, PageInfo pi) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectTransactionCompleteList", mid, rowBounds);
	}

	//판매관리 메인페이지 페이징
	@Override
	public int getSaleStatus(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.saleStatus", mid);
	}

	//판매관리 메인 페이지 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleStatusList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectSaleStatusList", mid, rowBounds);
		
		map.put("mid", mid);
		for(int i=0; i<list.size(); i++) {
			map.put("itemNo", String.valueOf(list.get(i).getItemNo()));
			list.get(i).setBidCount((Integer)sqlSession.selectOne("MyPage.bidCount", map));
			ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.searchBidRank", map);
			
			for(int j=0; j<temp.size(); j++) {
				if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
					list.get(i).setCurrentPrice(temp.get(j).getCurrentPrice());
				}
			}
		}
		return list;
	}

	//판매관리 경매종료 페이징
	@Override
	public int getEndOfSale(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getEndOfSale", mid);
	}

	//판매관리 경매종료 목록 조회
	@Override
	public ArrayList<PayTable> selectEndOfSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<PayTable> list = (ArrayList)sqlSession.selectList("MyPage.selectEndOfSaleList", mid, rowBounds);
		map.put("mid", mid);
		
		for(int i=0; i<list.size(); i++) {
			map.put("itemNo", String.valueOf(list.get(i).getItemNo()));
			list.get(i).setBidCount((Integer)sqlSession.selectOne("MyPage.bidCount", map));
			ArrayList<PayTable> temp = (ArrayList)sqlSession.selectList("MyPage.searchBidRank", map);
			
			for(int j=0; j<temp.size(); j++) {
				if(list.get(i).getBidNo() == temp.get(j).getBidNo()) {
					list.get(i).setCurrentPrice(temp.get(j).getCurrentPrice());
				}
			}
		}
		return list;
	}

	//판매관리 거래신청 페이징
	@Override
	public int getBidderItem(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getBidderItem", mid);
	}

	//판매관리 거래신청 목록 조회
	@Override
	public ArrayList<PayTable> selectBidderItemList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectBidderItemList", mid, rowBounds);
	}

	//판매관리 입금신청 페이징
	@Override
	public int getSalesItemProgress(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("price", currentPrice);
		
		WinBid winBid = sqlSession.selectOne("MyPage.searchDealNo", map);
		map.put("dealNo", winBid.getDealNo());
		
		int result = sqlSession.update("MyPage.salesItemProgressUpdate", map);
		
		int count = 0;
		
		if(result > 0) {
			count = sqlSession.selectOne("MyPage.getSalesItemProgress", map);
		}
		
		return count;
	}

	//판매관리 입금요청 매개변수 없는 페이징
	@Override
	public int getSalesItemProgressNoParam(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getSalesItemProgress", mid);
	}

	//판매관리 입금신청 목록 조회
	@Override
	public ArrayList<PayTable> selectSalesItemProgressList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectSalesItemProgressList", mid, rowBounds);
	}

	//판매관리 배송요청 페이징
	@Override
	public int getRequestDeliverySale(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getRequestDeliverySale", mid);
	}

	//판매관리 배송요청 목록 조회
	@Override
	public ArrayList<PayTable> selectRequestDeliverySaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectRequestDeliverySaleList", mid, rowBounds);
	}

	//판매관리 구매결정대기 페이징
	@Override
	public int getSaleWaiting(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getSaleWaiting", mid);
	}

	//판매관리 구매결정대기 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleWaitingList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectSaleWaitingList", mid, rowBounds);
	}

	//판매관리 수령이후 송금 페이징
	@Override
	public int getAfterReceipt2(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getAfterReceipt2", mid);
	}

	//판매관리 수령이후 송금 목록 조회
	@Override
	public ArrayList<PayTable> selectAfterReceipt2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectAfterReceipt2", mid, rowBounds);
	}

	//판매관리 거래완료 페이징
	@Override
	public int getTransactionSale(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getTransactionSale", mid);
	}

	//판매관리 거래완료 목록 조회
	@Override
	public ArrayList<PayTable> selectTransactionSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectTransactionSaleList", mid, rowBounds);
	}

	//판매관리 구매거부 페이징
	@Override
	public int getSaleOther(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getSaleOther", mid);
	}

	//판매관리 구매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleOtherList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectSaleOtherList", mid, rowBounds);
	}

	//판매관리 반품 페이징
	@Override
	public int getReturnSale(SqlSessionTemplate sqlSession, String mid) {
		
		return sqlSession.selectOne("MyPage.getReturnSale", mid);
	}

	//판매관리 반품 목록 조회
	@Override
	public ArrayList<PayTable> selectReturnSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectReturnSaleList", mid, rowBounds);
	}

	//판매관리 미입금 페이징
	@Override
	public int getPaymentSale(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getPaymentSale", mid);
	}

	//판매관리 미입금 목록 조회
	@Override
	public ArrayList<PayTable> selectPaymentSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		return (ArrayList)sqlSession.selectList("MyPage.selectPaymentSaleList", mid, rowBounds);
	}

	//판매관리 판매거부 insert 페이징
	@Override
	public int getRefuseToSell2(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice) {
		int count = 0;
		int result = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("mid", mid);
		map.put("itemNo", itemNo);
		map.put("price", currentPrice);
		
		WinBid winbid = sqlSession.selectOne("MyPage.searchDealPayMemberNo", map);
		map.put("dealNo", winbid.getDealNo());
		map.put("payMemberNo", winbid.getMemberNo());
		result = sqlSession.update("MyPage.noSaleUpdate", map);
		
		if(result > 0) {
			if(sqlSession.selectOne("MyPage.getRefuseToSell2", map) == null) {
				count = 0;
			}else {
				count = sqlSession.selectOne("MyPage.getRefuseToSell2", map);
			}
		}
		
		return count;
	}

	//판매관리 판매거부 페이징
	@Override
	public int getRefuseToSell2NoParam(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getRefuseToSell2", mid);
	}

	//판매관리 판매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectRefuseToSell2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectRefuseToSell2List", mid, rowBounds);
	}

	//판매관리 미수령 신고 페이징
	@Override
	public int getNotReceiving2(SqlSessionTemplate sqlSession, String mid) {

		return sqlSession.selectOne("MyPage.getNotReceiving2", mid);
	}

	//판매관리 미수령 신고 목록 조회
	@Override
	public ArrayList<PayTable> selectNotReceiving2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectNotReceiving2List", mid, rowBounds);
	}

}