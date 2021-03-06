package com.kh.eg.item.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.dao.MemberDao;

@Service
@Repository
public class ItemDaoImpl implements ItemDao {


	@Override
	public int insertItem(SqlSessionTemplate sqlSession, HashMap<String, Object> hmap) {
		
		return sqlSession.insert("Item.insertItem",hmap);
	}


	@Override
	public int selectItemNoNextval(SqlSessionTemplate sqlSession) {
		int abc=sqlSession.selectOne("Item.selectItemNo");
		
		return abc;
	
	}

	@Override
	public int insertAuctionDetail(SqlSessionTemplate sqlSession, HashMap<String, Object> hmap) {
		
		return sqlSession.insert("Item.insertAuctionDetail",hmap);
	}

	@Override
	public ArrayList<Category> selectCategory(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Item.selectCategory");
	}

	@Override
	public ArrayList<Category> selectMiddleCategory(SqlSessionTemplate sqlSession, String cateNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectMiddleCategory",cateNo);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate sqlSession, Attachment attachment) {
		// TODO Auto-generated method stub
		return sqlSession.insert("Item.insertAttachment",attachment);
	}
	
}
