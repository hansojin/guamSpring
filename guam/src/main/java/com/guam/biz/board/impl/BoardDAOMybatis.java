package com.guam.biz.board.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guam.biz.board.BoardVO;

@Repository
public class BoardDAOMybatis{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return mybatis.selectOne("BoardDAO.getBoard", vo);	
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);	
	}
	
	///////////////// 위에는 이후 삭제 ///////////////////
	
	public void insertMboard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertMboard() 기능 처리");
		mybatis.insert("BoardDAO.insertMboard", vo);
	}
	
	public List<BoardVO> getMboardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getMboardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getMboardList", vo);	
	}
	
	public void insertSboard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertSboard() 기능 처리");
		mybatis.insert("BoardDAO.insertSboard", vo);
	}
	
	public List<BoardVO> getSboardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getSboardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getSboardList", vo);	
	}
	
	public void deleteMboard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteMboard() 기능 처리");
		mybatis.delete("BoardDAO.deleteMboard", vo);		
	}
	
	public void deleteSboard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteSboard() 기능 처리");
		mybatis.delete("BoardDAO.deleteSboard", vo);		
	}
	
	public List<BoardVO> searchMboardList(String search) {
	    System.out.println("===> Mybatis로 searchMboardList() 기능 처리");
	    Map<String, String> paramMMap = new HashMap<>();
	    paramMMap.put("search", search);
	    return mybatis.selectList("BoardDAO.searchMboardList", paramMMap);
	}
	
	public List<BoardVO> searchSboardList(String search) {
	    System.out.println("===> Mybatis로 searchSboardList() 기능 처리");
	    Map<String, String> paramSMap = new HashMap<>();
	    paramSMap.put("search", search);
	    return mybatis.selectList("BoardDAO.searchSboardList", paramSMap);
	}
}