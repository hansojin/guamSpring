package com.guam.biz.comm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guam.biz.board.BoardVO;
import com.guam.biz.comm.CommReplyVO;
import com.guam.biz.comm.CommVO;

@Service("commService")
public class CommServiceImpl implements CommService {

	@Autowired
	private CommDAOMybatis commDAO;
	
	@Override
	public void insertComm(CommVO vo) {
		commDAO.insertComm(vo);
	}
	
	@Override
	public List<CommVO> communityList(CommVO vo){
		return commDAO.communityList(vo);
	}
	
	@Override
	public CommVO communityPost(CommVO vo) {
		return commDAO.communityPost(vo);
	}
	
	
	@Override
	public void addComment(CommReplyVO vo) {
		commDAO.addComment(vo);
	}
	
	@Override
	public void addCommentCnt(int seq) {
		commDAO.addCommentCnt(seq);
	}


	
	
}
