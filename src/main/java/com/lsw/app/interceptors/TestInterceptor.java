package com.lsw.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter{
	
	//controller 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		//return이 true라면 다음 인터셉터나 controller로 보냄
		//return이 false라면 진입을 막음 -> 어디로 보낼지는 개발자가 정해줘야 함
		System.out.println("Test Interceptor PreHandle");
		return true;
	}
	
	
	//controller 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Test Interceptor PostHandle");
	}
	
	
	//JSP 렌더링 이후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Test Interceptor AfterCompletion");
	}
	
	
	
	
	
}
