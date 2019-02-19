package com.kh.eg.bidding.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingDao {

	ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo);

	int insertBidding(SqlSessionTemplate sqlSession, Bid b);

	int selectPrice(SqlSessionTemplate sqlSession, String itemNo);




}
