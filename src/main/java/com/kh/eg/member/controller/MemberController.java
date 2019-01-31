package com.kh.eg.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.eg.member.model.service.MemberService;
import com.kh.eg.member.model.vo.Member;

@Controller
public class MemberController {
@Autowired
private MemberService ms;
@Autowired
private BCryptPasswordEncoder passwordEncoder;

@RequestMapping("insert.me")
public String insertMember(Member m, Model model) {
	
	
	System.out.println("member : "+ m);
	
	//bcrypt란?
	//DB에 비밀번호를 저장할 목적으로 설계되었다.
	
	//sha-512는 단방향 해쉬 함수
	//단방향 해쉬 함수는 암호화된 메세지를 수학적인 연산을 통해 암호화된 메세지인 다이제스트를 생성한다.
	//원본 메세지를 가지고 암호화된 메세지를 복호화할 수 있는 것을 양방향이라 하고
	//암호화된 메세지를 복호화 할 수 없는 것을 단방향이라고 한다.
	
	//단방향 해쉬 함수도 사용하면 안되는 이유
	//1. 단방향 해쉬함수는 많은 다이제스트가 확보되면 평문을 찾아낼 수 있다.
	//위에가 무슨말이나면 다이제스트가 많이 생기면 일정한 규칙이 보이면서 역방향으로 찾아낼 수 있음
	
	//2. 비밀번호를 저장하기 위한 목적으로 설계된 알고리즘이 아닌,
	//	  검색을 위해 설계된 알고리즘이다.
	
	//이를 해결하기 위해 슬링(salting)기법이 추가되었다.
	//원본 메세지에 문자열을 추가하여 동일한 길의 다이제스트를 생성하는 것을 슬링이라 한다.
	
	//하지만 salt값을 알아내면 나머지는 단방향 해쉬함수를 통한 다이제스트를 복호화 하는 것과
	//별 차이가 없다.
	
	//bcrypt방식은 이러한 salt값을 랜덤하게 생성하여 암호화를 하는 방식
	//추가적으로 다이제스트를 생성하는데 걸릴 시간을 결정할 수도 있다.
	
	//1999년에 발표되어 현재까지 사용되는 가장 강력한 비밀번호 저장용 매커니즘이다.
	
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
}
