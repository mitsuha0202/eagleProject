package com.kh.eg.admin.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;

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

public interface AdMemberDao {
	int getListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<AdminVo> selectMemberList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> selectBlackList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int getBlackListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	int getSearchListCount(SqlSessionTemplate sqlSession, SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchMemberList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int getSearchBlackListCount(SqlSessionTemplate sqlSession, SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchBlackList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> memberMoneyList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> searchMoneyList(SqlSessionTemplate sqlSession, SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int blackListCheck(SqlSessionTemplate sqlSession, String string) throws AdMemberselectException;

	int blackListoff(SqlSessionTemplate sqlSession, String string) throws AdMemberselectException;

	int reportCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<Report> selectReportList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int getSearchReportListCount(SqlSessionTemplate sqlSession, SearchReport sr) throws AdMemberselectException;

	ArrayList<Report> searchReportList(SqlSessionTemplate sqlSession, SearchReport sr, PageInfo pi) throws AdMemberselectException;

	ArrayList<Category> selectCategoryList(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	int insertCategory(SqlSessionTemplate sqlSession, Category cg) throws AdMemberselectException;

	int delcategory(SqlSessionTemplate sqlSession, Category cg) throws AdMemberselectException;

	int payBackListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<Exchange> selectPayBackList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	int postListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<Post> selectPostList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int returnListCount(SqlSessionTemplate sqlSession) throws AdMemberselectException;

	ArrayList<Return> selectReturnList(SqlSessionTemplate sqlSession, PageInfo pi) throws AdMemberselectException;

	int payBackY(SqlSessionTemplate sqlSession, String string);

	int payBackX(SqlSessionTemplate sqlSession, String string);

	int returnRefuse(SqlSessionTemplate sqlSession, String string);

	int returnOk(SqlSessionTemplate sqlSession, String string);

	int moneyChange(SqlSessionTemplate sqlSession, String string, String money);

	

	

	
}
