package com.kh.eg.item.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.eg.common.CommonUtils;
import com.kh.eg.item.model.service.ItemService;
import com.kh.eg.item.model.vo.Item;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService is;
	
	@RequestMapping("goMain.it")
	public String goMain() {
		return "main/main";
	}
	
	/*@RequestMapping("itemRegist.it")
	public String itemRegist() {
		return "item/itemRegist";
	}*/
	
	
	
	@RequestMapping("itemRegist.it")
	public String insertItem(Item it,Model model,HttpServletRequest request,@RequestParam(value="photo",required=false) MultipartFile photo ) {
		
		System.out.println("item : " +it );
		System.out.println();
		
		String root=request.getSession().getServletContext().getRealPath("resources");
		
		String filePath=root+"\\uploadFiles";
		
		String originFileName=photo.getOriginalFilename();
		String ext=originFileName.substring(originFileName.lastIndexOf("."));
		String changeName=CommonUtils.getRandomString();
		
		
		try {
			photo.transferTo(new File(filePath+"\\" +changeName+ext));
			is.insertItem(it);
			return "redirect:goMain.it";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new File(filePath+"\\" + changeName+ ext).delete();
			model.addAttribute("msg","파일 등록 실패!");
			return "common/errorPage";
		} 
		
		
	}

}
