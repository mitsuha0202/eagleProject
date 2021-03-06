package com.kh.eg.member.model.service;

import com.kh.eg.member.model.vo.Member;

public interface MemberService {

	int insertMember(Member m);

	Member loginUser(Member m);

	int idDuplicationCheck(String userId);

	int emailDuplicationCheck(String email);

	int insertKakaoUser(Member m);

	int insertNaverUser(Member m);

}
