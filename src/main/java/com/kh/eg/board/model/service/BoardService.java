package com.kh.eg.board.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Reply;
import com.kh.eg.board.model.vo.SearchCondition;


public interface BoardService {

	int getListCount();

	ArrayList<Board> selectBoardList(PageInfo pi);

	int insertBoard(Board b);

	Board selectOneBoard(String bid);

	int insertReply(Reply r);

	int deleteBoard(String bid);

	int replyCount(String bid);

	int updateBoard(Board b);

	int getSearchResultListCount(SearchCondition sc);

	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi);

	ArrayList<Board> selectNotice();

}
