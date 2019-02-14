package com.kh.eg.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
private BCryptPasswordEncoder passwordEncoder;
@Autowired
private DataSourceTransactionManager transactionManager;
	
	@Override
	public int insertMember(Member m) {
		
		return md.insertMember(sqlSession, m);
	}
	
	//로그인용 메소드
	@Override
	public Member loginUser(Member m) {
		Member loginUser = null;
		
		String encPassword = md.selectEncPassword(sqlSession, m);
		
		if(!passwordEncoder.matches(m.getUserPwd(), encPassword)) {
			loginUser = null;
		}else {
			loginUser = md.selectMember(sqlSession, m);
		}

		return loginUser;
	}

	@Override
	public int idDuplicationCheck(String userId) {
		
		int result = 0;
		result = md.idDuplicationCheck(sqlSession,userId);
		
		return result;
	}

	@Override
	public int emailDuplicationCheck(String email) {
		int result = 0;
		result = md.emailDuplicationCheck(sqlSession,email);
		
		return result;
	}

	@Override
	public int insertKakaoUser(Member m) {
		
		int result = md.insertSnsUser(sqlSession, m);
		
		return result;
	}
}
