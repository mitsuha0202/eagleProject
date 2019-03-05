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
import com.kh.eg.myPage.model.vo.WinBid;
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
	
	//환급메인페이지, 리스트도 출력
		@RequestMapping("refundMain.em")
		public String refundMain(@ModelAttribute("emoney") emoney e,
				@RequestParam(defaultValue="1") int currentPage,
				HttpServletRequest request, Model model, HttpSession session) {
				Member m = new Member();
				m = (Member)session.getAttribute("loginUser");
				e.setMemberNo(m.getMid());
				System.out.println(e.getMemberNo());
				int listCount = es.getListCount(e);				
				PageInfo pi = Pagination.getPageInfo(currentPage, listCount);		
				ArrayList<emoney> list = es.refundEmoneyList(pi, e);
				if(list !=null) {
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					return "emoney/refundMain";			
				}else {
					model.addAttribute("msg", "조회실패");
					return "common/errorPage";
				}
		
		}
		
		//API에 전송할 값 넣는 메소드
		@RequestMapping("saveCharge.em")
		public String saveCharge(@RequestParam(value="buyer_code", required=false) String buyer_code, @RequestParam(value="amount", required=false) int amount,
				HttpSession session, emoney e, HttpServletRequest request, HttpServletResponse response) throws JsonIOException, IOException {
			
			Member m = new Member();
			m = (Member)session.getAttribute("loginUser");
			String id = m.getMid();
			e.setMemberNo(id);
			e.setMoney(m.getEmoney());
			
			System.out.println("eMemberNo=mMid "+e.getMemberNo());
			System.out.println("eMoney=mEmoney " + e.getMoney());
			
			e.getMemberNo().equals(buyer_code);
			/*e.setMemberNo(buyer_code);*/
			/*e.setAmount(amount);*/
			e.setMoney(amount);
			/*m.setEmoney(e.getMoney());*/
			
			System.out.println("buyer_code : " + buyer_code);
			System.out.println("amount : " + amount);
			System.out.println("memberEmoney : " + m.getEmoney());
			/*int resultA = es.insertEmoney(e);*/
			int resultB = es.insertMemberEmoney(e);
			
			/*int result1 = resultA + resultB;*/
			/*int result = resultA + resultB;*/
			
			/*int resultC = es.updateEmoney(m);*/
			int resultC = es.updateEmoney(id,buyer_code, amount);
			System.out.println("memberEMoney2 : " + m.getEmoney());
			/*int result = resultA + resultB + resultC;*/
			int result = resultB + resultC;
			if(result > 0) {			
				response.setContentType("application/json");
				response.setCharacterEncoding("utf-8");
				/*response.getWriter().println(result + "");*/
				m.setEmoney(m.getEmoney());
				System.out.println("memberEMoney3 : " + m.getEmoney());
				return "redirect:charge.em";
			}else {
				return "common/errorPage";
			}
			
			

		}
	
	@RequestMapping("refundMemberEmoney.em")
	public void refundMemberEmoney( @RequestParam(value="refundEmoney", required=false) int refundEmoney,
			HttpSession session, emoney e, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Member m = new Member();
		m = (Member)session.getAttribute("loginUser");
		e.setMemberNo(m.getMid());
		e.setMoney(m.getEmoney());
		
		System.out.println("멤버넘버찍히나? : " + e.getMemberNo());
		System.out.println("이머니찍히나? : " + e.getMoney());
		
		e.setMoney(refundEmoney);		
		System.out.println("리펀드머니찍히나? : " + refundEmoney);
		/*m.setEmoney(refundEmoney);*/
		int result1 = es.refundMemberEmoney(e);
		int result4 = es.refundEmoneyeInsert(e);
		/*int result3 = es.selectEmoneyeSq(e);*/
		/*int result2 = es.updateRefundEmoney(m, e);*/
		
		/*int result = result1 + result2 + result3 + result4;*/
		/*int result = result1 + result4 + result3;*/
		int result = result1 + result4;
	
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().println(result + "");
		
	}
	
	
	
	
	//입금요청에서 배송요청갈때
	@RequestMapping("paymentA.em")
	public String paymentA( @RequestParam(value="itemNo") String itemNo,Model model,HttpSession session, @RequestParam(value="currentPrice") String currentPrice , HttpServletRequest request, HttpServletResponse response) {
		
		Member m = new Member();
		m = (Member)session.getAttribute("loginUser");
		String id = m.getMid();
		System.out.println("멤버 아이디 : " + id);
		System.out.println("아이템 번호 : " + itemNo);
		System.out.println("아이템 가격 : " + currentPrice);
		int result = es.paymentA(id,itemNo,currentPrice);
		if(result>0) {
			return "redirect:requestdelivery.mp";
		}else {
			model.addAttribute("msg","배송요청 실패");
			return "common/errorPage";
		}
		
	}
	
	
	//결제하기 버튼 클릭시 결제 페이지
	@RequestMapping(value="charge.em", method = RequestMethod.GET)
	public String charge() {
		return "emoney/charge";
	}
	
	//환급하기 버튼 클릭시 환급 페이지
	@RequestMapping("refund.em")
	public String refund() {
		return "emoney/refund";
	}
	
	
	
	
	
	
	
	
	
	
	
}