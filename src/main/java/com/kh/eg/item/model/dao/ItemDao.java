package com.kh.eg.item.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;

public interface ItemDao {

	int insertItem(SqlSessionTemplate sqlSession, HashMap<String, Object> hmap);

	int insertAttachment(SqlSessionTemplate sqlSession, HashMap<String, Object> hmap);


	int selectItemNoNextval(SqlSessionTemplate sqlSession);

	int insertAuctionDetail(SqlSessionTemplate sqlSession, HashMap<String, Object> hmap);

	ArrayList<Category> selectCategory(SqlSessionTemplate sqlSession);

}
