package com.lsw.app.boards.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsw.app.boards.BoardDTO;
import com.lsw.app.product.ProductDTO;
import com.lsw.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = noticeService.list(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
		
		return "/board/list";
	}

	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		//매개변수에 BoardDTO boardDTO가 아닌 이유는 
		//모든 NoticeDTO는 BoardDTO지만 모든 BoardDTO는 NoticeDTO가 아니므로 처음 생성 자체는 NoticeDTO로 해줘야한다
		//이후 service, dao 과정에서는 부모타입인 BoardDTO로,
		//리턴값도 BoardDTO로 받는 것
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		
		noticeService.hit(boardDTO);
		
		String url = "";
		
		if (boardDTO != null) {
			model.addAttribute("dto", boardDTO);
			url = "board/detail";
		} else {
			model.addAttribute("result", "존재하지 않는 게시글입니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		
		return url;

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.delete(noticeDTO);
		
		String url = "";
		if (result > 0) {
			url = "commons/message";
			model.addAttribute("result", "게시글을 삭제하였습니다.");
			model.addAttribute("url", "board/list");
		} else {
			model.addAttribute("result", "삭제에 실패했습니다.");
			model.addAttribute("url", "board/list");
			url = "commons/message";
		}
		return url;

	}

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String add(){
		return "board/wrtie";
	}
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, Model model) throws Exception {
		int result = noticeService.add(noticeDTO);

		String url = "";
		if (result > 0) {
			url = "redirect:board/list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "글쓰기에 실패했습니다.");
			model.addAttribute("url", "board/list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		
		String url = "";
		if (boardDTO != null) {
			model.addAttribute("dto", boardDTO);
			url = "board/update";
		} else {
			model.addAttribute("result", "없는 게시글입니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		
		return url;
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		
		int result = noticeService.update(noticeDTO);

		return "redirect:board/list";

	}
	
	
	
	
}
