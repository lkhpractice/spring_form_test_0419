package com.lkhpractice.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/join2")
	public String join2() {
		return "join2";
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
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		
		model.addAttribute("memberId", mid);
		
		System.out.println("post방식 실행!!");
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.GET)
	public String loginOkGet(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("id");
		String mpw = request.getParameter("pw");
		
		model.addAttribute("memberId", mid);
		
		System.out.println("get방식 실행!!");
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/student/{studentId}") // {studentId} : 숫자만 받는 부분
	public String studentId(@PathVariable String studentId, Model model) {
		
		model.addAttribute("studentNum", studentId);
		
		return "studentIdView";
	}
	
	@RequestMapping(value = "/studentTest")
	public String studentTest(@ModelAttribute("dto") MemberDto memberDto) {
		
		return "studentTest";
	}

}
