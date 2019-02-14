package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.WishList;

public interface MyPageDao {

	//1대1 게시글들 조회
	ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, String memberNo);
	
	//1대1 게시글 삭제
	int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum);

	//1대1 게시글 등록
	int insertMessage(SqlSessionTemplate sqlSession, MyPageBoard myPage);

	//1대1 게시글 검색
	ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, String searchTitle, String searchTitle2);

	//게시글 개수 조회
	int countMessage(SqlSessionTemplate sqlSession, String memberNo);

	//1대1 게시글 상세보기
	MyPageBoard selectOneBoard(SqlSessionTemplate sqlSession, String boardNo);
	
	
	//위시리스트 등록해놓은거 검색
	ArrayList<WishList> selectWishList(SqlSessionTemplate sqlSession, String memberNo);
	
}
