package com.kh.eg.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;

public interface MemberDao {

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	Member selectMember(SqlSessionTemplate sqlSession, Member m);

}
