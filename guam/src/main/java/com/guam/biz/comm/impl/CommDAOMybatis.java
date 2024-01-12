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
	

	
	
	
	
}
