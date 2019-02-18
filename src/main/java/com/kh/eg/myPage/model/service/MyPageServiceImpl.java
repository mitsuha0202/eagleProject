package com.kh.eg.myPage.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.dao.MyPageDao;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.Query;
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
	public ArrayList<MyPageBoard> searchMessage(String search, String searchTitle) {
		
		return md.searchMessage(sqlSession, search, searchTitle);
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

}
