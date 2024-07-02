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
	
	
	

}
