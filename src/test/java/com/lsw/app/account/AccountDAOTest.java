package com.lsw.app.account;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsw.app.DefaultTest;

public class AccountDAOTest extends DefaultTest{

	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	public void accountTest() throws Exception {
		
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setBank_id("3");
		accountDTO = accountDAO.detail(accountDTO);
		
		assertNotNull(accountDTO);
	}
	
	
//	public void addTest() throws Exception {
//		TradeDTO tradeDTO 
//		int result = tradeDTO.add(tradeDTO);
//	}

}
