package com.lkhpractice.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lkhpractice.member.dto.MemberDto;

@Controller
public class MemberController {
	// login -> loginOk.jsp가 출력되는 RequestMapping
	// id:tiger, pw:12345 파라미터가 전송됨 (loginOk?id=tiger&pw=12345)
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login2")
	public String login2() {
		return "login2";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(MemberDto memberDto, Model model) {
		
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "loginOk2")
	public String loginOk2(@RequestParam("id") String mid, @RequestParam("pw") String mpw, Model model) {
		
		model.addAttribute("memberId", mid);
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		
		model.addAttribute("memberId", mid);
		
		return "loginOk";
	}

}
