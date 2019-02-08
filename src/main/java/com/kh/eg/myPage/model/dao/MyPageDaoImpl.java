package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.myPage.model.vo.MyPageBoard;

public class MyPageDaoImpl implements MyPageDao{

	@Override
	public ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession) {
		
		return null;
	}

}
