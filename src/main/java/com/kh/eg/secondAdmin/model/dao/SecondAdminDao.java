package com.kh.eg.secondAdmin.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

public interface SecondAdminDao {

	Member loginAdminCheck(SqlSessionTemplate sqlSession, SecondAdmin sa);

	ArrayList<SecondAdmin> categoryName(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> searchCategory(SqlSessionTemplate sqlSession, HashMap<String, String> hmap);

	ArrayList<SecondAdmin> categoryWeeks(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryMonth(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryYear(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryPriceDays(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryPriceWeek(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryPriceMonth(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> categoryPriceYear(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateDaysTen(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateDaysHun(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateDaysMil(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateDaysMax(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateWeekTen(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateWeekHun(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateWeekMil(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateWeekMax(SqlSessionTemplate sqlSession);
	
	ArrayList<SecondAdmin> lastCateMonthTen(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateMonthHun(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateMonthMil(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateMonthMax(SqlSessionTemplate sqlSession);
	
	ArrayList<SecondAdmin> lastCateYearTen(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateYearHun(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateYearMil(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> lastCateYearMax(SqlSessionTemplate sqlSession);

	ArrayList<SecondAdmin> searchPrice(SqlSessionTemplate sqlSession, HashMap<String, String> hmap);
	
}
