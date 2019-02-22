package com.kh.eg.emoney.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;

@Repository
public class emoneyDaoImpl implements emoneyDao{

	//결제하는 메소드	
	@Override
	public int insertEmoney(SqlSessionTemplate sqlSession, emoney e) {
		
		int result = sqlSession.insert("emoney.insertEmoney",e);
		
		System.out.println("result뭐찍히니"+result);
		return result;
	}
	
	//결제후 유저에게 이머니넣어주기
	@Override
	public int insertMemberEmoney(SqlSessionTemplate sqlSession, emoney e) {
		
		int result = sqlSession.insert("emoney.insertMemberEmoney", e);
		
		System.out.println("result뭐찍히나2 : "+result);
		
		
		return result;
	}
	
	@Override
	public int updateEmoney(SqlSessionTemplate sqlSession, Member m) {
		System.out.println("test");
		int result = sqlSession.update("Member.updateEmoney", m);
		
		System.out.println("result이것도찍히나3 " + result);
		
		return result;
	}

	//현재 유저의 금액 출력하는 메소드
	@Override
	public emoney selectMemberNowCash(SqlSessionTemplate sqlSession, emoney e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//페이징처리하면서 리스트뽑기
	@Override
	public ArrayList<emoney> selectEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e) {
		ArrayList<emoney> list = null;
		
		int offset = (pi.getCurrentPage() -1 ) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("emoney.emoneyList", e, rowBounds);
		System.out.println("결제리스트뽑기"+list);
		return list;
	}

	//충전 내역 리스트 메소드
	@Override
	public int getlistCount(SqlSessionTemplate sqlSession, emoney e) {
		
		int result = sqlSession.selectOne("emoney.selectEmoneyList", e);
		
		System.out.println("결제내역리스트 뽑는 result" + result);
		
		return result;
		
	}

	



	
	
}