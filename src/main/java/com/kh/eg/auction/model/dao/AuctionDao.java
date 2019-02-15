package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;

public interface AuctionDao {


	ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession);

	ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession);

	ArrayList<Item> selectItem(SqlSessionTemplate sqlSession);

	/*Object selectAttachment(SqlSessionTemplate sqlSession, int itemNo);*/

	
	
}
