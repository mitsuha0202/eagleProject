package com.kh.eg.auction.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.item.model.vo.Item;

public interface AuctionDao {

	ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, int itemNo);

}
