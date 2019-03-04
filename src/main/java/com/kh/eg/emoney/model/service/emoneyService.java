package com.kh.eg.emoney.model.service;

import java.util.ArrayList;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;
import com.kh.eg.member.model.vo.Member;
import com.kh.eg.myPage.model.vo.WinBid;

public interface emoneyService {

	int insertEmoney(emoney e);	
	
	int insertMemberEmoney(emoney e);

	ArrayList<emoney> selectEmoneyList(PageInfo pi, emoney e);

	int getListCount(emoney e);

	int updateEmoney(Member m, emoney e);

	ArrayList<emoney> refundEmoneyList(PageInfo pi, emoney e);

	int refundMemberEmoney(emoney e);

	/*int updateRefundEmoney(Member m, emoney e);*/

	int selectEmoneyeSq(emoney e);

	int refundEmoneyeInsert(emoney e);

	int paymentMember(Member m, emoney e);

	int paymentInsert(emoney e, WinBid w);
	
	//마이페이지 - 결제 입금요청
	int paymentA(String id, String itemNo, String currentPrice);

/*	int selectCurrval(emoney e);

	int selectNextval(emoney e);
	*/
}