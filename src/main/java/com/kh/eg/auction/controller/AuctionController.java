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
import com.kh.eg.item.model.vo.Item;

@Controller
public class AuctionController {
	@Autowired 
	private AuctionService as;

	@RequestMapping("auctionCategory.au")
	public String selectAuction(HttpServletRequest request,HttpServletResponse response,Model model,Item it ) {
		
		int itemNo=it.getItemNo();
		ArrayList<Item> list=as.selectItem(itemNo);
			  if(list != null) {
			         model.addAttribute("list", list);
			         return "auction/auction";
			      }else {
			         model.addAttribute("msg", "1대1 문의 조회 실패");
			         return "common/errorPage";
			      }
	}
	
	
}
