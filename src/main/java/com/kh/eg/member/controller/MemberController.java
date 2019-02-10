package com.kh.eg.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.member.model.service.MemberService;
import com.kh.eg.member.model.vo.Member;

@SessionAttributes("loginUser")

@Controller
public class MemberController {
@Autowired
private MemberService ms;
@Autowired
private BCryptPasswordEncoder passwordEncoder;


	@RequestMapping("goMain.me")
	public String goMain() {
		return "main/main";
	}
	@RequestMapping("insert.me")
	public String insertMember(Member m, Model model) {
		
		
		System.out.println("member : "+ m);
		
	/*	String encPassword = passwordEncoder.encode(m.getUserPwd());*/
		
	/*	System.out.println(encPassword);
		
		m.setUserPwd(encPassword);
		
		if(m.getGender().equals("1") || m.getGender().equals("3")) {
			m.setGender("M");
		}else {
			m.setGender("F");
		}*/
		
		int result = ms.insertMember(m);
		
		if(result>0) {
			return "redirect:goMain.me";
		}else {
			model.addAttribute("msg","회원가입 실패!");
			return "common/errorPage";
		}	
	/*	return null;*/
	}
	
	@RequestMapping("loginView.me")
	public String showMemberLoginView() {
		return "member/memberLogin";
	}
	
	@RequestMapping("memberJoinView.me")
	public String showMemberJoinView() {
		return "member/memberJoin";
	}
	
	//로그인용 메소드
	@RequestMapping("login.me")
	public String loginCheck(Member m, Model model) {
		
		Member loginUser = ms.loginUser(m);
		
		if(loginUser != null) {
		model.addAttribute("loginUser",loginUser);
		
		return "redirect:goMain.me";
		}else {
			model.addAttribute("msg","로그인 실패!");
			
			return "common/errorPage";
			
		}
	}
}
