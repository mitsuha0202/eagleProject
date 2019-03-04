package com.kh.eg.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

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

@Repository
public class AdMemberDaoImpl implements AdMemberDao{

	@Override
	public int getListCount(SqlSessionTemplate session) throws AdMemberselectException{
	
		int result = session.selectOne("AdminVo.selectListCount");
		
		if(result <= 0) {
			throw new AdMemberselectException("게시글 수 조회 실패!");
		}
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> selectMemberList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectMemberList", null, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public ArrayList<AdminVo> selectBlackList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectBlackList", null, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int getBlackListCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.selectBlackListCount");
		
		if(result <= 0) {
			throw new AdMemberselectException("게시글 수 조회 실패!");
		}
		
		return result;
	}

	@Override
	public int getSearchListCount(SqlSessionTemplate session, SearchCondition sc) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.SearchListCount", sc);
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> searchMemberList(SqlSessionTemplate session, SearchCondition sc, PageInfo pi) throws AdMemberselectException{
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchMemberList", sc, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int getSearchBlackListCount(SqlSessionTemplate session, SearchCondition sc) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.SearchBlackListCount", sc);
		
		return result;
	}

	@Override
	public ArrayList<AdminVo> searchBlackList(SqlSessionTemplate session, SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchBlackList", sc, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public ArrayList<AdminVo> memberMoneyList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.memberMoneyList", null, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public ArrayList<AdminVo> searchMoneyList(SqlSessionTemplate session, SearchCondition sc, PageInfo pi) throws AdMemberselectException {
		ArrayList<AdminVo> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchMoneyList", sc, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public int blackListCheck(SqlSessionTemplate session, String memberId) throws AdMemberselectException {
		
		int result = session.update("AdminVo.blackListChange", memberId);
		
		return result;
	}

	@Override
	public int blackListoff(SqlSessionTemplate session, String memberId) throws AdMemberselectException {
		
		int result = session.update("AdminVo.blackListoff", memberId);
		
		return result;
	}

	@Override
	public int reportCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.reportCount");
		
		return result;
	}

	@Override
	public ArrayList<Report> selectReportList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		
		ArrayList<Report> reportlist = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		reportlist = (ArrayList)session.selectList("AdminVo.selectReportList", null, rowBounds);
		
		if(reportlist == null) {
			throw new AdMemberselectException("신고목록 조회 실패!");
		}
		
		return reportlist;
	}

	@Override
	public int getSearchReportListCount(SqlSessionTemplate session, SearchReport sr) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.searchReportListCount", sr);
		
		return result;
	}

	@Override
	public ArrayList<Report> searchReportList(SqlSessionTemplate session, SearchReport sr, PageInfo pi) throws AdMemberselectException {
		ArrayList<Report> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.searchReportList", sr, rowBounds);
		
		if(list == null) {
			throw new AdMemberselectException("회원 조회 실패!");
		}
		
		return list;
	}

	@Override
	public ArrayList<Category> selectCategoryList(SqlSessionTemplate session) throws AdMemberselectException {
		ArrayList<Category> list = null;
		
		list = (ArrayList)session.selectList("AdminVo.categoryList", null);
		
		return list;
	}

	@Override
	public int insertCategory(SqlSessionTemplate session, Category cg) throws AdMemberselectException {
		int result = session.insert("AdminVo.insertCategory",cg);
		return result;
	}

	@Override
	public int delcategory(SqlSessionTemplate session, Category cg) throws AdMemberselectException {
		int result = session.update("AdminVo.delcategory",cg);
		return result;
	}

	@Override
	public int payBackListCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.payBackListCount");
		
		return result;
	}

	@Override
	public ArrayList<Exchange> selectPayBackList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		ArrayList<Exchange> list = null;
		
		list = (ArrayList)session.selectList("AdminVo.selectPayBackList", null);
		
		return list;
	}

	@Override
	public ArrayList<Notice> selectNoticeList(SqlSessionTemplate session) throws AdMemberselectException {
		ArrayList<Notice> list = null;
		
		list = (ArrayList)session.selectList("AdminVo.selectNoticeList", null);
		
		return list;
	}

	@Override
	public int postListCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.postListCount");
		
		return result;
	}

	@Override
	public ArrayList<Post> selectPostList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		ArrayList<Post> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectPostList", null, rowBounds);
		
		return list;	
	}

	@Override
	public int returnListCount(SqlSessionTemplate session) throws AdMemberselectException {
		int result = session.selectOne("AdminVo.returnListCount");
		
		return result;
	}

	@Override
	public ArrayList<Return> selectReturnList(SqlSessionTemplate session, PageInfo pi) throws AdMemberselectException {
		ArrayList<Return> list = null;
		
		int offset = (pi.getCurrentPage() -1) * pi.getLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getLimit());
		
		list = (ArrayList)session.selectList("AdminVo.selectReturnList", null, rowBounds);
		
		return list;
	}
	
	@Override
	public int payBackY(SqlSessionTemplate session, String check) {
		
		
		int result = 0;
		
		String memberId=check.split("!")[0];
		String eMoney=check.split("!")[1];
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("memberId", memberId);
		map.put("eMoney", Integer.parseInt(eMoney));
		int result1 = session.update("AdminVo.payBackY", memberId);
		int result2 = session.update("AdminVo.payBackUp", map);
		
		if(result1 > 0 && result2 >0) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public int payBackX(SqlSessionTemplate session, String check) {
		String memberId=check.split("!")[0];
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("memberId", memberId);
		int result = session.update("AdminVo.payBackX", memberId);
		return result;
	}

	@Override
	public int returnRefuse(SqlSessionTemplate session, String payNoCheck) {
		int result = session.update("AdminVo.returnRefuse", payNoCheck);
		
		return result;
	}

	@Override
	public int returnOk(SqlSessionTemplate session, String check) {
		
		String payNo=check.split("!")[0];
		String price=check.split("!")[1];
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("price", price);
		map.put("payNo", payNo);
		
		int result = 0;
		
		int result1 = session.update("AdminVo.returnOk", map); 
		int result2 = session.update("AdminVo.buyer", map); 
		int result3 = session.update("AdminVo.seller", map); 
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			result = 1;
		}
		
		return result;
	}
	
	
	@Override
	public int moneyChange(SqlSessionTemplate session, String memberId, String money) {
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		map.put("eMoney", money);
		map.put("memberId", memberId);
		
		int result = session.update("AdminVo.moneyChange", map);
		
		System.out.println(result);
		
		return result;
	}

	


	


}
