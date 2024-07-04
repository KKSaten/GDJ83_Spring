package com.lsw.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		//하위 내장객체에서 상위 내장객체 꺼낼 수 있음
		//근데 상위 내장객체에서 하위 내장객체는 꺼낼 수 없음
		//오래 살아남는 놈이 상위임. 서블릿>세션>리퀘스트>페이지
		//상위가 있어도 하위는 없을 수도 있으니까
		HttpSession session = request.getSession();
		
		
		
		
//		Cookie[] cookies = request.getCookies();
//		for(Cookie c: cookies) {
//			System.out.println(c.getName());
//			System.out.println(c.getValue());
//		}
		
//		Cookie cookie = new Cookie("test", "SW");
//		cookie.setMaxAge(60);
//		response.addCookie(cookie);
		
		
		return "index";
	}
	
}
