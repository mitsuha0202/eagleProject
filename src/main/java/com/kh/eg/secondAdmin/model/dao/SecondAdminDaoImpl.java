package com.kh.eg.secondAdmin.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.secondAdmin.model.vo.SecondAdmin;

@Repository
public class SecondAdminDaoImpl implements SecondAdminDao{

	@Override
	public Member loginAdminCheck(SqlSessionTemplate sqlSession, SecondAdmin sa) {
		 
		return sqlSession.selectOne("Member.adminCheck",sa);
	}

	@Override
	public ArrayList<SecondAdmin> categoryName(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		
		
		for(int i=0; i<list.size();i++) {
			
			int result = sqlSession.selectOne("SecondAdmin.categoryCount",i+1);
				list.get(i).setCategoryCount(result);
		}
		
		for(int i =0; i<list.size();i++) {
			System.out.println(i+"번째 : "+list.get(i).getCategoryName());
			System.out.println(i+"번쨰 : "+list.get(i).getCategoryCount());
		}
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> searchCategory(SqlSessionTemplate sqlSession, HashMap<String, String> hmap) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		
		for(int i=0; i<list.size();i++) {
			i = i+1; 
			String cateNO = Integer.toString(i);  
			hmap.put("cateNO", cateNO); 
			int result = sqlSession.selectOne("SecondAdmin.searchCategoryCount",hmap); 
			System.out.println(i+"번쨰 "+result);
			int isi =Integer.parseInt(cateNO);  
			int isi2 = isi-1;  
			list.get(isi2).setCategoryCount(result);
			i= i-1;
		}
		
		return list;
	
}

	@Override
	public ArrayList<SecondAdmin> searchPrice(SqlSessionTemplate sqlSession, HashMap<String, String> hmap) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		
		int tenS =0;
		int hunS =0;
		int mil = 0;
		int max = 0;
		for(int i=0; i<list.size();i++) {
			i=i+1;
			String cateNo = Integer.toString(i);
			hmap.put("cateNo", cateNo);
			int result =sqlSession.selectOne("SecondAdmin.searchPriceTenCount",hmap);
			tenS += result;
			int isi =Integer.parseInt(cateNo);  
			int isi2 = isi-1;  
			i= i-1;
		}
		for(int i=0; i<list.size();i++) {
			i=i+1;
			String cateNo = Integer.toString(i);
			hmap.put("cateNo", cateNo);
			int result =sqlSession.selectOne("SecondAdmin.searchPriceHunCount",hmap);
			hunS += result;
			int isi =Integer.parseInt(cateNo);  
			int isi2 = isi-1;  
			i= i-1;
		}
		for(int i=0; i<list.size();i++) {
			i=i+1;
			String cateNo = Integer.toString(i);
			hmap.put("cateNo", cateNo);
			int result =sqlSession.selectOne("SecondAdmin.searchPriceMilCount",hmap);
			mil += result;
			int isi =Integer.parseInt(cateNo);  
			int isi2 = isi-1;  
			i= i-1;
		}
		for(int i=0; i<list.size();i++) {
			i=i+1;
			String cateNo = Integer.toString(i);
			hmap.put("cateNo", cateNo);
			int result =sqlSession.selectOne("SecondAdmin.searchPriceMaxCount",hmap);
			max += result;
			int isi =Integer.parseInt(cateNo);  
			int isi2 = isi-1;  
			i= i-1;
		}
		int [] arr = {tenS, hunS, mil, max};

		for(int i =0; i<arr.length;i++) {
			list.get(i).setPriceCount(arr[i]);
			System.out.println(list.get(i).getPriceCount());
		}
		return list;
	}
	@Override
	public ArrayList<SecondAdmin> categoryWeeks(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryWeeks",i+1);
			list.get(i).setCategoryCount(result);
		}
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryMonth(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryMonth",i+1);
			list.get(i).setCategoryCount(result);
		}
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryYear(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryYear",i+1);
			list.get(i).setCategoryCount(result);
		}
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceDays(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		int tenS =0;
		int hunS =0;
		int mil = 0;
		int max = 0;
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceDaysTen",i+1);
			tenS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceDaysHun",i+1);
			hunS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceDaysMil",i+1);
			mil += result;
		}
		
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceDaysMax",i+1);
			max += result;
		}

		int [] arr = {tenS, hunS, mil, max};

		for(int i =0; i<arr.length;i++) {
			list.get(i).setPriceCount(arr[i]);
			System.out.println(list.get(i).getPriceCount());
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceWeek(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		int tenS =0;
		int hunS =0;
		int mil = 0;
		int max = 0;
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceWeekTen",i+1);
			tenS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceWeekHun",i+1);
			hunS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceWeekMil",i+1);
			mil += result;
		}
		
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceWeekMax",i+1);
			max += result;
		}

		int [] arr = {tenS, hunS, mil, max};

		for(int i =0; i<arr.length;i++) {
			list.get(i).setPriceCount(arr[i]);
			System.out.println(list.get(i).getPriceCount());
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceMonth(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		int tenS =0;
		int hunS =0;
		int mil = 0;
		int max = 0;
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceMonthTen",i+1);
			tenS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceMonthHun",i+1);
			hunS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceMonthMil",i+1);
			mil += result;
		}
		
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceMonthMax",i+1);
			max += result;
		}

		int [] arr = {tenS, hunS, mil, max};

		for(int i =0; i<arr.length;i++) {
			list.get(i).setPriceCount(arr[i]);
			System.out.println(list.get(i).getPriceCount());
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> categoryPriceYear(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		int tenS =0;
		int hunS =0;
		int mil = 0;
		int max = 0;
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceYearTen",i+1);
			tenS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceYearHun",i+1);
			hunS += result;
		}
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceYearMil",i+1);
			mil += result;
		}
		
		for(int i=0; i<list.size();i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceYearMax",i+1);
			max += result;
		}

		int [] arr = {tenS, hunS, mil, max};

		for(int i =0; i<arr.length;i++) {
			list.get(i).setPriceCount(arr[i]);
			System.out.println(list.get(i).getPriceCount());
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysTen(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountDaysTen",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysHun(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountDaysHun",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysMil(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountDaysMil",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateDaysMax(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountDaysMax",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekTen(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountWeekTen",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekHun(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountWeekHun",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekMil(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountWeekMil",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateWeekMax(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountWeekMax",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}
	
	@Override
	public ArrayList<SecondAdmin> lastCateMonthTen(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountMonthTen",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthHun(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountMonthHun",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthMil(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountMonthMil",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateMonthMax(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountMonthMax",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}
	
	@Override
	public ArrayList<SecondAdmin> lastCateYearTen(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountYearTen",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearHun(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountYearHun",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearMil(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountYearMil",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	@Override
	public ArrayList<SecondAdmin> lastCateYearMax(SqlSessionTemplate sqlSession) {
		ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		for(int i =0; i<list.size(); i++) {
			int result = sqlSession.selectOne("SecondAdmin.categoryPriceCountYearMax",i+1);
			list.get(i).setCategoryCount(result);
		}
		
		return list;
	}

	
}
