package com.kh.eg.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.kh.eg.board.model.dao.BoardDao;
import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Reply;
import com.kh.eg.board.model.vo.SearchCondition;
import com.kh.eg.member.model.dao.MemberDao;

@Service
public class BoardServiceImpl implements BoardService {
@Autowired
private BoardDao bd;
@Autowired
private SqlSessionTemplate sqlSession;
@Autowired
private DataSourceTransactionManager transactionManager;

	@Override
	public int getListCount() {
		
		int listCount = bd.getListCount(sqlSession);
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi) {
		ArrayList<Board> list = bd.selectBoardList(sqlSession, pi);
		
		return list;
	}

	@Override
	public int insertBoard(Board b) {

		int result = bd.inserBoard(sqlSession, b);
		return result;
	}

	@Override
	public Board selectOneBoard(String bid) {
		Board b = null;
		
		int result = bd.updateCount(sqlSession,bid);
		
		b = bd.selecOneBoard(sqlSession, bid);
		
		return b;
	}

	@Override
	public int insertReply(Reply r) {
		int result = bd.insertReply(sqlSession,r);
		return result;
	}

	@Override
	public int deleteBoard(String bid) {
		int result = bd.deleteBoard(sqlSession, bid);
		return result;
	}

	@Override
	public int replyCount(String bid) {
		int result = bd.replyCount(sqlSession, bid);
		return result;
	}

	@Override
	public int updateBoard(Board b) {
		int result = bd.updateBoard(sqlSession, b);
		return result;
	}

	@Override
	public int getSearchResultListCount(SearchCondition sc) {
		int result = bd.getSearchResultListCount(sqlSession, sc);
		return result;
	}

	@Override
	public ArrayList<Board> selectSearchResultList(SearchCondition sc,PageInfo pi) {
		ArrayList<Board> list = bd.selectSearchResultList(sc, pi,sqlSession);
		
		
		return list;
	}

	@Override
	public ArrayList<Board> selectNotice() {
		ArrayList<Board> list = bd.selectNotice(sqlSession);
		return list;
	}

	@Override
	public int insertNotice(Board b) {
		int result = bd.inserNotice(sqlSession, b);
		return result;
	}

	@Override
	public int deleteNotice(String[] deleteNum) {
		int result = bd.deleteNotice(sqlSession, deleteNum);
		return result;
	}

}
