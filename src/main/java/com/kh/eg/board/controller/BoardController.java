package com.kh.eg.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.eg.board.model.service.BoardService;
import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Pagination;
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
	public String boardSelectOne(){
		return "board/boardDetail";
	}
}
