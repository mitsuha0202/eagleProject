
package com.kh.eg.item.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.vo.AuctionDetail;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.common.CommonUtils;
import com.kh.eg.item.model.service.ItemService;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;

@Controller
public class ItemController {
	@Autowired
	private ItemService is;
	
	@RequestMapping("goMain.it")
	public String goMain() {
		return "main/main";
	}
	
	@RequestMapping("itemRegist.it")
	public String itemRegist(Model model) {
		
		ArrayList<Category> category=is.selectCategory();
		model.addAttribute("category",category);
		
		System.out.println(category);
	
			return "item/itemRegist";
		}
	@RequestMapping("middleCategory.it")
	public @ResponseBody ArrayList<Category> middleCategory(Model model,@RequestParam String bigc) {
		
		System.out.println("bigc"+bigc);
		
		
		return null;
		
	}
	
	
	
	
	@RequestMapping("insertItem.it")
	public String insertItem(Item it,Model model,HttpServletRequest request,@RequestParam(value="photo",required=false)MultipartFile photo) {
		
		
		System.out.println("item : " +it );
		System.out.println("photo:" +photo);
		
		String root=request.getSession().getServletContext().getRealPath("resources");
		Member m=new Member();
		Attachment att=new Attachment();
		AuctionDetail auctionD=new AuctionDetail();
		String date=request.getParameter("startDay");
		
		String date1=request.getParameter("endDay");
		String categoryNo=request.getParameter("categoryNo");
		
		Category category=new Category();
		category.setCategoryNo(categoryNo);
		it.setCategoryNo(categoryNo);
		
		
		java.sql.Date day=null;
		java.sql.Date day2=null;
		
		
		
		if(date != "") {
			String[] dateArr = date.split("-");
			int[] drr = new int[dateArr.length];
			
			for(int i = 0; i < dateArr.length; i++) {
				drr[i] = Integer.parseInt(dateArr[i]);
			}
			
			day = new java.sql.Date(new GregorianCalendar(drr[0], drr[1] - 1, drr[2]).getTimeInMillis());
			
			
		}else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		if(date1 != "") {
			String[] dateArr = date1.split("-");
			int[] drr = new int[dateArr.length];
			
			for(int i = 0; i < dateArr.length; i++) {
				drr[i] = Integer.parseInt(dateArr[i]);
			}
			
			day2 = new java.sql.Date(new GregorianCalendar(drr[0], drr[1] - 1, drr[2]).getTimeInMillis());
			
			
		}else {
			day2 = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		System.out.println(day);
		System.out.println(day2);
		auctionD.setStartDay(day);
		auctionD.setEndDay(day2);
		
		
		
		//m.setUserId("eagle01");
		String filePath=root+"\\uploadFiles";
		
		System.out.println("item+ " +it.getMid());
		
			
		
		String originFileName=photo.getOriginalFilename();
		String ext=originFileName.substring(originFileName.lastIndexOf("."));
		String changeName=CommonUtils.getRandomString();
		
		att.setOriginName(originFileName);
		att.setChangeName(changeName+ext);
		att.setRoot(filePath);
		
		
		Item item=new Item();
		item.setAuctionCode(request.getParameter("auctionCode"));
		System.out.println(item.getAuctionCode());
		
		
		HashMap<String,Object> hmap=new HashMap<String, Object>();
		hmap.put("m", m);
		hmap.put("attachment", att);
		hmap.put("item", it);
		hmap.put("auctionDetail",auctionD);
		hmap.put("category",category);
		System.out.println(auctionD);
		
		
		try {
			photo.transferTo(new File(filePath+"\\" +changeName+ext));
			System.out.println("contr");
			int result = is.insertItem(hmap);
			//int result=is.insertItem(it);
			System.out.println(result);
			return "redirect:goMain.it";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new File(filePath+"\\" + changeName+ ext).delete();
			model.addAttribute("msg","파일 등록 실패!");
			return "common/errorPage";
		} 
		
		
		
		
	}
	
/*	public Date calDate(int year, int month, int day) {
	      GregorianCalendar gc = new GregorianCalendar(year,month-1,day);
	      Date date = new Date(gc.getTimeInMillis());
	      System.out.println(date);
	      return date;   
	   }*/
	
	
	
	

}

