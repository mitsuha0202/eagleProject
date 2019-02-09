package com.kh.eg.myPage.model.service;

import java.util.ArrayList;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.MyPageBoard;

public interface MyPageService {

	ArrayList<MyPageBoard> selectMessage(Member m);
	
}
