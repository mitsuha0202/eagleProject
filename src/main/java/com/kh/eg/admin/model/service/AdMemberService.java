package com.kh.eg.admin.model.service;

import java.util.ArrayList;

import com.kh.eg.admin.model.exception.AdMemberselectException;
import com.kh.eg.admin.model.vo.AdminVo;
import com.kh.eg.admin.model.vo.Category;
import com.kh.eg.admin.model.vo.Exchange;
import com.kh.eg.admin.model.vo.Notice;
import com.kh.eg.admin.model.vo.PageInfo;
import com.kh.eg.admin.model.vo.Post;
import com.kh.eg.admin.model.vo.Report;
import com.kh.eg.admin.model.vo.SearchCondition;
import com.kh.eg.admin.model.vo.SearchReport;

public interface AdMemberService {
	
	int getListCount() throws AdMemberselectException;

	ArrayList<AdminVo> selectBoardList(PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> selectBlackList(PageInfo pi) throws AdMemberselectException;

	int getBlackListCount() throws AdMemberselectException;

	int getSearchListCount(SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchMemberList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int getSearchBlackListCount(SearchCondition sc) throws AdMemberselectException;

	ArrayList<AdminVo> searchBlackList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> memberMoneyList(PageInfo pi) throws AdMemberselectException;

	ArrayList<AdminVo> searchMoneyList(SearchCondition sc, PageInfo pi) throws AdMemberselectException;

	int checkBlackList(String[] check) throws AdMemberselectException;

	int BlackListoff(String[] check) throws AdMemberselectException;

	int reportCount() throws AdMemberselectException;

	ArrayList<Report> selectReportList(PageInfo pi) throws AdMemberselectException;

	int getSearchReportListCount(SearchReport sr) throws AdMemberselectException;

	ArrayList<Report> searchReportList(SearchReport sr, PageInfo pi) throws AdMemberselectException;

	ArrayList<Category> selectCategoryList() throws AdMemberselectException;

	int insertCategory(Category cg) throws AdMemberselectException;

	int delCategory(Category cg) throws AdMemberselectException;

	int payBackListCount() throws AdMemberselectException;

	ArrayList<Exchange> selectPayBackList(PageInfo pi) throws AdMemberselectException;

	ArrayList<Notice> selectNoticeList() throws AdMemberselectException;

	int postListCount() throws AdMemberselectException;

	ArrayList<Post> selectPostList(PageInfo pi) throws AdMemberselectException;





	

	



	

}
