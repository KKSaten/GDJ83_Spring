package com.lsw.app.locations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/location/*")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {

		List<LocationDTO> ar = locationService.getList();

		model.addAttribute("list", ar);

	}

	
	@RequestMapping(value = "detail")
	public void getDetail(Model model, int location_id) throws Exception {
		LocationDTO locationDTO = locationService.getDetail(location_id);
		
		model.addAttribute("dto", locationDTO);
	}
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(Model model, LocationDTO locationDTO) throws Exception {
		int result = locationService.add(locationDTO);
		
		String url = "";
		if(result>0) {
			url = "redirect:./list";
		}else {
			url = "commons/message";
			model.addAttribute("result", "지역 등록에 실패");
			model.addAttribute("url", "./list");
			
		}
		return url;	
	}
	
	
	
}
