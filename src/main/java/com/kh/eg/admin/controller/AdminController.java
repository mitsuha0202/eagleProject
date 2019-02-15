package com.kh.eg.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.exception.AdSearchMemberException;
import com.kh.eg.admin.model.service.AdMemberService;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.SearchCondition;
import com.kh.eg.common.Pagination;

@Controller
public class AdminController {
	@Autowired
	private AdMemberService ams;
	
	@RequestMapping("blackList.ad")
	public String blackListview(Model model, HttpServletRequest request){
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		
		try {
			listCount = ams.getBlackListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.selectBlackList(pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/blackList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		}
		
	}
	@RequestMapping("category.ad")
	public String categoryview(){
		return "admin/category";
	}
	
	@RequestMapping("searchMemberList.ad")
	public String serachMemberview(Model model, HttpServletRequest request){
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println(searchCondition);
		System.out.println(searchValue);
		
		SearchCondition sc = new SearchCondition();
		if(searchCondition.equals("userId")) {
			sc.setUserId(searchValue);
		}
		if(searchCondition.equals("userName")) {
			sc.setUserName(searchValue);
		}
		if(searchCondition.equals("phone")) {
			sc.setPhone(searchValue);
		}
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		try {
			listCount = ams.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.searchMemberList(sc, pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/memberList";
		} catch (AdSearchMemberException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		} 
	
	}
	
	@RequestMapping("memberList.ad")
	public String memberview(Model model, HttpServletRequest request){
		
		
		
		int currentPage = 1;
		
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		try {
			listCount = ams.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.selectBoardList(pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/memberList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		}
		
		
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
