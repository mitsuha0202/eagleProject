package com.kh.eg.secondAdmin.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.dao.SecondAdminDao;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@Service
public class SecondAdminSerivceImpl implements SecondAdminService{
	@Autowired
	private SecondAdminDao sad;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public Member loginAdmin(SecondAdmin sa) {
		
		return sad.loginAdminCheck(sqlSession, sa);
	}
	
	
}
