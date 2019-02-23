package com.kh.eg.emoney.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;

public interface emoneyDao {

	int insertEmoney(SqlSessionTemplate sqlSession, emoney e);
	
	int insertMemberEmoney(SqlSessionTemplate sqlSession, emoney e);

	ArrayList<emoney> selectEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e);

	int getlistCount(SqlSessionTemplate sqlSession, emoney e);

	int updateEmoney(SqlSessionTemplate sqlSession, Member m);

	ArrayList<emoney> refundEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e);

	int refundMemberEmoney(SqlSessionTemplate sqlSession, emoney e);

	int updateRefundEmoney(SqlSessionTemplate sqlSession, Member m);
	
	int selectCurrval(SqlSessionTemplate sqlSession, emoney e);
	
	int selectNextval(SqlSessionTemplate sqlSession, emoney e);

	
	
	
}