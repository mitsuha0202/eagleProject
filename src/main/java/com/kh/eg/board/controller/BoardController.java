package com.kh.eg.board.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.eg.board.model.service.BoardService;
import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Pagination;
import com.kh.eg.board.model.vo.Reply;
import com.kh.eg.board.model.vo.SearchCondition;
import com.kh.eg.member.model.vo.Member;

@Controller
public class BoardController {
@Autowired
private BoardService bs;
	
	@RequestMapping("goBoard.bo")
	public String goBoard(@ModelAttribute("Board") Board b,
			@RequestParam(defaultValue="1") int currentPage,
			HttpServletRequest request, Model model){
		
		int listCount  = bs.getListCount();
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = bs.selectBoardList(pi);
		System.out.println("list : "+list);
		for(int i=0; i<list.size();i++) {
			list.get(i).setbCount(list.get(i).getbCount());
		}
		if(list != null) {
			model.addAttribute("list",list);
			model.addAttribute("pi",pi);
			return "board/board";
		
		}else {
			model.addAttribute("msg","자유게시판 조회 실패!");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("insertBoardView.bo")
	public String showInsertBoardView(){
		return "board/insertBoard";
	}
	
	@RequestMapping("insertBoard.bo")
	public String insertBoard(Board b, Model model, HttpSession session) {
		
		Member m = new Member();
		
		m = (Member)session.getAttribute("loginUser");
		
		b.setbMid(m.getMid());
		int result = bs.insertBoard(b);
		
		return "redirect:goBoard.bo";
	}
	
	@RequestMapping("boardSelectOne.bo")
	public String boardSelectOne(@RequestParam String bid, Model model){
		System.out.println(bid);
		Board b = bs.selectOneBoard(bid);
		
		if(b == null) {
			model.addAttribute("msg", "게시판 상세보기 실패!");
			return "common/errorPage";
		}else {
			model.addAttribute("b", b);
			return "board/boardDetail";
		}
		
	}
	
	@RequestMapping("insertReply.bo")
	public String insertReply(@RequestParam(value="bid") String bid, @RequestParam String rContent, Reply r, HttpSession session) {
		Member m = new Member();
		m = (Member)session.getAttribute("loginUser");
		System.out.println("reContent:" +r.getrContent());
		System.out.println("bid :" +bid);
		r.setrContent(rContent);
		r.setReBid(bid);
		r.setReMid(m.getMid());
		int result = bs.insertReply(r);
		
		return "redirect:boardSelectOne.bo?bid="+bid;	
		
	}
	
	@RequestMapping("deleteBoard.bo")
	public String insertReply(@RequestParam String bid, Model model) {
		
		int result =bs.deleteBoard(bid);
		
		if(result>0) {
			return "redirect:goBoard.bo";
		}else {
			model.addAttribute("msg","게시물 삭제 실패!");
			return "common/errorPage";
		}
	}
	@RequestMapping("replyCount.bo")
	public @ResponseBody HashMap<String, Object> replyCount(@RequestParam String bid){
		HashMap<String, Object> hmap = new HashMap<String, Object>();
		
		int result = bs.replyCount(bid);
		
		hmap.put("result",result);
		
		return hmap;
	}
	
	@RequestMapping("updateBoardView.bo")
	public  String updateBoardView(@RequestParam String bid, Board b, Model model) {
		
		b = bs.selectOneBoard(bid);
		
		if(b == null) {
			model.addAttribute("msg","수정 보기 실패!");
			return "common/errorPage";
		}else {
			model.addAttribute("b",b);
			return "board/updateBoard";
		}
	}
	
	@RequestMapping("updateBoard.bo")
	public String updateBoardView(@RequestParam String bid, @RequestParam String updateC,Board b,Model model) {
		b.setBid(bid);
		b.setbContent(updateC);
		
		int result = bs.updateBoard(b);
		
		if(result>0) {
			return "redirect:boardSelectOne.bo?bid="+bid;
		}else {
			model.addAttribute("msg","글 수정 실패!");
			return "common/errorPage";
		}	
	}
	
	@RequestMapping("searchBoard.bo")
	public String searchBoard(@RequestParam String searchCondition, @RequestParam String searchValue
			,Model model, @RequestParam(defaultValue="1") int currentPage) {
		
		SearchCondition sc = new SearchCondition();
		
		if(searchCondition.equals("writer")) {
			sc.setWriter(searchValue);
		}
		if(searchCondition.equals("title")) {
			sc.setTitle(searchValue);
		}
		if(searchCondition.equals("content")) {
			sc.setContent(searchValue);
		}
		
		int listCount  = bs.getSearchResultListCount(sc);
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		ArrayList<Board> list = bs.selectSearchResultList(sc,pi);
		
		System.out.println("list : "+list);
		for(int i=0; i<list.size();i++) {
			list.get(i).setbCount(list.get(i).getbCount());
		}
		if(list != null) {
			model.addAttribute("searchCondition",searchCondition);
			model.addAttribute("searchValue", searchValue);
			model.addAttribute("list",list);
			model.addAttribute("pi",pi);
			return "board/searchBoard";
		
		}else {
			model.addAttribute("msg","검색결과 조회 실패!");
			return "common/errorPage";
		}
		
	}
}
