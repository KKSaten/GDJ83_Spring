package com.lsw.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.member.MemberDTO;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESAPCE="com.lsw.app.account.AccountDAO.";
	
	
	public List<AccountDTO> getList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESAPCE+"list", memberDTO);
	}
	
	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE+"add", accountDTO);
	}
}
