package com.guam.biz.study.impl;

import java.util.List;

import com.guam.biz.study.ChatVO;
import com.guam.biz.study.StudyVO;

public interface StudyService {

	// 스터디 글 등록
	void insertStudy(StudyVO vo);
	
	// 스터디 글 조회
	List<StudyVO> studyList(StudyVO vo);
	
	// 스터디 글 삭제
	void deleteStudyPost(StudyVO vo);
	
	// 스터디 글 검색
	List<StudyVO> searchStudyList(String search);
	
	// 내가 작성한 스터디 글 조회 
	List<StudyVO> myStudy(StudyVO vo);
	
	// 채팅 목록
	List<ChatVO> toChat(ChatVO vo);
	
	// 채팅 등록
	void chatInsert(ChatVO vo);
	
}
