package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.vo.AuctionCount;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;

public interface AuctionDao {


	ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession);

	ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession);

	ArrayList<Item> selectItem(SqlSessionTemplate sqlSession);

	ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession, String alignName);

	ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, String alignName);

	ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession, String alignName);

	ArrayList<Member> selectMember(SqlSessionTemplate sqlSession);

	ArrayList<Member> selectMember(SqlSessionTemplate sqlSession, String alignName);

	ArrayList<Category> selectCategory(SqlSessionTemplate sqlSession, String categoryLevel);

	ArrayList<Bid> selectBid1(SqlSessionTemplate sqlSession, String categoryLevel);

	ArrayList<Item> selectItem1(SqlSessionTemplate sqlSession, String categoryLevel);

	ArrayList<Attachment> selectAttachment1(SqlSessionTemplate sqlSession, String categoryLevel);

	ArrayList<Member> selectMember1(SqlSessionTemplate sqlSession, String categoryLevel);

	ArrayList<Bid> mainBid(SqlSessionTemplate sqlSession);

	ArrayList<Item> mainItem(SqlSessionTemplate sqlSession);

	ArrayList<Attachment> mainAttachment(SqlSessionTemplate sqlSession);

	ArrayList<Member> mainMember(SqlSessionTemplate sqlSession);

	ArrayList<Item> mainItem1(SqlSessionTemplate sqlSession);

	ArrayList<Item> mainItem2(SqlSessionTemplate sqlSession);

	int selectCount(SqlSessionTemplate sqlSession);

	/*Object selectAttachment(SqlSessionTemplate sqlSession, int itemNo);*/

	
	
}
