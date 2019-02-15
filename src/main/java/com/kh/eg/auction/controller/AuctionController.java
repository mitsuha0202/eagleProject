package com.kh.eg.auction.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.attachment.model.vo.Attachment;
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
		
		ArrayList<Bid> list2=as.selectBid();
		System.out.println(list2);
		ArrayList<Item> list1=as.selectItem();
		for(int i=0;i<list1.size();i++) {
			int count=0;
			System.out.println(list1);
			for(int j=0;j<list2.size();j++) {
				System.out.println(list2);
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;
				}
			}
			list1.get(i).setBidCount(count);
			
		};
		
		ArrayList<Attachment>list3=as.selectAttachment();
		
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				System.out.println(list3);
				if(list1.get(j).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		}

		model.addAttribute(list1);
		
		return "auction/auction";
	}
	
	
	
	
}
