package com.kh.eg.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.admin.model.exception.AdMemberselectException;

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

	/*@Override
	public ArrayList<AdminVo> selectMemberList(SqlSession session, AdminVo admin){
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() - 1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectMemberList", null, rowBounds);
		
		if(list == null) {
			session.close();
			throw new AdMemberselectException("회원 조회 실패");
		}
		
		return list;
	}*/


}
