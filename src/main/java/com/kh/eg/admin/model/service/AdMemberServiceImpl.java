package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.admin.model.dao.AdMemberDao;
import com.kh.eg.admin.model.exception.AdMemberselectException;
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
	
	//검색 후 회원목록 페이징 카운트
	@Override
	public int getSearchListCount(SearchCondition sc) throws AdMemberselectException {
		int listCount = amd.getSearchListCount(sqlSession, sc);
		return listCount;
	}
	
	//검색 후 회원 목록 조회
	@Override
	public ArrayList<AdminVo> searchMemberList(SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.searchMemberList(sqlSession, sc , pi);
		
		return list;
	}

	@Override
	public int getSearchBlackListCount(SearchCondition sc) throws AdMemberselectException {
		int listCount = amd.getSearchBlackListCount(sqlSession, sc);
		return listCount;
	}

	@Override
	public ArrayList<AdminVo> searchBlackList(SearchCondition sc, PageInfo pi) throws AdMemberselectException  {
		ArrayList<AdminVo> list = amd.searchBlackList(sqlSession, sc , pi);
		
		return list;
	}

	@Override
	public ArrayList<AdminVo> memberMoneyList(PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.memberMoneyList(sqlSession, pi);
		return list;
	}

	@Override
	public ArrayList<AdminVo> searchMoneyList(SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.searchMoneyList(sqlSession, sc , pi);
		
		return list;
	}

	
	
	
	

}
