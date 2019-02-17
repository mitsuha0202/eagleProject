package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.Maccount;
import com.kh.eg.myPage.model.vo.MyPageBoard;
import com.kh.eg.myPage.model.vo.PageInfo;
import com.kh.eg.myPage.model.vo.WishList;

@Repository
public class MyPageDaoImpl implements MyPageDao{

	//1대1 쪽지함 페이징 처리
	@Override
	public int getListCount(SqlSessionTemplate sqlSession, String memberNo) {
		
		return sqlSession.selectOne("MyPage.countMessage", memberNo);
	}
	
	//1대1 문의함 게시글들 조회
	@Override
	public ArrayList<MyPageBoard> selectMessage(SqlSessionTemplate sqlSession, PageInfo pi, String memberNo) {
		int offset = (pi.getCurrentPage()  - 1) * pi.getLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		return (ArrayList)sqlSession.selectList("MyPage.selectMessage", memberNo, rowBounds);
	}
	
	//1대1 문의함 게시글 삭제
	@Override
	public int deleteMessage(SqlSessionTemplate sqlSession, int[] deleteNum) {
		int result = 0;
		for(int i=0; i<deleteNum.length; i++) {
			sqlSession.update("MyPage.deleteReply", deleteNum[i]);
			result = sqlSession.update("MyPage.deleteMessage", deleteNum[i]);
		}
		return result;
	}

	//1대1 문의함 게시글 등록
	@Override
	public int insertMessage(SqlSessionTemplate sqlSession, MyPageBoard myPage) {
		
		return sqlSession.insert("MyPage.insertMessage", myPage);
	}
	
	//1대1 게시글 검색
	@Override
	public ArrayList<MyPageBoard> searchMessage(SqlSessionTemplate sqlSession, String search, String searchTitle) {
			
		return (ArrayList)sqlSession.selectList("MyPage.searchMessage", searchTitle);
	}

	//위시리스트 등록해놓은거 검색
	@Override
	public ArrayList<WishList> selectWishList(SqlSessionTemplate sqlSession, String memberNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("MyPage.selectWishList", memberNo);
	}
	
	//위시리스트 삭제
	@Override
	public int wishListDelete(SqlSessionTemplate sqlSession, int[] wishlistno) {
		int result = 0;
		for(int i=0; i<wishlistno.length; i++) {
			
			
			result = sqlSession.update("MyPage.deleteWishList",wishlistno[i]);
		}
		return result;
	}

	//게시글 개수 조회
	@Override
	public int countMessage(SqlSessionTemplate sqlSession, String memberNo) {
		
		return  sqlSession.selectOne("MyPage.countMessage", memberNo); 
	}

	//1대1 게시글 상세보기 
	@Override
	public MyPageBoard selectOneBoard(SqlSessionTemplate sqlSession, String boardNo) {
		MyPageBoard myBoard = sqlSession.selectOne("MyPage.selectOneBoard", boardNo);
		myBoard.setrContents((String)sqlSession.selectOne("MyPage.selectOneReply", myBoard.getBoardNo()));
		return myBoard;

	}

	//회원정보 업데이트
	@Override
	public int updateMember(SqlSessionTemplate sqlSession, Member member) {
		
		return sqlSession.update("MyPage.updateMember", member);
	}

	//회원정보 삭제
	@Override
	public int deleteUserInfo(SqlSessionTemplate sqlSession, String mid) {
		/*sqlSession.select*/
		return sqlSession.update("MyPage.deleteUserInfo", mid);
	}

	//계좌등록, 변경
	@Override
	public int updateAccount(SqlSessionTemplate sqlSession, Maccount maccount) {
		String mid = String.valueOf(maccount.getMid());
		Maccount temp =  sqlSession.selectOne("MyPage.selectAccount", mid);
		int result = 0;
		if(temp == null) {
			result = sqlSession.insert("MyPage.insertAccount", maccount);
		}else {
			result = sqlSession.update("MyPage.updateAccount", maccount);
		}
		return result;
	}

	//계좌조회
	@Override
	public Maccount selectAccount(SqlSessionTemplate sqlSession, Member m) {
		String mid = m.getMid();
		return sqlSession.selectOne("MyPage.selectAccount", mid);
	}

	//유저정보 수정시 원래 정보 조회
	@Override
	public Member selectMember(SqlSessionTemplate sqlSession, Member temp) {
		
		return sqlSession.selectOne("MyPage.selectMember", temp);
	}
	
}