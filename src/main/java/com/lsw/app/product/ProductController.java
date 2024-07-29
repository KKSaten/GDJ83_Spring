package com.lsw.app.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.member.MemberDTO;
import com.lsw.app.util.Pager;
import com.lsw.app.util.ProductCommentPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Pager pager, Model model) throws Exception {
		List<ProductDTO> list = productService.getList(pager);
		
		model.addAttribute("pager", pager);
		model.addAttribute("list", list);
		
	}
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(Model model, ProductDTO productDTO) throws Exception{
		productDTO = productService.getDetail(productDTO);
		
		String url = "";
		
		if(productDTO != null) {
			model.addAttribute("dto", productDTO);
			url = "product/detail";
		} else {
			model.addAttribute("result", "잘못된 접근입니다");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		
		return url;
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = productService.add(productDTO, files, session);
		
		String url = "";
		if(result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "상품 추가 실패");
			model.addAttribute(url, "./list");
		}
		
		return url;
		
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.delete(productDTO);
		
		String url = "";
		if(result > 0) {
			url = "redirect:./list";
		} else {
			url = "commons/message";
			model.addAttribute("result", "상품 삭제 실패");
			model.addAttribute("url", "./list");
		}
		
		return url;
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, ProductDTO productDTO) throws Exception {	
		productDTO = productService.getDetail(productDTO);
		
		String url = "";
		if(productDTO != null) {
			model.addAttribute("dto", productDTO);
			url = "product/update";
		} else {
			model.addAttribute("result", "상품 수정 실패");
			model.addAttribute("url", "./list");
			url = "commons/message";
		}
		
		return url;
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ProductDTO productDTO) throws Exception {
		
		int result = productService.update(productDTO);
		
		return "redirect:./list";

	}
	
	
	@GetMapping("addWish")
	public String addWish(Integer item_id, HttpSession session, Model model) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = productService.addWish(item_id, memberDTO.getMember_id());
		model.addAttribute("msg", result);

		
		return "commons/result";
	}
	
	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		List<ProductDTO> ar = productService.wishList(memberDTO);
		model.addAttribute("list", ar);
	}
	
	
	@PostMapping("commentAdd")
	public String commentAdd(ProductCommentDTO productCommentDTO, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		productCommentDTO.setBoardWriter(memberDTO.getMember_id());
		
		int result = productService.commentAdd(productCommentDTO);
		model.addAttribute("msg", result);
		return "commons/result";
	}
	
	@GetMapping("commentList")
	public void commentList(Model model, ProductCommentPager productCommentPager) throws Exception {
		List<ProductCommentDTO> list = productService.commentList(productCommentPager);
		model.addAttribute("list", list);
		model.addAttribute("pager", productCommentPager);
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(HttpSession session, Model model, ProductCommentDTO productCommentDTO) throws Exception {
		
		int result = productService.commentDelete(productCommentDTO);
		model.addAttribute("msg", result);
		
		return "commons/result";
	}
	
	
	@RequestMapping(value="../account/add", method=RequestMethod.GET )
	public void addAccount(Model model, ProductDTO productDTO) throws Exception {
		model.addAttribute("dto", productDTO);
	}
	
	
	

	
	

}
