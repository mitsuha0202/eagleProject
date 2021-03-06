package com.kh.eg.emoney.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.WinBid;

public interface emoneyDao {

	int insertEmoney(SqlSessionTemplate sqlSession, emoney e);
	
	int insertMemberEmoney(SqlSessionTemplate sqlSession, emoney e);

	ArrayList<emoney> selectEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e);

	int getlistCount(SqlSessionTemplate sqlSession, emoney e);

	ArrayList<emoney> refundEmoneyList(SqlSessionTemplate sqlSession, PageInfo pi, emoney e);

	int refundMemberEmoney(SqlSessionTemplate sqlSession, emoney e);

	/*int updateRefundEmoney(SqlSessionTemplate sqlSession, Member m, emoney e);*/
	
	int selectCurrval(SqlSessionTemplate sqlSession, emoney e);
	
	int selectNextval(SqlSessionTemplate sqlSession, emoney e);

	int updateEmoney(SqlSessionTemplate sqlSession, Member m);

	int selectEmoneyeSq(SqlSessionTemplate sqlSession, emoney e);

	int refundEmoneyeInsert(SqlSessionTemplate sqlSession, emoney e);

	int paymentMember(SqlSessionTemplate sqlSession, Member m, emoney e);

	int paymentInsert(SqlSessionTemplate sqlSession, emoney e, WinBid w);
	
	//마이페이지 - 결제(입금요청)
	int paymentA(SqlSessionTemplate sqlSession, String id, String itemNo, String currentPrice);

	int selectEmoney(SqlSessionTemplate sqlSession, String buyer_code);




	
	
	
}