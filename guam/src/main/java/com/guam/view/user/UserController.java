package com.guam.view.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guam.biz.board.BoardVO;
import com.guam.biz.user.UserVO;
import com.guam.biz.user.impl.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 처리");
		UserVO user = userService.getUser(vo);
		if (user != null) {
			session.setAttribute("id", user.getId());
			return "index.jsp";
		} else {
			session.setAttribute("loginError", true);
			return "login.jsp";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");

		session.invalidate();
		return "login.jsp";
	}

	// id 중복 체크
	@RequestMapping("/idCheck.do")
	public void idCheck(UserVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(vo);
		PrintWriter out = response.getWriter();
		UserVO tmp = userService.idCheck(vo);
		System.out.println(tmp);
		if (tmp == null)
			out.write("1");
		else
			out.write("0");
	}

	// 회원수
	@RequestMapping("/memberCount.do")
	public String memberCount(UserVO vo) {

		userService.memberCount(vo);
		return "index.jsp";
	}

	// 회원가입
	@RequestMapping("/memberRegister.do")
	public String addMember(UserVO vo) {
		System.out.println("회원 가입 처리");
		userService.insertMember(vo);
		return "index.jsp";
	}

	// to myPage
	@RequestMapping("/getUserInfo.do")
	public String getUserInfo(UserVO vo, Model model) {
		System.out.println("user 정보 가져오기 " + vo);
		model.addAttribute("user", userService.getUserInfo(vo)); 
		return "myPage.jsp"; 
	}
	
	
	// to myPage 수정하기
	@RequestMapping("/updateInfo.do")
	public String updateUserInfo(UserVO vo, Model model) {
		System.out.println("user 정보 가져오기 " + vo);
		model.addAttribute("user", userService.getUserInfo(vo)); 
		return "myPageEdit.jsp"; 
	}
	
	// user info 수정
	@RequestMapping("/updateMemberInfo.do")
	public String updateMember(@ModelAttribute("user") UserVO vo, HttpSession session) {
		System.out.println("user 정보 수정");
		userService.updateMember(vo);
		return "redirect:/getUserInfo.do?id=" + session.getAttribute("id");
	}
	
	// 회원 탈퇴
	@RequestMapping("/resign.do")
	public String deleteBoard(UserVO vo, HttpSession session) {
		System.out.println("회원 탈퇴 처리");
			
		userService.deleteUser(vo);
		session.invalidate();
		return "index.jsp";
	}

}