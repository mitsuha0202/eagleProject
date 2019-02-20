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

	@Override
	public ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Bid> bidlist=null;
		if(alignName.equals("1")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC");
		}
		return bidlist;
	}

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Item> itemlist=null;
		if(alignName.equals("1")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC");
		}
		return itemlist;
	}

	@Override
	public ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession, String alignName) {
		ArrayList<Attachment> attachmentlist=null;
		if(alignName.equals("1")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC");
		}
		return attachmentlist;
	}

	


	
	
	

}
