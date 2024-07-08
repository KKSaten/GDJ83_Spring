package com.lsw.app.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("member");
		if(obj != null) {		
			chain.doFilter(request, response);
		}else {
			//1.jsp를 통해 보내는 forward
			request.setAttribute("result", "로그인 후 이용 가능합니다.");
			request.setAttribute("url", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/commons/message.jsp");
			view.forward(request, response);
			//2.클라이언트에게 직접 url을 보내는 redirect
//			HttpServletResponse res = (HttpServletResponse)response;
//			res.sendRedirect("/member/login");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
