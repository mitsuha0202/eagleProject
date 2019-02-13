package com.kh.eg.emoney.model.service;

import com.kh.eg.emoney.model.vo.emoney;

public interface emoneyService {

	int insertEmoney(emoney em);
	
	emoney emoneyList(emoney em);
	
	int insertMemberCash(emoney em);
	
	emoney selectMemberNowCash(emoney em);
	
}
