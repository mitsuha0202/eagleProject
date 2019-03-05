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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.RequestScope;

import com.kh.eg.bidding.model.service.BiddingService;
import com.kh.eg.bidding.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.bidding.model.vo.Bidding;
import com.kh.eg.bidding.model.vo.Board;
import com.kh.eg.bidding.model.vo.ItemDetail;

@SessionAttributes("loginUser")
@Controller
public class AuctionDetailController {
@Autowired
private BiddingService bs;
	
	@RequestMapping("auctionDetail.bi")
	public String goDetail(@RequestParam String itemNo, @RequestParam String auctionCode, Model m) {
		
		m.addAttribute("itemNo", itemNo);
		m.addAttribute("auctionCode", auctionCode);
		
		return "bidding/auctionDetail";
	}
	
	@RequestMapping("auctionDetailQuestion.bi")
	public String goQuestion(@RequestParam String itemNo, @RequestParam String aCode, @RequestParam String memberNo, @RequestParam String sMemberNo, Model m) {
		m.addAttribute("itemNo", itemNo);
		m.addAttribute("aCode", aCode);
		m.addAttribute("memberNo", memberNo);
		m.addAttribute("sMemberNo", sMemberNo);
		
		return "bidding/auctionDetailQuestion";
	}
	
	@RequestMapping("insertQuestion.bi")
	public @ResponseBody int insertQuestion(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="memberNo", required=false) String memberNo, 
											@RequestParam(value="sMemberNo", required=false) String sMemberNo, @RequestParam(value="sMemberNo", required=false) String title,
											@RequestParam(value="boardContent", required=false) String boardContent,
											HttpServletRequest request, HttpServletResponse response) {
		Board b = new Board();
		
		b.setItemNo(itemNo);
		b.setmNo(memberNo);
		b.setsMno(sMemberNo);
		b.setTitle(title);
		b.setBoardContent(boardContent);
		
		int result = bs.insertQuestion(b);
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
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
		
		
		if(i != null) {
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
				String sysDate = String.valueOf(ndM);
				
				System.out.println(remainTime);
				i.setStartDay(sysDate);
				i.setEndDay(remainTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
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
	
	@RequestMapping("auctionFinish.bi")
	public @ResponseBody int updateStatus(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		int result = bs.updateStatus(itemNo);
	
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping("selectQa.bi")
	public @ResponseBody ArrayList<Board> selectQa(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response){
		ArrayList<Board> list = bs.selectQa(itemNo);
		
		if(list != null) {
			return list;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("insertLuckyBid.bi")
	public @ResponseBody int insertLuckyBid(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
											@RequestParam(value="price", required=false) String price, HttpServletRequest request, HttpServletResponse response) {
		Bidding b = new Bidding();
		int currentPrice = Integer.parseInt(price);
		b.setItemNo(itemNo);
		b.setMemberNo(mNo);
		b.setCurrentPrice(currentPrice);
		
		int result = bs.insertLuckyBid(b);
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping("compareLuckyMno.bi")
	public @ResponseBody Bidding selectLuckyMno(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
													HttpServletRequest request, HttpServletResponse response) {
		Bidding b = new Bidding();
		Bidding bdd = null;
		b.setItemNo(itemNo);
		b.setMemberNo(mNo);
		
		bdd = bs.selectLuckyMno(b);
		
		if(bdd != null) {
			return bdd;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("updateLuckyBid.bi")
	public @ResponseBody int updateLuckyBid(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
											@RequestParam(value="price", required=false) String price, HttpServletRequest request, HttpServletResponse response) {
		Bidding b = new Bidding();
		int currentPrice = Integer.parseInt(price);
		b.setItemNo(itemNo);
		b.setMemberNo(mNo);
		b.setCurrentPrice(currentPrice);
		
		int result = bs.updateLuckyBid(b);
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping("compareLuckyPrice.bi")
	public @ResponseBody Bidding selectLuckyPrice(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="price", required=false) String price,
													HttpServletRequest request, HttpServletResponse response) {
		Bidding b = new Bidding();
		Bidding bdd = null;
		int currentPrice = Integer.parseInt(price);
		b.setItemNo(itemNo);
		b.setCurrentPrice(currentPrice);
		
		bdd = bs.selectLuckyPrice(b);
		
		if(bdd != null) {
			return bdd;
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("realTimeBid.bi")
	public @ResponseBody int insertRealBid(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="mNo", required=false) String mNo,
											@RequestParam(value="price", required=false) String price, HttpServletRequest request, HttpServletResponse response) {
		Bidding b = new Bidding();
		int currentPrice = Integer.parseInt(price);
		b.setItemNo(itemNo);
		b.setMemberNo(mNo);
		b.setCurrentPrice(currentPrice);
		
		System.out.println(itemNo + mNo + currentPrice);
		
		int result = bs.insertRealBid(b);
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
	}
	
	@RequestMapping("selectRealTime.bi")
	public @ResponseBody ItemDetail selectRealTime(@RequestParam(value="itemNo", required=false) String itemNo, HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = null;
		
		i = bs.selectRealTime(itemNo);
		
		
		if(i != null) {
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
				
				long time = ndM - edM;
				String remainTime = String.valueOf(time);
				
				System.out.println(remainTime);
				
				i.setStartDay(remainTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return i;
		}
		else {
			return null;
		}
	}
	@RequestMapping("updateRealTime.bi")
	public @ResponseBody int updateRealTime(@RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="nowTime", required=false) String nowTime, 
												HttpServletRequest request, HttpServletResponse response) {
		ItemDetail i = new ItemDetail();
		
		SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long miliTime = Long.parseLong(nowTime);
		Date dateTime = new Date(miliTime);
		
		String endDay = sft.format(dateTime);
		
		i.setItemNo(itemNo);
		i.setEndDay(endDay);
		
		int result = bs.updateRealTime(i);
		
		if(result > 0) {
			return result;
		}
		else {
			return 0;
		}
	}
}
