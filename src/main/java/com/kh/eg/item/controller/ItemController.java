
package com.kh.eg.item.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.eg.attachment.model.vo.Attachment;
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
	public String itemRegist() {
	
			return "item/itemRegist";
		}
		
	
	
	@RequestMapping("insertItem.it")
	public String insertItem(Item it,Model model,HttpServletRequest request,@RequestParam(value="photo",required=false) MultipartFile photo ) {

		System.out.println("item : " +it );
		System.out.println("photo:" +photo);
		
		String root=request.getSession().getServletContext().getRealPath("resources");
		Member m=new Member();
		Attachment att=new Attachment();
		
		
		m.setUserId("eagle01");
		String filePath=root+"\\uploadFiles";
		
		System.out.println("item+ " +it.getMid());
		String originFileName=photo.getOriginalFilename();
		String ext=originFileName.substring(originFileName.lastIndexOf("."));
		String changeName=CommonUtils.getRandomString();
		
		att.setOriginName(originFileName);
		att.setChangeName(changeName);
		att.setRoot(filePath);
		
		
		
		Item item=new Item();
		item.setAuctionCode(request.getParameter("auctionCode"));
		System.out.println(item.getAuctionCode());
		
		
		HashMap<String,Object> hmap=new HashMap<String, Object>();
		hmap.put("m", m);
		hmap.put("attachment", att);
		hmap.put("item", it);
		
		
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

}

