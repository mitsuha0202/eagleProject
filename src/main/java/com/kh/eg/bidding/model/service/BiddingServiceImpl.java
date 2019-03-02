package com.kh.eg.bidding.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.bidding.model.dao.BiddingDao;
import com.kh.eg.bidding.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.Board;
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
	public ItemDetail selectWishList(ItemDetail i) {
		ItemDetail id = null;
		
		id = bd.selectWishList(sqlSession, i);
		
		return id;
	}

	@Override
	public ItemDetail selectTime(String itemNo) {
		ItemDetail i = null;
		
		i = bd.selectTime(sqlSession, itemNo);
		
		return i;
	}

	@Override
	public Attachment selectImage(String itemNo) {
		Attachment att = null;
		
		att = bd.selectImage(sqlSession, itemNo);
		
		return att;
	}

	@Override
	public ArrayList<Attachment> selectDetailImage(String itemNo) {
		ArrayList<Attachment> att = null;
		
		att = bd.selectDetailImage(sqlSession, itemNo);
		
		return att;
	}

	@Override
	public int updateStatus(String itemNo) {
		int result = bd.updateStatus(sqlSession, itemNo);
		
		return result;
	}

	@Override
	public ArrayList<Board> selectQa(String itemNo) {
		ArrayList<Board> list = null;
		
		list = bd.selectQa(sqlSession, itemNo);
		
		return list;
	}

	@Override
	public int insertLuckyBid(Bidding b) {
		int result = bd.insertLuckyBid(sqlSession, b);
		
		return result;
	}

	@Override
	public int updateLuckyBid(Bidding b) {
		int result = bd.updateLuckyBid(sqlSession, b);
		
		return result;
	}

	@Override
	public Bidding selectLuckyMno(Bidding b) {
		Bidding bdd = null;
		
		bdd = bd.selectLuckyMno(sqlSession, b);
		
		return bdd;
	}

	@Override
	public Bidding selectLuckyPrice(Bidding b) {
		Bidding bdd = null;
		
		bdd = bd.selectLuckyPrice(sqlSession, b);
		
		return bdd;
	}

	@Override
	public int insertRealBid(Bidding b) {
		int result = bd.insertRealBid(sqlSession, b);
		
		return result;
	}

	@Override
	public ItemDetail selectRealTime(String itemNo) {
		ItemDetail i = null;
		
		i = bd.selectRealTime(sqlSession, itemNo);
		
		return i;
	}
	
}
