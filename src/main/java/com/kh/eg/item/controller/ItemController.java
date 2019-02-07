package com.kh.eg.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
	
	@RequestMapping("itemRegist.it")
	public String itemRegist() {
		return "item/itemRegist";
	}

}
