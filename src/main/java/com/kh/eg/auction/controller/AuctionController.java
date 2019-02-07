package com.kh.eg.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionController {

	@RequestMapping("auctionCategory.au")
	public String Auction() {
		return "auction/auction";
	}
}
