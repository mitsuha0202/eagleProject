package com.kh.eg.board.model.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.board.model.vo.Board;
import com.kh.eg.board.model.vo.PageInfo;
import com.kh.eg.board.model.vo.Reply;
import com.kh.eg.board.model.vo.SearchCondition;
import com.kh.eg.member.model.vo.Member;
import com.sun.crypto.provider.AESParameters;

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
		ArrayList<Board> mlist = null;
		Board b= new Board();
		Member m = new Member();
		int offset = (pi.getCurrentPage() -1 ) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		b.setbMid(m.getUserName());
		list = (ArrayList)sqlSession.selectList("Board.selectBoardList", null, rowBounds);
		ArrayList<Member> name = null;
		
		name =(ArrayList)sqlSession.selectList("Member.selectListWriter",list, rowBounds);
		for(int i=0; i<name.size();i++) {
			list.get(i).setUserName(name.get(i).getUserName());
		}

		return list;
	}

	@Override
	public int inserBoard(SqlSessionTemplate sqlSession, Board b) {
		int result = sqlSession.insert("Board.insertBoard",b);
		return result;
	}

	@Override
	public int updateCount(SqlSessionTemplate sqlSession, String bid){
		
		int result = sqlSession.update("Board.updateBoardCount",bid);
		System.out.println("조회수 : "+result);
		return result;
	}

	@Override
	public Board selecOneBoard(SqlSessionTemplate sqlSession, String bid) {
		Board b = null;
		/*Reply r = new Reply();*/
		ArrayList<String> reply = null;
		ArrayList<String> replyC = null;
		ArrayList<Date> replyDate = null;
		b = sqlSession.selectOne("Board.selectBoardOne", bid);
		String name = sqlSession.selectOne("Board.selectWriter", bid);
		reply = (ArrayList)sqlSession.selectList("Board.replyWriter",bid);
		replyC = (ArrayList)sqlSession.selectList("Board.replyContent",bid);
		replyDate = (ArrayList)sqlSession.selectList("Board.replyDate",bid);
		System.out.println("replysize: "+reply.size());
		System.out.println(reply);
/*		String[] arrays = reply.toArray(new String[reply.size()]);*/
		/*ArrayList<Reply> list = new ArrayList<Reply>();
		b.setReplyList(list);*/
		Reply r = null;
		ArrayList<Reply> list = new ArrayList<Reply>();
		
		for(int i=0;i<reply.size();i++) {
			r = new Reply();
			r.setrUserName(reply.get(i));
			r.setrContent(replyC.get(i));
			r.setWriteDay(replyDate.get(i));
			System.out.println("여기안찍힘?");
			System.out.println(r.getrUserName());
			list.add(r);
		}
		b.setUserName(name);
		b.setReplyList(list);
		
		return b;
	}

	@Override
	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		
		int result = sqlSession.insert("Board.insertReply",r);
		
		return result;
	}

	@Override
	public int deleteBoard(SqlSessionTemplate sqlSession, String bid) {
		int result = sqlSession.update("Board.deleteBoard",bid);
		return result;
	}

	@Override
	public int replyCount(SqlSessionTemplate sqlSession, String bid) {
		int result = sqlSession.selectOne("Board.replyCount",bid);
		
		System.out.println("Reply갯수 : "+result);
		return result;
	}

	@Override
	public int updateBoard(SqlSessionTemplate sqlSession, Board b) {
		int result = sqlSession.update("Board.updateBoard",b);
		return result;
	}

	@Override
	public int getSearchResultListCount(SqlSessionTemplate sqlSession, SearchCondition sc) {
		int result = sqlSession.selectOne("Board.selectSearchResultCount",sc);
		return result;
	}

	@Override
	public ArrayList<Board> selectSearchResultList(SearchCondition sc, PageInfo pi, SqlSessionTemplate sqlSession) {
		ArrayList<Board> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)sqlSession.selectList("Board.selectSearchResultList",sc,rowBounds);
		ArrayList<Member> name = null;
		
		name =(ArrayList)sqlSession.selectList("Member.searchListWriter",sc, rowBounds);
		for(int i=0; i<name.size();i++) {
			list.get(i).setUserName(name.get(i).getUserName());
		}
		return list;
	}

}
