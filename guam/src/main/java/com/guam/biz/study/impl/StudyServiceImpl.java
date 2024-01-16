package com.guam.biz.study.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guam.biz.study.ChatVO;
import com.guam.biz.study.StudyVO;


@Service("studyService")
public class StudyServiceImpl implements StudyService {

	@Autowired
	private StudyDAOMybatis studyDAO;
	
	@Override
	public void insertStudy(StudyVO vo) {
		studyDAO.insertStudy(vo);
	}

	@Override
	public List<StudyVO> studyList(StudyVO vo){
		return studyDAO.studyList(vo);
	}
	
	@Override
	public void deleteStudyPost(StudyVO vo) {
		studyDAO.deleteStudyPost(vo);
	}
	
	@Override
	public List<StudyVO> searchStudyList(String search){
		return studyDAO.searchStudyList(search);
	}
	
	@Override
	public List<StudyVO> myStudy(StudyVO vo){
		return studyDAO.myStudy(vo);
	}
	
	@Override
	public List<ChatVO> toChat(ChatVO vo){
		return studyDAO.toChat(vo);
	}
	
	@Override
	public void chatInsert(ChatVO vo) {
		studyDAO.chatInsert(vo);
	}
	
}
