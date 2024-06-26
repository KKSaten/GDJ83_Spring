package com.lsw.app.departments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//		mv.setViewName("dapartment/list");
//		return mv;
		
		model.addAttribute("list", ar);
		
	}
	
	
	@RequestMapping(value = "detail") //메서드 형식 안적으면 GET
//	@RequestParam(name = "num", defaultValue = "10") int department_id     //파라미터값의 이름이 다르게 오거나, 없는 값이 오거나를 하기 위한 대비
	public String getDetail(Model model, int department_id) throws Exception{
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id); //파라미터값을 받으면 String 타입을 int로 바꾸기 위해 파싱하고...
																				  //이제 그런 거 필요없음 spring에서 알아서 해준다
		String path="commons/message";
		
		
		if(departmentDTO != null) {			
			model.addAttribute("dto", departmentDTO);
			path="department/detail";
		} else {
			model.addAttribute("result", "존재하지 않는 부서입니다");
			model.addAttribute("url", "./list");
		}
		
		return path;
	}

	
	//add
	@RequestMapping(value = "add", method = RequestMethod.GET) //입력폼 요청하는 것에만 쓰임
	public void add() {		
	}
	@RequestMapping(value = "add", method = RequestMethod.POST) //
	public String add(DepartmentDTO departmentDTO, Model model) throws Exception {
	
		int result = departmentService.add(departmentDTO);
		String url = "";
		if(result>0) {
			url = "redirect:./list";
		}else {
			url = "commons/message";
			model.addAttribute("result", "부서 등록에 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}
	
	
	
	//delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(DepartmentDTO departmentDTO, Model model) throws Exception {
		
		int result = departmentService.delete(departmentDTO);
		
		String url = "";
		if(result>0) {
			url = "redirect:./list";
		}else {
			url = "commons/message";
			model.addAttribute("result", "부서 삭제에 실패");
			model.addAttribute("url", "./list");
		}
		return url;
	}
	
	
	
	//update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(int department_id, Model model) throws Exception {
		DepartmentDTO departmentDTO = departmentService.getDetail(department_id);
		
		String url = "commons/message";
		if(departmentDTO != null) {
			model.addAttribute("dto", departmentDTO);
			url = "department/update";
		}else {
			model.addAttribute("result", "존재하지 않는 부서입니다");
			model.addAttribute("url", "list");
		}
		
		return url;
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(DepartmentDTO departmentDTO) throws Exception {
		
		int result = departmentService.update(departmentDTO);
		
		return "redirect:./list";
	}
	
	
	
	
	
}
