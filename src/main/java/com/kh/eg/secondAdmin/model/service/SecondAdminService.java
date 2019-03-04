package com.kh.eg.secondAdmin.model.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

public interface SecondAdminService {

	Member loginAdmin(SecondAdmin sa);

	ArrayList<SecondAdmin> categoryName();

	ArrayList<SecondAdmin> searchCategory(HashMap<String, String> hmap);

	ArrayList<SecondAdmin> categoryWeeks();

	ArrayList<SecondAdmin> categoryMonth();

	ArrayList<SecondAdmin> categoryYear();

	ArrayList<SecondAdmin> categoryPriceDays();

	ArrayList<SecondAdmin> categoryPriceWeek();

	ArrayList<SecondAdmin> categoryPriceMonth();

	ArrayList<SecondAdmin> categoryPriceYear();

	ArrayList<SecondAdmin> lastCateDaysTen();

	ArrayList<SecondAdmin> lastCateDaysHun();

	ArrayList<SecondAdmin> lastCateDaysMil();

	ArrayList<SecondAdmin> lastCateDaysMax();

	ArrayList<SecondAdmin> lastCateWeekTen();

	ArrayList<SecondAdmin> lastCateWeekHun();

	ArrayList<SecondAdmin> lastCateWeekMil();

	ArrayList<SecondAdmin> lastCateWeekMax();
	
	ArrayList<SecondAdmin> lastCateMonthTen();

	ArrayList<SecondAdmin> lastCateMonthHun();

	ArrayList<SecondAdmin> lastCateMonthMil();

	ArrayList<SecondAdmin> lastCateMonthMax();

	ArrayList<SecondAdmin> lastCateYearTen();

	ArrayList<SecondAdmin> lastCateYearHun();

	ArrayList<SecondAdmin> lastCateYearMil();

	ArrayList<SecondAdmin> lastCateYearMax();

	ArrayList<SecondAdmin> searchPrice(HashMap<String, String> hmap);

}
