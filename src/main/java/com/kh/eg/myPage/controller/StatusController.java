package com.kh.eg.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {
	
	
	
	
	
	
	
	
//------------------------------------------입찰중물품 페이지-------------------------------------------	
	
	//구매현황상세페이지메인
	@RequestMapping("purchasestatus.mp")
	public String purchasestatusPage() {
		return "myPage/management/purchasestatusMainPage";
	}
		
	//구매현황상세페이지메인 - 입찰중물품 - 진행중인 최고 입찰물품
	@RequestMapping("highstbiditem.mp")
	public String highstbiditemPage() {
		return "myPage/management/purchasestatusMainPage";
	}
	
	//구매현황 상세페이지 - 입찰중물품 - 진행중인 차순위 입찰 물품
	@RequestMapping("secondbiditem.mp")
	public String secondbiditemPage() {
		return "myPage/management/secondbiditemPage";
	}
	
	
//--------------------------------구매 종료 페이지들------------------------------------------------------	
	
	//구매현황상세페이지 - 구매종료페이지버튼
	@RequestMapping("purchaseend.mp")
	public String purchaseendPage() {
		return "myPage/management/purchaseendPage";
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
	
	
//-------------------------------구매물품 거래진행중 페이지들------------------------------------------------------	
	//구매현황상세페이지 - 구매 물품 거래 진행중 페이지 - 입금요청
		@RequestMapping("purchaseitemdeal.mp")
		public String purchaseitemdealPage() {
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
