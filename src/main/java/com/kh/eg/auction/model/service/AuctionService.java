package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;

public interface AuctionService {

	ArrayList<Attachment> selectAttachment();

	ArrayList<Bid> selectBid();

	ArrayList<Item> selectItem();

	ArrayList<Bid> selectBid(String alignName);

	ArrayList<Item> selectItem(String alignName);

	ArrayList<Attachment> selectAttachment(String alignName);

	ArrayList<Member> selectMember();

	ArrayList<Member> selectMember(String alignName);

	ArrayList<Category> selectCategory(String categoryLevel);

	ArrayList<Bid> selectBid1(String categoryLevel);

	ArrayList<Item> selectItem1(String categoryLevel);

	ArrayList<Attachment> selectAttachment1(String categoryLevel);

	ArrayList<Member> selectMember1(String categoryLevel);

	ArrayList<Bid> selectBidM();

	ArrayList<Item> selectItemM();

	ArrayList<Attachment> selectAttachmentM();

	ArrayList<Member> selectMemberM();

	ArrayList<Item> selectItemM1();

	ArrayList<Item> selectItemM2();


}
