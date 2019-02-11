package com.kh.eg.member.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("logout.me")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:goMain.me";
	}
	
	@RequestMapping("duplicationCheck.me")
	public @ResponseBody HashMap<String, Object> 
			duplicationCheck(@RequestParam String userId,
							HttpServletResponse response){
		
		System.out.println("여기 찍히냐??");
		int result = 0;
		
		result = ms.idDuplicationCheck(userId);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		System.out.println("result : "+result);
		hmap.put("result", result);
		
		return hmap;
		
	}

	
	
	
	
	
}
