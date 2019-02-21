package com.kh.eg.emoney.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.emoney.model.dao.emoneyDao;
import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;

@Service
public class emoneyServiceImpl implements emoneyService {
	@Autowired
	private emoneyDao ed;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private DataSourceTransactionManager transactionManager;

	//결제시 결제정보 인설트하는 메소드
	@Override
	public int insertEmoney(emoney e) {
		
		int result = ed.insertEmoney(sqlSession, e);
		return result;
	}

	
	//충전한 금액 유저에게 넣는 메소드
	@Override
	public int insertMemberCash(emoney e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//현재 유저의 보유금액 출력 메소드
	@Override
	public emoney selectMemberNowCash(emoney e) {
		// TODO Auto-generated method stub
		return null;
	}

	//결제 내역 리스트
	@Override
	public ArrayList<emoney> selectEmoneyList(PageInfo pi, emoney e) {
		ArrayList<emoney> list = ed.selectEmoneyList(sqlSession, pi, e);
		return list;
	}

	//결제 내역 수 조회용 메소드
	@Override
	public int getListCount(emoney e) {
		int listCount = ed.getlistCount(sqlSession, e);
		
		return listCount;
	}


	


	

}
