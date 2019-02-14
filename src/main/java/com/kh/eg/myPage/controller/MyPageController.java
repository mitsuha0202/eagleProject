package com.kh.eg.myPage.controller;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
		public String myPageMainPage() {
			
		   return "myPage/myPageMain";
		   }
		
		//회원등급 혜택안내 페이지로 이동
		@RequestMapping("userGradeInfo.mp")
		public String userGradeInfoPage() {
			
			return "myPage/userGradeInfoPage";
		}
		
		//게시글 개수 조회
		@RequestMapping("countMessage.mp")
		public @ResponseBody String countMessage(@RequestParam String userId) {
		      int count = ms.countMessage(userId);
		      String messageCount = String.valueOf(count);
		      return messageCount;
		}
		
		//쪽지함 페이지로 이동
		   @RequestMapping("userMessage.mp")
		   public String userMessagePage(Model model, Member m, HttpSession session) {
		      m = (Member)session.getAttribute("loginUser");
		      String memberNo= m.getMid();
		      ArrayList<MyPageBoard> list = ms.selectMessage(memberNo);
		      if(list != null) {
		         model.addAttribute("list", list);
		         return "myPage/usesrMessagePage";
		      }else {
		         model.addAttribute("msg", "1대1 문의 조회 실패");
		         return "common/errorPage";
		      }
		   }
		
		//회원정보 수정 페이지로 이동
		@RequestMapping("userInfoUpdatePage.mp")
		public String userInfoUpdatePage() {
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
		
		//1대1 문의 삭제 
		@RequestMapping("deleteMessage.mp")
		public String deleteMessage(HttpServletRequest request, Model model) {
			String[] delete = request.getQueryString().split(",");
			String[] deleteNum = new String[delete.length];
			for(int i=0; i<deleteNum.length; i++) {
				deleteNum[i] = delete[i].substring(10, delete[i].length());
			}
			int[] num = new int[deleteNum.length];
			for(int i=0; i<deleteNum.length; i++) {
				num[i] = Integer.parseInt(deleteNum[i]);
			}
			int result = ms.deleteMessage(num);
			if(result > 0) {
				return "redirect:userMessage.mp";
			}else {
				model.addAttribute("msg", "1대1문의글 삭제 실패");
				return "common/errorPage";
			}
		}
		
		//1대1 문의 작성
		@RequestMapping("insertMessage.mp")
		public String insertMessage(Model model, MyPageBoard myPage) {
			int result = ms.insertMessage(myPage);
	
			if(result >0) {
				return "redirect:userMessage.mp";
			}else {
				return "common/errorPage";
			}
		}
		
		//1대1 문의 검색
		@RequestMapping("searchMessage.mp")
		public String searchMessage(@RequestParam(value="search") String search, @RequestParam(value="searchTitle") String searchTitle, Model model) {
			ArrayList<MyPageBoard> list = ms.searchMessage(search, searchTitle);
			if(list != null) {
				model.addAttribute("list", list);
				return "myPage/usesrMessagePage";
			}else {
				model.addAttribute("msg", "검색조회 실패");
				return "common/errorPage";
			}
		}
		
		//유저정보 수정 
		@RequestMapping("userInfoUpate.mp")
		public String userInfoUpdate(Member member, Model model, HttpServletRequest request) {
			String detailAddress = request.getParameter("detailAddress");
			String temp = member.getAddress();
			temp += " " + detailAddress;
			member.setAddress(temp);
			System.out.println(member);
			return null;
		}
		
		//1대1 문의 상세보기
		@RequestMapping("detailMessage.mp")
		public String detailMessagePage(HttpServletRequest request, Model model) {
			String temp = request.getQueryString();
			String boardNo = temp.substring(6, temp.length());
			System.out.println(boardNo);
			MyPageBoard myBoard = ms.selectOneBoard(boardNo);
			System.out.println(myBoard);
			if(myBoard != null) {
				model.addAttribute("myBoard", myBoard);
				return "myPage/userMessageDetailPage";
			}else {
				model.addAttribute("msg", "상세보기 실패");
				return "common/errorPage";
			}
		}
	}