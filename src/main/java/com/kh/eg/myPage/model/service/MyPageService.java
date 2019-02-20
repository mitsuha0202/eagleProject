package com.kh.eg.myPage.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
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
	
	
	
}
