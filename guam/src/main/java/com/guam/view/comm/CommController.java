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

import com.guam.biz.comm.CommReplyVO;
import com.guam.biz.comm.CommVO;
import com.guam.biz.comm.impl.CommService;

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
		model.addAttribute("commList", commService.communityList(vo));		
	    return "community.jsp";																	
	}
	
	// 글 상세 정보
	@RequestMapping("/communityPost.do")
	public String communityPost(CommVO vo, CommReplyVO vor, Model model) {
		System.out.println("글 상세 조회 처리");
		model.addAttribute("commList", commService.communityPost(vo));			
		model.addAttribute("commentList", commService.communityPostComment(vor));
		return "communityPost.jsp";												
	}	
	
	// 댓글 등록
	@RequestMapping("/addComment.do")
	public String addComment(CommReplyVO vo) {
		System.out.println("커뮤니티 댓글 처리");
		commService.addComment(vo);

		return "addCommentCnt.do?seq="+vo.getSeq();
	}
	// 댓글 카운트 증가 
	@RequestMapping("/addCommentCnt.do")
	public String addCommentCnt(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		commService.addCommentCnt(seq);
		return "redirect:/communityPost.do?seq="+seq;
	}
	
	// 댓글 삭제 
	@RequestMapping("/deleteComment.do")
	public String deleteMboard(HttpServletRequest request) {
		System.out.println("커뮤니티 댓글 삭제 처리");
		int seq = Integer.parseInt(request.getParameter("seq"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		commService.deleteComment(idx,seq);
		return "redirect:/communityPost.do?seq="+seq;
	}

	// 글 삭제
	@RequestMapping("/deletePost.do")
	public String deletePost(CommVO vo) {
		System.out.println("커뮤니티 글 등록 처리");
		commService.deletePost(vo);
		return "communityList.do";
	}	
	
	// 글 수정 페이지 이동
	@RequestMapping("/toEdit.do")
	public String communityPost(CommVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		model.addAttribute("commList", commService.communityPost(vo));			
		return "communityPostEdit.jsp";												
	}		

	// 글 수정 
	@RequestMapping("/editPost.do")
	public String editPost(CommVO vo) {
		System.out.println("커뮤니티 글 update 처리");
		commService.editPost(vo);
		return "redirect:/communityPost.do?seq="+vo.getSeq();
	}	
	
	// 내가 쓴 글
	@RequestMapping("/myComm.do")
	public String myComm(CommVO vo, Model model) {
		System.out.println("내가 작성한 커뮤니티 글 목록 검색 처리");
		List<CommVO> clist = commService.myComm(vo);
		if (clist == null || clist.isEmpty())
			return "noWritten.jsp";
		model.addAttribute("commList", clist);		
	    return "community.jsp";																
	}
	
	// 내가 쓴 댓글의 글
	@RequestMapping("/myComment.do")
	public String myComment(CommVO vo, Model model) {
		System.out.println("내가 작성한 댓글의 커뮤니티 글 목록 검색 처리");
		List<CommVO> clist = commService.myComment(vo);
		if (clist == null || clist.isEmpty())
			return "noWritten.jsp";
		model.addAttribute("commList", clist);		
		return "community.jsp";																
	}	
	
	
}
