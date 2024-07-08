package com.lsw.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsw.app.product.ProductDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	


}
