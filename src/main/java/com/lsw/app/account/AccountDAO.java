package com.lsw.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.account.TradeDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.lsw.app.account.AccountDAO.";
	
	
//	public List<AccountDTO> getList(MemberDTO memberDTO) throws Exception {
//		return sqlSession.selectList(NAMESPACE+"list", memberDTO);
//	}
	
	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"add", accountDTO);
	}
		
	public AccountDTO detail(AccountDTO accountDTO) throws Exception {	
		return sqlSession.selectOne(NAMESPACE+"detail", accountDTO);	
	}
	
	
	public int transfer(TradeDTO tradeDTO) throws Exception {
		int result = sqlSession.update(NAMESPACE+"transfer", tradeDTO);
		
		return result;
	}
	public int transferList(TradeDTO tradeDTO) throws Exception {
		
		int a = sqlSession.insert(NAMESPACE+"transferList", tradeDTO);
		int b = sqlSession.insert(NAMESPACE+"transferList_u", tradeDTO);
		
		int result = a + b;
		
		return result;
	}
	
	public List<TradeDTO> bankingList(AccountDTO accountDTO) {
		
		return sqlSession.selectList(NAMESPACE+"bankingList", accountDTO);
	}
	
	public String getPW(AccountDTO accountDTO) {
		return sqlSession.selectOne(NAMESPACE+"getPW", accountDTO);
	}
}
