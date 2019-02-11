package com.kh.eg.emoney.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.emoney;

public interface emoneyDao {

	int insertPay(SqlSessionTemplate sqlSession, emoney em);
	
	
	
}
