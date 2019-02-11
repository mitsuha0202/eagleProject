package com.kh.eg.item.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.item.model.vo.Item;

public interface ItemDao {

	int insertItem(SqlSessionTemplate sqlSession, Item it);

}
