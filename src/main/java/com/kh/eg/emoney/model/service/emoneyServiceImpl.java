package com.kh.eg.emoney.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.emoney.model.dao.emoneyDao;
import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;

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
	
		System.out.println("result1 : " + result);
		
		return result;
	}

	
	//충전한 금액 유저에게 넣는 메소드
	@Override
	public int insertMemberEmoney(emoney e) {
		int result = ed.insertMemberEmoney(sqlSession, e);
		
		System.out.println("result2 : " + result);
		return result;
	}
	
	@Override
	public int updateEmoney(Member m) {
		int result = ed.updateEmoney(sqlSession, m);
		
		System.out.println("result3 : " + result);
		return result;
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


	@Override
	public ArrayList<emoney> refundEmoneyList(PageInfo pi, emoney e) {
		ArrayList<emoney> list = ed.refundEmoneyList(sqlSession, pi, e);
		return list;
	}


	@Override
	public int refundMemberEmoney(emoney e) {
		int result = ed.refundMemberEmoney(sqlSession, e);
		
		System.out.println("환급신청 잘되나? : " + result);
		
		return result;
	}


	@Override
	public int updateRefundEmoney(Member m) {
		int result = ed.updateRefundEmoney(sqlSession, m);
		
		System.out.println("환급시 업데이트잘되나? : "+ result);
		
		return result;
	}


	/*@Override
	public int selectCurrval(emoney e) {
		int result = ed.selectCurrval(sqlSession, e);
		System.out.println("서비스에서찍히나 커발");
		return result;
	}


	@Override
	public int selectNextval(emoney e) {
		int result = ed.selectNextval(sqlSession, e);
		System.out.println("서비스에서찍히나 넥스트발");
		return result;
	}
*/


	


	

}