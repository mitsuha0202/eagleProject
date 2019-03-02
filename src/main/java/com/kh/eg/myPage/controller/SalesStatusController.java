package com.kh.eg.myPage.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.common.Pagination;
import com.kh.eg.myPage.model.service.MyPageService;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;

@SessionAttributes("loginUser")

@Controller
public class SalesStatusController {
	
	@Autowired
	private MyPageService ms;
		
	//판매현황+ 메인페이지
		@RequestMapping("salesstatus.mp")
		public String salesstatusPage(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
			m = (Member)session.getAttribute("loginUser");
			int listCount = ms.getSaleStatus(m.getMid());
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<PayTable> list = ms.selectSaleStatusList(pi, m.getMid());
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "myPage/salesmanagement/salesstatusMainPage";
		}
		
//----------------------------------------판매 종료 페이지들------------------------------------------
		
	//판매 종료 - 경매낙찰물품
		@RequestMapping("endofsale.mp")
		public String endofsalePage(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
			m = (Member)session.getAttribute("loginUser");
			int listCount = ms.getEndOfSale(m.getMid());
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<PayTable> list = ms.selectEndOfSaleList(pi, m.getMid());
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "myPage/salesmanagement/endofsalePage";
		}
		
		@RequestMapping("bidderitem.mp")
		public String bidderItemPage(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
			m = (Member)session.getAttribute("loginUser");
			int listCount = ms.getBidderItem(m.getMid());
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			ArrayList<PayTable> list = ms.selectBidderItemList(pi, m.getMid());
			model.addAttribute("list", list);
			model.addAttribute("pi", pi);
			return "myPage/salesmanagement/bidderitemPage";
		}

//---------------------------------------------판매 물품 거래 진행중 페이지들-------------------------------------------------
		
		//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 입금요청
				@RequestMapping("salesitemprogress.mp")
				public String purchaseitemdealPage2(@RequestParam(defaultValue="1") int currentPage, @RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="currentPrice", required=false) String currentPrice, HttpSession session, Model model, Member m) {
					ArrayList<PayTable> list = null;
					PageInfo pi = null;
					m = (Member)session.getAttribute("loginUser");
					
					if(itemNo != null && !itemNo.equals("") && currentPrice != null && !currentPrice.equals("")) {
						int listCount = ms.getSalesItemProgress(m.getMid(), itemNo, currentPrice);
						pi = Pagination.getPageInfo(currentPage, listCount);			
					}else {			
						int listCount = ms.getSalesItemProgressNoParam(m.getMid());
						pi = Pagination.getPageInfo(currentPage, listCount);
					}
					
					list = ms.selectSalesItemProgressList(pi, m.getMid());
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					return "myPage/salesmanagement/purchaseitemdealPage2";
				}
			
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 배송요청
				@RequestMapping("requestdelivery2.mp")
				public String requestdeliveryPage2(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					ArrayList<PayTable> list = null;
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getRequestDeliverySale(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					list = ms.selectRequestDeliverySaleList(pi, m.getMid());

					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					return "myPage/salesmanagement/requestdeliveryPage2";
				}
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 배송중
				@RequestMapping("shipping2.mp")
				public String shippingPage2(@RequestParam(defaultValue="1") int currentPage, @RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="currentPrice", required=false) String currentPrice, HttpSession session, Model model, Member m) {
					ArrayList<PayTable> list = null;
					PageInfo pi = null;
					m = (Member)session.getAttribute("loginUser");
					
					if(itemNo != null && !itemNo.equals("") && currentPrice != null && !currentPrice.equals("")) {
						int listCount = ms.getSalesItemProgress(m.getMid(), itemNo, currentPrice);
						pi = Pagination.getPageInfo(currentPage, listCount);			
					}else {			
						int listCount = ms.getSalesItemProgressNoParam(m.getMid());
						pi = Pagination.getPageInfo(currentPage, listCount);
					}
					
					list = ms.selectSalesItemProgressList(pi, m.getMid());
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					return "myPage/salesmanagement/shippingPage2";
				}
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 구매결정대기
				@RequestMapping("purchasedecisionwaiting2.mp")
				public String purchasedecisionwaitingPage2(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getSaleWaiting(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectSaleWaitingList(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/purchasedecisionwaitingPage2";
				}
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 수령이후/송금예정
				@RequestMapping("afterreceipt2.mp")
				public String afterreceiptPage2(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getAfterReceipt2(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectAfterReceipt2List(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/afterreceiptPage2";
				}
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 거래완료 물품
				@RequestMapping("transactioncomplete2.mp")
				public String transactioncompletePage2(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getTransactionSale(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectTransactionSaleList(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/transactioncompletePage2";
				}	

//-------------------------------------------구매거부/반품/미입금/판매거부/미수령신고 페이지----------------------------
				//구매거부
				@RequestMapping("salesother.mp")
				public String salesotherPage(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getSaleOther(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectSaleOtherList(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/salesotherPage";
				}
				
				//반품
				@RequestMapping("return2.mp")
				public String return2Page(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getReturnSale(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectReturnSaleList(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					return "myPage/salesmanagement/return2Page";
				}
				
				//미입금
				@RequestMapping("payment2.mp")
				public String payment2Page(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getPaymentSale(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectPaymentSaleList(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/payment2Page";
				}
				
				//판매거부
				@RequestMapping("refusetosell2.mp")
				public String refusetosell2Page(@RequestParam(defaultValue="1") int currentPage, @RequestParam(value="itemNo", required=false) String itemNo, @RequestParam(value="currentPrice", required=false) String currentPrice, HttpSession session, Model model, Member m) {
					ArrayList<PayTable> list = null;
					PageInfo pi = null;
					m = (Member)session.getAttribute("loginUser");
					
					if(itemNo != null && !itemNo.equals("") && currentPrice != null && !currentPrice.equals("")) {
						int listCount = ms.getRefuseToSell2(m.getMid(), itemNo, currentPrice);
						pi = Pagination.getPageInfo(currentPage, listCount);			
					}else {			
						int listCount = ms.getRefuseToSell2NoParam(m.getMid());
						pi = Pagination.getPageInfo(currentPage, listCount);
					}
					
					list = ms.selectRefuseToSell2List(pi, m.getMid());
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/refusetosell2Page";
				}
				
				//미수령신고
				@RequestMapping("notreceving2.mp")
				public String notrecevingPage(@RequestParam(defaultValue="1") int currentPage, HttpSession session, Model model, Member m) {
					m = (Member)session.getAttribute("loginUser");
					int listCount = ms.getNotReceving2(m.getMid());
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					ArrayList<PayTable> list = ms.selectNotReceiving2List(pi, m.getMid());
					
					model.addAttribute("list", list);
					model.addAttribute("pi", pi);
					
					return "myPage/salesmanagement/notrecevingPage";
				}
				
}
