package com.lsw.app.boards.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.boards.BoardDAO;
import com.lsw.app.boards.BoardDTO;
import com.lsw.app.boards.BoardFileDTO;
import com.lsw.app.boards.BoardService;
import com.lsw.app.files.FileDTO;
import com.lsw.app.files.FileManager;
import com.lsw.app.util.Pager;

@Service
public class QnaService implements BoardService {
	


	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// 1. rownum 계산
		pager.makeRow();
		
		// 2. pageing 계산
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		
		Long num = qnaDAO.getNum();
		boardDTO.setBoardNum(num);
		
		int result = qnaDAO.add(boardDTO);
		

		if (multipartFiles == null) {
			return result;
		}
		
		String path = session.getServletContext().getRealPath("resources/upload/qna");
		
		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(num);
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());
			result = qnaDAO.addFile(qnaFileDTO);
		}
			
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(boardDTO);
	}

	@Override
	public int hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.hit(boardDTO);
	}
	
	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.fileDetail(fileDTO);
	}

	public int reply(QnaDTO qnaDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		QnaDTO parent = (QnaDTO)qnaDAO.detail(qnaDTO);
		//1. step을 1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);
		
		//2. 답글의 REF, STEP, DEPTH를 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		
		result = qnaDAO.reply(qnaDTO);

		// 파일 저장
		String path = session.getServletContext().getRealPath("resources/upload/Qna");

		if (multipartFiles == null) {
			return result;
		}

		for (MultipartFile f : multipartFiles) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(path, f);
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(qnaDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());
			result = qnaDAO.addFile(qnaFileDTO);
		}
		
		
		return result;
		
	}
	
	
}
