package com.kh.eg.bidding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.eg.bidding.model.service.BiddingService;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Controller
public class AuctionDetailController {
@Autowired
private BiddingService bs;
	
	@RequestMapping("auctionDetail.bi")
	public String goDetail() {
		return "bidding/auctionDetail";
	}
	
	@RequestMapping("auctionDetails.bi")
	public @ResponseBody ItemDetail auctionDetail(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		ItemDetail ide = null;
		
		ide = bs.selectItem(itemNo);
		
		if(ide != null) {
			return ide;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("insertBidding.bi")
	public @ResponseBody int insertBidding(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="price", required=false) String price, 
												HttpServletRequest request, HttpServletResponse response) {
		
		Bid b = new Bid();
		
		System.out.println(price);
		int prices = Integer.parseInt(price);
		System.out.println(itemNo);
		System.out.println(prices);
		b.setItemNo(itemNo);
		b.setCurrentPrice(prices);
		int result = bs.insertBidding(b);
		
		return result;
	}
	
	@RequestMapping("selectPrice.bi")
	public @ResponseBody int selectPrice(@RequestMapping(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		
		int result = bs.selectPrice(itemNo);
		
		if(result != 0) {
			return result;
		}
		else {
			return 0;
		}
	}
}
