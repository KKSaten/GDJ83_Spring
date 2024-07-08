package com.lsw.app.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESAPCE="com.lsw.app.member.MemberDAO.";
	
	
	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESAPCE+"join", memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESAPCE+"login", memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESAPCE+"update", memberDTO);
	}
	
	public int delete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESAPCE+"delete", memberDTO);
	}
	
	

}
