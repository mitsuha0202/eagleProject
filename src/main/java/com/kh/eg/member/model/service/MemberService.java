package com.kh.eg.member.model.service;

import com.kh.eg.member.model.vo.Member;

public interface MemberService {

	int insertMember(Member m);

	Member loginUser(Member m);

	int idDuplicationCheck(String userId);

}
