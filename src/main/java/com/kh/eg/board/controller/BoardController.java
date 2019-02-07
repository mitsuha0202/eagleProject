package com.kh.eg.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping("goBoard.bo")
	public String goBoard(){
		return "board/board";
	}
	
	@RequestMapping("insertBoardView.bo")
	public String showInsertBoardView(){
		return "board/insertBoard";
	}
	
	@RequestMapping("boardSelectOne.bo")
	public String boardSelectOne(){
		return "board/boardDetail";
	}
}
