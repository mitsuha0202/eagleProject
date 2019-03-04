package com.kh.eg.secondAdmin.model.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.dao.SecondAdminDao;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@Service
public class SecondAdminSerivceImpl implements SecondAdminService{
	@Autowired
	private SecondAdminDao sad;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	@Override
	public Member loginAdmin(SecondAdmin sa) {
		
		return sad.loginAdminCheck(sqlSession, sa);
	}

	@Override
	public ArrayList<SecondAdmin> categoryName() {
		ArrayList<SecondAdmin> list = sad.categoryName(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> searchCategory(HashMap<String, String> hmap) {
		ArrayList<SecondAdmin> list = sad.searchCategory(sqlSession, hmap);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryWeeks() {
		ArrayList<SecondAdmin> list = sad.categoryWeeks(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryMonth() {
		ArrayList<SecondAdmin> list =sad.categoryMonth(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryYear() {
		ArrayList<SecondAdmin> list =sad.categoryYear(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceDays() {
		ArrayList<SecondAdmin> list =sad.categoryPriceDays(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceWeek() {
		ArrayList<SecondAdmin> list =sad.categoryPriceWeek(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceMonth() {
		ArrayList<SecondAdmin> list =sad.categoryPriceMonth(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceYear() {
		ArrayList<SecondAdmin> list =sad.categoryPriceYear(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysTen() {
		ArrayList<SecondAdmin> list =sad.lastCateDaysTen(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysHun() {
		ArrayList<SecondAdmin> list =sad.lastCateDaysHun(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysMil() {
		ArrayList<SecondAdmin> list =sad.lastCateDaysMil(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysMax() {
		ArrayList<SecondAdmin> list =sad.lastCateDaysMax(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekTen() {
		ArrayList<SecondAdmin> list =sad.lastCateWeekTen(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekHun() {
		ArrayList<SecondAdmin> list =sad.lastCateWeekHun(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekMil() {
		ArrayList<SecondAdmin> list =sad.lastCateWeekMil(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekMax() {
		ArrayList<SecondAdmin> list =sad.lastCateWeekMax(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthTen() {
		ArrayList<SecondAdmin> list =sad.lastCateMonthTen(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthHun() {
		ArrayList<SecondAdmin> list =sad.lastCateMonthHun(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthMil() {
		ArrayList<SecondAdmin> list =sad.lastCateMonthMil(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthMax() {
		ArrayList<SecondAdmin> list =sad.lastCateMonthMax(sqlSession);
		return list;
	}
	
	@Override
	public ArrayList<SecondAdmin> lastCateYearTen() {
		ArrayList<SecondAdmin> list =sad.lastCateYearTen(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearHun() {
		ArrayList<SecondAdmin> list =sad.lastCateYearHun(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearMil() {
		ArrayList<SecondAdmin> list =sad.lastCateYearMil(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearMax() {
		ArrayList<SecondAdmin> list =sad.lastCateYearMax(sqlSession);
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> searchPrice(HashMap<String, String> hmap) {
		ArrayList<SecondAdmin> list = sad.searchPrice(sqlSession, hmap);
		return list;
	}
	
}
