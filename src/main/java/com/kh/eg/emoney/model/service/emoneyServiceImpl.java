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
import com.kh.eg.myPage.model.vo.WinBid;

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


	/*@Override
	public int updateRefundEmoney(Member m, emoney e) {
		int result = ed.updateRefundEmoney(sqlSession, m, e);
		
		System.out.println("환급시 업데이트잘되나? : "+ result);
		
		return result;
	}*/


	@Override
	public int selectEmoneyeSq(emoney e) {
		int result = ed.selectEmoneyeSq(sqlSession, e);
		System.out.println("시퀀스확인중 : " + result);
		return result;
	}


	@Override
	public int refundEmoneyeInsert(emoney e) {
		int result = ed.refundEmoneyeInsert(sqlSession, e);
		System.out.println("인설트 잘 되는지 확인중 : " + result);
		return result;
	}


	@Override
	public int paymentMember(Member m, emoney e) {
		int result = ed.paymentMember(sqlSession,m, e);
		
		System.out.println("result1 : " + result);
		
		return result;
	}


	@Override
	public int paymentInsert(emoney e, WinBid w) {
		int result = ed.paymentInsert(sqlSession, e, w);
		System.out.println("result2 : " + result);
		return result;
	}

	//마이페이지 결제(입금 요청)
	@Override
	public int paymentA(String id, String itemNo , String currentPrice) {
		int result = ed.paymentA(sqlSession,id,itemNo , currentPrice);
		
		
		return result;
	}


	@Override
	public int selectEmoney(Member m) {
		int result = ed.selectEmoney(sqlSession, m);
		return result;
	}








	/*@Override
	public int updateEmoney(String id, String buyer_code, int amount, Member m) {
		int result = ed.updateEmoney(sqlSession, id, buyer_code, amount, m);
		System.out.println("result3 : " + result);
		return result;
	}*/



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