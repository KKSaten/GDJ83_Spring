package com.lsw.app.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //Exception을 전문적으로 처리하는 별도의 컨트롤러. 전역적으로 모든 controller들의 예외를 모두 처리
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String exception1(Model model) {
		return "errors/error_400";
	}

}


