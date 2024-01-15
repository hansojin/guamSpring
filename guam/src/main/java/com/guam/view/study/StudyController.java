package com.guam.view.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.guam.biz.study.StudyVO;
import com.guam.biz.study.impl.StudyService;

@Controller
public class StudyController {
	
	@Autowired
	private StudyService studyService;
	
	// 스터디 글 등록
	@RequestMapping("/insertStudy.do")
	public String insertStudy(StudyVO vo) {
		System.out.println("스터디 글 등록 처리");
		studyService.insertStudy(vo);
		return "studyList.do";
	}
	
	// 글 목록 검색
	@RequestMapping("/studyList.do")
	public String studyList(StudyVO vo, Model model) {
		System.out.println("스터디 글 목록 검색 처리");
		model.addAttribute("studyList", studyService.studyList(vo));			// Model 정보 저장 
		   return "study.jsp";												// View 이름 리턴					
	}
	
	// 스터디 글 삭제
	@RequestMapping("/deleteStudyPost.do")
	public String deleteStudyPost(StudyVO vo) {
		System.out.println("스터디 글 삭제 처리");
		studyService.deleteStudyPost(vo);
		return "studyList.do";
	}
	
	// search 기능
	@RequestMapping("/searchStudy.do")
	public String searchStudy(Model model, HttpServletRequest request) {
		System.out.println("스터디 글 검색 처리");
		String search = request.getParameter("search");
		model.addAttribute("studyList", studyService.searchStudyList(search));
		return "study.jsp?search"+search;	
	}
	
}
