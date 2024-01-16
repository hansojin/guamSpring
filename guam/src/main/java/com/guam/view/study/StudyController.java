package com.guam.view.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.guam.biz.study.ChatVO;
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
		model.addAttribute("studyList", studyService.studyList(vo));			
		   return "study.jsp";																
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
	
	// 내가 작성한 스터디 글 목록 
	@RequestMapping("/myStudy.do")
	public String myStudy(StudyVO vo, Model model) {
		System.out.println("내가 작성한 스터디 글 목록 검색 처리");
		model.addAttribute("studyList", studyService.myStudy(vo));			
		return "study.jsp";															
	}
	
	// 채팅 목록 검색
	@RequestMapping("/toChat.do")
	public String toChat(ChatVO vo, Model model) {
		System.out.println("채팅 목록 검색 처리");
		model.addAttribute("chatList", studyService.toChat(vo));			
		return "chat.jsp";																
	}
	
	// 채팅 입력 
	@RequestMapping("/chatInsert.do")
	public String chatInsert(ChatVO vo) {
		System.out.println("채팅 입력 처리");
		studyService.chatInsert(vo);
		return "redirect:/toChat.do?seq="+vo.getSeq();
	}
}
