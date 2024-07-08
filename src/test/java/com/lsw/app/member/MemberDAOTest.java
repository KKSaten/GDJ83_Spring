package com.lsw.app.member;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsw.app.DefaultTest;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void loginTest() throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("IronMan");
		memberDTO = memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
		
	}
	

}
