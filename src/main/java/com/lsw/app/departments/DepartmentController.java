package com.lsw.app.departments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/department/*")
public class DepartmentController {
	
	//IOC : Inversion Of Controll 
	//객체 생성, 메서드 호출
	//Controller, Service, Repository, Component
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList() throws Exception {
		System.out.println("department list");
		
//		return "department/list";
		departmentService.getList();
	}
	
	
	

}
