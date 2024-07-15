package com.lsw.app.notice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsw.app.product.ProductDTO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void list(Long page, String kind, String search, Model model) {
		Map<String, Object> map = noticeService.list(page, kind, search);
		model.addAttribute("map", map);

	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(NoticeDTO noticeDTO, Model model) {
		noticeDTO = noticeService.detail(noticeDTO);
		
		
		
		String url = "";
		if (noticeDTO != null) {
			model.addAttribute("dto", noticeDTO);
			url = "notice/list";
		} else {
			model.addAttribute("result", "없는 게시글 입니다.");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}

	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(NoticeDTO noticeDTO, Model model) {
		int result = noticeService.delete(noticeDTO);
		String url = "";
		if (result > 0) {
			url = "commons/message";
			model.addAttribute("result", "게시글을 삭제하였습니다.");
			model.addAttribute("url", "/notice/list");
		} else {
			model.addAttribute("result", "삭제에 실패했습니다.");
			model.addAttribute("url", "/notice/list");
			url = "commons/message";
		}
		return url;

	}

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public void add() {

	}

	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO,Model model) {
		int result = noticeService.add(noticeDTO);
		

		String url = "";
		if (result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "글쓰기에 실패했습니다.");
			model.addAttribute("url", "./list");
		}
		return url;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		noticeDTO = noticeService.detail(noticeDTO);
		System.out.println("notice update");
		String url = "";
		if (noticeDTO != null) {
			model.addAttribute("dto", noticeDTO);
			url = "notice/update";
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

		return "redirect:list";

	}

}
