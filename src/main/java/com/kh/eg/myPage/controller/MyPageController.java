package com.kh.eg.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageController {
	
	@RequestMapping("myPageMain.mp")
	public String viewMyPage() {
		return "myPage/myPageMain";
	}
}
