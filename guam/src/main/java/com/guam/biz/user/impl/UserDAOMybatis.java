package com.guam.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guam.biz.board.BoardVO;
import com.guam.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;	
	
	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public UserVO idCheck(UserVO vo) {
		return mybatis.selectOne("UserDAO.idCheck", vo);
	}
	
	public int memberCount(UserVO vo) {
		return mybatis.selectOne("UserDAO.memberCount", vo);
	}
	
	public void insertMember(UserVO vo) {
		System.out.println("===> Mybatis로 insertMember() 기능 처리");
		mybatis.insert("UserDAO.insertMember", vo);
	}
	
	public void updateMember(UserVO vo) {
		System.out.println("===> Mybatis로 updateMember() 기능 처리");
		mybatis.insert("UserDAO.updateMember", vo);
	}
	
	public UserVO getUserInfo(UserVO vo) {
		System.out.println("===> Mybatis로 getUserInfo() 기능 처리");
		return mybatis.selectOne("UserDAO.getUserInfo", vo);	
	}
	
	public void deleteUser(UserVO vo) {
		System.out.println("===> Mybatis로 deleteUser() 기능 처리");
		mybatis.delete("UserDAO.deleteUser", vo);		
	}
	
	
	
}