package com.kh.eg.myPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.common.Pagination;
import com.kh.eg.myPage.model.service.MyPageService;
import com.kh.eg.myPage.model.vo.AnswerBoard;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.SearchCondition;
import com.kh.eg.myPage.model.vo.WishList;

@SessionAttributes("loginUser")

	@Controller
	public class MyPageController {
		
		@Autowired
		private MyPageService ms;
		
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
		
		//마이페이지로 이동
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
		   public String userMessagePage(Model model, Member m, HttpSession session, HttpServletRequest request) {
			   int currentPage = 1;
			   if(request.getParameter("currentPage") != null) {
				   currentPage = Integer.parseInt(request.getParameter("currentPage"));
			   }
			   
			   //유저번호 받기위해 
		       m = (Member)session.getAttribute("loginUser");
		       String memberNo= m.getMid();
			   
			   int listCount = ms.getListCount(memberNo);
			   PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		       
		       ArrayList<MyPageBoard> list = ms.selectMessage(pi, memberNo);
		       if(list != null) {
		          model.addAttribute("list", list);
		          model.addAttribute("pi", pi);
		          return "myPage/usesrMessagePage";
		       }else {
		          model.addAttribute("msg", "1대1 문의 조회 실패");
		          return "common/errorPage";
		       }
		    }
		   
		//위시리스트 페이지로 이동
		@RequestMapping("wishList.mp")
		public String wishList(Model model, Member m , HttpSession session) {
			m = (Member)session.getAttribute("loginUser");
			String memberNo = m.getMid();
			ArrayList<WishList> list = ms.selectWishList(memberNo);
			System.out.println(list.size());
			if(list != null) {
				model.addAttribute("list",list);
				return "myPage/wishListPage";
			}else {
				model.addAttribute("msg","위시리스트 조회 실패");
				return "common/errorPage";
			}
			
		}
		//위시리스트 삭제
		@RequestMapping("delete.mp")
		public String wishListDelete(Model model, HttpServletRequest request) {
			String[] appr = request.getParameter("wishlistno").split(",");
			int[] wishlistno = new int[appr.length];
			
			for(int i =0;i<appr.length;i++) {
				
				wishlistno[i] = Integer.parseInt(appr[i]);
				
				
			}
			int result = ms.wishListDelete(wishlistno);
			System.out.println(wishlistno[0]);
			System.out.println("업데이트 : " +result);
			if(result > 0) {
				return "redirect:wishList.mp";
			}else {
				model.addAttribute("msg", "1대1문의글 삭제 실패");
				return "common/errorPage";
			}
			
		}
		
		//회원정보 수정 페이지로 이동
		@RequestMapping("userInfoUpdatePage.mp")
		public String userInfoUpdatePage(HttpSession session, Model model) {
			Member temp = (Member)session.getAttribute("loginUser");
			Member m = ms.selectMember(temp);
			
			if(m != null) {
				model.addAttribute("m", m);
				return "myPage/userInfoUpdate";
			}else {
				model.addAttribute("msg", "회원정보 조회실패");
				return "common/errorPage";
			}
		}
		
		//회원탈퇴 페이지로 이동
		@RequestMapping("userDelete.mp")
		public String userDelete() {
			return "myPage/userDeletePage";
		}
		
		
		
		//계좌관리 페이지로 이동
		@RequestMapping("userAccount.mp")
		public String userAccount(HttpSession session, Model model, Member m) {
			m = (Member)session.getAttribute("loginUser");
			Maccount maccount = ms.selectAccount(m);
			
				model.addAttribute("maccount", maccount);
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
		public String queryBoard(Model model, Member m, HttpSession session, HttpServletRequest request) {
			int currentPage = 1;
			   if(request.getParameter("currentPage") != null) {
				   currentPage = Integer.parseInt(request.getParameter("currentPage"));
			   }
			   
			   //유저번호 받기위해 
		       m = (Member)session.getAttribute("loginUser");
		       String memberNo= m.getMid();
			   
			   int listCount = ms.getQueryListCount(memberNo);
			   PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		       
		       ArrayList<MyPageBoard> list = ms.selectQueryBoard(pi, memberNo);
		       if(list != null) {
		          model.addAttribute("list", list);
		          model.addAttribute("pi", pi);
		          return "myPage/queryBoardPage";
		       }else {
		          model.addAttribute("msg", "1대1 문의 조회 실패");
		          return "common/errorPage";
		       }

		}
		
		//문의받은게시판
		@RequestMapping("answerBoard.mp")
		public String answerBoard(Model model, Member m , HttpSession session) {
			m = (Member)session.getAttribute("loginUser");
			String memberNo = m.getMid();
			ArrayList<AnswerBoard> list = ms.answerBoard(memberNo);
			System.out.println(list.size());
			if(list != null) {
				model.addAttribute("list",list);
				return "myPage/answerBoardPage";
			}else {
				model.addAttribute("msg","위시리스트 조회 실패");
				return "common/errorPage";
			}
		}
		
		//문의게시판 검색
		@RequestMapping("querySearch.mp")
		public String searchQuery(HttpSession session, Member m, @RequestParam(value="searchCondition") String searchCondition, @RequestParam(value="searchValue") String searchValue, @RequestParam(value="saleMemberNo") String saleMemberNo,@RequestParam(defaultValue="1") int currentPage, Model model) {
			SearchCondition sc = new SearchCondition();
			HashMap<String, String> hmap = new HashMap<String, String>();
			
			//유저번호 받아옴
			m = (Member)session.getAttribute("loginUser");
			String memberNo= m.getMid();
			
			hmap.put("memberNo", memberNo);
			hmap.put("saleMemberNo", saleMemberNo);
			
			//select에 따라 value값 넣기
			if(searchCondition.equals("판매자")) {
				sc.setWriter(searchValue);
				hmap.put("saleMember", sc.getWriter());
			}
			if(searchCondition.equals("쪽지제목")) {
				sc.setTitle(searchValue);
				hmap.put("title", sc.getTitle());
			}
			
			int listCount = ms.getSearchQueryCount(hmap);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<MyPageBoard> list = ms.searchQuery(pi, hmap);
			
			if(list != null) {
				model.addAttribute("searchCondition",searchCondition);
				model.addAttribute("searchValue", searchValue);
				model.addAttribute("list",list);
				model.addAttribute("pi",pi);
			}
			
			return "myPage/searchQueryBoardPage";
		}
		
		//문의받은게시판 상세페이지
		@RequestMapping("answerPageDetail.mp")
		public String answerPageDetail() {
			return "myPage/answerPageDetailPage";
		}
		//문의받은게시판 답변눌렀을때 답변페이지
		@RequestMapping("reanswerDetail.mp")
		public String reanswerDetail() {
			return "myPage/reanswerDetailPage";
		}
		
		//1대1 상담문의
		@RequestMapping("onebyone.mp")
		public String onebyone() {
			return "myPage/onebyoneQuery";
		}
		
		//1대1 문의 삭제 
		@RequestMapping("deleteMessage.mp")
		public String deleteMessage(@RequestParam(value="deleteNum") String docNo, HttpServletRequest request, Model model) {
			String[] deleteNum = docNo.split(",");
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
		public String searchMessage(@RequestParam(value="searchCondition") String searchCondition, @RequestParam(value="searchValue") String searchValue, @RequestParam(defaultValue="1") int currentPage, Model model, HttpSession session, Member m) {
			SearchCondition sc = new SearchCondition();
			HashMap<String, String> hmap = new HashMap<String, String>();
			
			if(searchCondition.equals("판매자")) {
				sc.setWriter(searchValue);
				hmap.put("saleMember", sc.getWriter());
			}
			if(searchCondition.equals("쪽지제목")) {
				sc.setTitle(searchValue);
				hmap.put("title", sc.getTitle());
			}
			
			m = (Member)session.getAttribute("loginUser");
			String memberNo= m.getMid();
			
			hmap.put("memberNo", memberNo);
			
			int listCount  = ms.getListSearchMessageCount(hmap);
			
			PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
			
			ArrayList<MyPageBoard> list = ms.searchMessage(pi, hmap);
			
			if(list != null) {
				model.addAttribute("searchCondition",searchCondition);
				model.addAttribute("searchValue", searchValue);
				model.addAttribute("list",list);
				model.addAttribute("pi",pi);
				return "myPage/searchMessagePage";
			
			}else {
				model.addAttribute("msg","검색결과 조회 실패!");
				return "common/errorPage";
			}
		}
		
		//유저정보 수정 
		@RequestMapping("userInfoUpate.mp")
		public String userInfoUpdate(Member member, Model model, HttpServletRequest request, HttpServletResponse response) {
			String detailAddress = request.getParameter("detailAddress");
			String temp = member.getAddress();
			temp += " " + detailAddress;
			member.setAddress(temp);
			member.setUserPwd(passwordEncoder.encode(member.getUserPwd()));
			
			int result = ms.updateMember(member);
			
			if(result > 0) {
				return "redirect:myPageMain.mp";
			}else {
				model.addAttribute("msg", "회원정보 수정 실패");
				return "common/errorPage";
			}				 
		}
		
		//1대1 문의 상세보기
		@RequestMapping("detailMessage.mp")
		public String detailMessagePage(HttpServletRequest request, Model model) {
			String temp = request.getQueryString();
			String boardNo = temp.substring(6, temp.length());
			MyPageBoard myBoard = ms.selectOneBoard(boardNo);
			
			if(myBoard != null) {
				model.addAttribute("myBoard", myBoard);
				return "myPage/userMessageDetailPage";
			}else {
				model.addAttribute("msg", "상세보기 실패");
				return "common/errorPage";
			}
		}
		
		//유저 삭제
		@RequestMapping("deleteUserInfo.mp")
		public String deleteUserInfo(HttpServletRequest request, SessionStatus status, HttpServletResponse response) {
			String mid = request.getParameter("mid");
			int result = ms.deleteUserInfo(mid);
			
			if(result > 0) {
				status.setComplete();
				return "redirect:goMain.me";
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('거래중인 내역이 있어 탈퇴가 불가능합니다.'); location.href='userDelete.mp';</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return "myPage/userDeletePage";
				/*model.addAttribute("msg", "회원탈퇴 실패");
				return "common/errorPage";*/
			}
		}
		
		//계좌등록, 변경
		@RequestMapping("updateAccount.mp")
		public String updateAccount(Maccount maccount, Model model) {
			int result = ms.updateAccount(maccount);
			
			if(result > 0) {
				return "redirect:userAccount.mp";
			}else {
				model.addAttribute("msg", "계좌등록 실패");
				return "common/errorPage";
			}
		}
		
		//문의게시판 상세보기
		@RequestMapping("queryBoardDetail.mp")
		public String queryBoardDetail(HttpServletRequest request, Model model) {
			String temp = request.getQueryString();
			String boardNo = temp.substring(6, temp.length());
			MyPageBoard myBoard = ms.selectOneQuery(boardNo);
			
			if(myBoard != null) {
				model.addAttribute("myBoard", myBoard);
				return "myPage/queryBoardDetail";
			}else {
				model.addAttribute("msg", "문의게시판 상세보기 조회 실패");
				return "common/errorPage";
			}
		}
	}