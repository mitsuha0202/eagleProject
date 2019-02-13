package com.kh.eg.emoney.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.emoney;

public interface emoneyDao {

	int insertEmoney(SqlSessionTemplate sqlSession, emoney em);
	
	emoney emoneyList(SqlSessionTemplate sqlSession, emoney em);
	
	int insertMemberCash(SqlSessionTemplate sqlSession, emoney em);
	
	emoney selectMemberNowCash(SqlSessionTemplate sqlSession, emoney em);
	
	
	
}
