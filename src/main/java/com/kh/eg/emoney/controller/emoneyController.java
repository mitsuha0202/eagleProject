package com.kh.eg.emoney.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.emoney.model.service.emoneyService;

@Controller
public class emoneyController {
/*@Autowired
private emoneyService es;*/
	
	//사이버머니 결제 메인페이지
	@RequestMapping("emoneyMain.em")
	public String emoneyMain() {
		return "emoney/emoneyMain";
	}
	//결제하기 버튼 클릭시 결제 페이지
	@RequestMapping("charge.em")
	public String charge() {
		return "emoney/charge";
	}
	
	
	
	/*//결제내역 리스트 페이지
	@RequestMapping("emoneyList.em")
	public String emoneyList() {
		return "emoney/emoneyList";
	}*/
	
	//충전api 페이지
	@RequestMapping("chargeAPI.em")
	public String chargeAPI() {
		return "emoney/chargeAPI";
	}
	
	/*//API에 전송할 값 넣는 메소드
	@RequestMapping("saveCharge.em")
	public String saveCharge() {
		return "emoney/charge";
	}
	*/
	
	
	
	
	
}
