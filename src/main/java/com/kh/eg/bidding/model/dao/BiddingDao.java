package com.kh.eg.bidding.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingDao {

	ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo);

	int insertBidding(SqlSessionTemplate sqlSession, Bidding b);

	ItemDetail selectPrice(SqlSessionTemplate sqlSession, String itemNo);

	ItemDetail selectStartPrice(SqlSessionTemplate sqlSession, String itemNo);

	Bidding selectMid(SqlSessionTemplate sqlSession, String itemNo);

	ItemDetail selectDate(SqlSessionTemplate sqlSession, String itemNo);

	int insertWishList(SqlSessionTemplate sqlSession, ItemDetail i);

	ItemDetail selectWishList(SqlSessionTemplate sqlSession, String itemNo, String mNo);




}
