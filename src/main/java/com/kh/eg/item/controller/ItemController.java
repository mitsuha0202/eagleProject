
package com.kh.eg.item.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
	public @ResponseBody ArrayList<Category> middleCategory(Model model,@RequestParam(value="cateNo") String cateNo) {
		
		System.out.println("cateNo"+cateNo);
		ArrayList<Category> category =is.selectMiddleCategory(cateNo);
		System.out.println("category: asdf" + category);
		
		return category;
		
	}
	
	
	
	
	@RequestMapping("insertItem.it")
	public  String insertItem(Item it,Model model,HttpServletRequest request,HttpServletResponse response, @RequestParam(value="photo",required=false)MultipartFile photo,
			@RequestParam(value="categoryNo" ,required=false) String cateNo,
			@RequestParam(value="categoryNo2") String cateNo2,
			MultipartHttpServletRequest mtf) {
		
		
		System.out.println("item : " +it );
		System.out.println("photo:" +photo);
		
		String root=request.getSession().getServletContext().getRealPath("resources");
		Member m=new Member();
		ArrayList<Attachment> att=new ArrayList<Attachment>();
		AuctionDetail auctionD=new AuctionDetail();
		String date=request.getParameter("startDay");
		
		String date1=request.getParameter("endDay");
		//String categoryNo=request.getParameter("categoryNo");
		
		Category category=new Category();
	
		String[] ccc = cateNo2.split(",");
		
		category.setCategoryNo(ccc[0]);
		it.setCategoryNo(ccc[0]);
		category.setUpperCategoryNo(cateNo);
		
		
		SimpleDateFormat format1=new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
		format1.format(date);
		format1.format(date1);
		
		
		
	
		/*java.sql.Date day=null;
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
		
		auctionD.setStartDay(day);
		auctionD.setEndDay(day2);*/
		
		
		
		//m.setUserId("eagle01");
		
		Item item=new Item();
		it.setAuctionCode(request.getParameter("auctionCode"));
		String luckyPrice1=(request.getParameter("luckyPrice1"));
		String luckyPrice2=(request.getParameter("luckyPrice2"));
		
		
		
		if(it.getAuctionCode().equals("AC002")) {
			
			it.setBidUnit(luckyPrice2);
			it.setStartPrice(luckyPrice1);
			
			int bidUnit1 = Integer.parseInt(it.getBidUnit());
			int startPrice1=Integer.parseInt(it.getStartPrice());
			int random=(int)(Math.random()*(bidUnit1-startPrice1+1)+startPrice1);
			it.setLucky(random);
			
		}else {
			it.setLucky(0);
		}
		
		HashMap<String,Object> hmap=new HashMap<String, Object>();
		hmap.put("m", m);
		hmap.put("attachment", att);
		hmap.put("item", it);
		hmap.put("auctionDetail",auctionD);
		hmap.put("category",category);
		System.out.println(auctionD);
		
		
		List<MultipartFile> fileList=mtf.getFiles("photo");
		
		int count = 0;
		int level = 0;
		
		
		
		for(int i=0;i<fileList.size();i++) {
			Attachment attt=new Attachment();
			String originFileName=fileList.get(i).getOriginalFilename();
			String ext=originFileName.substring(originFileName.lastIndexOf("."));
			String changeName=CommonUtils.getRandomString();
			String filePath=root+"\\uploadFiles";
						
			attt.setOriginName(originFileName);
			attt.setChangeName(changeName+ext);
			attt.setRoot(filePath);
			
			if(count == 0) {
				level = 0;
			}
			else {
				level = 1;
			}
			attt.setFileLevel(level);
			count++;
			att.add(attt);
			
			try {
				fileList.get(i).transferTo(new File(filePath+"\\"+changeName+ext));
				
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				new File(filePath+"\\" + changeName+ ext).delete();
				model.addAttribute("msg","파일 등록 실패!");
				return "common/errorPage";
			}
			
		}
		is.insertItem(hmap);
		return "redirect:mainPage.au";
		/*is.insertItem(hmap);
		return "main/main";*/
	}
		
		
		
		
		
	}
	
	



