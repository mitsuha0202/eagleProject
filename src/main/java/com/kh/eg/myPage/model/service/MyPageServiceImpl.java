package com.kh.eg.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.dao.MyPageDao;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MainList;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.RatingMyPage;
import com.kh.eg.myPage.model.vo.SearchCondition;
import com.kh.eg.myPage.model.vo.WishList;

@Service
public class MyPageServiceImpl implements MyPageService{
	//dao 변수
	@Autowired
	private MyPageDao md;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//1대1 쪽지함 페이징 처리
	@Override
	public int getListCount(String memberNo) {
		
		return md.getListCount(sqlSession, memberNo);
	}	
	
	//1대1 문의함 게시글들 조회
	@Override
	public ArrayList<MyPageBoard> selectMessage(PageInfo pi, String memberNo) {
		return md.selectMessage(sqlSession, pi, memberNo);
	}

	//1대1 문의함 게시글 삭제
	@Override
	public int deleteMessage(int[] deleteNum) {
		int result = md.deleteMessage(sqlSession, deleteNum);
		return result;
	}
	
	//1대1 문의함 게시글 등록
	@Override
	public int insertMessage(MyPageBoard myPage) {
		int result = md.insertMessage(sqlSession, myPage);
		return result;
	}

	//1대1 문의 게시글 검색
	@Override
	public ArrayList<MyPageBoard> searchMessage(PageInfo pi, HashMap<String, String> hmap) {
		
		return md.searchMessage(sqlSession, pi, hmap);
	}
	
	//위시리스트 등록해놓은거 검색
	@Override
	public ArrayList<WishList> selectWishList(String memberNo) {
		
		return md.selectWishList(sqlSession,memberNo);
	}
	
	//위시리스트 삭제
	@Override
	public int wishListDelete(int[] wishlistno) {
		int result = md.wishListDelete(sqlSession,wishlistno);
		return result;
	}
	
	//게시글 개수 조회
	@Override
	public int countMessage(String memberNo) {
		
		return md.countMessage(sqlSession, memberNo);
	}

	//1대1 게시글 상세보기 
	@Override
	public MyPageBoard selectOneBoard(String boardNo) {
		
		return md.selectOneBoard(sqlSession, boardNo);
	}

	//회원정보 업데이트
	@Override
	public int updateMember(Member member) {
		
		return md.updateMember(sqlSession, member);
	}

	//회원정보 삭제
	@Override
	public int deleteUserInfo(String mid) {
		
		return md.deleteUserInfo(sqlSession, mid);
	}
	
	//계좌등록, 변경
	@Override
	public int updateAccount(Maccount maccount) {

		return md.updateAccount(sqlSession, maccount);
	}

	//계좌 조회
	@Override
	public Maccount selectAccount(Member m) {
		
		return md.selectAccount(sqlSession, m);
	}

	//유저정보 수정시 원래 정보 조회
	@Override
	public Member selectMember(Member temp) {
		
		return md.selectMember(sqlSession, temp);
	}

	//문의게시판 페이징 처리
	@Override
	public int getQueryListCount(String memberNo) {
		
		return md.getQueryListCount(sqlSession, memberNo);
	}

	//문의게시판 조회
	@Override
	public ArrayList<MyPageBoard> selectQueryBoard(PageInfo pi, String memberNo) {
		
		return md.selectQueryBoard(sqlSession, pi, memberNo);
	}
	
	//문의게시판 상세보기
	@Override
	public MyPageBoard selectOneQuery(String boardNo) {
		
		return md.selectOneQuery(sqlSession, boardNo);
	}

	//쪽지함 검색 페이징 처리
	@Override
	public int getListSearchMessageCount(HashMap<String, String> hmap) {
		
		return md.getListSearchMessageCount(sqlSession, hmap);
	}

	//구매관리 입찰중 물품 갯수 조회
	@Override
	public int countPayListMain(String userId) {
		
		return md.countPayListMain(sqlSession, userId);
	}

	//구매관리 입찰중 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayList(PageInfo pi, String mid) {
		
		return md.selectPayList(sqlSession, pi, mid);
	}

	//구매관리 입찰중 물품 리스트 페이징 처리
	@Override
	public int getPayListCount(String mid) {

		return md.getPayListCount(sqlSession, mid);
	}



	//문의받은게시판 조회
	@Override
	public ArrayList<AnswerBoard> answerBoard(String memberNo) {
		
		return md.answerBoard(sqlSession, memberNo);

	}


	//문의게시판 검색 페이징
	@Override
	public int getSearchQueryCount(HashMap<String, String> hmap) {
		
		return md.getSearchQueryCount(sqlSession, hmap);
	}

	//문의게시판 검색
	@Override
	public ArrayList<MyPageBoard> searchQuery(PageInfo pi, HashMap<String, String> hmap) {
		
		return md.searchQuery(sqlSession, pi, hmap);
  }
	
	//문의받은게시판 상세 조회
	@Override
	public ArrayList<AnswerBoard> answerBoardDetail(String searchTitle) {
		
		return md.answerBoardDetail(sqlSession,searchTitle);

	}
	
	//답변페이지 게시판번호 물품번호조회
	@Override
	public AnswerBoard reanswerDetail(String answerno) {
		
		return md.reanswerDetail(sqlSession,answerno);
	}

	//구매관리 입찰중 물품 차순위 갯수
	@Override
	public int countPayListSecond(String userId) {

		return md.countPayListSecond(sqlSession, userId);
	}

	//낙찰받은 물품 페이징
	@Override
	public int getWinBidListCount(String mid) {

		return md.countWinBidListCount(sqlSession, mid);
	}

	//마감된 경매중 낙찰된 물품 갯수 
	@Override
	public int countExitAuction(String userId) {

		return md.countExitAuction(sqlSession, userId);
	}

	//낙찰받은 물품 목록 조회
	@Override
	public ArrayList<PayTable> selectWinBid(PageInfo pi, String mid) {
		
		return md.selectWinBid(sqlSession, pi, mid);
	}
	
	//문의받은게시판 - 답변페이지 등록
	@Override
	public int answerBoardInsert(AnswerBoard answer) {
		
		return md.answerBoardInsert(sqlSession,answer);
	}
	
	//문의받은게시판 페이징 처리
	@Override
	public int getSearchResultListCount(SearchCondition sc) {
		int result = md.getSearchResultListCount(sqlSession, sc);
		return result;
	}
	
	//문의받은게시판 페이징 처리후 리스트결과
	@Override
	public ArrayList<AnswerBoard> selectSearchResultList(SearchCondition sc, PageInfo pi) {
		ArrayList<AnswerBoard> list = md.selectSearchResultList(sc, pi,sqlSession);
		
		
		return list;
	}

	//최고순위 입찰중 물품 갯수
	@Override
	public int countPayListFirst(String userId) {

		return md.countPayListFirst(sqlSession, userId);
	}

	//낙찰받지 못한 물품 페이징
	@Override
	public int getFalseBidListCount(String mid) {
		
		return md.getFalseBidListCount(sqlSession, mid);
	}

	//낙찰받지 못한 물품 목록 조회
	@Override
	public ArrayList<PayTable> selectFalseBidList(PageInfo pi, String mid) {
		
		return md.selectFalseBidList(sqlSession, pi, mid);
	}

	//입금요청 물품 목록 페이징 
	@Override
	public int getPayContinueList(String mid) {
		
		return md.getPayContinueList(sqlSession, mid);
	}

	//입금요청 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayContinueList(PageInfo pi, String mid) {
		
		return md.selectPayContinueList(sqlSession, pi, mid);
	}

	//마이페이지 - 회원등급확인
	@Override
	public ArrayList<RatingMyPage> selectRating(String memberNo) {
		// TODO Auto-generated method stub
		return md.selectRating(sqlSession,memberNo);
	}
	
	

	//배송요청 페이징처리
	@Override
	public int getDeliveryListCount(String mid) {

		return md.getDeliveryListCount(sqlSession, mid);
	}
	
	//배송요청 목록 조회
	@Override
	public ArrayList<PayTable> selectDelivery(String mid, PageInfo pi) {
		
		return md.selectDelivery(sqlSession, mid, pi);
	}

	//배송중 페이징 처리
	@Override
	public int getShippingListCount(String mid) {

		return md.getShippingListCount(sqlSession, mid);
	}

	//배송중 목록 조회
	@Override
	public ArrayList<PayTable> selectShipping(String mid, PageInfo pi) {
		
		return md.selectShipping(sqlSession, mid, pi);
	}

	//구매결정대기 페이징 처리
	@Override
	public int getWaitingListCount(String mid) {

		return md.getWaitingListCount(sqlSession, mid);
	}

	//구매결정대기 목록 조회
	@Override
	public ArrayList<PayTable> selectWaiting(String mid, PageInfo pi) {

		return md.selectWaiting(sqlSession, mid, pi);
	}

	//수령이후 입금 페이징
	@Override
	public int getAfterSend(String mid) {

		return md.getAfterSend(sqlSession, mid);
	}

	//수령이후 입금 목록 조회
	@Override
	public ArrayList<PayTable> selectAfterSend(String mid, PageInfo pi) {
		
		return md.selectAfterSend(sqlSession, mid, pi);
	}

	//구매거부 페이징 처리
	@Override
	public int getPurchaseOther(String mid, String itemNo, String currentPrice) {
		
		return md.getPurchaseOther(sqlSession, mid, itemNo, currentPrice);
	}

	//구매거부 매개변수 없을때 페이징
	@Override
	public int getPurchaseOtherNoparam(String mid) {

		return md.getPurchaseOtherNoParam(sqlSession, mid);
	}

	//구매거부 목록
	@Override
	public ArrayList<PayTable> selectPurChaseNoParam(PageInfo pi, String mid) {
		
		return md.selectPurChaseNoParam(sqlSession, pi, mid);
	}

	//반품 페이징
	@Override
	public int getReturn(String mid, String itemNo) {

		return md.getReturn(sqlSession, mid, itemNo);
	}

	//반품 목록 조회
	@Override
	public ArrayList<PayTable> selectReturnList(PageInfo pi, String mid) {

		return md.selectReturnList(sqlSession, pi, mid);
	}

	//반품 매개변수 없는 페이징 
	@Override
	public int getReturnNoparam(String mid) {

		return md.getReturnNoParam(sqlSession, mid);
	}

	//미입금 페이징
	@Override
	public int getNoPayment(String mid, String itemNo, String currentPrice) {

		return md.getNoPayment(sqlSession, mid, itemNo, currentPrice);
	}

	//미입금 매개변수 없는 페이징
	@Override
	public int getNoPaymentNoparam(String mid) {

		return md.getNoPaymentNoParam(sqlSession, mid);
	}
	
	//미입금 목록 조회
	@Override
	public ArrayList<PayTable> selectNoPaymentList(PageInfo pi, String mid) {
	
		return md.selectNoPaymentList(sqlSession, pi, mid);
	}

	//판매거부 페이징
	@Override
	public int getRefuseSell(String mid) {

		return md.getRefuseSell(sqlSession, mid);
	}

	//판매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectRefuseSellList(PageInfo pi, String mid) {
		
		return md.selectRefuseSellList(sqlSession, pi, mid);
	}

	//미수령 신고 페이징
	@Override
	public int getNotReceiving(String mid, String itemNo, String currentPrice) {

		return md.getNotReceiving(sqlSession, mid, itemNo, currentPrice);
	}

	//미수령 신고 매개변수 없는 페이징
	@Override
	public int getNotReceivingNoparam(String mid) {

		return md.getNotReceivingNoParam(sqlSession, mid);
	}

	//미수령 신고 목록 조회
	@Override
	public ArrayList<PayTable> selectNotReceivingList(PageInfo pi, String mid) {

		return md.selectNotReceivingList(sqlSession, pi, mid);
	}

	//거래완료 페이징
	@Override
	public int getTransactionComplete(String mid) {

		return md.getTransactionComplete(sqlSession, mid);
	}

	//거래완료 목록 조회
	@Override
	public ArrayList<PayTable> selectTransactionComplete(String mid, PageInfo pi) {
		
		return md.selectTransactionComplete(sqlSession, mid, pi);
	}

	//판매관리 메인페이지 페이징
	@Override
	public int getSaleStatus(String mid) {
		
		return md.getSaleStatus(sqlSession, mid);
	}

	//판매관리 메인페이지 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleStatusList(PageInfo pi, String mid) {

		return md.selectSaleStatusList(sqlSession, pi, mid);
	}

	//판매관리 경매종료 페이징
	@Override
	public int getEndOfSale(String mid) {

		return md.getEndOfSale(sqlSession, mid);
	}

	//판매관리 경매종료 목록 조회
	@Override
	public ArrayList<PayTable> selectEndOfSaleList(PageInfo pi, String mid) {
		
		return md.selectEndOfSaleList(sqlSession, pi, mid);
	}

	//판매관리 거래신청 페이징
	@Override
	public int getBidderItem(String mid) {

		return md.getBidderItem(sqlSession, mid);
	}

	//판매관리 거래신청 목록 조회
	@Override
	public ArrayList<PayTable> selectBidderItemList(PageInfo pi, String mid) {

		return md.selectBidderItemList(sqlSession, pi, mid);
	}

	//판매관리 입금요청 페이징
	@Override
	public int getSalesItemProgress(String mid, String itemNo, String currentPrice) {

		return md.getSalesItemProgress(sqlSession, mid, itemNo, currentPrice);
	}

	//판매관리 입금요청 매개변수 없는 페이징
	@Override
	public int getSalesItemProgressNoParam(String mid) {

		return md.getSalesItemProgressNoParam(sqlSession, mid);
	}

	//판매관리 입금신청 목록 조회
	@Override
	public ArrayList<PayTable> selectSalesItemProgressList(PageInfo pi, String mid) {

		return md.selectSalesItemProgressList(sqlSession, pi, mid);
	}

	//판매관리 배송요청 페이징
	@Override
	public int getRequestDeliverySale(String mid) {

		return md.getRequestDeliverySale(sqlSession, mid);
	}

	//판매관리 배송요청 목록 조회
	@Override
	public ArrayList<PayTable> selectRequestDeliverySaleList(PageInfo pi, String mid) {

		return md.selectRequestDeliverySaleList(sqlSession, pi, mid);
	}

	//구매자가 winbid에 거래신청 insert
	@Override
	public int insertDeal(String mid, String[] itemNo, String[] curList) {

		return md.insertDeal(sqlSession, mid, itemNo, curList);
	}

	//판매관리 구매결정대기 페이징
	@Override
	public int getSaleWaiting(String mid) {

		return md.getSaleWaiting(sqlSession, mid);
	}

	//판매관리 구매결정대기 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleWaitingList(PageInfo pi, String mid) {

		return md.selectSaleWaitingList(sqlSession, pi, mid);
	}

	//판매관리 수령이후 송금 페이징
	@Override
	public int getAfterReceipt2(String mid) {

		return md.getAfterReceipt2(sqlSession, mid);
	}

	//판매관리 수령이후 송금 목록 조회
	@Override
	public ArrayList<PayTable> selectAfterReceipt2List(PageInfo pi, String mid) {

		return md.selectAfterReceipt2List(sqlSession, pi, mid);
	}

	//판매관리 거래완료 페이징
	@Override
	public int getTransactionSale(String mid) {

		return md.getTransactionSale(sqlSession, mid);
	}

	//판매관리 거래완료 목록 조회
	@Override
	public ArrayList<PayTable> selectTransactionSaleList(PageInfo pi, String mid) {

		return md.selectTransactionSaleList(sqlSession, pi, mid);
	}

	//판매관리 구매거부 페이징
	@Override
	public int getSaleOther(String mid) {

		return md.getSaleOther(sqlSession, mid);
	}

	//판매관리 구매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectSaleOtherList(PageInfo pi, String mid) {

		return md.selectSaleOtherList(sqlSession, pi, mid);
	}

	//판매관리 반품 페이징
	@Override
	public int getReturnSale(String mid) {

		return md.getReturnSale(sqlSession, mid);
	}

	//판매관리 반품 목록 조회
	@Override
	public ArrayList<PayTable> selectReturnSaleList(PageInfo pi, String mid) {

		return md.selectReturnSaleList(sqlSession, pi, mid);
	}

	//판매관리 미입금 페이징
	@Override
	public int getPaymentSale(String mid) {

		return md.getPaymentSale(sqlSession, mid);
	}

	//판매관리 미입금 목록 조회
	@Override
	public ArrayList<PayTable> selectPaymentSaleList(PageInfo pi, String mid) {

		return md.selectPaymentSaleList(sqlSession, pi, mid);
	}

	//판매관리 판매거부 insert 페이징
	@Override
	public int getRefuseToSell2(String mid, String itemNo, String currentPrice) {

		return md.getRefuseToSell2(sqlSession, mid, itemNo, currentPrice);
	}

	//판매관리 판매거부 페이징
	@Override
	public int getRefuseToSell2NoParam(String mid) {

		return md.getRefuseToSell2NoParam(sqlSession, mid);
	}

	//판매관리 판매거부 목록 조회
	@Override
	public ArrayList<PayTable> selectRefuseToSell2List(PageInfo pi, String mid) {

		return md.selectRefuseToSell2List(sqlSession, pi, mid);
	}

	//판매관리 미수령 신고 페이징
	@Override
	public int getNotReceving2(String mid) {

		return md.getNotReceiving2(sqlSession, mid);
	}

	//판매관리 미수령 신고 목록 조회
	@Override
	public ArrayList<PayTable> selectNotReceiving2List(PageInfo pi, String mid) {

		return md.selectNotReceiving2List(sqlSession, pi, mid);
	}

	//마이페이지 메인에 띄울 리스트
	@Override
	public ArrayList<MainList> getList(String mid) {

		return md.getList(sqlSession, mid);
	}

	//판매관리 배송중 페이징
	@Override
	public int getShippingSale(String mid, String itemNo, String currentPrice) {

		return md.getShippingSale(sqlSession, mid, itemNo, currentPrice);
	}

	//판매관리 배송중 페이징
	@Override
	public int getShippingSaleNoParam(String mid) {

		return md.getShippingSaleNoParam(sqlSession, mid);
	}

	//판매관리 배송중 목록 조회
	@Override
	public ArrayList<PayTable> selectShippingSaleList(PageInfo pi, String mid) {

		return md.selectShippingSaleList(sqlSession, pi, mid);
	}

	//구매관리 구매확정 페이징
	@Override
	public int getAfterReceipt(String mid, String itemNo) {

		return md.getAfterReceipt(sqlSession, mid, itemNo);
	}

	//구매관리 구매확정 페이징
	@Override
	public int getAfterReceiptNoParam(String mid) {

		return md.getAfterReceiptNoParam(sqlSession, mid);
	}

	//구매관리 구매확정 목록 조회
	@Override
	public ArrayList<PayTable> selectAfterReceiptList(PageInfo pi, String mid) {

		return md.selectAfterReceiptList(sqlSession, pi, mid);
	}

	//구매관리 배송완료 페이징
	@Override
	public int getDeliveryCheck(String mid, String itemNo) {

		return md.getDeliveryCheck(sqlSession, mid, itemNo);
	}

	//판매관리 반품 완료 업데이트
	@Override
	public int returnFinish(String itemNo, String mid) {
		
		return md.returnFinish(sqlSession, itemNo, mid);
	}

	@Override
	public ArrayList<PayTable> searchWinList(String mid) {

		return md.searchWinList(sqlSession, mid);
	}
	
}
