package com.kh.eg.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MainList;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.RatingMyPage;
import com.kh.eg.myPage.model.vo.SearchCondition;
import com.kh.eg.myPage.model.vo.WishList;

public interface MyPageService {

	//전체 게시물 수 조회용 메소드
	int getListCount(String memberNo); 
	
	//1대1 문의 게시글 조회
	ArrayList<MyPageBoard> selectMessage(PageInfo pi, String memberNo);
	
	//1대1 문의 게시글 삭제
	int deleteMessage(int[] num);
	
	//1대1 문의 게시글 등록
	int insertMessage(MyPageBoard myPage);

	//1대1 문의 게시글 검색
	ArrayList<MyPageBoard> searchMessage(PageInfo pi, HashMap<String, String> hmap);

	//게시글 개수 조회
	int countMessage(String memberNo);

	//1대1 게시판 상세보기
	MyPageBoard selectOneBoard(String boardNo);


	
	//위시리스트 등록해놓은거 검색
	ArrayList<WishList> selectWishList(String memberNo);
	
	//위시리스트 삭제
	int wishListDelete(int[] wishlistno);
	
	//회원정보 업데이트
	int updateMember(Member member);

	//회원정보 삭제
	int deleteUserInfo(String mid);

	//계좌등록,변경
	int updateAccount(Maccount maccount);

	//계좌조회
	Maccount selectAccount(Member m);

	//유저정보 수정시 원래 정보 조회
	Member selectMember(Member temp);

	//문의게시판 페이징 처리
	int getQueryListCount(String memberNo);

	//문의게시판 조회
	ArrayList<MyPageBoard> selectQueryBoard(PageInfo pi, String memberNo);

	//문의게시판 상세보기
	MyPageBoard selectOneQuery(String boardNo);

	//쪽지함 검색 페이징 처리
	int getListSearchMessageCount(HashMap<String, String> hmap);

	//구매관리 입찰중 물품 갯수 
	int countPayListMain(String userId);

	//구매관리 입찰중 물품 리스트 조회
	ArrayList<PayTable> selectPayList(PageInfo pi, String mid);
	
	//구매관리 입찰중 물품 리스트 페이징 처리
	int getPayListCount(String mid);
	
	//문의받은게시판 조회
	ArrayList<AnswerBoard> answerBoard(String memberNo);

	//문의게시판 검색 페이징 
	int getSearchQueryCount(HashMap<String, String> hmap);

	//문의게시판 검색 
	ArrayList<MyPageBoard> searchQuery(PageInfo pi, HashMap<String, String> hmap);
	
	//문의받은게시판 상세 조회
	ArrayList<AnswerBoard> answerBoardDetail(String searchTitle);
	
	//답변페이지 게시판번호 물품번호조회
	AnswerBoard reanswerDetail(String answerno);

	//구매관리 입찰중 물품 차순위 갯수
	int countPayListSecond(String userId);

	//낙찰받은 물품 페이징처리
	int getWinBidListCount(String mid);

	//마감된 경매중 낙찰된 물품 갯수 
	int countExitAuction(String userId);

	//낙찰받은 물품 목록
	ArrayList<PayTable> selectWinBid(PageInfo pi, String mid);
	
	//문의받은게시판 - 답변페이지 등록
	int answerBoardInsert(AnswerBoard answer);
	
	//문의받은게시판 페이징 처리
	int getSearchResultListCount(SearchCondition sc);
	
	//문의받은 게시판 페이징처리후 리스트결과
	ArrayList<AnswerBoard> selectSearchResultList(SearchCondition sc, PageInfo pi);

	//최고 순위 입찰중 물품
	int countPayListFirst(String userId);

	//낙찰받지 못한 물품 페이징
	int getFalseBidListCount(String mid);

	//낙찰받지 못한 물품 목록 조회
	ArrayList<PayTable> selectFalseBidList(PageInfo pi, String mid);

	//입금요청 물품 리스트 페이징
	int getPayContinueList( String string);

	//입금요청 물품 리스트 조회
	ArrayList<PayTable> selectPayContinueList(PageInfo pi, String mid);
	
	//마이페이지 - 회원등급확인
	ArrayList<RatingMyPage> selectRating(String memberNo);

	//배송요청 페이징 처리
	int getDeliveryListCount(String mid);
	
	//배송요청 목록 조회
	ArrayList<PayTable> selectDelivery(String mid, PageInfo pi);

	//배송중 페이징 처리
	int getShippingListCount(String mid);

	//배송중 목록 조회
	ArrayList<PayTable> selectShipping(String mid, PageInfo pi);

	//구매결정대기 페이징 처리
	int getWaitingListCount(String mid);
	
	//구매결정대기 목록 조회
	ArrayList<PayTable> selectWaiting(String mid, PageInfo pi);

	//수령이후 입금예정 페이징
	int getAfterSend(String mid);

	//수령이후 입금예정 목록 조회
	ArrayList<PayTable> selectAfterSend(String mid, PageInfo pi);

	//구매거부 페이징 처리
	int getPurchaseOther(String mid, String itemNo, String currentPrice);

	//구매거부 매개변수 없을때 페이징
	int getPurchaseOtherNoparam(String mid);

	//구매거부 목록 조회
	ArrayList<PayTable> selectPurChaseNoParam(PageInfo pi, String mid);

	//반품 페이징 처리
	int getReturn(String mid, String itemNo, String currentPrice);

	//반품 페이징 처리
	int getReturnNoparam(String mid);

	//반품 매개변수 없는 목록 조회
	ArrayList<PayTable> selectReturnList(PageInfo pi, String mid);

	//미입금 페이징 처리
	int getNoPayment(String mid, String itemNo, String currentPrice);

	//미입금 매개변수 없는 페이징 처리
	int getNoPaymentNoparam(String mid);
	
	//미입금 목록 조회
	ArrayList<PayTable> selectNoPaymentList(PageInfo pi, String mid);

	//판매거부 페이징
	int getRefuseSell(String mid);

	//판매거부 목록 조회
	ArrayList<PayTable> selectRefuseSellList(PageInfo pi, String mid);

	//미수령 신고 페이징
	int getNotReceiving(String mid, String itemNo, String currentPrice);

	//미수령 신고 매개변수 없는 페이징
	int getNotReceivingNoparam(String mid);

	//미수령 신고 목록 조회
	ArrayList<PayTable> selectNotReceivingList(PageInfo pi, String mid);

	//거래완료 페이징
	int getTransactionComplete(String mid);

	//거래완료 목록 조회
	ArrayList<PayTable> selectTransactionComplete(String mid, PageInfo pi);

	//판매관리 메인 페이지 페이징
	int getSaleStatus(String mid);

	//판매관리 메인 페이지 목록 조회
	ArrayList<PayTable> selectSaleStatusList(PageInfo pi, String mid);

	//판매관리 경매종료 페이징
	int getEndOfSale(String mid);

	//판매관리 경매종료 목록 조회
	ArrayList<PayTable> selectEndOfSaleList(PageInfo pi, String mid);

	//판매관리 거래신청 있는 페이징
	int getBidderItem(String mid);

	//판매관리 거래신청 목록 조회
	ArrayList<PayTable> selectBidderItemList(PageInfo pi, String mid);

	//판매관리 입금신청 페이징
	int getSalesItemProgress(String mid, String itemNo, String currentPrice);

	//판매관리 입금요청 매개변수 없는 페이징
	int getSalesItemProgressNoParam(String mid);

	//판매관리 입금신청 목록 조회
	ArrayList<PayTable> selectSalesItemProgressList(PageInfo pi, String mid);

	//판매관리 배송요청 페이징
	int getRequestDeliverySale(String mid);

	//판매관리 배송요청 목록 조회
	ArrayList<PayTable> selectRequestDeliverySaleList(PageInfo pi, String mid);

	//구매자 거래신청 winbid에 insert
	int insertDeal(String mid, String[] itemNo, String[] curList);

	//판매관리 구매결정대기 페이징
	int getSaleWaiting(String mid);

	//판매관리 구매결정대기 목록 조회
	ArrayList<PayTable> selectSaleWaitingList(PageInfo pi, String mid);

	//판매관리 수령이후 송금 페이징
	int getAfterReceipt2(String mid);

	//판매관리 수령이후 송금 목록 조회
	ArrayList<PayTable> selectAfterReceipt2List(PageInfo pi, String mid);

	//판매관리 거래완료 페이징
	int getTransactionSale(String mid);

	//판매관리 거래완료 목록 조회
	ArrayList<PayTable> selectTransactionSaleList(PageInfo pi, String mid);

	//판매관리 구매거부 페이징
	int getSaleOther(String mid);

	//판매관리 구매거부 목록 조회
	ArrayList<PayTable> selectSaleOtherList(PageInfo pi, String mid);

	//판매관리 반품 페이징
	int getReturnSale(String mid);

	//판매관리 반품 목록 조회
	ArrayList<PayTable> selectReturnSaleList(PageInfo pi, String mid);

	//판매관리 미입금 페이징
	int getPaymentSale(String mid);

	//판매관리 미입금 목록 조회
	ArrayList<PayTable> selectPaymentSaleList(PageInfo pi, String mid);

	//판매관리 판매거부 insert 페이징
	int getRefuseToSell2(String mid, String itemNo, String currentPrice);

	//판매관리 판매거부 페이징
	int getRefuseToSell2NoParam(String mid);

	//판매관리 판매거부 목록 조회
	ArrayList<PayTable> selectRefuseToSell2List(PageInfo pi, String mid);

	//판매관리 미수령 신고 페이징
	int getNotReceving2(String mid);

	//판매관리 미수령 신고 목록 조회
	ArrayList<PayTable> selectNotReceiving2List(PageInfo pi, String mid);

	//마이페이지 메인에 부를 리스트
	ArrayList<MainList> getList(String mid);

}
