package com.kh.eg.bidding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.bidding.model.service.BiddingService;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.ItemDetail;

@SessionAttributes("loginUser")
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
											@RequestParam(value="mid", required=false) String mid, HttpServletRequest request, HttpServletResponse response) {
		
		Bidding b = new Bidding();
		
		int prices = Integer.parseInt(price);
		b.setItemNo(itemNo);
		b.setCurrentPrice(prices);
		b.setMemberNo(mid);
		int result = bs.insertBidding(b);
		
		return result;
	}
	
	@RequestMapping("selectPrice.bi")
	public @ResponseBody ItemDetail selectPrice(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		
		ItemDetail i = null;
		
		i = bs.selectPrice(itemNo);
		if(i != null) {
			return i;
		}
		else {
			i = bs.selectStartPrice(itemNo);
			if(i.getStartPrice() != 0) {
				return i;
			}
			else {
				return null;
			}
		}
	}
	
	@RequestMapping("compareMid.bi")
	public @ResponseBody Bidding selectMid(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		Bidding b = null;
		
		b = bs.selectMid(itemNo);
		
		if(b != null) {
			return b;
		}
		else {
			return null;
		}
	}
}
