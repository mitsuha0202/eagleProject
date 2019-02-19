package com.kh.eg.board.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Reply;
import com.kh.eg.board.model.vo.SearchCondition;

public interface BoardDao {

	int getListCount(SqlSessionTemplate sqlSession);

	ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi);

	int inserBoard(SqlSessionTemplate sqlSession, Board b);

	int updateCount(SqlSessionTemplate sqlSession, String bid);

	Board selecOneBoard(SqlSessionTemplate sqlSession, String bid);

	int insertReply(SqlSessionTemplate sqlSession, Reply r);

	int deleteBoard(SqlSessionTemplate sqlSession, String bid);

	int replyCount(SqlSessionTemplate sqlSession, String bid);

	int updateBoard(SqlSessionTemplate sqlSession, Board b);

	int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc);

	ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi, SqlSessionTemplate sqlSession);

}
