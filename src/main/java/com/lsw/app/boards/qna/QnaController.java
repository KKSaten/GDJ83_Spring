package com.lsw.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsw.app.boards.BoardDTO;
import com.lsw.app.member.MemberDTO;
import com.lsw.app.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	private int master;
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board") //Model의 키값
	public String getBoard() {
			
		return "QnA" ; //Model의 밸류값이 됨
	}
	
	
//	@RequestMapping(value="list", method = RequestMethod.GET)
	@GetMapping("list")		//이제는 이렇게 쓸 수 있다. 메서드가 post면 PostMapping 어노테이션
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		
		List<BoardDTO> ar = qnaService.list(pager);
		mv.addObject("list", ar); //Model은 setAttribute이지만 ModelAndView는 addObject
		
		mv.setViewName("board/list");
		
		return mv;
	}
	
	
	@GetMapping("detail")
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		
		qnaService.hit(boardDTO);
		
		model.addAttribute("dto", boardDTO);
		
		return "board/detail";
	}
	
	
	@GetMapping("add")
	public String add() throws Exception {
		
		return "board/form";
	}
	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession session) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getMember_id());
		
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";
	}
	
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		
		model.addAttribute("dto", qnaDTO);
		
		return "board/form";
	}
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getMember_id());
		
		int result = qnaService.reply(qnaDTO);
		
		return "redirect:./list";
	}
	
	
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = (QnaDTO)qnaService.detail(qnaDTO);
		
		model.addAttribute("dto", boardDTO);
		
		return "board/form";
	}
	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {

		int result = qnaService.update(qnaDTO);
		
		return "redirect:./list";
	}
	
	@PostMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {

		int result = qnaService.delete(qnaDTO);
		
		return "redirect:./list";
	}
	
}
