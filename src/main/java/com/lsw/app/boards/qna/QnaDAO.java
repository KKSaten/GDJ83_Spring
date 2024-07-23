package com.lsw.app.boards.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.boards.BoardDAO;
import com.lsw.app.boards.BoardDTO;
import com.lsw.app.boards.BoardFileDTO;
import com.lsw.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE="com.lsw.app.boards.qna.QnaDAO."; //마지막에 .찍는 것 잊지 말 것
	//NAMESPACE가 전부 대문자인 이유는
	//상수형 타입의 변수는 대문자로 적는 것이 관례
		
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"add", boardDTO);
	}

	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"delete", boardDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"detail", boardDTO);
	}

	@Override
	public int hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "hit", boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"reply", qnaDTO);
	}
	
	public int replyUpdate(QnaDTO qnaDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"replyUpdate", qnaDTO);
	}
}
