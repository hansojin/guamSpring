package com.guam.biz.board.impl;

import java.util.List;

import com.guam.biz.board.BoardVO;

public interface BoardService {
	
	// 모집 및 신청글 등록
	void insertMboard(BoardVO vo);
	void insertSboard(BoardVO vo);
	
	// 모집 및 신청글 목록 조회
	List<BoardVO> getMboardList(BoardVO vo);
	List<BoardVO> getSboardList(BoardVO vo);

	
	// 모집 및 신청글 삭제
	void deleteMboard(BoardVO vo);
	void deleteSboard(BoardVO vo);
	
	// 검색 글 목록 조회
	List<BoardVO> searchMboardList(String search);
	List<BoardVO> searchSboardList(String search);
	
	
}