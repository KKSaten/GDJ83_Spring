package com.lsw.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsw.app.util.PageOption;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public Map<String, Object> getList(Long page) throws Exception {
		//page가 1이면		2라면		3		4
		//첫번째 숫자 1			11		21		31
		//두번째 숫자 10		20		30		40
		//그런데 또 목록 10개가 아니라 5개씩 보겠다면?
		//이런 걸 다 감안해야한다
		
		if(page == null || page <= 0) {
			page = 1L;
		}
		
		
		//1. 데이터 총 갯수를 구하여 총 페이지 수 구하기
		long perPage = 5L;
		long startRow = page * perPage - (perPage-1);
		long lastRow = page * perPage;
		
//		List<Long> ar = new ArrayList<Long>();
//		ar.add(startRow);
//		ar.add(lastRow);		//클라스 대신 collection인 List, map으로도 가능
		
		PageOption pageOption = new PageOption();
		pageOption.setStartRow(startRow);
		pageOption.setLastRow(lastRow);
		
		long totalCount = productDAO.totalCount();
		long totalPage = totalCount / perPage;
		if(totalCount%perPage > 0) {
			totalPage++;
		}
		
		
		//2. 총 페이지 수로 총 블럭 수를 구하기
		long perBlock = 5L; //한 블럭에 보여질 페이지 번호의 수
		long totalBlock = totalPage/perBlock; //총 블럭의 수
		if(totalPage%perBlock > 0) {
			totalBlock ++;
		}
		
		
		//3.현재 페이지 번호로 현재 블럭 번호를 구하기
		
		// page		1	2	3	4	5	6	7	8	9	10	11
		// 블럭번호	1	1	1	1	1	2	2	2	2	2	3
		long curBlock = page/perBlock;
		if(page%perBlock>0) {
			curBlock++;
		}
		
		//4. 현재 블럭 번호로 시작번호와 끝 번호 구하기
		
		// curBlock	1	2	3	
		// start	1	6	11
		// last		1	10	15
		long startNum = (curBlock-1) * perBlock + 1;
		long lastNum = curBlock * perBlock;
		
		
		//5. 이전 블럭, 다음 블럭의 유무 판단
		boolean pre = true;		//true면 이전 블럭이 존재, false면 이전 블럭이 없음
		boolean next = true;
		if (curBlock == 1) {
			pre = false;
		}
		if (curBlock == totalBlock) {
			next = false;
			
			lastNum = totalPage;
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", productDAO.getList(pageOption));
		map.put("totalPage", totalPage); 
		map.put("startNum", startNum);
		map.put("lastNum", lastNum);
		map.put("pre", pre);
		map.put("next", next);
		
		return map;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		return productDAO.getDetail(productDTO);
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		return productDAO.add(productDTO);
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}

}
