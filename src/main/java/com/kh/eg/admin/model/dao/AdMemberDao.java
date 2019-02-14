package com.kh.eg.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.admin.model.exception.AdMemberselectException;

public interface AdMemberDao {
	int getListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;
	
}
