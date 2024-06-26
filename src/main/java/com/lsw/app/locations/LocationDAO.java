package com.lsw.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.util.DBConnection;

@Repository
public class LocationDAO {
	
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<LocationDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		
		
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID ASC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
			
			ar.add(locationDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		return ar;
	}
	
	
	
	public LocationDTO getDetail(int num) throws Exception {
		//1. DB접속
		Connection con = dbConnection.getConnection();
		
		//2. sql문 작성
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 처리
		st.setInt(1, num);
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		LocationDTO locationDTO = null;
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			locationDTO.setCity(rs.getString("CITY"));
			locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
			locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));	
		}
		
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		
		return locationDTO;
		
	}
	
	public int add(LocationDTO locationDTO) throws Exception {
		
		Connection con = dbConnection.getConnection();
		
		String sql = "INSERT INTO LOCATIONS "
				+ "VALUES(LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, locationDTO.getStreet_address());
		st.setString(2, locationDTO.getPostal_code());
		st.setString(3, locationDTO.getCity());
		st.setString(4, locationDTO.getState_province());
		st.setString(5, locationDTO.getCountry_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
	

}
