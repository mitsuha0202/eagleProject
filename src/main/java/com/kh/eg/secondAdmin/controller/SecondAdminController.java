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
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("datepicker1", datepicker1);
		hmap.put("datepicker2", datepicker2);
		ArrayList<SecondAdmin> list = sas.searchCategory(hmap);
		return list;
	}
	
	@RequestMapping("priceDaySearch.sad")
	public @ResponseBody ArrayList<SecondAdmin> priceSearch(@RequestParam(value="datepicker1") String datepicker1, @RequestParam(value="datepicker2") String datepicker2){
		
		Date startDay = null;
		Date endDay = null;
		System.out.println("datepicker1:"+datepicker1);
		System.out.println("datepicker2:"+datepicker2);
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("datepicker1", datepicker1);
		hmap.put("datepicker2", datepicker2);
		ArrayList<SecondAdmin> list = sas.searchPrice(hmap);
		return list;
	}
	
	@RequestMapping("categoryPriceDays.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryPriceDays() {
		ArrayList<SecondAdmin> list = sas.categoryPriceDays();
		
		
		return list;
	}
	
	@RequestMapping("categoryPriceWeek.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryPriceWeek() {
		ArrayList<SecondAdmin> list = sas.categoryPriceWeek();
		
		
		return list;
	}
	
	@RequestMapping("categoryPriceMonth.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryPriceMonth() {
		ArrayList<SecondAdmin> list = sas.categoryPriceMonth();
		
		
		return list;
	}
	
	@RequestMapping("categoryPriceYear.sad")
	public @ResponseBody ArrayList<SecondAdmin> categoryPriceYear() {
		ArrayList<SecondAdmin> list = sas.categoryPriceYear();
		
		
		return list;
	}
	
	@RequestMapping("statList3.sad")
	public String statList3() {
		
		
		return "admin/statList3";
	}
	
	@RequestMapping("lastCateDaysTen.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateDaysTen(){
		ArrayList<SecondAdmin> list = sas.lastCateDaysTen();
		
		return list;
	}
	
	@RequestMapping("lastCateDaysHun.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateDaysHun(){
		ArrayList<SecondAdmin> list = sas.lastCateDaysHun();
		
		return list;
	}
	
	@RequestMapping("lastCateDaysMil.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateDaysMil(){
		ArrayList<SecondAdmin> list = sas.lastCateDaysMil();
		
		return list;
	}
	
	@RequestMapping("lastCateDaysMax.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateDaysMax(){
		ArrayList<SecondAdmin> list = sas.lastCateDaysMax();
		
		return list;
	}
	
	@RequestMapping("lastCateWeekTen.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateWeekTen(){
		ArrayList<SecondAdmin> list = sas.lastCateWeekTen();
		
		return list;
	}
	
	@RequestMapping("lastCateWeekHun.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateWeekHun(){
		ArrayList<SecondAdmin> list = sas.lastCateWeekHun();
		
		return list;
	}
	
	@RequestMapping("lastCateWeekMil.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateWeekMil(){
		ArrayList<SecondAdmin> list = sas.lastCateWeekMil();
		
		return list;
	}
	
	@RequestMapping("lastCateWeekMax.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateWeekMax(){
		ArrayList<SecondAdmin> list = sas.lastCateWeekMax();
		
		return list;
	}
	
	@RequestMapping("lastCateMonthTen.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateMonthTen(){
		ArrayList<SecondAdmin> list = sas.lastCateMonthTen();
		
		return list;
	}
	
	@RequestMapping("lastCateMonthHun.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateMonthHun(){
		ArrayList<SecondAdmin> list = sas.lastCateMonthHun();
		
		return list;
	}
	
	@RequestMapping("lastCateMonthMil.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateMonthMil(){
		ArrayList<SecondAdmin> list = sas.lastCateMonthMil();
		
		return list;
	}
	
	@RequestMapping("lastCateMonthMax.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateMonthMax(){
		ArrayList<SecondAdmin> list = sas.lastCateMonthMax();
		
		return list;
	}
	
	@RequestMapping("lastCateYearTen.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateYearTen(){
		ArrayList<SecondAdmin> list = sas.lastCateYearTen();
		
		return list;
	}
	
	@RequestMapping("lastCateYearHun.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateYearHun(){
		ArrayList<SecondAdmin> list = sas.lastCateYearHun();
		
		return list;
	}
	
	@RequestMapping("lastCateYearMil.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateYearMil(){
		ArrayList<SecondAdmin> list = sas.lastCateYearMil();
		
		return list;
	}
	
	@RequestMapping("lastCateYearMax.sad")
	public @ResponseBody ArrayList<SecondAdmin> lastCateYearMax(){
		ArrayList<SecondAdmin> list = sas.lastCateYearMax();
		
		return list;
	}
	
}
