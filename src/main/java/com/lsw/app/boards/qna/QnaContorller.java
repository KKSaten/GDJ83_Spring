package com.lsw.app.boards.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*")
public class QnaContorller {
	
//	@RequestMapping(value="list", method = RequestMethod.GET)
	@GetMapping("list")		//이제는 이렇게 쓸 수 있다. 메서드가 post면 PostMapping 어노테이션
	public ModelAndView list(ModelAndView mv) throws Exception {
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	
	@GetMapping("detail")
	public String detail() throws Exception {
		
		return "board/detail";
	}
	
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "board/add";
	}
	
	@GetMapping("update")
	public String update() throws Exception {
		
		return "board/update";
	}
	
}
