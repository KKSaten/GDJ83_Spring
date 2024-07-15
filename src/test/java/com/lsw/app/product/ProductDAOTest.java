package com.lsw.app.product;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lsw.app.DefaultTest;
import com.lsw.app.util.Pager;

public class ProductDAOTest extends DefaultTest {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void pageTest() throws Exception{
		long perPage = 10L;
		long totalCount = 125;
		long totalPage = totalCount/perPage;
		if(totalCount%perPage>0) {
			totalPage++;
		}
		System.out.println(totalPage);
	}
	

	
	
	
	
//	@Test
//	public void addTest() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//		for(int i=0; i<100; i++) {
//			productDTO.setItem_name("자유입출금" + i);
//			productDTO.setItem_detail("상세설명" + i);
//			double r = ((int)(Math.random()*1000))/100.0;
//			productDTO.setItem_rate(r);
//			productDAO.add(productDTO);	
//			Thread.sleep(500);
//		}
//		System.out.println("finish");
//	}
//	
//	
//	
//	@Test
//	public void getDetailTest() throws Exception {
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setItem_id(82);
//		productDTO = productDAO.getDetail(productDTO);
//		//단정문
//		assertNotNull(productDTO);
//		
//	}
	
	
	
	
	
}
