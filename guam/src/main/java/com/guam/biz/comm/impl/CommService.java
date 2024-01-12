package com.guam.biz.comm.impl;

import java.util.List;

import com.guam.biz.board.BoardVO;
import com.guam.biz.comm.CommReplyVO;
import com.guam.biz.comm.CommVO;

public interface CommService {

	// 커뮤니티 글 등록
	void insertComm(CommVO vo);
	
	// 커뮤니티 글 목록 조회
	List<CommVO> communityList(CommVO vo);
	
	// 글 상세 조회
	CommVO communityPost(CommVO vo);
	
	// 커뮤니티 댓글 등록
	void addComment(CommReplyVO vo);
	void addCommentCnt(int seq);
	

	
}
