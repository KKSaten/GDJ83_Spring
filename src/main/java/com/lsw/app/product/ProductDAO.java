package com.lsw.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<ProductDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		
		//SQL
		String sql = "SELECT * FROM ITEMS ORDER BY ITEM_ID ASC";
		
		//미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//?처리

		//최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			int item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name");
			String item_detail = rs.getString("item_detail");
			double item_rate = rs.getDouble("item_rate");
			
			productDTO.setItem_id(item_id);
			productDTO.setItem_name(item_name);
			productDTO.setItem_detail(item_detail);
			productDTO.setItem_rate(item_rate);
			
			ar.add(productDTO);
		}
		
		//자원해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
	
	
	public ProductDTO getDetail(int num) throws Exception {
		
		Connection con = dbConnection.getConnection();
		
		//SQL
		String sql = "SELECT * FROM ITEMS WHERE ITEM_ID=? ORDER BY ITEM_ID ASC";
		
		//미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//?처리
		st.setInt(1, num);
		
		//최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		ProductDTO productDTO = null;
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setItem_id(rs.getInt("ITEM_ID"));
			productDTO.setItem_name(rs.getString("ITEM_NAME"));
			productDTO.setItem_detail(rs.getString("ITEM_DETAIL"));
			productDTO.setItem_rate(rs.getDouble("ITEM_RATE"));
		}
		
		//자원 해제
		rs.close();
		st.close();
		con.close();
		
		return productDTO;
	}
	
	
	
	public void add() throws Exception {
		//연결
		Connection con = dbConnection.getConnection();
		
		//sql
		String sql = "INSERT INTO ITEMS VALUES(ITEM_ID_SEQ.NEXTVAL, ?, ?, ?)";
		
		//미리 전송
		PreparedStatement st = con.pre
		
	}
	
	
	

}
