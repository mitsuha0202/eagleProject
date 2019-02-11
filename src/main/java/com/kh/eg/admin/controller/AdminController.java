package com.kh.eg.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("blackList.ad")
	public String blackListview(){
		return "admin/blackList";
	}
	@RequestMapping("category.ad")
	public String categoryview(){
		return "admin/category";
	}
	@RequestMapping("memberList.ad")
	public String memberview(){
		return "admin/memberList";
	}
	@RequestMapping("reportList.ad")
	public String reportListview(){
		return "admin/reportList";
	}
	@RequestMapping("payBackList.ad")
	public String payBackListview(){
		return "admin/payBackList";
	}
	@RequestMapping("moneyList.ad")
	public String moneyListview(){
		return "admin/moneyList";
	}
	@RequestMapping("postList.ad")
	public String postListview(){
		return "admin/postList";
	}
	@RequestMapping("noticeList.ad")
	public String noticeListview(){
		return "admin/noticeList";
	}
	@RequestMapping("returnList.ad")
	public String returnListview(){
		return "admin/returnList";
	}
	@RequestMapping("statList1.ad")
	public String statList1view(){
		return "admin/statList1";
	}
	@RequestMapping("statList2.ad")
	public String statList2view(){
		return "admin/statList2";
	}
	@RequestMapping("login.ad")
	public String loginview(){
		return "admin/login";
	}
	
	
	
	
	
}
