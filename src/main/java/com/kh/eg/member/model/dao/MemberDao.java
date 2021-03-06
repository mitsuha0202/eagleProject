package com.kh.eg.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	Member selectMember(SqlSessionTemplate sqlSession, Member m);

	int idDuplicationCheck(SqlSessionTemplate sqlSession, String userId);

	int emailDuplicationCheck(SqlSessionTemplate sqlSession, String email);

	int insertSnsUser(SqlSessionTemplate sqlSession, Member m);

	String selectEncPassword(SqlSessionTemplate sqlSession, Member m);

	int insertNaverUser(SqlSessionTemplate sqlSession, Member m);

}
