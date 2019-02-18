package com.kh.eg.bidding.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.bidding.model.dao.BiddingDao;
import com.kh.eg.bidding.model.vo.ItemDetail;

@Service
public class BiddingServiceImpl implements BiddingService{
@Autowired
private BiddingDao bd;
@Autowired
private SqlSessionTemplate sqlSession;

	@Override
	public ItemDetail selectItem(String itemNo) {
		ItemDetail ide = null;
		
		ide = bd.selectItem(sqlSession, itemNo);
		
		return ide;
	}
}
