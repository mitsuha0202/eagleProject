package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.item.model.vo.Item;

public interface AuctionService {

	ArrayList<Item> selectItem(int itemNo);

	

}
