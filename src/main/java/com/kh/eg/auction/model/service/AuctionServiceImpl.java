package com.kh.eg.auction.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.auction.model.dao.AuctionDao;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.item.model.vo.Item;

@Service
public class AuctionServiceImpl implements AuctionService {
@Autowired
	private AuctionDao ad;
@Autowired
private SqlSessionTemplate sqlSession;

	
	@Override
	public HashMap<String, Object> selectItem(int itemNo) {
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		hmap.put("item", ad.selectItem(sqlSession,itemNo));
		hmap.put("bid", ad.selectBid(sqlSession,itemNo));
		return hmap;
		
		
		
	}

	

}
