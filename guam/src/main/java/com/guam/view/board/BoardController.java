package com.guam.view.board;

import java.io.IOException;

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
	
	// 글 등록
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("글 등록 처리");
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("글 수정 처리");
		
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		
		model.addAttribute("board", boardService.getBoard(vo));		// Model 정보 저장
		return "getBoard.jsp";										// View 이름 리턴
	}	
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		
//		// Null Check
//		if(vo.getSearchCondition() == null) 
//			vo.setSearchCondition("TITLE");
//		if(vo.getSearchKeyword() == null) 
//			vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo));		// Model 정보 저장 
    	return "getBoardList.jsp";											// View 이름 리턴					
	}
	
	
	
	
	///////////// 여기 위에 지우기 ////////////////
	
	
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
		model.addAttribute("MboardList", boardService.getMboardList(vo));		// Model 정보 저장 
    	return "getMboardList.jsp";												// View 이름 리턴					
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
		model.addAttribute("SboardList", boardService.getSboardList(vo));		// Model 정보 저장 
    	return "getSboardList.jsp";												// View 이름 리턴					
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
	
	
	
	
	
	
	
	
	
	
	
}