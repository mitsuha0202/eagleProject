package com.kh.eg.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.member.model.dao.MemberDao;
import com.kh.eg.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
@Autowired
private MemberDao md;
@Autowired
private SqlSessionTemplate sqlSession;

@Autowired
private DataSourceTransactionManager transactionManager;

@Override
public int insertMember(Member m) {
	
	return md.insertMember(sqlSession, m);
}
}