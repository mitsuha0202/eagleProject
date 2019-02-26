package com.kh.eg.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
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
	int getPayContinueList( String[] itemNo);

	//입금요청 물품 리스트 조회
	ArrayList<PayTable> selectPayContinueList(PageInfo pi, String mid, String[] itemNo, String[] curList);

	//입금요청 아이템번호 없을시
	int getPayContinueList2(String mid);
	//입금요청 아이템번호 없을시
	ArrayList<PayTable> selectPayContinueList2(PageInfo pi, String mid);
	

	//마이페이지 - 회원등급확인
	ArrayList<RatingMyPage> selectRating(String memberNo);

	//배송요청 페이징 처리
	int getDeliveryListCount(String mid);
	
	ArrayList<PayTable> selectDelivery(String mid, PageInfo pi);


	
	
	
	
	
}
