package com.guam.biz.user.impl;

import com.guam.biz.user.UserVO;

public interface UserService {

	// 회원 등록
	UserVO getUser(UserVO vo);

	// 아이디 중복 체크
	UserVO idCheck(UserVO vo);
	
	// 멤버 수 확인
	void memberCount(UserVO vo);
	
	// 회원가입
	void insertMember(UserVO vo);
	
	// 마이페이지에서 정보 수정
	void updateMember(UserVO vo);
	
	// 유저 정보 가져오기
	UserVO getUserInfo(UserVO vo);
	
	// 유저 삭제
	void deleteUser(UserVO vo);
}