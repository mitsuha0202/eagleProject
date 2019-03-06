package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.dao.AuctionDao;
import com.kh.eg.auction.model.vo.AuctionCount;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;

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

	@Override
	public ArrayList<Bid> selectBid(String alignName) {
		// TODO Auto-generated method stub
		return ad.selectBid(sqlSession,alignName);
	}

	@Override
	public ArrayList<Item> selectItem(String alignName) {
		// TODO Auto-generated method stub
		return ad.selectItem(sqlSession,alignName);
	}

	@Override
	public ArrayList<Attachment> selectAttachment(String alignName) {
		// TODO Auto-generated method stub
		return ad.selectAttachment(sqlSession,alignName);
	}

	@Override
	public ArrayList<Member> selectMember() {
	
		return ad.selectMember(sqlSession);
	}

	@Override
	public ArrayList<Member> selectMember(String alignName) {
		// TODO Auto-generated method stub
		return ad.selectMember(sqlSession,alignName);
	}

	@Override
	public ArrayList<Category> selectCategory(String categoryLevel) {
		// TODO Auto-generated method stub
		return ad.selectCategory(sqlSession,categoryLevel);
	}

	@Override
	public ArrayList<Bid> selectBid1(String categoryLevel) {
		// TODO Auto-generated method stub
		return ad.selectBid1(sqlSession,categoryLevel);
	}

	@Override
	public ArrayList<Item> selectItem1(String categoryLevel) {
		// TODO Auto-generated method stub
		return ad.selectItem1(sqlSession,categoryLevel);
	}

	@Override
	public ArrayList<Attachment> selectAttachment1(String categoryLevel) {
		// TODO Auto-generated method stub
		return ad.selectAttachment1(sqlSession,categoryLevel);
	}

	@Override
	public ArrayList<Member> selectMember1(String categoryLevel) {
		// TODO Auto-generated method stub
		return ad.selectMember1(sqlSession,categoryLevel);
	}

	@Override
	public ArrayList<Bid> selectBidM() {
		// TODO Auto-generated method stub
		return ad.mainBid(sqlSession);
	}

	@Override
	public ArrayList<Item> selectItemM() {
		// TODO Auto-generated method stub
		return ad.mainItem(sqlSession);
	}

	@Override
	public ArrayList<Attachment> selectAttachmentM() {
		// TODO Auto-generated method stub
		return ad.mainAttachment(sqlSession);
	}

	@Override
	public ArrayList<Member> selectMemberM() {
		// TODO Auto-generated method stub
		return ad.mainMember(sqlSession);
	}

	@Override
	public ArrayList<Item> selectItemM1() {
		// TODO Auto-generated method stub
		return ad.mainItem1(sqlSession);
	}

	@Override
	public ArrayList<Item> selectItemM2() {
		// TODO Auto-generated method stub
		return  ad.mainItem2(sqlSession);
	}

	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return ad.selectCount(sqlSession);
	}

}
