package com.kh.eg.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;

public interface BoardDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi);

	int inserBoard(SqlSessionTemplate sqlSession, Board b);

	int updateCount(SqlSessionTemplate sqlSession, String bid);

	Board selecOneBoard(SqlSessionTemplate sqlSession, String bid);

}
