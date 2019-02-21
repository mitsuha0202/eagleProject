package com.kh.eg.auction.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.service.AuctionService;
import com.kh.eg.auction.model.service.AuctionServiceImpl;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.auction.model.vo.Pagination;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.item.model.vo.Item;

import net.sf.json.JSONArray;

@Controller
public class AuctionController {
	@Autowired 
	private AuctionService as;

	@RequestMapping("selectAlign.au")
	public @ResponseBody ArrayList<Item> selectAlign(Model model,@RequestParam String alignName) {


		System.out.println("alignName"+alignName);
		ArrayList<Bid> list2=as.selectBid(alignName);
		ArrayList<Item> list1=as.selectItem(alignName);
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;

				}
			}
			list1.get(i).setBidCount(count);

		}

		ArrayList<Attachment>list3=as.selectAttachment(alignName);

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		}
		
		if(alignName.equals("7")) {

			Collections.sort(list1, new Comparator<Item>() {
				@Override
				public int compare(Item o1, Item o2) {

					return o1.getBidCount()-o2.getBidCount();

				}
			});
			for(Item item:list1) {
				System.out.println(item);
			}
			return list1;

		}
		else {
			return list1;

		}
		//return list1;

	}



	@RequestMapping("auctionCategory.au")
	public String selectAuction(HttpServletRequest request,Model model,Item it ) {

		ArrayList<Bid> list2=as.selectBid();
		ArrayList<Item> list1=as.selectItem();
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;
				}
			}
			list1.get(i).setBidCount(count);

		};

		ArrayList<Attachment>list3=as.selectAttachment();

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		}

		model.addAttribute("list1",list1);
		System.out.println(list1);

		return "auction/auction";
	}




}
