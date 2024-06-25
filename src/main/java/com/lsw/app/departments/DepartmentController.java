package com.lsw.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	
	//IOC : Inversion Of Controll 
	//객체 생성, 메서드 호출
	//Controller, Service, Repository, Component
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		System.out.println("department list");
		
		//return "department/list";
		
		List<DepartmentDTO> ar = departmentService.getList();
		
		// Model + View
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("list", ar);
//		return mv;
		
		model.addAttribute("list", ar);
		
	}
	
	
	

}
