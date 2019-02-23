package com.kh.eg.secondAdmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.admin.model.service.AdMemberService;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.service.SecondAdminService;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@SessionAttributes("loginAdmin")

@Controller
public class SecondAdminController {
	@Autowired
	private SecondAdminService sas;
	
	@RequestMapping("adminLogin")
	public String adminLogin(@RequestParam String memberId, @RequestParam String memberPwd, Model model, SecondAdmin sa) {
		
		if(!memberId.equals("admin")) {
			model.addAttribute("msg", "잘못된 접근입니다. 관리자만 접근 가능합니다.");
			return "common/errorPage";
		}else {
			sa.setMemberId(memberId);
			sa.setMemberPwd(memberPwd);
			Member loginAdmin = sas.loginAdmin(sa);
			if(loginAdmin == null) {
				model.addAttribute("msg", "잘못된 접근입니다. 관리자만 접근 가능합니다.");
				return "common/errorPage";
			}else {
				model.addAttribute("loginAdmin", loginAdmin);
				return "redirect:memberList.ad";
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
}
