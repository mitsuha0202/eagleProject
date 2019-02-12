package com.kh.eg.myPage.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.myPage.model.dao.MyPageDao;
import com.kh.eg.myPage.model.vo.MyPageBoard;

@Service
public class MyPageServiceImpl implements MyPageService{
	@Autowired
	private MyPageDao md;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<MyPageBoard> selectMessage(String memberNo) {
		
		return md.selectMessage(sqlSession, memberNo);
	}

	@Override
	public int deleteMessage(int[] deleteNum) {
		int result = md.deleteMessage(sqlSession, deleteNum);
		return result;
	}
	

}
