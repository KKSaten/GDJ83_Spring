package com.lsw.app.notice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsw.app.util.PageOption;

@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;

	public Map<String, Object> list(Long page, String kind, String search) {
		if (page == null) {// -페이지로 가지않도록
			page = 1L;
		}

		if (page < 1) {
			page = 1L;
		}
		if (search == null) {
			search = "";
		}

		// 1. 총 갯수로 총 페이지 수 구하기
		long perPage = 10L;
		System.out.println("test perPage " + perPage);
		System.out.println("test page " + page);

		long startRow = (page - 1) * perPage + 1;
		System.out.println("test startRow " + startRow);

		long lastRow = page * perPage;
		System.out.println("test lastRow " + lastRow);
//
//		List<Long> ar = new ArrayList<Long>();
//
//		// ar.add(perPage);
//		ar.add(startRow);
//		ar.add(lastRow);

		PageOption pageOption = new PageOption();
		pageOption.setStartRow(startRow);
		pageOption.setLastRow(lastRow);
		pageOption.setSearch(search);
		pageOption.setKind(kind);
//		
//		pager.setLastRow(page);
		// 2. 총 페이지 수로 총 블럭수 구하기
		long totalCount = noticeDAO.getTotalCount(pageOption);
		long totalPage = totalCount / perPage;

		// 나머지가 0이 아니면 페이지를 1증가해서 모든 데이터를 보여줌
		if (totalCount % perPage != 0) {
			// totalPage = totalCount / perPage + 1;
			totalPage++;
		}
		// 3. 현재 페이지 번호로 현재 블럭 번호 구하기
		long perBlock = 5L; // 한페이지에 보여질 페이번호의 갯수
		long totalBlock = 0; // 총 블럭의 수

		totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}
		// 3. 현재 페이지 번호로 현재블럭 번호를 구하기
		// page 1 2 3 4 5 6 10 11
		// 블럭번호 1 1 1 1 1 2 2 3
		long curBlock = 0;
		curBlock = page / perBlock;

		if (page % perBlock != 0) {
			curBlock++;
		}

		// 4. 현재 블럭 번호로 시작번호와 끝 번호 구하기

		// curBLock 1 2 3 4
		// start 1 6 11 16
		// last 5 10 15 20
		long startNum = (curBlock - 1) * perBlock + 1;
		long lastNum = curBlock * perBlock;

		// page 1 2 3 4 5 6 7 10
		// start 1 1 1 1 1 6 6 6
		// last 5 5 5 5 5 10 10 10

		// 5. 이전블럭, 다음 블럭 유무 판단
		boolean pre = true; // true면 이전블럭이 존재, false면 이전블럭이 존재x
		boolean next = true;
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {// 현재 블럭이 마지막 블럭이라면
			next = false;
			lastNum = totalPage;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", noticeDAO.list(pageOption));
		map.put("totalPage", totalPage);
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		map.put("kind", kind);
		map.put("search", search);

		// System.out.println("totalPage " + totalPage);
		return map;

		// noticeDAO.list();
	}

	public NoticeDTO detail(NoticeDTO noticeDTO) {
		return noticeDAO.detail(noticeDTO);

	}

	public int delete(NoticeDTO noticeDTO) {
		return noticeDAO.delete(noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO) {
		return noticeDAO.add(noticeDTO);
		
	}
	public int update(NoticeDTO noticeDTO) {
		return noticeDAO.update(noticeDTO);
		
	}

}
