package com.kh.eg.board.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;


public interface BoardService {

	int getListCount();

	ArrayList<Board> selectBoardList(PageInfo pi);

	int insertBoard(Board b);

	Board selectOneBoard(String bid);

}
