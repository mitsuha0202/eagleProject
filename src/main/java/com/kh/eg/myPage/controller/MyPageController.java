package com.kh.eg.myPage.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.service.MyPageService;
import com.kh.eg.myPage.model.vo.MyPageBoard;

@SessionAttributes("loginUser")

@Controller
public class MyPageController {
	
	@Autowired
	private MyPageService ms;
	
	@RequestMapping("myPageMain.mp")
	public String myPageMainPage(Model model, Member m, HttpSession session) {
		m = (Member)session.getAttribute("loginUser");
		if(m == null) {
			return "myPage/noLogin";
		}else {
			return "myPage/myPageMain";
		}
	}
	
	//회원등급 혜택안내 페이지로 이동
	@RequestMapping("userGradeInfo.mp")
	public String userGradeInfoPage() {
		return "myPage/userGradeInfoPage";
	}
	
	//쪽지함 페이지로 이동
	@RequestMapping("userMessage.mp")
	public String userMessagePage(Model model, Member m, HttpSession session) {
		m = (Member)session.getAttribute("loginUser");
		String memberNo= m.getMid();
		ArrayList<MyPageBoard> list = ms.selectMessage(memberNo);		
		return null;
	}
	
	//회원정보 수정 페이지로 이동
	@RequestMapping("userInfoUpdate.mp")
	public String userInfoUpdate() {
		return "myPage/userInfoUpdate";
	}
	
	//회원탈퇴 페이지로 이동
	@RequestMapping("userDelete.mp")
	public String userDelete() {
		return "myPage/userDeletePage";
	}
	
	//위시리스트 페이지로 이동
	@RequestMapping("wishList.mp")
	public String wishList() {
		return "myPage/wishListPage";
	}
	
	//계좌관리 페이지로 이동
	@RequestMapping("userAccount.mp")
	public String userAccount() {
		return "myPage/accountPage";
	}
	
	//계좌변경  페이지로 이동
	@RequestMapping("accountUpdate.mp")
	public String accountUpdate() {
		return "myPage/accountUpdatePage";
	}
	
	//사이트 이용안내 페이지로 이동
	@RequestMapping("egAuctionInfo.mp")
	public String egAuctionInfo() {
		return "myPage/egAuctionInfoPage";
	}
	
	//문의게시판
	@RequestMapping("queryBoard.mp")
	public String queryBoard() {
		return "myPage/queryBoardPage";
	}
	
	//문의받은게시판
	@RequestMapping("answerBoard.mp")
	public String answerBoard() {
		return "myPage/answerBoardPage";
	}
	
	//1대1 상담문의
	@RequestMapping("onebyone.mp")
	public String onebyone() {
		return "myPage/onebyoneQuery";
	}
}