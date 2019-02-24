package com.kh.eg.bidding.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.bidding.model.service.BiddingService;
import com.kh.eg.bidding.model.vo.Attachment;
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
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
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
	
	@RequestMapping("selectDate.bi")
	public @ResponseBody ItemDetail selectDate(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = null;
		i = bs.selectDate(itemNo);
		
		if(i != null) {
			return i;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("insertWishList.bi")
	public @ResponseBody int insertWishList(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
													HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = new ItemDetail();
		
		i.setItemNo(itemNo);
		i.setmNo(mNo);
		
		int result = bs.insertWishList(i);
		
		if(result > 0) {
			return result;
		}
		else {
			return result;
		}
	}
	
	@RequestMapping("compareWish.bi")
	public @ResponseBody ItemDetail selectWishList(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
												HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = null;
		ItemDetail id = new ItemDetail();
		
		id.setItemNo(itemNo);
		id.setmNo(mNo);
		
		i = bs.selectWishList(id);
		if(i != null) {
			return i;
		}
		else {
			i = new ItemDetail();
			i.setmNo("0");
			return i;
		}
	}
	
	@RequestMapping("selectTime.bi")
	public @ResponseBody ItemDetail selectTime(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = null;
		
		i = bs.selectTime(itemNo);
		
		System.out.println(i.getStartDay());
		System.out.println(i.getEndDay());
		
		String nowDay = i.getStartDay();
		String endDay = i.getEndDay();
		
		SimpleDateFormat sft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		try {
			Date nd = sft.parse(nowDay);
			Date ed = sft.parse(endDay);
			
			long ndM = nd.getTime();
			long edM = ed.getTime();
			
			System.out.println(ndM);
			System.out.println(edM);
			
			long time = edM - ndM;
			String remainTime = String.valueOf(time);
			
			System.out.println(remainTime);
			
			i.setEndDay(remainTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(i != null) {
			return i;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("selectThumbnail.bi")
	public @ResponseBody Attachment selectImage(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		Attachment att = null;
		
		att = bs.selectImage(itemNo);
		
		if(att != null) {
			return att;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("selectDetailImage.bi")
	public @ResponseBody ArrayList<Attachment> selectDetailImage(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response){
		ArrayList<Attachment> att = bs.selectDetailImage(itemNo);
		
		if(att != null) {
			return att;
		}
		else {
			return null;
		}
	}
}
