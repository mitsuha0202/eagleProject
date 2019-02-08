package com.kh.eg.bidding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionDetailController {
	
	@RequestMapping("auctionDetail.bi")
	public String auctionDetail() {
		return "bidding/auctionDetail";
	}
}
