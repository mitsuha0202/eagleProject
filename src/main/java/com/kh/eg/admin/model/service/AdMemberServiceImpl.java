package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.kh.eg.admin.model.dao.AdMemberDao;
import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;

import static com.kh.eg.common.Template.*;

public class AdMemberServiceImpl implements AdMemberService{

	@Override
	public int getListCount() throws AdMemberselectException {
		SqlSession session = getSqlSession();
		
		int listCount = new AdMemberDao().getListCount(session);
		
		session.close();
		
		return listCount;
	}

	@Override
	public ArrayList<AdminVo> selectMemberList(PageInfo pi) throws AdMemberselectException {
		// TODO Auto-generated method stub
		return null;
	}

}
