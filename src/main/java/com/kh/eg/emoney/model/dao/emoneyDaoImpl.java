package com.kh.eg.emoney.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.emoney;

public class emoneyDaoImpl implements emoneyDao{

	//결제하는 메소드	
	@Override
	public int insertEmoney(SqlSessionTemplate sqlSession, emoney em) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//충전 내역 리스트 메소드
	@Override
	public emoney emoneyList(SqlSessionTemplate sqlSession, emoney em) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//충전한 금액 유저에게 넣는 메소드
	@Override
	public int insertMemberCash(SqlSessionTemplate sqlSession, emoney em) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
