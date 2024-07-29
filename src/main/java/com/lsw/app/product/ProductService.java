package com.lsw.app.product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lsw.app.files.FileManager;
import com.lsw.app.member.MemberDTO;
import com.lsw.app.util.Pager;
import com.lsw.app.util.ProductCommentPager;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileManager fileManager;
	
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
	
	public int add(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {
		
		Long num = productDAO.getNum();
		
		productDTO.setItem_id(num);
		
		int result = productDAO.add(productDTO);

		if (files == null) {
			return result;
		}
		

		// 1. 저장할 폴더 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println(path);
//		File file = new File(path);
//
//		if (!file.exists()) {
//			file.mkdirs();
//		}

		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}

//			// 2. 저장할 파일명 생성
//			String fileName = UUID.randomUUID().toString();
//			fileName = fileName + "_" + f.getOriginalFilename();
//
//			// 3. HDD에 파일 저장
//			File f2 = new File(file, fileName);
//			f.transferTo(f2);
			
			String fileName = fileManager.fileSave(path, f); //위에 주석처리된 놈들 이녀석으로

			// 4. 파일정보를 DB에 저장
			// 파일명, 오리지널, 파일번호, 제품id
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFileName(fileName);
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setItem_id(num);
			result = productDAO.addFile(productFileDTO);

		}
		
		
		
		return result;
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		return productDAO.delete(productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return productDAO.update(productDTO);
	}
	
	
	public int addWish(Integer item_id, String member_id) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_id", item_id);
		map.put("member_id", member_id);

		return productDAO.addWish(map);

	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);
	}
	
	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.commentAdd(productCommentDTO);
	}
	
	public List<ProductCommentDTO> commentList(ProductCommentPager productCommentPager) throws Exception {
		productCommentPager.makeRow();
		productCommentPager.makeNum(productDAO.commentTotalCount(productCommentPager));
		
		return productDAO.commentList(productCommentPager);
	}
	
	public int commentDelete(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.commentDelete(productCommentDTO);
	}

}
