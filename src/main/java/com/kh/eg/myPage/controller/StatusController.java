package com.kh.eg.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {
	//판매현황 상세페이지
	@RequestMapping("salesstatus.mp")
	public String salesstatusPage() {
		return "myPage/salesstatusMainPage";
	}
	
	//구매현황상세페이지
	@RequestMapping("purchasestatus.mp")
	public String purchasestatusPage() {
		return "myPage/purchasestatusMainPage";
	}
}
