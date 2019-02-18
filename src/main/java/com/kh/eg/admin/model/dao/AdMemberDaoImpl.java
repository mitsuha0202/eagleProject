package com.kh.eg.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;

@Repository
public class AdMemberDaoImpl implements AdMemberDao{

	@Override
	public int getListCount(SqlSessionTemplate session) throws AdMemberselectException{
	
		int result = session.selectOne("AdminVo.selectListCount");
		
		if(result <= 0) {
			session.close();
			throw new AdMemberselectException("게시글 수 조회 실패!");
		}
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> selectMemberList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectMemberList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public ArrayList<AdminVo> selectBlackList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectBlackList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int getBlackListCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.selectBlackListCount");
		
		if(result <= 0) {
			session.close();
			throw new AdMemberselectException("게시글 수 조회 실패!");
		}
		
		return result;
	}

	@Override
	public int getSearchListCount(SqlSessionTemplate session, SearchCondition sc) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.SearchListCount", sc);
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> searchMemberList(SqlSessionTemplate session, SearchCondition sc, PageInfo pi) throws AdMemberselectException{
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchMemberList", sc, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int getSearchBlackListCount(SqlSessionTemplate session, SearchCondition sc) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.SearchBlackListCount", sc);
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> searchBlackList(SqlSessionTemplate session, SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchBlackList", sc, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	
	
	


}
