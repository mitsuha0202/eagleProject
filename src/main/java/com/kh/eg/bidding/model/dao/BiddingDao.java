package com.kh.eg.bidding.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingDao {

	ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo);



}
