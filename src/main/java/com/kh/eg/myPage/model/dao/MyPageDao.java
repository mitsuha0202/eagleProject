package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.model.vo.RatingMyPage;
import com.kh.eg.myPage.model.vo.SearchCondition;
import com.kh.eg.myPage.model.vo.WishList;

public interface MyPageDao {

	//1대1 쪽지함 페이징 처리
	int getListCount(SqlSessionTemplate sqlSession, String memberNo);
	
	//1대1 게시글들 조회
	ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, PageInfo pi, String memberNo);
	
	//1대1 게시글 삭제
	int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum);

	//1대1 게시글 등록
	int insertMessage(SqlSessionTemplate sqlSession, MyPageBoard myPage);

	//1대1 게시글 검색
	ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> hmap);

	//게시글 개수 조회
	int countMessage(SqlSessionTemplate sqlSession, String memberNo);

	//1대1 게시글 상세보기
	MyPageBoard selectOneBoard(SqlSessionTemplate sqlSession, String boardNo);
	
	//위시리스트 등록해놓은거 검색
	ArrayList<WishList> selectWishList(SqlSessionTemplate sqlSession, String memberNo);
	
	//위시리스트 삭제
	int wishListDelete(SqlSessionTemplate sqlSession, int[] wishlistno);

	//회원정보 업데이트
	int updateMember(SqlSessionTemplate sqlSession, Member member);

	//회원정보 삭제
	int deleteUserInfo(SqlSessionTemplate sqlSession, String mid);

	//계좌 등록, 변경
	int updateAccount(SqlSessionTemplate sqlSession, Maccount maccount);

	//계좌조회
	Maccount selectAccount(SqlSessionTemplate sqlSession, Member m);

	//유저정보 수정시 원래 정보 조회
	Member selectMember(SqlSessionTemplate sqlSession, Member temp);

	//문의게시판 페이징 처리
	int getQueryListCount(SqlSessionTemplate sqlSession, String memberNo);

	//문의게시판 조회
	ArrayList<MyPageBoard> selectQueryBoard(SqlSessionTemplate sqlSession, PageInfo pi, String memberNo);

	//문의게시판 상세보기
	MyPageBoard selectOneQuery(SqlSessionTemplate sqlSession, String boardNo);

	//쪽지함 검색 페이징 처리
	int getListSearchMessageCount(SqlSessionTemplate sqlSession, HashMap<String, String> hmap);

	//구매관리 입찰중 물품 갯수 조회
	int countPayListMain(SqlSessionTemplate sqlSession, String userId);

	//구매관리 입찰중 물품 리스트 조회
	ArrayList<PayTable> selectPayList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//구매관리 입찰중 물품 리스트 페이징 처리
	int getPayListCount(SqlSessionTemplate sqlSession, String mid);
	
	//문의 받은 게시판
	ArrayList<AnswerBoard> answerBoard(SqlSessionTemplate sqlSession, String memberNo);

	//문의게시판 검색 페이징
	int getSearchQueryCount(SqlSessionTemplate sqlSession, HashMap<String, String> hmap);

	//문의게시판 검색
	ArrayList<MyPageBoard> searchQuery(SqlSessionTemplate sqlSession, PageInfo pi, HashMap<String, String> hmap);
	
	//문의 받은 게시판 상세페이지
	ArrayList<AnswerBoard> answerBoardDetail(SqlSessionTemplate sqlSession, String searchTitle);
	
	//답변페이지 게시판번호 물품번호조회
	AnswerBoard reanswerDetail(SqlSessionTemplate sqlSession, String answerno);

	//구매관리 입찰중 물품 차순위 갯수
	int countPayListSecond(SqlSessionTemplate sqlSession, String userId);

	//낙찰받은 물품 페이징
	int countWinBidListCount(SqlSessionTemplate sqlSession, String mid);

	//마감된 경매중 낙찰된 물품 갯수 
	int countExitAuction(SqlSessionTemplate sqlSession, String userId);

	//낙찰받은 물품 목록 조회
	ArrayList<PayTable> selectWinBid(SqlSessionTemplate sqlSession, PageInfo pi, String mid);
	
	//문의받은게시판 - 답변페이지 등록
	int answerBoardInsert(SqlSessionTemplate sqlSession, AnswerBoard answer);
	
	//문의받은게시판 페이징 처리
	int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc);
	
	//문의받은게시판 페이징 처리후 리스트결과
	ArrayList<AnswerBoard> selectSearchResultList(SearchCondition sc, PageInfo pi, SqlSessionTemplate sqlSession);

	//최고순위 입찰중 물품 갯수 조회
	int countPayListFirst(SqlSessionTemplate sqlSession, String userId);

	//낙찰받지 못한 물품 페이징
	int getFalseBidListCount(SqlSessionTemplate sqlSession, String mid);

	//낙찰받지 못한 물품 목록 조회
	ArrayList<PayTable> selectFalseBidList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//입금요청 물품 목록 페이징
	int getPayContinueList(SqlSessionTemplate sqlSession, String mid);

	//입금요청 물품 리스트 조회
	ArrayList<PayTable> selectPayContinueList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//배송요청 페이징
	int getDeliveryListCount(SqlSessionTemplate sqlSession, String mid);

	//배송요청 목록 조회
	ArrayList<PayTable> selectDelivery(SqlSessionTemplate sqlSession, String mid, PageInfo pi);
	
	//마이페이지 - 회원등급확인
	ArrayList<RatingMyPage> selectRating(SqlSessionTemplate sqlSession, String memberNo);

	//배송중 페이징 처리
	int getShippingListCount(SqlSessionTemplate sqlSession, String mid);

	//배송중 목록 조회
	ArrayList<PayTable> selectShipping(SqlSessionTemplate sqlSession, String mid, PageInfo pi);

	//구매결정대기 페이징 처리
	int getWaitingListCount(SqlSessionTemplate sqlSession, String mid);

	//구매결정대기 목록 조회
	ArrayList<PayTable> selectWaiting(SqlSessionTemplate sqlSession, String mid, PageInfo pi);

	//수령이후 송금예정
	int getAfterSend(SqlSessionTemplate sqlSession, String mid);

	//수령이후 입금 목록 조회
	ArrayList<PayTable> selectAfterSend(SqlSessionTemplate sqlSession, String mid, PageInfo pi);

	//구매거부 페이징 처리
	int getPurchaseOther(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);

	//구매거부 매개변수 없을때 페이징
	int getPurchaseOtherNoParam(SqlSessionTemplate sqlSession, String mid);

	//구매거부 목록 조회
	ArrayList<PayTable> selectPurChaseNoParam(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//반품 페이징
	int getReturn(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);	

	//반품 매개변수 없는 페이징
	int getReturnNoParam(SqlSessionTemplate sqlSession, String mid);
	
	//반품 목록 조회
	ArrayList<PayTable> selectReturnList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//미입금 페이징
	int getNoPayment(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);

	//미입금 매개변수 없는 페이징
	int getNoPaymentNoParam(SqlSessionTemplate sqlSession, String mid);

	//미입금 목록 조회
	ArrayList<PayTable> selectNoPaymentList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매거부 페이징
	int getRefuseSell(SqlSessionTemplate sqlSession, String mid);

	//판매거부 목록 조회
	ArrayList<PayTable> selectRefuseSellList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//미수령 신고 페이징
	int getNotReceiving(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);

	//미수령 신고 매개변수 없는 페이징
	int getNotReceivingNoParam(SqlSessionTemplate sqlSession, String mid);

	//미수령 신고 목록 조회
	ArrayList<PayTable> selectNotReceivingList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//거래완료 페이징
	int getTransactionComplete(SqlSessionTemplate sqlSession, String mid);

	//거래완료 목록 조회
	ArrayList<PayTable> selectTransactionComplete(SqlSessionTemplate sqlSession, String mid, PageInfo pi);

	//판매관리 메인 페이지 페이징
	int getSaleStatus(SqlSessionTemplate sqlSession, String mid);

	//판매관리 메인 페이지 목록 조회
	ArrayList<PayTable> selectSaleStatusList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 경매종료 페이징
	int getEndOfSale(SqlSessionTemplate sqlSession, String mid);

	//판매관리 경매종료 목록 조회
	ArrayList<PayTable> selectEndOfSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);
	
	//판매관리 거래신청 페이징
	int getBidderItem(SqlSessionTemplate sqlSession, String mid);

	//판매관리 거래신청 목록 조회
	ArrayList<PayTable> selectBidderItemList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 입금신청 페이징
	int getSalesItemProgress(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);

	//판매관리 입금요청 매개변수 없는 페이징
	int getSalesItemProgressNoParam(SqlSessionTemplate sqlSession, String mid);

	//판매관리 입금신청 목록 조회
	ArrayList<PayTable> selectSalesItemProgressList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 배송요청 페이징
	int getRequestDeliverySale(SqlSessionTemplate sqlSession, String mid);

	//판매관리 배송요청 목록 조회
	ArrayList<PayTable> selectRequestDeliverySaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//구매자가 winbid에 거래신청 insert
	int insertDeal(SqlSessionTemplate sqlSession, String mid, String[] itemNo, String[] curList);

	//판매관리 구매결정대기 페이징
	int getSaleWaiting(SqlSessionTemplate sqlSession, String mid);

	//판매관리 구매결정대기 목록 조회
	ArrayList<PayTable> selectSaleWaitingList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 수령이후 송금 페이징
	int getAfterReceipt2(SqlSessionTemplate sqlSession, String mid);

	//판매관리 수령이후 송금 목록 조회
	ArrayList<PayTable> selectAfterReceipt2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 거래완료 페이징
	int getTransactionSale(SqlSessionTemplate sqlSession, String mid);

	//판매관리 거래완료 목록 조회
	ArrayList<PayTable> selectTransactionSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 구매거부 페이징
	int getSaleOther(SqlSessionTemplate sqlSession, String mid);

	//판매관리 구매거부 목록 조회
	ArrayList<PayTable> selectSaleOtherList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 반품 페이징
	int getReturnSale(SqlSessionTemplate sqlSession, String mid);

	//판매관리 반품 목록 조회
	ArrayList<PayTable> selectReturnSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 미입금 페이징
	int getPaymentSale(SqlSessionTemplate sqlSession, String mid);

	//판매관리 미입금 목록 조회
	ArrayList<PayTable> selectPaymentSaleList(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 판매거부 insert 페이징
	int getRefuseToSell2(SqlSessionTemplate sqlSession, String mid, String itemNo, String currentPrice);

	//판매관리 판매거부 페이징
	int getRefuseToSell2NoParam(SqlSessionTemplate sqlSession, String mid);

	//판매관리 판매거부 목록 조회
	ArrayList<PayTable> selectRefuseToSell2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//판매관리 미수령 신고 페이징
	int getNotReceiving2(SqlSessionTemplate sqlSession, String mid);

	//판매관리 미수령 신고 목록 조회
	ArrayList<PayTable> selectNotReceiving2List(SqlSessionTemplate sqlSession, PageInfo pi, String mid);
}
