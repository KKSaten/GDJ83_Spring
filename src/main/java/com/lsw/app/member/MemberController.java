package com.lsw.app.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model,
			@CookieValue(name = "remember", required = false, defaultValue = "")
			String value) throws Exception {
		
		model.addAttribute("id", value);
		
//		Cookie [] cookies = request.getCookies();
//		for(Cookie c: cookies) {
//			if(c.getName().equals("remember")) {
//				request.setAttribute("id", c.getValue());
//			}
//		}
		
	}
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, MemberDTO memberDTO,
			HttpServletResponse response, HttpSession session,
			String remember) throws Exception {
		
		if(remember != null) {
			Cookie cookie = new Cookie("remember", memberDTO.getMember_id());
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		memberDTO = memberService.login(memberDTO); 
		
		String url="";
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			url="redirect:/";
			
		}else {
			url = "commons/message";
			model.addAttribute("result", "아이디 혹은 비밀번호를 확인하시기 바랍니다");
			model.addAttribute("url", "/member/login");
		}
		
		return url;
	}
	
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); //session의 유지시간을 0으로 만듦. 즉 바로 삭제
		
		return "redirect:/";
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
	}
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);
		
		String url = "";
		if(result > 0) {
			url = "commons/message";
			model.addAttribute("result", "가입을 환영합니다");
			model.addAttribute("url", "/");
		} else {
			url = "commons/message";
			model.addAttribute("result", "회원가입 실패");
			model.addAttribute("url", "/");
		}
		
		return url;
		
	}

}
