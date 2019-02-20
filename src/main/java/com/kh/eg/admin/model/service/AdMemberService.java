package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;

public interface AdMemberService {
	
	int getListCount() throws AdMemberselectException;

	ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> selectBlackList(PageInfo pi) throws AdMemberselectException;

	int getBlackListCount() throws AdMemberselectException;

	int getSearchListCount(SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchMemberList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int getSearchBlackListCount(SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchBlackList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> memberMoneyList(PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> searchMoneyList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;


	

}
