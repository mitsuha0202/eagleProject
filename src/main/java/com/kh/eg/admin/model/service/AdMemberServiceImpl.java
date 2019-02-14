package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.admin.model.dao.AdMemberDao;
import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;


@Service
public class AdMemberServiceImpl implements AdMemberService{
	@Autowired
	private AdMemberDao amd;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getListCount() throws AdMemberselectException {
		int listCount = amd.getListCount(sqlSession);
		return listCount;
	}

	@Override
	public ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
