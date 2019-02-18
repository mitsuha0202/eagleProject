package com.kh.eg.bidding.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.eg.bidding.model.service.BiddingService;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Controller
public class AuctionDetailController {
@Autowired
private BiddingService bs;
	
	@RequestMapping("auctionDetail.bi")
	public @ResponseBody ItemDetail auctionDetail(@RequestParam(required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		ItemDetail ide = null;
		System.out.println(itemNo);
		ide = bs.selectItem(itemNo);
		
		if(ide != null) {
			return ide;
		}
		else {
			return null;
		}
		
	}
}
