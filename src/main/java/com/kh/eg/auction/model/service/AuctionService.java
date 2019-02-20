package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;

public interface AuctionService {

	ArrayList<Attachment> selectAttachment();

	ArrayList<Bid> selectBid();

	ArrayList<Item> selectItem();

	ArrayList<Bid> selectBid(String alignName);

	ArrayList<Item> selectItem(String alignName);

	ArrayList<Attachment> selectAttachment(String alignName);


}
