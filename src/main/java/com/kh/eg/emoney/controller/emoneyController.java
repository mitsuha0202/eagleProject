package com.kh.eg.emoney.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class emoneyController {

	@RequestMapping("emoney.em")
	public String charge() {
		return "emoney/emoneyMain";
	}
	/*@Autowired
	private emoneyRService Rs;
	
	
	@RequestMapping("insert.p")
	public String insertPay(Pay p, Model model) {
		
		if(true) {

			return "pay/charge";
		}else {
			model.addAttribute("msg", "결제실패!");
			return "common/errorPage";
		}
		
		
	}*/
	
}
