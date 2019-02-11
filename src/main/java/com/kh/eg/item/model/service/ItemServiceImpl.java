package com.kh.eg.item.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.item.model.dao.ItemDao;
import com.kh.eg.item.model.vo.Item;

@Service
public class ItemServiceImpl implements ItemService {
@Autowired
private SqlSessionTemplate sqlSession;
@Autowired
private ItemDao id;
@Autowired
private DataSourceTransactionManager transactionManager;
	
	
	@Override
	public int insertItem(Item it) {
		
		int result=0;
		int result1=id.insertItem(sqlSession,it);
		
		if(result1>0) {
			result=1;
		}else {
			result=0;
		}
		
		
		return result;
	}

}
