package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;


@Repository
public class AuctionDaoImpl implements AuctionDao {

	@Override
	public ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectAttachment");
	}

	@Override
	public ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectBid");
	}

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Item.selectItem");
	}

	


	
	
	

}
