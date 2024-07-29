package com.lsw.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.files.FileDTO;
import com.lsw.app.util.Pager;

public interface BoardService {
	
	//list
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	//detail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	//hit
	public int hit(BoardDTO boardDTO) throws Exception;
	
	//file 다운로드
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception;

}
