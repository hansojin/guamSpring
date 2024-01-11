package com.guam.biz.user.impl;

import com.guam.biz.user.UserVO;

public interface UserService {

	// 회원 등록
	UserVO getUser(UserVO vo);

	// 아이디 중복 체크
	UserVO idCheck(UserVO vo);
	
	// 멤버 수 확인
	void memberCount(UserVO vo);
}