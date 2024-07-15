package com.lsw.app.boards.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lsw.app.boards.BoardDAO;
import com.lsw.app.boards.BoardDTO;
import com.lsw.app.boards.BoardService;
import com.lsw.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();

		long totalCount = boardDAO.getTotalCount(pager);

		pager.makeNum(totalCount);

		return boardDAO.list(pager); 
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.add(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.delete(boardDTO);
	}

	@Override
	public int hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.hit(boardDTO);
	}


	
	
	
	
	
	
//	@Autowired
//	private NoticeDAO noticeDAO;
//
//	public List<BoardDTO> getList(Pager pager) throws Exception{
//		
//		pager.makeRow();
//
//		long totalCount = noticeDAO.getTotalCount(pager);
//
//		pager.makeNum(totalCount);
//
//		return noticeDAO.list(pager); 
//		
//	}
//
//	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception{
//		return noticeDAO.detail(boardDTO);
//	}
//
//	public int delete(BoardDTO boardDTO) throws Exception{
//		return noticeDAO.delete(boardDTO);
//	}
//	
//	public int add(BoardDTO boardDTO) throws Exception{
//		return noticeDAO.add(boardDTO);
//		
//	}
//	public int update(BoardDTO boardDTO) throws Exception{
//		return noticeDAO.update(boardDTO);
//		
//	}
//	
//	public int hit(BoardDTO boardDTO) throws Exception{
//		return noticeDAO.hit(boardDTO);
//	}

}
