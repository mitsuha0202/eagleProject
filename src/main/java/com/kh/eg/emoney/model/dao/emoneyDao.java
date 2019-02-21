package com.kh.eg.emoney.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;

public interface emoneyDao {

	int insertEmoney(SqlSessionTemplate sqlSession, emoney e);
	
	emoney emoneyList(SqlSessionTemplate sqlSession, emoney e);
	
	int insertMemberCash(SqlSessionTemplate sqlSession, emoney e);
	
	emoney selectMemberNowCash(SqlSessionTemplate sqlSession, emoney e);

	ArrayList<emoney> selectEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e);

	int getlistCount(SqlSessionTemplate sqlSession, emoney e);
	
	
	
}
