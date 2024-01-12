package com.guam.view.comm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guam.biz.board.BoardVO;
import com.guam.biz.comm.CommReplyVO;
import com.guam.biz.comm.CommVO;
import com.guam.biz.comm.impl.CommService;
import com.guam.biz.user.UserVO;

@Controller
public class CommController {

	@Autowired
	private CommService commService;
	
	// 커뮤니티 글 등록
	@RequestMapping("/insertComm.do")
	public String insertComm(CommVO vo) {
		System.out.println("커뮤니티 글 등록 처리");
		commService.insertComm(vo);
		return "communityList.do";
	}
	
	// 글 목록 검색
	@RequestMapping("/communityList.do")
	public String communityList(CommVO vo, Model model) {
		System.out.println("커뮤니티 글 목록 검색 처리");
		model.addAttribute("commList", commService.communityList(vo));		// Model 정보 저장 
	    return "community.jsp";												// View 이름 리턴					
	}
	
	// 글 상세 정보
	@RequestMapping("/communityPost.do")
	public String communityPost(CommVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		model.addAttribute("commList", commService.communityPost(vo));			// Model 정보 저장
		return "communityPost.jsp";												// View 이름 리턴
	}	
	
	// 댓글 등록
	@RequestMapping("/addComment.do")
	public String addComment(CommReplyVO vo) {
		System.out.println("커뮤니티 댓글 처리");
		commService.addComment(vo);

		return "addCommentCnt.do?seq="+vo.getCommseq();
	}
	// 댓글 카운트 증가 
	@RequestMapping("/addCommentCnt.do")
	public String addCommentCnt(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		commService.addCommentCnt(seq);
		return "redirect:/communityPost.do?seq="+seq;
	}
	

	
	
	
	
}
