package com.lsw.app.boards;

import java.util.List;

import com.lsw.app.files.FileDTO;
import com.lsw.app.util.Pager;

public interface BoardDAO {
	
	//NoticeDAO, QnaDAO
	
	//totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
	//list
	public abstract List<BoardDTO> list(Pager pager) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	
	//addFile
	public int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	//getNum
	public Long getNum() throws Exception;
	
	//update
	int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	int delete(BoardDTO boardDTO) throws Exception;
	
	//detail
	BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//hit
	int hit(BoardDTO boardDTO) throws Exception;
	
	//file 다운로드
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception;
	
	
	
}
