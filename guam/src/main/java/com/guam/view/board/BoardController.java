package com.guam.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guam.biz.board.BoardVO;
import com.guam.biz.board.impl.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// 모집 글 등록
	@RequestMapping(value="/insertMboard.do")
	public String insertMboard(BoardVO vo) throws IOException {
		System.out.println("모집 글 등록 처리");
		boardService.insertMboard(vo);
		return "getMboardList.do";
	}	
	
	// 모집 글 목록 
	@RequestMapping("/getMboardList.do")
	public String getMboardList(BoardVO vo, Model model) {
		System.out.println("모집 글 목록 검색 처리");
		model.addAttribute("MboardList", boardService.getMboardList(vo));		
    	return "getMboardList.jsp";																
	}
	
	// 신청 글 등록
	@RequestMapping(value="/insertSboard.do")
	public String insertSboard(BoardVO vo) throws IOException {
		System.out.println("신청 글 등록 처리");
		boardService.insertSboard(vo);
		return "getSboardList.do";
	}	
	
	// 신청 글 목록 
	@RequestMapping("/getSboardList.do")
	public String getSboardList(BoardVO vo, Model model) {
		System.out.println("신청 글 목록 검색 처리");
		model.addAttribute("SboardList", boardService.getSboardList(vo));		
    	return "getSboardList.jsp";																
	}
	
	// 모집 글 삭제
	@RequestMapping("/deleteMboard.do")
	public String deleteMboard(BoardVO vo) {
		System.out.println("모집 글 삭제 처리");
		boardService.deleteMboard(vo);
		return "getMboardList.do";
	}
	
	// 신청 글 삭제
	@RequestMapping("/deleteSboard.do")
	public String deleteSboard(BoardVO vo) {
		System.out.println("신청 글 삭제 처리");
		boardService.deleteSboard(vo);
		return "getSboardList.do";
	}
		
	// search 기능
	@RequestMapping("/searchBoardList.do")
	public String searchBoardList(Model model, HttpServletRequest request) {
		System.out.println("신청 글 목록 검색 처리");
		String searchValue = request.getParameter("search");
		model.addAttribute("MboardList", boardService.searchMboardList(searchValue));
		model.addAttribute("SboardList", boardService.searchSboardList(searchValue));		
    	return "getSearchBoardList.jsp?search=" + searchValue;														
	}
	
	// 내가 작성한 모집 글 보러가기
	@RequestMapping("/myMList.do")
	public String myMList(BoardVO vo, Model model) {
		System.out.println("작성한 모집 글 목록 검색 처리");
		List<BoardVO> mlist = boardService.myMList(vo);
		if (mlist == null || mlist.isEmpty()) {
	        return "noWritten.jsp";
	    }
	    model.addAttribute("MboardList", mlist);
	    return "getMboardList.jsp";
	}
	
	// 내가 작성한 신청 글 보러가기
	@RequestMapping("/mySList.do")
	public String mySList(BoardVO vo, Model model) {
		System.out.println("작성한 신청 글 목록 검색 처리");
		List<BoardVO> slist = boardService.mySList(vo);
		if (slist == null || slist.isEmpty()) {
	        return "noWritten.jsp";
	    }
	    model.addAttribute("SboardList", slist);
	    return "getSboardList.jsp";
	}
	
	
	
	
	
	
	
	
	
}