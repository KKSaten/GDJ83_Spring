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
	

}
