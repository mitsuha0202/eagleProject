package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.myPage.model.vo.MyPageBoard;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	@Override
	public ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, String memberNo) {
		
		return (ArrayList)sqlSession.selectList("MyPage.selectMessage", memberNo);
	}

}
