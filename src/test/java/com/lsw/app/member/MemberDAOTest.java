package com.lsw.app.member;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsw.app.DefaultTest;
import com.lsw.app.files.FileDTO;

public class MemberDAOTest extends DefaultTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void addFileTest() throws Exception {
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setMember_id("IronHeart");
		memberFileDTO.setFileName("IronMan");
		memberFileDTO.setOriName("IronMan");
		int result = memberDAO.addFile(memberFileDTO);
		
		System.out.println(result);
		
	}
	

}
