package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.admin.model.dao.AdMemberDao;
import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.exception.AdSearchMemberException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;

@Service
public class AdMemberServiceImpl implements AdMemberService{
	@Autowired
	private AdMemberDao amd;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//페이징 카운트
	@Override
	public int getListCount() throws AdMemberselectException {
		int listCount = amd.getListCount(sqlSession);
		return listCount;
	}
	
	//회원목록조회
	@Override
	public ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException {
		
		ArrayList<AdminVo> list = amd.selectMemberList(sqlSession, pi);
		
		return list;
	}
	
	//블랙리스트 목록조회
	@Override
	public ArrayList<AdminVo> selectBlackList(PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.selectBlackList(sqlSession, pi);
		
		return list;
	}
	
	//블랙리스트 페이징 카운트
	@Override
	public int getBlackListCount() throws AdMemberselectException {
		int listCount = amd.getBlackListCount(sqlSession);
		return listCount;
	}

	@Override
	public ArrayList<AdminVo> searchMemberList(SearchCondition sc, PageInfo pi) throws AdSearchMemberException {
		ArrayList<AdminVo> list = amd.searchMemberList(sqlSession, sc, pi);
		
		return list;
	}
	
	
	

}
