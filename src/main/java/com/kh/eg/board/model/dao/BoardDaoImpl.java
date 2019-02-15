package com.kh.eg.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Override
	public int getListCount(SqlSessionTemplate sqlSession) {

		int result = sqlSession.selectOne("Board.selectListCount");
		
		return result;
	}

	@Override
	public ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() -1 ) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("Board.selectBoardList", null, rowBounds);
		
		return list;
	}

	@Override
	public int inserBoard(SqlSessionTemplate sqlSession, Board b) {
		int result = sqlSession.insert("Board.insertBoard",b);
		return result;
	}

}
