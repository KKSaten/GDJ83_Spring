package com.lsw.app.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsw.app.util.PageOption;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Long page) throws Exception {
		//page가 1이면		2라면		3		4
		//첫번째 숫자 1			11		21		31
		//두번째 숫자 10		20		30		40
		//그런데 또 목록 10개가 아니라 5개씩 보겠다면?
		//이런 걸 다 감안해야한다
		
		if(page == null) {
			page = 1L;
		}
		
		long perPage = 10L;
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
		
		pageOption.setTotalPage(totalPage);
		
		return productDAO.getList(pageOption);
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
