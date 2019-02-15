package com.kh.eg.myPage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.kh.eg.member.model.vo.Member;
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
			sqlSession.delete("MyPage.deleteReply", deleteNum[i]);
			result = sqlSession.delete("MyPage.deleteMessage", deleteNum[i]);
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

	//게시글 개수 조회
	@Override
	public int countMessage(SqlSessionTemplate sqlSession, String memberNo) {
		
		return  sqlSession.selectOne("MyPage.countMessage", memberNo); 
	}

	//1대1 게시글 상세보기 
	@Override
	public MyPageBoard selectOneBoard(SqlSessionTemplate sqlSession, String boardNo) {

		return sqlSession.selectOne("MyPage.selectOneBoard", boardNo);

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
		return sqlSession.delete("MyPage.deleteUserInfo", mid);
	}
}