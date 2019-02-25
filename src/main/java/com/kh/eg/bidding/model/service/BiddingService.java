package com.kh.eg.bidding.model.service;

import java.util.ArrayList;

import com.kh.eg.bidding.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingService {

	ItemDetail selectItem(String itemNo);

	int insertBidding(Bidding b);

	ItemDetail selectPrice(String itemNo);

	ItemDetail selectStartPrice(String itemNo);

	Bidding selectMid(String itemNo);

	ItemDetail selectDate(String itemNo);

	int insertWishList(ItemDetail i);

	ItemDetail selectWishList(ItemDetail i);

	ItemDetail selectTime(String itemNo);

	Attachment selectImage(String itemNo);

	ArrayList<Attachment> selectDetailImage(String itemNo);

	int updateStatus(String itemNo);


}
