package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;

public interface AdMemberService {

	int getListCount() throws AdMemberselectException;

	ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException;

}
