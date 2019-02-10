package com.kh.eg.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.item.model.service.ItemService;
import com.kh.eg.item.model.vo.Item;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService is;
	
	/*@RequestMapping("goMain.it")
	public String goMain() {
		return "main/main";
	}*/
	
	@RequestMapping("itemRegist.it")
	public String itemRegist() {
		return "item/itemRegist";
	}
	
	
	
/*	@RequestMapping("insertItem.it")
	public String insertItem(Item it,Model model) {
		
		System.out.println("item : " +it );
		
		
		return "redirect:goMain.it";
	}*/

}
