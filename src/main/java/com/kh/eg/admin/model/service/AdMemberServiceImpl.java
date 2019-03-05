package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.eg.admin.model.dao.AdMemberDao;
import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.Category;
import com.kh.eg.admin.model.vo.Exchange;
import com.kh.eg.admin.model.vo.Notice;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.Post;
import com.kh.eg.admin.model.vo.Report;
import com.kh.eg.admin.model.vo.Return;
import com.kh.eg.admin.model.vo.SearchCondition;
import com.kh.eg.admin.model.vo.SearchReport;

@Service
public class AdMemberServiceImpl implements AdMemberService{
	@Autowired
	private AdMemberDao amd;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//페이징 카운트
	@Override
	public int getListCount() throws AdMemberselectException {
		int listCount = amd.getListCount(sqlSession);
		return listCount;
	}
	
	//회원목록조회
	@Override
	public ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException {
		
		ArrayList<AdminVo> list = amd.selectMemberList(sqlSession, pi);
		
		return list;
	}
	
	//블랙리스트 목록조회
	@Override
	public ArrayList<AdminVo> selectBlackList(PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.selectBlackList(sqlSession, pi);
		
		return list;
	}
	
	//블랙리스트 페이징 카운트
	@Override
	public int getBlackListCount() throws AdMemberselectException {
		int listCount = amd.getBlackListCount(sqlSession);
		return listCount;
	}
	
	//검색 후 회원목록 페이징 카운트
	@Override
	public int getSearchListCount(SearchCondition sc) throws AdMemberselectException {
		int listCount = amd.getSearchListCount(sqlSession, sc);
		return listCount;
	}
	
	//검색 후 회원 목록 조회
	@Override
	public ArrayList<AdminVo> searchMemberList(SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.searchMemberList(sqlSession, sc , pi);
		
		return list;
	}
	
	//검색후 블랙리스트 카운트
	@Override
	public int getSearchBlackListCount(SearchCondition sc) throws AdMemberselectException {
		int listCount = amd.getSearchBlackListCount(sqlSession, sc);
		return listCount;
	}
	
	//검색 후 블랙리스트
	@Override
	public ArrayList<AdminVo> searchBlackList(SearchCondition sc, PageInfo pi) throws AdMemberselectException  {
		ArrayList<AdminVo> list = amd.searchBlackList(sqlSession, sc , pi);
		
		return list;
	}

	//사이버머니 리스트
	@Override
	public ArrayList<AdminVo> memberMoneyList(PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.memberMoneyList(sqlSession, pi);
		return list;
	}
	
	//사이버머니 검색 후 리스트
	@Override
	public ArrayList<AdminVo> searchMoneyList(SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = amd.searchMoneyList(sqlSession, sc , pi);
		
		return list;
	}
	
	//블랙리스트 추가
	@Override
	public int checkBlackList(String[] check) throws AdMemberselectException {
		
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.blackListCheck(sqlSession, check[i]);
		}
		
		return result;
	}
	
	//블랙리스트 해제
	@Override
	public int BlackListoff(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.blackListoff(sqlSession, check[i]);
		}
		
		return result;
	}
	
	//신고 카운트
	@Override
	public int reportCount() throws AdMemberselectException {
		int listCount = amd.reportCount(sqlSession);
		return listCount;
	}
	
	//신고 리스트
	@Override
	public ArrayList<Report> selectReportList(PageInfo pi) throws AdMemberselectException {
		ArrayList<Report> reportlist = amd.selectReportList(sqlSession, pi);
		return reportlist;
	}

	@Override
	public int getSearchReportListCount(SearchReport sr) throws AdMemberselectException {
		int listCount = amd.getSearchReportListCount(sqlSession, sr);
		return listCount;
	}

	@Override
	public ArrayList<Report> searchReportList(SearchReport sr, PageInfo pi) throws AdMemberselectException {
		ArrayList<Report> list = amd.searchReportList(sqlSession, sr , pi);
		
		return list;
	}
	
	//카테고리 리스트 
	@Override
	public ArrayList<Category> selectCategoryList() throws AdMemberselectException {
		ArrayList<Category> list = amd.selectCategoryList(sqlSession);
		
		return list;
	}
	
	//카테고리 추가
	@Override
	public int insertCategory(Category cg) throws AdMemberselectException {
		int result = amd.insertCategory(sqlSession, cg);
		return result;
	}
	
	//카테고리 삭제
	@Override
	public int delCategory(Category cg) throws AdMemberselectException {
		int result = amd.delcategory(sqlSession, cg);
		return result;
	}
	
	//환전 리스트 카운트
	@Override
	public int payBackListCount() throws AdMemberselectException {
		int listCount = amd.payBackListCount(sqlSession);
		return listCount;
	}
	
	//환전 리스트
	@Override
	public ArrayList<Exchange> selectPayBackList(PageInfo pi) throws AdMemberselectException {
		ArrayList<Exchange> list = amd.selectPayBackList(sqlSession, pi);
		
		return list;
	}
	
	//공지사항 리스트
	@Override
	public ArrayList<Notice> selectNoticeList() throws AdMemberselectException {
		ArrayList<Notice> list = amd.selectNoticeList(sqlSession);
		
		return list;
	}
	
	//문의 리스트 카운트
	@Override
	public int postListCount() throws AdMemberselectException {
		int listCount = amd.postListCount(sqlSession);
		return listCount;
	}
	
	//문의 리스트
	@Override
	public ArrayList<Post> selectPostList(PageInfo pi) throws AdMemberselectException {
		ArrayList<Post> list = amd.selectPostList(sqlSession, pi);
		
		return list;
	}
	
	//반품 카운트
	@Override
	public int returnListCount() throws AdMemberselectException {
		int listCount = amd.returnListCount(sqlSession);
		return listCount;
	}
	
	//반품리스트
	@Override
	public ArrayList<Return> selectReturnList(PageInfo pi) throws AdMemberselectException {
		ArrayList<Return> list = amd.selectReturnList(sqlSession, pi);
		
		return list;
	}
	
	//환전 승인
	@Override
	public int payBackY(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.payBackY(sqlSession, check[i]);
		}
		
		return result;
	}
	
	
	//환전거절
	@Override
	public int payBackX(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.payBackX(sqlSession, check[i]);
		}
		
		return result;
	}

	@Override
	public int returnRefuse(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.returnRefuse(sqlSession, check[i]);
		}
		
		return result;
	}

	@Override
	public int returnOk(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.returnOk(sqlSession, check[i]);
		}
		
		return result;
	}
	
	//사이버머니 변경
	@Override
	public int moneyChange(String[] check, String money) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.moneyChange(sqlSession, check[i], money);
		}
		
		return result;
	}

	@Override
	public int auctionDel(String[] check) throws AdMemberselectException {
		int result = 0;
		for(int i = 0; i <check.length; i++) {
			result += amd.auctionDel(sqlSession, check[i]);
		}
		
		return result;
	}

	

	

	
	
	
	
	

}
