package com.kh.eg.bidding.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.bidding.model.dao.BiddingDao;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Service
public class BiddingServiceImpl implements BiddingService{
@Autowired
private BiddingDao bd;
@Autowired
private SqlSessionTemplate sqlSession;

	@Override
	public ItemDetail selectItem(String itemNo) {
		ItemDetail ide = null;
		
		ide = bd.selectItem(sqlSession, itemNo);
		
		return ide;
	}

	@Override
	public int insertBidding(Bidding b) {
		int result = bd.insertBidding(sqlSession, b);
		
		return result;
	}

	@Override
	public ItemDetail selectPrice(String itemNo) {
		ItemDetail i = null;
		
		i = bd.selectPrice(sqlSession, itemNo);
		
		return i;
	}

	@Override
	public ItemDetail selectStartPrice(String itemNo) {
		ItemDetail i = null;
		
		i = bd.selectStartPrice(sqlSession, itemNo);
		
		return i;
	}

	@Override
	public Bidding selectMid(String itemNo) {
		Bidding b = null;
		
		b = bd.selectMid(sqlSession, itemNo);
		
		return b;
	}

	@Override
	public ItemDetail selectDate(String itemNo) {
		ItemDetail i = null;
		
		i = bd.selectDate(sqlSession, itemNo);
		
		return i;
	}

	@Override
	public int insertWishList(ItemDetail i) {
		int result = bd.insertWishList(sqlSession, i);
		
		return result;
	}

	@Override
	public ItemDetail selectWishList(String itemNo, String mNo) {
		ItemDetail i = null;
		
		i = bd.selectWishList(sqlSession, itemNo, mNo);
		
		return i;
	}
}
