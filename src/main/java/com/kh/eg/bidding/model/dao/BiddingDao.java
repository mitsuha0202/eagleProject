package com.kh.eg.bidding.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.bidding.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.Board;
import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingDao {

	ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo);

	int insertBidding(SqlSessionTemplate sqlSession, Bidding b);

	ItemDetail selectPrice(SqlSessionTemplate sqlSession, String itemNo);

	ItemDetail selectStartPrice(SqlSessionTemplate sqlSession, String itemNo);

	Bidding selectMid(SqlSessionTemplate sqlSession, String itemNo);

	ItemDetail selectDate(SqlSessionTemplate sqlSession, String itemNo);

	int insertWishList(SqlSessionTemplate sqlSession, ItemDetail i);

	ItemDetail selectWishList(SqlSessionTemplate sqlSession, ItemDetail i);

	ItemDetail selectTime(SqlSessionTemplate sqlSession, String itemNo);

	Attachment selectImage(SqlSessionTemplate sqlSession, String itemNo);

	ArrayList<Attachment> selectDetailImage(SqlSessionTemplate sqlSession, String itemNo);

	int updateStatus(SqlSessionTemplate sqlSession, String itemNo);

	ArrayList<Board> selectQa(SqlSessionTemplate sqlSession, String itemNo);

	int insertLuckyBid(SqlSessionTemplate sqlSession, Bidding b);

	int updateLuckyBid(SqlSessionTemplate sqlSession, Bidding b);

	Bidding selectLuckyMno(SqlSessionTemplate sqlSession,Bidding b);

	Bidding selectLuckyPrice(SqlSessionTemplate sqlSession, Bidding b);

	int insertRealBid(SqlSessionTemplate sqlSession, Bidding b);

	ItemDetail selectRealTime(SqlSessionTemplate sqlSession, String itemNo);

	int updateRealTime(SqlSessionTemplate sqlSession, ItemDetail i);





}
