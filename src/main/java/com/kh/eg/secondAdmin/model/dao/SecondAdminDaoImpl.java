package com.kh.eg.secondAdmin.model.dao;

import java.util.ArrayList;

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

}
