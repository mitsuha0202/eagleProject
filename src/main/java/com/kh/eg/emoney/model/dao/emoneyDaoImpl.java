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
				
		return result;
	}
	
	//충전 내역 리스트 메소드
	@Override
	public emoney emoneyList(SqlSessionTemplate sqlSession, emoney e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//충전한 금액 유저에게 넣는 메소드
	@Override
	public int insertMemberCash(SqlSessionTemplate sqlSession, emoney e) {
		// TODO Auto-generated method stub
		return 0;
	}

	//현재 유저의 금액 출력하는 메소드
	@Override
	public emoney selectMemberNowCash(SqlSessionTemplate sqlSession, emoney e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<emoney> selectEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<emoney> list = null;
		ArrayList<emoney> mlist = null;
		emoney e= new emoney();
		Member m = new Member();
		int offset = (pi.getCurrentPage() -1 ) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		e.setMoney(offset);
		/*list = (ArrayList)sqlSession.selectList("emoney.selectEmoneyList", null, rowBounds);
		ArrayList<Member> name = null;
		
		name =(ArrayList)sqlSession.selectList("Member.selectListWriter",list, rowBounds);
		for(int i=0; i<name.size();i++) {
			list.get(i).setUseNo(name.get(i).getUserName());
		}*/

		return list;
	}

	
	
}
