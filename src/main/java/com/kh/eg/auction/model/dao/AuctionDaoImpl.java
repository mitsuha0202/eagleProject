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
		else if(alignName.equals("2")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC2");
		}
		else if(alignName.equals("3")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC3");
			
		}
		else if(alignName.equals("4")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC4");
		}
		else if(alignName.equals("5")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC5");
		}
		else if(alignName.equals("6")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC6");
		}
		else if(alignName.equals("7")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC7");
		}
		return bidlist;
	}

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Item> itemlist=null;
		if(alignName.equals("1")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC");
		}
		else if(alignName.equals("2")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC2");
			
		}
		else if(alignName.equals("3")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC3");
			
		}
		else if(alignName.equals("4")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC4");
		}
		else if(alignName.equals("5")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC5");
		}
		else if(alignName.equals("6")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC6");
		}
		else if(alignName.equals("7")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC7");
		}
		
		return itemlist;
	}

	@Override
	public ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession, String alignName) {
		ArrayList<Attachment> attachmentlist=null;
		if(alignName.equals("1")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC");
		}
		else if(alignName.equals("2")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC2");
		}
		else if(alignName.equals("3")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC3");
			
		}
		else if(alignName.equals("4")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC4");
		}
		else if(alignName.equals("5")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC5");
		}
		else if(alignName.equals("6")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC6");
		}
		else if(alignName.equals("7")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC7");
		}
		return attachmentlist;
	}

	


	
	
	

}
