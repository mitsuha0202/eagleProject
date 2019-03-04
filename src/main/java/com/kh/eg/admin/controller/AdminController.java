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
import com.kh.eg.admin.model.vo.Exchange;
import com.kh.eg.admin.model.vo.Notice;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.Post;
import com.kh.eg.admin.model.vo.Report;
import com.kh.eg.admin.model.vo.Return;
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

	//환전 완료
	@RequestMapping("payBackY.ad")
	public String payBackYview(Model model, HttpServletRequest request) throws AdMemberselectException{
		String[] check = request.getParameterValues("checkUser");

		System.out.println(check);

		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}

		int result;

		result = ams.payBackY(check);
		return "redirect:payBackList.ad";
	}

	//환전 거절
	@RequestMapping("payBackX.ad")
	public String payBackXview(Model model, HttpServletRequest request) throws AdMemberselectException{
		String[] check = request.getParameterValues("checkUser");

		System.out.println(check);

		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}

		int result;
		
		result = ams.payBackX(check);
		return "redirect:payBackList.ad";
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
	
	
	//사이버머니 변경
	@RequestMapping("moneyChange.ad")
	public String moneyChangeview(Model model, HttpServletRequest request) throws AdMemberselectException{
		String money = request.getParameter("moneychange");
		String[] check = request.getParameterValues("check");

		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}
		int result;
		result = ams.moneyChange(check, money);
		return "redirect:moneyList.ad";
		
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


	//환전하기 리스트
	@RequestMapping("payBackList.ad")
	public String payBackListview(Model model, HttpServletRequest request){

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;
		try {
			listCount = ams.payBackListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<Exchange> list = ams.selectPayBackList(pi);

			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/payBackList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";

		}
	}


	//공지사항 리스트
	@RequestMapping("postList.ad")
	public String postListview(Model model, HttpServletRequest request){

		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;
		try {
			listCount = ams.postListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<Post> list = ams.selectPostList(pi);

			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/postList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","회원 조회 실패!");
			return "common/errorPage";

		}
	}


	@RequestMapping("noticeList.ad")
	public String noticeListview(Model model, HttpServletRequest request){

		try {
			ArrayList<Notice> list = ams.selectNoticeList();
			model.addAttribute("list", list);
			return "admin/noticeList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","공지사항 조회 실패!");
			return "common/errorPage";
		}

	}

	@RequestMapping("noticeInsert.ad")
	public String noticeInsertView(Model model, HttpServletRequest request){

		return "admin/noticeInsert";
	}

	@RequestMapping("noticeView.ad")
	public String noticeView(Model model, HttpServletRequest request){

		return "admin/noticeView";
	}

	//반품 리스트
	@RequestMapping("returnList.ad")
	public String returnListview(Model model, HttpServletRequest request){
		int currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int listCount;

		try {
			listCount = ams.returnListCount();
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);

			ArrayList<Return> list = ams.selectReturnList(pi);

			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "admin/returnList";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","반품 조회 실패!");
			return "common/errorPage";

		}
	}
	//반품거절
	@RequestMapping("returnRefuse.ad")
	public String returnRefuseview(Model model, HttpServletRequest request){
		String[] check = request.getParameterValues("payNum");
		System.out.println(check);
		for(int i = 0; i< check.length; i++) {
			System.out.println(check[i]);
		}

		int result;

		try {
			result = ams.returnRefuse(check);
			return "redirect:returnList.ad";
		} catch (AdMemberselectException e) {
			e.printStackTrace();
			model.addAttribute("msg","반품 거절 실패!");
			return "common/errorPage";
		}
		
	}
	
		//반품승인
		@RequestMapping("returnOk.ad")
		public String returnOkview(Model model, HttpServletRequest request){
			String[] check = request.getParameterValues("payNum");
			System.out.println(check);
			for(int i = 0; i< check.length; i++) {
				System.out.println(check[i]);
			}

			int result;

			try {
				result = ams.returnOk(check);
				return "redirect:returnList.ad";
			} catch (AdMemberselectException e) {
				e.printStackTrace();
				model.addAttribute("msg","반품 승인 실패!");
				return "common/errorPage";
			}
			
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
