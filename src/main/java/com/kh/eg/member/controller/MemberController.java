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
		
		m.setUserPwd(passwordEncoder.encode(m.getUserPwd()));
		
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
		
		/*System.out.println("여기 찍히냐??");
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
		}*/
		
		HashMap<String, Object> hmap = new HashMap<String, Object>();
			try {
				
				String key = new TempKey().getKey(5, false);
				MailHandler sendMail = new MailHandler(mailSender);
				sendMail.setSubject("Eagle's Auction 이메일 인증");
				sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
					.append("이메일 인증 코드 : "+key).toString());
				sendMail.setFrom("adad0306@gmail", "이글스옥션");
				sendMail.setTo(email);
				sendMail.send();
				
				int result=0;
				hmap.put("result", result);
				hmap.put("key",key);
				
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return hmap;
	}
	
	@RequestMapping("kakaoLogin.me")
	public String kakao(@RequestParam(value="userId") String userId,
			@RequestParam(value="userEmail") String userEmail,
			@RequestParam(value="password") String password, Model model) {
		
		System.out.println(userId);
		System.out.println(userEmail);
		System.out.println(password);
		
		Member m = new Member();
		m.setUserName("kakao");
		m.setPhone("010-1111-1111");
		m.setAddress("카카오 본사");
		m.setUserId(userId);
		m.setEmail(userEmail);
		m.setUserPwd(passwordEncoder.encode(password));
		int result = ms.insertKakaoUser(m);
		
		
		if(result > 0) {
		model.addAttribute("userId", userId);
		model.addAttribute("userPwd",password);
			return "redirect:snsLogin.me";
		}else {
			model.addAttribute("msg","카카오 로그인 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("snsLogin.me")
	public String snsLogin(@RequestParam(value="userId") String userId,
			@RequestParam(value="userPwd") String userPwd, Model model) {
		
		System.out.println("일단 여기오갸");
		System.out.println("snsLoginuserId : "+userId);
		System.out.println("snsLOginUserPwd : "+userPwd);
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		Member loginUser = ms.loginUser(m);
		
		if(loginUser != null) {
			model.addAttribute("loginUser",loginUser);
			return "redirect:goMain.me";
		}else {
			model.addAttribute("msg","SNS로그인 실패!");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("naverCallBack.me")
		public String naverCallBack() {
		return "member/naverCallBack";
	}
	
	@RequestMapping("naverLogin.me")
	public String naverLogin(@RequestParam String id, @RequestParam String email, 
				@RequestParam String name, @RequestParam String password, Model model ) {
		
		Member m = new Member();
		m.setUserName(name);
		m.setPhone("010-1111-1111");
		m.setAddress("네이버 본사");
		m.setUserId(id);
		m.setEmail(email);
		m.setUserPwd(passwordEncoder.encode(password));
		int result = ms.insertNaverUser(m);
		
		
		if(result > 0) {
			model.addAttribute("userId", id);
			model.addAttribute("userPwd",password);
			return "redirect:snsLogin.me";
		}else {
			model.addAttribute("msg","네이버 로그인 실패");
			return "common/errorPage";
		}
	}
}
