package com.kh.eg.bidding.model.service;

import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.ItemDetail;

public interface BiddingService {

	ItemDetail selectItem(String itemNo);

	int insertBidding(Bid b);

	ItemDetail selectPrice(String itemNo);

	ItemDetail selectStartPrice(String itemNo);


}
