package com.lsw.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsw.app.member.MemberDTO;
import com.lsw.app.product.ProductDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public void add(Model model, ProductDTO productDTO, AccountDTO accountDTO)
			throws Exception {
		model.addAttribute("dto", productDTO);
		
	}
	@RequestMapping(value="add", method = RequestMethod.POST)
	public String add(AccountDTO accountDTO, HttpSession session, Model model) throws Exception {
		
		String id = ( (MemberDTO)session.getAttribute("member") ).getMember_id();
		accountDTO.setMember_id(id);
		
		int result = accountService.add(accountDTO);
		
		String url = "";
		if(result > 0) {
			url = "commons/message";
			model.addAttribute("result", "계좌 개설 성공");
			model.addAttribute("url", "/member/mypage");
		} else {
			url = "commons/message";
			model.addAttribute("result", "Error");
			model.addAttribute("url", "/member/mypage");
		}
		
		return url;
	}
	
	
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public void detail(HttpSession session, AccountDTO accountDTO, Model model) throws Exception {
		accountDTO = accountService.detail(accountDTO);
		model.addAttribute("dto", accountDTO);
		
		List<TradeDTO> banking_ar = accountService.bankingList(accountDTO);
		model.addAttribute("list", banking_ar);
	}
	
	
	@RequestMapping(value="transfer", method=RequestMethod.GET)
	public void transfer(AccountDTO accountDTO, Model model) throws Exception {	
		model.addAttribute("dto", accountDTO);

	}
	@RequestMapping(value="transfer", method=RequestMethod.POST)
	public String transfer(AccountDTO accountDTO, TradeDTO tradeDTO, Model model)
			throws Exception {	
		model.addAttribute("dto", tradeDTO);
		
		int result = accountService.transfer(accountDTO, tradeDTO);
		
		String url = "";
		if(result == 4) {
			url = "commons/message";
			model.addAttribute("result", "정상 이체 처리");
			model.addAttribute("url", "/member/mypage");
		} else if(result == -1) {
			url = "commons/message";
			model.addAttribute("result", "비밀번호가 잘못입력되었습니다");
			model.addAttribute("url", "/member/mypage");
		} else if(result == -2) {
			url = "commons/message";
			model.addAttribute("result", "잔액이 부족합니다");
			model.addAttribute("url", "/member/mypage");
		} else {
			url = "commons/message";
			model.addAttribute("result", "Error");
			model.addAttribute("url", "/member/mypage");
		}
		
		return url;
	}
	
	
}
