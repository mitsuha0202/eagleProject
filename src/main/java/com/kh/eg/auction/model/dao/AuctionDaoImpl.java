package com.kh.eg.auction.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.item.model.vo.Item;


@Repository
public class AuctionDaoImpl implements AuctionDao {

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, int itemNo) {
		
		return (ArrayList)sqlSession.selectList("Item.selectList", itemNo);
	}


	

}
