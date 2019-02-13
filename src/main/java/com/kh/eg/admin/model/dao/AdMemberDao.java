package com.kh.eg.admin.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;

public class AdMemberDao {

	public int getListCount(SqlSession session) throws AdMemberselectException {
		
		int result = session.selectOne("AdminVo.selectListCount");
		
		if(result <= 0) {
			session.close();
			throw new AdMemberselectException("게시글 수 조회 실패!");
		}
		
		return result;
	}

	public ArrayList<AdminVo> selectMemberList(SqlSession session, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectMemberList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패");
		}
		
		return list;
	}

}
