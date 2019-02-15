package com.kh.eg.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.exception.AdSearchMemberException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;

public interface AdMemberDao {
	int getListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<AdminVo> selectMemberList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> selectBlackList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int getBlackListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<AdminVo> searchMemberList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdSearchMemberException;

	
}
