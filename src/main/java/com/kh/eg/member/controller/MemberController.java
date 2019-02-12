package com.kh.eg.member.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.kh.eg.member.model.vo.MailHandler;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.member.model.vo.TempKey;

@SessionAttributes("loginUser")

@Controller
public class MemberController {
@Autowired
private MemberService ms;
@Autowired
private BCryptPasswordEncoder passwordEncoder;
@Autowired
private JavaMailSender mailSender;


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
	
	@RequestMapping("registerEmail.me")
	public @ResponseBody HashMap<String, Object> 
				emailCheck(@RequestParam String email,
						HttpServletResponse response) throws MessagingException{
		
		System.out.println("여기 찍히냐??");
		int result = 0;
		
		result = ms.emailDuplicationCheck(email);
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		if(result > 0) {
			result = 1;
			hmap.put("result", result);
			
			return hmap;
		}else {
			try {
			String key = new TempKey().getKey(5, false);
			MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("Eagle's Auction 이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
				.append("이메일 인증 코드 : "+key).toString());
				        
				sendMail.setFrom("adad0306@gmail", "이글스옥션");
				sendMail.setTo(email);
				sendMail.send();
				
				result=0;
				hmap.put("result", result);
				hmap.put("key",key);
			} catch (UnsupportedEncodingException e) {
			
				e.printStackTrace();
			}
			return hmap;
		}
		
	}
	
	
	
	
	
}
