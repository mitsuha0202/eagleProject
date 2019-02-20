package com.kh.eg.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;

public interface AdMemberDao {
	int getListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<AdminVo> selectMemberList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> selectBlackList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int getBlackListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	int getSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchMemberList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int getSearchBlackListCount(SqlSessionTemplate sqlSession, SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchBlackList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> memberMoneyList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> searchMoneyList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int blackListCheck(SqlSessionTemplate sqlSession, String string);

	int blackListoff(SqlSessionTemplate sqlSession, String string);


	

	
}
