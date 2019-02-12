package com.kh.eg.item.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.dao.MemberDao;

@Service
public class ItemDaoImpl implements ItemDao {
	

	@Override
	public int insertItem(SqlSessionTemplate sqlSession, Item it) {
		System.out.println("다오");
		return sqlSession.insert("Item.insertItem",it);
		
	}
	
}
