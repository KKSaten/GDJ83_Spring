package com.lsw.app.member;

import java.util.Map;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.account.*;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	//회원가입
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {
	}
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		
		System.out.println(session.getServletContext());
		System.out.println(files.getName());
		System.out.println(files.getOriginalFilename());
		System.out.println(files.getSize());
		
		
		
		
		int result = memberService.join(memberDTO, files, session);
		
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
	
	
	//로그인
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
			String remember, AccountDTO accountDTO) throws Exception {
		
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
//			session.setAttribute("account", accountDTO);
			url="redirect:/";
			
		}else {
			url = "commons/message";
			model.addAttribute("result", "아이디 혹은 비밀번호를 확인하시기 바랍니다");
			model.addAttribute("url", "/member/login");
		}
		
		return url;
	}
	
	
	//로그아웃
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate(); //session의 유지시간을 0으로 만듦. 즉 바로 삭제
		
		//session.setAttribute("member", null);
		//혹은 session은 남겨야한다면 session의 member 속성에 null을 넣어주던가
		//session.removeAttribute("member"); //아니면 member를 지우던가
		
		return "redirect:/";
		
	}
	
	
	//내정보
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(Model model, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
		
		
//		필터에서 만들겠음
//		String url = "";
//		if(session.getAttribute("member") == null) {
//			url = "commons/message";
//			model.addAttribute("result", "로그인 바랍니다");
//			model.addAttribute("url", "/member/login");
//		} else {
//			url = "/member/mypage";
//		}
//		
//		return url;
		
	}
	
	
	//내정보 수정
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		memberDTO = memberService.getDetail(memberDTO);
		model.addAttribute("member", memberDTO);
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Model model, HttpSession session, MemberDTO memberDTO) throws Exception {
		
		MemberDTO user = (MemberDTO)session.getAttribute("member");
		memberDTO.setMember_id(user.getMember_id());
		
		memberService.update(memberDTO);
		
		session.setAttribute("member", memberDTO); //세션값도 바꿔줘야 수정된 값이 보임
		//혹은 이렇게 처리하지 않고 mypage메서드,jsp에서 자체적으로 가져오는 방법도 있다.
		
		
		return "redirect:/member/mypage";
	}
	
	
	//회원탈퇴
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(HttpSession session ,MemberDTO memberDTO, Model model) throws Exception {
		
		MemberDTO user = (MemberDTO)session.getAttribute("member");
		memberDTO.setMember_id(user.getMember_id());
		
		int result = memberService.delete(memberDTO);
		
		
		session.invalidate();
		
		return "redirect:/";
			
	}
	
	

}
