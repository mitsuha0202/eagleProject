package com.kh.eg.emoney.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.kh.eg.board.model.vo.Board;
import com.kh.eg.emoney.model.service.emoneyService;
import com.kh.eg.emoney.model.service.emoneyServiceImpl;
import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.emoney.model.vo.Pagination;
import com.kh.eg.member.model.service.*;

@Controller
public class emoneyController {
@Autowired
private emoneyService es;

	
	//사이버머니 결제 메인페이지,리스트도 출력
	@RequestMapping("emoneyMain.em")
	public String emoneyMain(@ModelAttribute("emoney") emoney e,
		@RequestParam(defaultValue="1") int currentPage,
		HttpServletRequest request, Model model, HttpSession session) {
		Member m = new Member();
		m = (Member)session.getAttribute("loginUser");
		e.setMemberNo(m.getMid());
		System.out.println(e.getMemberNo());
		int listCount = es.getListCount(e);				
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);		
		ArrayList<emoney> list = es.selectEmoneyList(pi, e);
		if(list !=null) {
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "emoney/emoneyMain";			
		}else {
			model.addAttribute("msg", "조회실패");
			return "common/errorPage";
		}		
	}	
	//API에 전송할 값 넣는 메소드
	@RequestMapping("saveCharge.em")
	public void saveCharge(@RequestParam(value="buyer_code", required=false) String buyer_code, @RequestParam(value="amount", required=false) int amount,
			HttpSession session, emoney e, HttpServletRequest request, HttpServletResponse response) throws JsonIOException, IOException {
		
		Member m = new Member();
		m = (Member)session.getAttribute("loginUser");
		
		e.setMemberNo(m.getMid());
		e.setMoney(m.getEmoney());
		
		System.out.println("eMemberNo=mMid "+e.getMemberNo());
		System.out.println("eMoney=mEmoney " + e.getMoney());
		
		e.getMemberNo().equals(buyer_code);
		/*e.setMemberNo(buyer_code);*/
		e.setAmount(amount);
		e.setMoney(amount);
		
		System.out.println("buyer_code : " + buyer_code);
		System.out.println("amount : " + amount);
		
		
		int resultA = es.insertEmoney(e);
		int resultB = es.insertMemberEmoney(e);
		
		int result1 = resultA + resultB;
		/*int result = resultA + resultB;*/
		
		int result2 = es.updateEmoney(m);
		
		int result = result1 + result2;
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().println(result + "");
		/*new Gson().toJson(result, response.getWriter());*/
		

	}
	
	//결제하기 버튼 클릭시 결제 페이지
	@RequestMapping("charge.em")
	public String charge() {
		return "emoney/charge";
	}
	
	
	
	
	
	
	
	
	
}