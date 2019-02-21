package com.kh.eg.emoney.model.service;

import java.util.ArrayList;

import com.kh.eg.emoney.model.vo.PageInfo;
import com.kh.eg.emoney.model.vo.emoney;

public interface emoneyService {

	int insertEmoney(emoney e);	
	
	int insertMemberCash(emoney e);
	
	emoney selectMemberNowCash(emoney e);

	ArrayList<emoney> selectEmoneyList(PageInfo pi, emoney e);

	int getListCount(emoney e);
	
}
