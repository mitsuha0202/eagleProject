package com.kh.eg.secondAdmin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@Repository
public class SecondAdminDaoImpl implements SecondAdminDao{

	@Override
	public Member loginAdminCheck(SqlSessionTemplate sqlSession, SecondAdmin sa) {
		 
		return sqlSession.selectOne("Member.adminCheck",sa);
	}

}
