package com.kh.eg.bidding.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.bidding.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.Board;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Repository
public class BiddingDaoImpl implements BiddingDao{

	@Override
	public ItemDetail selectItem(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectDetailItem", itemNo);
	}

	@Override
	public int insertBidding(SqlSessionTemplate sqlSession, Bidding b) {

		return sqlSession.insert("ItemDetails.insertBidding", b);
	}

	@Override
	public ItemDetail selectPrice(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectPrice", itemNo);
	}

	@Override
	public ItemDetail selectStartPrice(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectStartPrice", itemNo);
	}

	@Override
	public Bidding selectMid(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectMid", itemNo);
	}

	@Override
	public ItemDetail selectDate(SqlSessionTemplate sqlSession, String itemNo) {
		ItemDetail id = new ItemDetail();
		id = sqlSession.selectOne("ItemDetails.selectDate", itemNo);
		return id;
	}

	@Override
	public int insertWishList(SqlSessionTemplate sqlSession, ItemDetail i) {

		return sqlSession.insert("ItemDetails.insertWishList", i);
	}

	@Override
	public ItemDetail selectWishList(SqlSessionTemplate sqlSession, ItemDetail i) {

		return sqlSession.selectOne("ItemDetails.selectWishList", i);
	}

	@Override
	public ItemDetail selectTime(SqlSessionTemplate sqlSession, String itemNo) {
		ItemDetail id = new ItemDetail();
		id = sqlSession.selectOne("ItemDetails.selectTime",itemNo);
		return id;
	}

	@Override
	public Attachment selectImage(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.selectOne("ItemDetails.selectImage", itemNo);
	}

	@Override
	public ArrayList<Attachment> selectDetailImage(SqlSessionTemplate sqlSession, String itemNo) {

		return (ArrayList)sqlSession.selectList("ItemDetails.selectDetailImage", itemNo);
	}

	@Override
	public int updateStatus(SqlSessionTemplate sqlSession, String itemNo) {

		return sqlSession.update("ItemDetails.updateStatus", itemNo);
	}

	@Override
	public ArrayList<Board> selectQa(SqlSessionTemplate sqlSession, String itemNo) {

		return (ArrayList)sqlSession.selectList("ItemDetails.selectQa", itemNo);
	}

	@Override
	public int insertLuckyBid(SqlSessionTemplate sqlSession, Bidding b) {

		return sqlSession.insert("ItemDetails.insertLuckyBid", b);
	}

	@Override
	public int updateLuckyBid(SqlSessionTemplate sqlSession, Bidding b) {

		return sqlSession.update("ItemDetails.updateLuckyBid", b);
	}

	@Override
	public Bidding selectLuckyMno(SqlSessionTemplate sqlSession, Bidding b) {

		return sqlSession.selectOne("ItemDetails.selectLuckyMno", b);
	}

	@Override
	public Bidding selectLuckyPrice(SqlSessionTemplate sqlSession, Bidding b) {

		return sqlSession.selectOne("ItemDetails.selectLuckyPrice", b);
	}
}
