package com.kh.eg.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {
	//판매현황 상세페이지
	@RequestMapping("salesstatus.mp")
	public String salesstatusPage() {
		return "myPage/management/salesstatusMainPage";
	}
	
	//구매현황상세페이지메인
	@RequestMapping("purchasestatus.mp")
	public String purchasestatusPage() {
		return "myPage/management/purchasestatusMainPage";
	}
	
	//구매현황상세페이지 - 구매종료페이지
	@RequestMapping("purchaseend.mp")
	public String purchaseendPage() {
		return "myPage/management/purchaseendPage";
	}
	
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지
	@RequestMapping("purchaseitemdeal.mp")
	public String purchaseitemdealPage() {
		return "myPage/management/purchaseitemdealPage";
	}
	
	//구매현황상세페이지 - 구매거부/반품/미입금등기타페이지
	@RequestMapping("purchaseother.mp")
	public String purchaseotherPage() {
		return "myPage/management/purchaseotherPage";
	}
	
	//구매현황상세페이지 - 입찰중물품 - 진행중인 최고 입찰물품
	@RequestMapping("highstbiditem.mp")
	public String highstbiditemPage() {
		return "myPage/management/purchasestatusMainPage";
	}
	
	//구매현황 상세페이지 - 입찰중물품 - 진행중인 차순위 입찰 물품
	@RequestMapping("secondbiditem.mp")
	public String secondbiditemPage() {
		return "myPage/management/secondbiditemPage";
	}
	
	//구매현황 상세페이지 - 구매종료 - 낙찰받은물품
	@RequestMapping("successbid.mp")
	public String sucessbidPage() {
		return "myPage/management/purchaseendPage";
	}
	
	//구매현황 상세페이지 - 구매종료 - 낙찰받지 못한 물품
	@RequestMapping("unsuccessbid.mp")
	public String unsuccessbidPage() {
		return "myPage/management/unsuccessbidPage";
	}
}
