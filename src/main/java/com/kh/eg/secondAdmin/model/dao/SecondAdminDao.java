package com.kh.eg.secondAdmin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

public interface SecondAdminDao {

	Member loginAdminCheck(SqlSessionTemplate sqlSession, SecondAdmin sa);
	
}