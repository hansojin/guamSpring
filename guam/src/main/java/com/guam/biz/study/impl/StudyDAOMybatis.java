package com.guam.biz.study.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guam.biz.comm.CommVO;
import com.guam.biz.study.StudyVO;

@Repository
public class StudyDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertStudy(StudyVO vo) {
		System.out.println("===> Mybatis로 insertStudy() 기능 처리");
		mybatis.insert("StudyDAO.insertStudy", vo);
	}
	
	
	public List<StudyVO> studyList(StudyVO vo) {
		System.out.println("===> Mybatis로 studyList() 기능 처리");
		return mybatis.selectList("StudyDAO.studyList", vo);	
	}
	
	public void deleteStudyPost(StudyVO vo) {
		System.out.println("===> Mybatis로 deleteStudyPost() 기능 처리");
		mybatis.delete("StudyDAO.deleteStudyPost", vo);
	}

	public List<StudyVO> searchStudyList(String search) {
		System.out.println("===> Mybatis로 searchStudyList() 기능 처리");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("search", search);
		return mybatis.selectList("StudyDAO.searchStudyList", paramMap);	
	}
}
