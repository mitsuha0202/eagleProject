package com.kh.eg.myPage.model.service;

import java.util.ArrayList;

import com.kh.eg.myPage.model.vo.MyPageBoard;

public interface MyPageService {

	ArrayList<MyPageBoard> selectMessage(String memberNo);

	int deleteMessage(int[] num);
	
}
