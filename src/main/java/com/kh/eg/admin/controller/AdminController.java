package com.kh.eg.admin.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.service.AdMemberService;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.Category;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.Report;
import com.kh.eg.admin.model.vo.SearchCondition;
import com.kh.eg.admin.model.vo.SearchReport;
import com.kh.eg.board.model.vo.Board;
import com.kh.eg.common.Pagination;
import com.kh.eg.member.model.vo.Member;

@Controller
public class AdminController {
	@Autowired
	private AdMemberService ams;
	
	//블랙 리스트
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
	
	//카테고리 리스트
	@RequestMapping("category.ad")
	public String categoryview(Model model, HttpServletRequest request) throws AdMemberselectException{
		
		ArrayList<Category> list = ams.selectCategoryList();
		
		model.addAttribute("list", list);
		
		return "admin/category";
	}
	
	//카테고리 추가
	@RequestMapping("addcategory.ad")
	public String addcategoryview(Model model, HttpServletRequest request){
		String category = request.getParameter("category");
		String size = request.getParameter("size");
		String division = request.getParameter("division");
		
		Category cg = new Category();
		java.math.BigDecimal bd = new BigDecimal(size);
		
		cg.setCategoryName(category);
		cg.setCategoryLevel(bd);
		cg.setUppercategoryNo(division);
		
		try {
			int result = ams.insertCategory(cg);
			model.addAttribute("result", result);
			return "redirect:category.ad";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
		}
	}
	
	//카테고리 삭제
	@RequestMapping("delcategory.ad")
	public String delcategoryview(Model model, HttpServletRequest request){
		
		String category = request.getParameter("category");
		
		Category cg = new Category();
		
		cg.setCategoryName(category);
		System.out.println(category);
		try {
			int result = ams.delCategory(cg);
			model.addAttribute("result", result);
			return "redirect:category.ad";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","카테고리 삭제 실패!");
			return "common/errorPage";
		}
	}
	
	
	
	//검색 후 블랙리스트
	@RequestMapping("searchBlackList.ad")
	public String serachBlackview(Model model, HttpServletRequest request){
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
			listCount = ams.getSearchBlackListCount(sc);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.searchBlackList(sc, pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/blackList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		} 
	
	}
	
	//검색 후 회원 리스트
	@RequestMapping("searchMemberList.ad")
	public String serachMemberview(Model model, HttpServletRequest request){
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
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
			listCount = ams.getSearchListCount(sc);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.searchMemberList(sc, pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/memberList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		} 
	
	}
	
	//회원리스트
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
	
	//블랙리스트 추가
	@RequestMapping("blackListChange.ad")
	public String memberChangeview(Model model, HttpServletRequest request){
		
		String[] check = request.getParameterValues("checkUser");
		
		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}
		
		int result;
		
		try {
			result = ams.checkBlackList(check);
			return "redirect:memberList.ad";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","블랙리스트 추가 실패!");
			return "common/errorPage";
		}
		
	}
	
	//블랙리스트 해제
	@RequestMapping("blackListoff.ad")
	public String blackListoffview(Model model, HttpServletRequest request){
		
		String[] check = request.getParameterValues("checkUser");
		
		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}
		
		int result;
		
		try {
			result = ams.BlackListoff(check);
			return "redirect:blackList.ad";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","블랙리스트 해제 실패!");
			return "common/errorPage";
		}
		
	}
	
	//사이버머니 리스트
	@RequestMapping("moneyList.ad")
	public String moneyListview(Model model, HttpServletRequest request){
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		try {
			listCount = ams.getListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.memberMoneyList(pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/moneyList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		}
	}
	
	//검색 후 사이버머니 리스트
	@RequestMapping("searchMoneyList.ad")
	public String searchMoneyListview(Model model, HttpServletRequest request){
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
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
			listCount = ams.getSearchListCount(sc);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<AdminVo> list = ams.searchMoneyList(sc, pi);
			
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/moneyList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		} 
	
	}
	
	
	//신고 리스트
	@RequestMapping("reportList.ad")
	public String reportListview(Model model, HttpServletRequest request){
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		try {
			listCount = ams.reportCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Report> reportlist = ams.selectReportList(pi);
			model.addAttribute("reportlist", reportlist);
			model.addAttribute("pi", pi);
			return "admin/reportList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		}
	}
	
	//검색 후 신고 리스트
	@RequestMapping("searchReportList.ad")
	public String searchReportListview(Model model, HttpServletRequest request){
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		SearchReport sr = new SearchReport();
		if(searchCondition.equals("userId")) {
			sr.setUserId(searchValue);
		}
		if(searchCondition.equals("title")) {
			sr.setTitle(searchValue);
		}
		if(searchCondition.equals("itemNo")) {
			sr.setItemNo(searchValue);
		}
		
		int currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount;
		try {
			listCount = ams.getSearchReportListCount(sr);
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<Report> reportlist = ams.searchReportList(sr, pi);
			model.addAttribute("reportlist", reportlist);
			model.addAttribute("pi", pi);
			return "admin/reportList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";
			
		} 
	}
	
	
	
	@RequestMapping("payBackList.ad")
	public String payBackListview(){
		return "admin/payBackList";
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
