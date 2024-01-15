package com.guam.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guam.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOMybatis boardDAO;
	
	@Override
	public void insertMboard(BoardVO vo) {
		boardDAO.insertMboard(vo);
	}
	
	@Override
	public List<BoardVO> getMboardList(BoardVO vo) {
		return boardDAO.getMboardList(vo);
	}
	
	@Override
	public void insertSboard(BoardVO vo) {
		boardDAO.insertSboard(vo);
	}
	
	@Override
	public List<BoardVO> getSboardList(BoardVO vo) {
		return boardDAO.getSboardList(vo);
	}

	@Override
	public void deleteMboard(BoardVO vo) {
		boardDAO.deleteMboard(vo);
	}
	
	@Override
	public void deleteSboard(BoardVO vo) {
		boardDAO.deleteSboard(vo);
	}
	
	@Override
	public List<BoardVO> searchMboardList(String search) {
		return boardDAO.searchMboardList(search);
	}
	
	@Override
	public List<BoardVO> searchSboardList(String search) {
		return boardDAO.searchSboardList(search);
	}
	
}