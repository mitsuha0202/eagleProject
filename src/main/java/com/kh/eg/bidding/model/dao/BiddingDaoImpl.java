package com.kh.eg.bidding.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.bidding.model.vo.ItemDetail;

@Repository
public class BiddingDaoImpl implements BiddingDao{

	@Override
	public ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectDetailItem",itemNo);
	}

	
}
