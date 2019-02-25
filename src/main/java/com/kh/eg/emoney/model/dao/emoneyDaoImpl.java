package com.kh.eg.emoney.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;
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
	
	@Override
	public int updateRefundEmoney(SqlSessionTemplate sqlSession, Member m, emoney e) {
		System.out.println("환급test");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("mid", Integer.parseInt(m.getMid()));
		/*map.put("emoney", String.valueOf(m.getEmoney()));*/
		map.put("emoney", m.getEmoney());
		/*String money = String.valueOf(m.getEmoney());*/
		int result = sqlSession.update("Member.updateRefundEmoney", map);
		System.out.println("환급업데이트잘되는지확인 : " + result);		
		
		return result;
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

	@Override
	public ArrayList<emoney> refundEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e) {
		ArrayList<emoney> list = null;
		
		int offset = (pi.getCurrentPage() -1 ) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("emoney.refundList", e, rowBounds);
		System.out.println("환급리스트뽑기"+list);
		return list;
	}

	@Override
	public int refundMemberEmoney(SqlSessionTemplate sqlSession, emoney e) {
		int result = sqlSession.insert("emoney.refundMemberEmoney", e);
		System.out.println("환급인설트잘되나? : " + result);		
		
		return result;
	}

	

	@Override
	public int selectCurrval(SqlSessionTemplate sqlSession, emoney e) {
		System.out.println("셀렉트커발찍히나?");
		int useNo = 0;
		int result = sqlSession.selectOne("emoney.selectCurrval", e);
		
		return useNo;
	}

	@Override
	public int selectNextval(SqlSessionTemplate sqlSession, emoney e) {
		System.out.println("넥스트발찍히나?");
		int useNo = 0;
		int result = sqlSession.selectOne("emoney.selectNextval", e);
		
		return useNo;
	}

	@Override
	public int selectEmoneyeSq(SqlSessionTemplate sqlSession, emoney e) {

		int result = sqlSession.selectOne("emoney.selectEmoneyeSq", e);
		return result;
	}

	@Override
	public int refundEmoneyeInsert(SqlSessionTemplate sqlSession, emoney e) {

		int result = sqlSession.insert("emoney.refundEmoneyeInsert", e);
		return result;
	}

	
	
	
	
}