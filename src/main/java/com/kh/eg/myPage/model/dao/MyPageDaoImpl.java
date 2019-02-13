package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.myPage.model.vo.MyPageBoard;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	//1대1 문의함 게시글들 조회
	@Override
	public ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, String memberNo) {
		
		return (ArrayList)sqlSession.selectList("MyPage.selectMessage", memberNo);
	}
	
	//1대1 문의함 게시글 삭제
	@Override
	public int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum) {
		int result1 = 0;
		int result2 = 0;
		for(int i=0; i<deleteNum.length; i++) {
			result1 = sqlSession.delete("MyPage.deleteReply", deleteNum[i]);
			result2 = sqlSession.delete("MyPage.deleteMessage", deleteNum[i]);
		}
		int result = 0;
		if(result1 > 0 && result2 > 0) {
			result = 1;
		}
		return result;
	}

	//1대1 문의함 게시글 등록
	@Override
	public int insertMessage(SqlSessionTemplate sqlSession, MyPageBoard myPage) {
		
		return sqlSession.insert("MyPage.insertMessage", myPage);
	}
	
	//1대1 게시글 검색
	@Override
	public ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, String search, String searchTitle) {
			
		return (ArrayList)sqlSession.selectList("MyPage.searchMessage", searchTitle);
	}
}