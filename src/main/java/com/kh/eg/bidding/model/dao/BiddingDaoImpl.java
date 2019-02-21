package com.kh.eg.bidding.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Repository
public class BiddingDaoImpl implements BiddingDao{

	@Override
	public ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectDetailItem", itemNo);
	}

	@Override
	public int insertBidding(SqlSessionTemplate sqlSession, Bidding b) {

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
	public Bidding selectMid(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectMid", itemNo);
	}

	@Override
	public ItemDetail selectDate(SqlSessionTemplate sqlSession, String itemNo) {
		ItemDetail id = new ItemDetail();
		id = sqlSession.selectOne("ItemDetails.selectDate", itemNo);
		return id;
	}

	@Override
	public int insertWishList(SqlSessionTemplate sqlSession, ItemDetail i) {

		return sqlSession.insert("ItemDetails.insertWishList", i);
	}

	@Override
	public ItemDetail selectWishList(SqlSessionTemplate sqlSession, String itemNo, String mNo) {

		/*return sqlSession.selectList("ItemDetails.selectWishList", itemNo, mNo);*/
		return null;
	}
}
