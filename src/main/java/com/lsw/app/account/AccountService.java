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
	
	
	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}
	
	
	public int transfer(AccountDTO accountDTO, BankingDTO bankingDTO) throws Exception {
		
		int result = -1;
		
		if ( accountDTO.getBank_pw().equals(accountDAO.detail(accountDTO).getBank_pw()) ) {			
			result = accountDAO.transfer(bankingDTO) + accountDAO.transferList(bankingDTO);
		}
		
		if ( bankingDTO.getDifference() > accountDAO.detail(accountDTO).getBalance() ) {			
			result = -2;
		}
		
		return result;
	}

}
