package com.kh.eg.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesStatusController {
	
		
	//판매현황+ 메인페이지
		@RequestMapping("salesstatus.mp")
		public String salesstatusPage() {
			return "myPage/salesmanagement/salesstatusMainPage";
		}

//------------------------------판매진행중 페이지들------------------------------------------
		
	//판매진행중 - 경매입찰자가 있는 물품 
		@RequestMapping("bidderitem.mp")
		public String bidderitemPage() {
			return "myPage/salesmanagement/bidderitemPage";
		}
	
	//판매진행중 - 경매입찰자가 없는 물품
		@RequestMapping("nobidderitem.mp")
		public String nobidderitemPage() {
			return "myPage/salesmanagement/nobidderitemPage";
		}
		
//----------------------------------------판매 종료 페이지들------------------------------------------
		
	//판매 종료 - 경매낙찰물품
		@RequestMapping("endofsale.mp")
		public String endofsalePage() {
			return "myPage/salesmanagement/endofsalePage";
		}


//---------------------------------------------판매 물품 거래 진행중 페이지들-------------------------------------------------
		
		//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 입금요청
				@RequestMapping("salesitemprogress.mp")
				public String purchaseitemdealPage2() {
					return "myPage/salesmanagement/purchaseitemdealPage2";
				}
			
			
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 입금확인중
				@RequestMapping("paymentconfirm2.mp")
				public String paymentconfirmPage2() {
					return "myPage/salesmanagement/paymentconfirmPage2";
				}
				
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 배송요청
				@RequestMapping("requestdelivery2.mp")
				public String requestdeliveryPage2() {
					return "myPage/salesmanagement/requestdeliveryPage2";
				}
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 배송중
				@RequestMapping("shipping2.mp")
				public String shippingPage2() {
					return "myPage/salesmanagement/shippingPage2";
				}
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 구매결정대기
				@RequestMapping("purchasedecisionwaiting2.mp")
				public String purchasedecisionwaitingPage2() {
					return "myPage/salesmanagement/purchasedecisionwaitingPage2";
				}
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 수령이후/송금예정
				@RequestMapping("afterreceipt2.mp")
				public String afterreceiptPage2() {
					return "myPage/salesmanagement/afterreceiptPage2";
					
				}
			//구매현황상세페이지 - 판매 물품 거래 진행중 페이지 - 거래완료 물품
				@RequestMapping("transactioncomplete2.mp")
				public String transactioncompletePage2() {
					return "myPage/salesmanagement/transactioncompletePage2";
				}	

//-------------------------------------------구매거부/반품/미입금/판매거부/미수령신고 페이지----------------------------
				//구매거부
				@RequestMapping("salesother.mp")
				public String salesotherPage() {
					return "myPage/salesmanagement/salesotherPage";
				}
				//반품
				@RequestMapping("return2.mp")
				public String return2Page() {
					return "myPage/salesmanagement/return2Page";
				}
				//미입금
				@RequestMapping("payment2.mp")
				public String payment2Page() {
					return "myPage/salesmanagement/payment2Page";
				}
				//판매거부
				@RequestMapping("refusetosell2.mp")
				public String refusetosell2Page() {
					return "myPage/salesmanagement/refusetosell2Page";
				}
				//미수령신고
				@RequestMapping("notreceving2.mp")
				public String notrecevingPage() {
					return "myPage/salesmanagement/notrecevingPage";
				}
				
}
