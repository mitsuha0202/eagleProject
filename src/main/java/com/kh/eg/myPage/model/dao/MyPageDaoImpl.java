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

	@Override
	public int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum) {
		int result1 = sqlSession.delete("MyPage.deleteReply", deleteNum);
		int result2 = sqlSession.delete("MyPage.deleteMessage", deleteNum);
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			result = 1;
		}
		return result;
	}

}
