package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.item.model.vo.Item;

public interface AuctionDao {

	HashMap<String, Object> selectItem(SqlSessionTemplate sqlSession, int itemNo);

	Object selectBid(SqlSessionTemplate sqlSession, int itemNo);

}
