package com.kh.eg.auction.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.auction.model.service.AuctionService;
import com.kh.eg.auction.model.service.AuctionServiceImpl;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.auction.model.vo.Pagination;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;

@Controller
public class AuctionController {
	@Autowired 
	private AuctionService as;

	@RequestMapping("auctionCategory.au")
	public String selectAuction(HttpServletRequest request,Model model,Item it ) {
		
		int itemNo=it.getItemNo();
		HashMap<String,Object> hmap=new HashMap<String, Object>();
		ArrayList<Bid> list2=new ArrayList<Bid>();
		ArrayList<Item> list1=new ArrayList<Item>();
		hmap.put("item",list1);
		hmap.put("bid",list2);
		
		hmap=as.selectItem(itemNo);
				
			  if(hmap != null) {
			         model.addAttribute("hmap", hmap);
			         return "auction/auction";
			      }else {
			         model.addAttribute("msg", " 조회 실패");
			         return "common/errorPage";
			      }
	}
	
	
}
