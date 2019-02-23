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
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
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
	public int getPayContinueList(String[] itemNo) {
		
		return md.getPayContinueList(sqlSession, itemNo);
	}

	//입금요청 물품 리스트 조회
	@Override
	public ArrayList<PayTable> selectPayContinueList(PageInfo pi, String mid, String[] itemNo) {
		
		return md.selectPayContinueList(sqlSession, pi, mid, itemNo);
	}
	
	
}
