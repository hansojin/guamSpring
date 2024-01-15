package com.guam.biz.study.impl;

import java.util.List;

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
	
}
