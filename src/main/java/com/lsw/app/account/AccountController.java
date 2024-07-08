package com.lsw.app.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsw.app.member.MemberDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void add(HttpSession session) throws Exception {
//		
//		String id = ( (MemberDTO)session.getAttribute("member") ).getMember_id();
//		accountDTO.setMember_id("id");
//		
//		int result = accountService.add(accountDTO);
//		
//		
//		return "redirect:/";
	}
	
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(AccountDTO accountDTO, HttpSession session) throws Exception {
		
		String id = ( (MemberDTO)session.getAttribute("member") ).getMember_id();
		accountDTO.setMember_id("id");
		
		int result = accountService.add(accountDTO);
		
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
}
