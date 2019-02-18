package com.kh.eg.item.model.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.vo.AuctionDetail;
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
	public int insertItem(HashMap<String, Object> hmap) {
		
		
		int result=0;
		int itemNo=id.selectItemNoNextval(sqlSession);
		((Item)hmap.get("item")).setItemNo(itemNo);
		System.out.println((Attachment)hmap.get("attachment"));
		((Attachment)hmap.get("attachment")).setItemNo(itemNo);
		((AuctionDetail)hmap.get("auctionDetail")).setItemNo(itemNo);
		
		int result1=id.insertItem(sqlSession,hmap);
		int result2=id.insertAttachment(sqlSession,hmap);
		int result3=id.insertAuctionDetail(sqlSession,hmap);
		
		if(result1>0&&result2>0&&result3>0) {
			result=1;
		}else {
			result=0;
		}
		System.out.println(result);
		
		return result;
		
		
	}

}
