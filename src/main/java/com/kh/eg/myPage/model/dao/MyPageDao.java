package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.MyPageBoard;

public interface MyPageDao {

	ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, Member m);
	
}
