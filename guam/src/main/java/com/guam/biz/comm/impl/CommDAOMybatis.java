package com.guam.biz.comm.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guam.biz.comm.CommReplyVO;
import com.guam.biz.comm.CommVO;

@Repository
public class CommDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertComm(CommVO vo) {
		System.out.println("===> Mybatis로 insertComm() 기능 처리");
		mybatis.insert("CommDAO.insertComm", vo);
	}
	
	public List<CommVO> communityList(CommVO vo) {
		System.out.println("===> Mybatis로 communityList() 기능 처리");
		return mybatis.selectList("CommDAO.communityList", vo);	
	}
	
	public CommVO communityPost(CommVO vo) {
		System.out.println("===> Mybatis로 communityPost() 기능 처리");
		mybatis.update("CommDAO.viewAddOne", vo);	// view+=1
		return mybatis.selectOne("CommDAO.communityPost", vo);	
	}

	public List<CommReplyVO> commentList(CommReplyVO vo) {
		System.out.println("===> Mybatis로 commentList() 기능 처리");
		return mybatis.selectList("CommDAO.commentList", vo);	
	}
	
	
	public void addComment(CommReplyVO vo) {
		System.out.println("===> Mybatis로 addComment() 기능 처리");
		mybatis.insert("CommDAO.addComment", vo);
	}
	
	public void addCommentCnt(int seq) {
		System.out.println("===> Mybatis로 addCommentCnt() 기능 처리");
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("seq", seq);
		mybatis.insert("CommDAO.addCommentCnt", paramMap);
	}
	
	public void minCommentCnt(int seq) {
		System.out.println("===> Mybatis로 minCommentCnt() 기능 처리");
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("seq", seq);
		mybatis.insert("CommDAO.minCommentCnt", paramMap);
	}
	
	public void deleteComment(int idx) {
		System.out.println("===> Mybatis로 deleteComment() 기능 처리");
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("idx", idx);
		mybatis.delete("CommDAO.deleteComment", paramMap);
	}
	
	public void deletePost(CommVO vo) {
		System.out.println("===> Mybatis로 deletePost() 기능 처리");
		mybatis.delete("CommDAO.deletePost", vo);
	}
	
	
	public CommVO toEdit(CommVO vo) {
		System.out.println("===> Mybatis로 toEdit() 기능 처리");
		return mybatis.selectOne("CommDAO.toEdit", vo);	
	}
	
	public void editPost(CommVO vo) {
		System.out.println("===> Mybatis로 editPost() 기능 처리");
		mybatis.update("CommDAO.editPost", vo);
	}
}
