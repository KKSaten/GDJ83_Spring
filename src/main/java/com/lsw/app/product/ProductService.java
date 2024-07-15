package com.lsw.app.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsw.app.util.Pager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		//page가 1이면		2라면		3		4
		//첫번째 숫자 1			11		21		31
		//두번째 숫자 10		20		30		40
		//그런데 또 목록 10개가 아니라 5개씩 보겠다면?
		//이런 걸 다 감안해야한다

		pager.makeRow();

		long totalCount = productDAO.getTotalCount(pager);// 100 , 130, 121~129 , 131~139

		pager.makeNum(totalCount);

		return productDAO.getList(pager);
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
