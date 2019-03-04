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
		/*ArrayList<SecondAdmin> list = (ArrayList)sqlSession.selectList("SecondAdmin.categoryName");
		
		for(int i=0; i<list.size();i++) {
			i = i+1;
			String si = Integer.toString(i);
			hmap.put("si", si);
			int result = sqlSession.selectOne("SecondAdmin.searchCategoryCount",hmap);
			int isi =Integer.parseInt(si);
			int isi2 = isi-1;
			list.get(isi2).setCategoryCount(result);
		}
		
		return list;
	}*/
return null;
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

}
