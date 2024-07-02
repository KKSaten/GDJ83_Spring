package com.lsw.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<ProductDTO> ar = productService.getList();
		
		model.addAttribute("list", ar);
	}
	
	
	@RequestMapping(value = "detail")
	public String getDetail(Model model, int item_id) throws Exception{
		ProductDTO productDTO = productService.getDetail(item_id);
		
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
	public String add(Model model, ProductDTO productDTO) throws Exception {
		int result = productService.add(productDTO);
		
		System.out.println(productDTO.getItem_name());
		
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
	
	
	

}
