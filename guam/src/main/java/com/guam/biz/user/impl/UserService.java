package com.guam.biz.user.impl;

import com.guam.biz.board.BoardVO;
import com.guam.biz.user.UserVO;

public interface UserService {

	// CRUD 기능의 메소드 구현
	// 회원 등록
	UserVO getUser(UserVO vo);

	// 아이디 중복 체크
	UserVO idCheck(UserVO vo);
	
	void memberCount(UserVO vo);
}