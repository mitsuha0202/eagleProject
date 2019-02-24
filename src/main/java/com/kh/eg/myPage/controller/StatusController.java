package com.kh.eg.myPage.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.common.Pagination;
import com.kh.eg.myPage.model.service.MyPageService;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.PayTable;
import com.kh.eg.myPage.common.Three;

@SessionAttributes("loginUser")

@Controller
public class StatusController {
	
	@Autowired
	private MyPageService ms;
	
//------------------------------------------입찰중물품 페이지-------------------------------------------	
	
	//구매현황상세페이지메인
	@RequestMapping("purchasestatus.mp")
	public String purchasestatusPage(HttpSession session, Model model, @RequestParam(defaultValue="1") int currentPage, Member m) {
		
		m = (Member)session.getAttribute("loginUser");
		int listCount = ms.getPayListCount(m.getMid());
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<PayTable> list = ms.selectPayList(pi, m.getMid());
		
		for(int i=0; i<list.size(); i++) {
			Three three = new Three();			
			list.get(i).setCurrentPrice((three.toNumFormat(Integer.parseInt(list.get(i).getCurrentPrice()))));
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "myPage/management/purchasestatusMainPage";
	}
	
	//구매현황상세페이지메인(최고, 차순위 갯수) 물품갯수(ajax)
	@RequestMapping("countPayListMain.mp")
	public @ResponseBody int countPayListMain(@RequestParam String userId, @RequestParam(value="key", required=false) String key) {
		int count = 0;
		if(key != null && key.equals("first")) {
			count = ms.countPayListFirst(userId);
		}else if(key != null && key.equals("second")) {
			count = ms.countPayListSecond(userId);
		}else if(key != null && key.equals("exitAuction")) {
			count = ms.countExitAuction(userId);
		}else {
			count = ms.countPayListMain(userId);
		}
		return count;
	}
		
	//구매현황상세페이지메인 - 입찰중물품 - 진행중인 최고 입찰물품
	@RequestMapping("highstbiditem.mp")
	public String highstbiditemPage(HttpSession session, Model model, @RequestParam(defaultValue="1") int currentPage, Member m) {
		
		m = (Member)session.getAttribute("loginUser");
		int listCount = ms.getPayListCount(m.getMid());
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<PayTable> topList = ms.selectPayList(pi, m.getMid());
		
		ArrayList<PayTable> list = new ArrayList<PayTable>();
		
		for(int i=0; i<topList.size(); i++) {
			if(topList.get(i).getRowBid() == 1) {
				list.add(topList.get(i));
			}
			
		}
		for(int i=0; i<list.size(); i++) {
			Three three = new Three();			
			list.get(i).setCurrentPrice((three.toNumFormat(Integer.parseInt(list.get(i).getCurrentPrice()))));
		}
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "myPage/management/firstPurchasestatus";
	}
	
	//구매현황 상세페이지 - 입찰중물품 - 진행중인 차순위 입찰 물품
	@RequestMapping("secondbiditem.mp")
	public String secondbiditemPage(HttpSession session, Model model, @RequestParam(defaultValue="1") int currentPage, Member m) {
		
		m = (Member)session.getAttribute("loginUser");
		int listCount = ms.getPayListCount(m.getMid());
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<PayTable> topList = ms.selectPayList(pi, m.getMid());
		
		ArrayList<PayTable> list = new ArrayList<PayTable>();
		
		for(int i=0; i<topList.size(); i++) {
			if(topList.get(i).getRowBid() != 1) {
				list.add(topList.get(i));
			}
		}
		for(int i=0; i<list.size(); i++) {
			Three three = new Three();			
			list.get(i).setCurrentPrice((three.toNumFormat(Integer.parseInt(list.get(i).getCurrentPrice()))));
		}
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "myPage/management/secondbiditemPage";
	}
	
	
//--------------------------------구매 종료 페이지들------------------------------------------------------	
	
	//구매현황상세페이지 - 구매종료페이지버튼, 낙찰받은물품
	@RequestMapping("purchaseend.mp")
	public String purchaseendPage(HttpSession session, Model model, @RequestParam(defaultValue="1") int currentPage, Member m) {
		
		//여기서는 순위 따져 currentPrice가 낙찰받은 금액임
		m = (Member)session.getAttribute("loginUser");
		int listCount = ms.getWinBidListCount(m.getMid());
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<PayTable> winBidList = ms.selectWinBid(pi, m.getMid());
		ArrayList<PayTable> list = new ArrayList<PayTable>();
		for(int i=0; i<winBidList.size(); i++) {
			if(winBidList.get(i).getCurrentPrice() != null) {
				Three three = new Three();			
				winBidList.get(i).setCurrentPrice((three.toNumFormat(Integer.parseInt(winBidList.get(i).getCurrentPrice()))));
			}
			if(winBidList.get(i).getRowBid() == 1) {
				list.add(winBidList.get(i));
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "myPage/management/purchaseendPage";
	}
	
	//구매현황 상세페이지 - 구매종료 - 낙찰받지 못한 물품
	@RequestMapping("unsuccessbid.mp")
	public String unsuccessbidPage(HttpSession session, Model model, @RequestParam(defaultValue="1") int currentPage, Member m) {
		
		m = (Member)session.getAttribute("loginUser");
		int listCount = ms.getFalseBidListCount(m.getMid());
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<PayTable> list = ms.selectFalseBidList(pi, m.getMid());
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getRowBid() == 1) {
				list.remove(i);
			}
		}
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "myPage/management/unsuccessbidPage";
	}
	
	
//-------------------------------구매물품 거래진행중 페이지들------------------------------------------------------	
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 입금요청
		@RequestMapping("purchaseitemdeal.mp")
		public String purchaseitemdealPage(@RequestParam(defaultValue="1") int currentPage, @RequestParam(value="itemNo", required=false) String itemNoList, HttpSession session, Model model) {
			
			Member m = (Member)session.getAttribute("loginUser");
			//아이템 번호 담기
			if(itemNoList != null && !itemNoList.equals("")) {
				String[] itemNo = itemNoList.split(",");
				int listCount = ms.getPayContinueList(itemNo);
				PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
				ArrayList<PayTable> list = ms.selectPayContinueList(pi, m.getMid(), itemNo);
				model.addAttribute("list", list);
				model.addAttribute("pi", pi);
			}else {
				int listCount = ms.getPayContinueList2(m.getMid());
				PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
				ArrayList<PayTable> list = ms.selectPayContinueList2(pi, m.getMid());
				model.addAttribute("list", list);
				model.addAttribute("pi", pi);
			}
			
			
			
			
			return "myPage/management/purchaseitemdealPage";
	}
	
	
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 입금확인중
		@RequestMapping("paymentconfirm.mp")
		public String paymentconfirmPage() {
			return "myPage/management/paymentconfirmPage";
		}
		
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 배송요청
		@RequestMapping("requestdelivery.mp")
		public String requestdeliveryPage() {
			return "myPage/management/requestdeliveryPage";
		}
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 배송중
		@RequestMapping("shipping.mp")
		public String shippingPage() {
			return "myPage/management/shippingPage";
		}
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 구매결정대기
		@RequestMapping("purchasedecisionwaiting.mp")
		public String purchasedecisionwaitingPage() {
			return "myPage/management/purchasedecisionwaitingPage";
		}
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 수령이후/송금예정
		@RequestMapping("afterreceipt.mp")
		public String afterreceiptPage() {
			return "myPage/management/afterreceiptPage";
			
		}
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 거래완료 물품
		@RequestMapping("transactioncomplete.mp")
		public String transactioncompletePage() {
			return "myPage/management/transactioncompletePage";
		}
	
//-------------------------------구매거부/반품/미입금/판매거부/미수령신고------------------------------------------------------

	//구매거부/반품/미입금/판매거부/미수령신고 - 구매거부
	@RequestMapping("purchaseother.mp")
	public String purchaseotherPage() {
		return "myPage/management/purchaseotherPage";
	}
	
	//구매거부/반품/미입금/판매거부/미수령신고 - 반품
		@RequestMapping("return.mp")
		public String returnPage() {
			return "myPage/management/returnPage";
		}
	//구매거부/반품/미입금/판매거부/미수령신고 - 미입금
		@RequestMapping("payment.mp")
		public String paymentPage() {
			return "myPage/management/paymentPage";
			
		}
	//구매거부/반품/미입금/판매거부/미수령신고 - 판매거부
		@RequestMapping("refusetosell.mp")
		public String refusetosellPage() {
			return "myPage/management/refusetosellPage";
		}
		
	//구매거부/반품/미입금/판매거부/미수령신고 - 미수령신고
		@RequestMapping("notreceving.mp")
		public String notrecevingPage() {
			return "myPage/management/notrecevingPage";
			
		}		
}
