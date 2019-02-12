package com.kh.eg.emoney.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.emoney.model.dao.emoneyDao;
import com.kh.eg.emoney.model.vo.emoney;

@Service
public class emoneyServiceImpl implements emoneyService {
	/*@Autowired
	private emoneyDao ed;*/
	@Autowired
	private SqlSessionTemplate sqlSession;

	//결제시 결제내역정보 인설트하는 메소드
	@Override
	public int insertEmoney(emoney em) {
		// TODO Auto-generated method stub
		return 0;
	}

	//결제 내역 리스트 메소드
	@Override
	public emoney emoneyList(emoney em) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//충전한 금액 유저에게 넣는 메소드
	@Override
	public int insertMemberCash(emoney em) {
		// TODO Auto-generated method stub
		return 0;
	}

}
