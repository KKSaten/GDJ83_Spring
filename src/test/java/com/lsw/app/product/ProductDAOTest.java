package com.lsw.app.product;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsw.app.DefaultTest;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void getDetailTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setItem_id(82);
		productDTO = productDAO.getDetail(productDTO);
		//단정문
		assertNotNull(productDTO);
		
	}
	
	
	
	
	
}
