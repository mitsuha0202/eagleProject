package com.kh.eg.bidding.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Repository
public class BiddingDaoImpl implements BiddingDao{

	@Override
	public ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectDetailItem", itemNo);
	}

	@Override
	public int insertBidding(SqlSessionTemplate sqlSession, Bid b) {

		return sqlSession.insert("ItemDetails.insertBidding", b);
	}

	@Override
	public ItemDetail selectPrice(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectPrice", itemNo);
	}

	@Override
	public ItemDetail selectStartPrice(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectStartPrice", itemNo);
	}

	@Override
	public Bid selectMid(SqlSessionTemplate sqlSession, String itemNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
