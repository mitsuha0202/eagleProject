package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.dao.AuctionDao;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;

@Service
public class AuctionServiceImpl implements AuctionService {
	@Autowired
	private AuctionDao ad;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Attachment> selectAttachment() {

		return ad.selectAttachment(sqlSession);
	}

	@Override
	public ArrayList<Bid> selectBid() {

		return ad.selectBid(sqlSession);
	}

	@Override
	public ArrayList<Item> selectItem() {
		// TODO Auto-generated method stub
		return ad.selectItem(sqlSession);
	}

}
