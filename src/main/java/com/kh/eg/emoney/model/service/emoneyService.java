package com.kh.eg.emoney.model.service;

import java.util.ArrayList;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;

public interface emoneyService {

	int insertEmoney(emoney e);	
	
	int insertMemberEmoney(emoney e);

	ArrayList<emoney> selectEmoneyList(PageInfo pi, emoney e);

	int getListCount(emoney e);

	int updateEmoney(Member m, emoney e);

	ArrayList<emoney> refundEmoneyList(PageInfo pi, emoney e);

	int refundMemberEmoney(emoney e);

	int updateRefundEmoney(Member m, emoney e);

	int selectEmoneyeSq(emoney e);

	int refundEmoneyeInsert(emoney e);

/*	int selectCurrval(emoney e);

	int selectNextval(emoney e);
	*/
}