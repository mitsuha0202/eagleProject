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
	int getPayContinueList(SqlSessionTemplate sqlSession, String[] itemNo);

	//입금요청 물품 리스트 조회
	ArrayList<PayTable> selectPayContinueList(SqlSessionTemplate sqlSession, PageInfo pi, String mid, String[] itemNo, String[] curList);

	int getPayContinueList2(SqlSessionTemplate sqlSession, String mid);
	//입금요청 아이템번호 없을시
	ArrayList<PayTable> selectPayContinueList2(SqlSessionTemplate sqlSession, PageInfo pi, String mid);

	//배송요청 페이징
	int getDeliveryListCount(SqlSessionTemplate sqlSession, String mid);

	//배송요청 목록 조회
	ArrayList<PayTable> selectDelivery(SqlSessionTemplate sqlSession, String mid, PageInfo pi);
	
	//마이페이지 - 회원등급확인
	ArrayList<RatingMyPage> selectRating(SqlSessionTemplate sqlSession, String memberNo);
	
	
	
	
	
	
}
