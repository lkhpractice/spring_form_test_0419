package com.lkhpractice.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/member")
	public String member(HttpServletRequest request, Model model) {
		String mid = request.getParameter("id");
		
		if(mid.equals("tiger")) {
			return "redirect:memberOk"; 
		}
		return "redirect:memberNot";
	} // redirect: 컨트롤러에 있는 요청을 다시 넣음(jsp파일 X)
	
	@RequestMapping(value = "/memberOk")
	public String memberOk() {
		
		return "memberOk";
	}
	
	@RequestMapping(value = "/memberNot")
	public String memberNot() {
		
		return "memberNot";
	}
	
}
