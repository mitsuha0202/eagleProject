package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.item.model.vo.Item;


@Repository
public class AuctionDaoImpl implements AuctionDao {

	@Override
	public HashMap<String, Object> selectItem(SqlSessionTemplate sqlSession, int itemNo) {
	
		return (HashMap)sqlSession.selectList("Item.selectList", itemNo);
	}

	@Override
	public HashMap<String, Object> selectBid(SqlSessionTemplate sqlSession, int itemNo) {
		return (HashMap)sqlSession.selectList("Item.selectBidList", itemNo);
	}


	

}
