package com.kh.eg.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Member.insertMember", m);
	}
	
	//로그인 체크용 메소드
	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("Member.selectLoginUser",m);
	}

	@Override
	public int idDuplicationCheck(SqlSessionTemplate sqlSession, String userId) {
		int result = 0;
		result = sqlSession.selectOne("Member.DuplicationCheck",userId);
		System.out.println("DaoResult : " + result);
		
		return result;
	}

	@Override
	public int emailDuplicationCheck(SqlSessionTemplate sqlSession, String email) {
		int result = 0;
		result = sqlSession.selectOne("Member.emailDuplicationCheck",email);
		System.out.println("EmailDaoResult : " + result);
		
		return result;
	}

	@Override
	public int insertSnsUser(SqlSessionTemplate sqlSession, Member m) {
		
		int result = sqlSession.insert("Member.insertSnsUser",m);
		return result;
	}

	@Override
	public String selectEncPassword(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("Member.selectPwd", m.getUserId());
	}

	@Override
	public int insertNaverUser(SqlSessionTemplate sqlSession, Member m) {
		int result = sqlSession.insert("Member.insertNaverUser",m);
		return result;
	}

}
