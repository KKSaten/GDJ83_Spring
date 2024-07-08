package com.lsw.app.account;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	
	public int add(AccountDTO accountDTO) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		accountDTO.setBank_id(String.valueOf( calendar.getTimeInMillis() ));
		
		
		return accountDAO.add(accountDTO);
	}
	

}
