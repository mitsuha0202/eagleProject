package com.kh.eg.myPage.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.myPage.model.dao.MyPageDao;
import com.kh.eg.myPage.model.vo.MyPageBoard;

@Service
public class MyPageServiceImpl implements MyPageService{
	//dao 변수
	@Autowired
	private MyPageDao md;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//1대1 문의함 게시글들 조회
	@Override
	public ArrayList<MyPageBoard> selectMessage(String memberNo) {
		return md.selectMessage(sqlSession, memberNo);
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
	

}
