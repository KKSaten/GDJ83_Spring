package com.lsw.app.member;


import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.account.AccountDAO;
import com.lsw.app.account.AccountDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private AccountDAO accountDAO;
	
	private String name="members";
	
	public int join(MemberDTO memberDTO, MultipartFile files, HttpSession session) throws Exception {
		
		
		int result = memberDAO.join(memberDTO);
		
		
		if(files == null) {
			return result;
		}
		
		ServletContext servletContext = session.getServletContext();
		
		//1. 어디에 저장? 어느 폴더에 저장할래?
		String path = servletContext.getRealPath("resources/upload/members");
		
		System.out.println(path);
		
		File file = new File(path);
		
		if(!file.exists()) { 
			file.mkdirs();
		}
		
		//2. 파일명은 뭐라고 저장하나? (파일명을 중복시키지 않을 방법이 있어야한다)
		//2-1.시간을 이용하자 
		Calendar calendar = Calendar.getInstance();
		Long n = calendar.getTimeInMillis();
		
		//확장자 뽑아올거임 subString
		String fileName = files.getOriginalFilename();
		fileName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(fileName);
		
		//split, StringTonkenizer으로도 해보자
		fileName = files.getOriginalFilename();
		String[] names = fileName.split("\\."); //그냥 .만 쓰니까 에러떠;
		fileName = names[names.length-1];
		System.out.println(fileName);
		
		
		fileName = n + "." + fileName;
		
		fileName = n+"_"+files.getOriginalFilename();
		System.out.println(fileName);
		
		
		
		//2-2. UUID라는 라이브러리를 이용 (랜덤하게 중복없이 뽑아줌)
		fileName = UUID.randomUUID().toString() + "_" + files.getOriginalFilename();
		System.out.println(fileName);
		
		
		
		//3. 하드디스크에 파일을 저장하자
		file = new File(file, fileName); //일단 객체 하나 파서
		
		//3-1. 어떻게 저장하지? 우리가 사용한 MultipartFile 클래스에 메서드가 하나 있음
//		files.transferTo(file); //tranferTO = 저따가 전송하세요 = 저따가 저장하세요
		
		//3-2 FileCopyUtils 라는 라이브러리 사용. 요 클래스에 메서드가 하나 있음
		FileCopyUtils.copy(files.getBytes(), file);
		
		
		
		
		
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		
		memberFileDTO.setMember_id(memberDTO.getMember_id());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(files.getOriginalFilename());
		
		result = memberDAO.addFile(memberFileDTO);
		
		return result;
		
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		
		MemberDTO result = memberDAO.login(memberDTO);
		// 매개변수에 담긴 유저가 입력한 pw도 살려야하고 DAO를 통해 db에서 가져온 pw도 살려야 비교가 가능하기 때문에
		// 새로운 객체 result를 만들어 따로 담은 것
		if(result != null) {
			if(result.getMember_pw().equals( memberDTO.getMember_pw() )) {
				//로그인 성공시점
				
				return result;
			} else {
				// return null;
				result = null;
			}
		}
		
		return result;
	}
	
	
	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}
	
	
	public int delete(MemberDTO memberDTO) throws Exception {
		return memberDAO.delete(memberDTO);
	}

	
	public MemberDTO getDetail(MemberDTO memberDTO) throws Exception {
		return memberDAO.getDetail(memberDTO); 
	}
	
	
}
