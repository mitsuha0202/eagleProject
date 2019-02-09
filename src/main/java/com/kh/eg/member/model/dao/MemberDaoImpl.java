package com.kh.eg.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//로그인 체크용 메소드
	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("Member.selectLoginUser",m);
	}

}
