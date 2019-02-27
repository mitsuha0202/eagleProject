package com.kh.eg.secondAdmin.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.service.SecondAdminService;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@SessionAttributes("loginAdmin")

@Controller
public class SecondAdminController {
	@Autowired
	private SecondAdminService sas;
	
	@RequestMapping("adminLogin.sad")
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
	
	
	/*@RequestMapping("categoryDays")
	public ArrayList<HashMap<String, String>> categoryDays(){
		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> cName = sas.categoryName();
		HashMap<String, String> cCount = sas.categoryCount();
		
		return list;
		
	}*/
	//카테고리 일단위
	@RequestMapping("categoryDays.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryDays() {
		HashMap<String, ArrayList<SecondAdmin>> hmap = new HashMap<String, ArrayList<SecondAdmin>>();
		ArrayList<SecondAdmin> list = sas.categoryName();
		
		
		return list;
	}
	
	
	//카테고리 주단위
	@RequestMapping("categoryWeeks.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryWeeks(){
		
		ArrayList<SecondAdmin> list = sas.categoryWeeks();
		
		return list;
	}
	
	//카테고리 월단위
	@RequestMapping("categoryMonth.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryMonth(){
		
		ArrayList<SecondAdmin> list = sas.categoryMonth();
		
		return list;
	}
	
	//카테고리 연단위
	@RequestMapping("categoryYear.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryYear(){
		
		ArrayList<SecondAdmin> list = sas.categoryYear();
		
		return list;
	}

	
	
	
	
	
	@RequestMapping("categoryDaySearch.sad")
	public @ResponseBody ArrayList<SecondAdmin> categorySearch(@RequestParam(value="datepicker1") String datepicker1, @RequestParam(value="datepicker2") String datepicker2){
		
		Date startDay = null;
		Date endDay = null;
		System.out.println("datepicker1:"+datepicker1);
		System.out.println("datepicker2:"+datepicker2);
		
		/*String[] dateArr = datepicker1.split("-");
		int[] drr = new int[dateArr.length];
		
		for(int i=0;i<dateArr.length;i++) {
			drr[i] = Integer.parseInt(dateArr[i]);
		}
		
		startDay = new java.sql.Date(new GregorianCalendar(drr[0], drr[1]-1, drr[2]).getTimeInMillis());
		
		dateArr = datepicker2.split("-");
		drr = new int[dateArr.length];
		
		for(int i=0;i<dateArr.length;i++) {
			drr[i] = Integer.parseInt(dateArr[i]);
		}
		endDay = new java.sql.Date(new GregorianCalendar(drr[0], drr[1]-1, drr[2]).getTimeInMillis());
		
		System.out.println(startDay);
		System.out.println(endDay);
		HashMap<String, Date> hmap = new HashMap<String, Date>();
		hmap.put("startDay", startDay);
		hmap.put("endDay", endDay);*/
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("datepicker1", datepicker1);
		hmap.put("datepicker2", datepicker2);
		ArrayList<SecondAdmin> list = sas.searchCategory(hmap);
		return list;
	}
	
	
	
	
}
