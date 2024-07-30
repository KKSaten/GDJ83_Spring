package com.lsw.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lsw.app.boards.BoardDTO;
import com.lsw.app.member.MemberDTO;

public class WriterInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String method = request.getMethod();
		
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		Map<String, Object> map = modelAndView.getModel();
		
		Iterator<String> it = map.keySet().iterator(); //key값을 알고 있으면 바로 꺼내면 되는데 모를 경우 key들을 다 꺼내보는 것
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		BoardDTO boardDTO = (BoardDTO)map.get("dto");
		
		if( !boardDTO.getBoardWriter().equals(memberDTO.getMember_id()) ) {
//			modelAndView.setViewName("redirect:/");
			modelAndView.setViewName("commons/message");
			modelAndView.addObject("result", "작성자만 수정할 수 있습니다");
			modelAndView.addObject("url", "/");
		}
		
		
		
	}
	
	
}
