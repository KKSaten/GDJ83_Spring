package com.lsw.app.account;

import java.util.Calendar;
import java.util.List;

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
	
	
	public int transfer(AccountDTO accountDTO, TradeDTO tradeDTO) throws Exception {
		
		int result = -1;

		if ( tradeDTO.getDifference() > accountDAO.detail(accountDTO).getBalance() ) {			
			result = -2;
		}
		
		if ( accountDTO.getBank_pw().equals(accountDAO.getPW(accountDTO)) ) {			
			result = accountDAO.transfer(tradeDTO) + accountDAO.transferList(tradeDTO);
		}
		
		return result;
	}
	
	public List<TradeDTO> bankingList(ListOption listOption) throws Exception {
		
		return accountDAO.bankingList(listOption);
	}

}
