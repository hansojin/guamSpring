package com.guam.biz.board.impl;

import java.util.List;

import com.guam.biz.board.BoardVO;

public interface BoardService {

	// 글 등록	
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);
	
	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 조회
	List<BoardVO> getBoardList(BoardVO vo);
	
	///////////////// 위에는 이후 삭제 ///////////////////
	
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