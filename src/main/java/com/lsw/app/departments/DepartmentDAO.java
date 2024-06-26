package com.lsw.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lsw.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	//DI, IOC
	@Autowired
	private DBConnection dbConnection;

	public List<DepartmentDTO> getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);
		
		
		//SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
		
		
		//미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// ?값 세팅

		//최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			
			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			
			ar.add(departmentDTO);
		}
		
		//자원 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	
	
	public DepartmentDTO getDetail(int num) throws Exception{
		//1. DB접속
		Connection con = dbConnection.getConnection();
		
		//2. Sql문 작성  //DBeaver에서 하던 행동 똑같은 순으로 하는 것
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID =?";
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 처리
		// ? 순서대로 처리
		//미리 보낸 것이 st고 DEPARTMENT_ID=?에서 아이디가 int니까
		st.setInt(1, num); // ?가 하나니까 인덱스번호 1번
		
		
		//5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentDTO = null;
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();	
//			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_id(rs.getInt(1)); //칼럼명 대신 인덱스 번호로도 가능, 대신 DB에서 select로 나온 칼럼 순서에 맞춰서
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
//			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			departmentDTO.setLocation_id(rs.getInt(4));
		}
		
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return departmentDTO;
		
	}
	
	
	//add
	public int add(DepartmentDTO departmentDTO) throws Exception{
		//1. DB 연결
		Connection con = dbConnection.getConnection();
		
		//2. sql문 작성
		String sql = "INSERT INTO DEPARTMENTS "
				+ "VALUES(DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)"; //받아와야하니까 일단 ? 
		
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 처리
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		
		//5. 최종 전송 및 결과 처리
		int result = st.executeUpdate();
		//add()는 getDetail처럼 db에서 값을 받아오는게 아니라 db에 적재하고 나면 끝이라
		//ResultSet과 executeQuery()가 아님
		
		//6. 자원 해제
		st.close();
		con.close();
		
		return result;
	}
	
	
	//delete
	public int delete(DepartmentDTO departmentDTO) throws Exception{
		
		Connection con = dbConnection.getConnection();
		
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
		
	}
	
	
	
	//update
	public int update(DepartmentDTO departmentDTO) throws Exception {
		
		Connection con = dbConnection.getConnection();
		
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=? "
				+ "WHERE DEPARTMENT_ID=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		
		return result;
	}
	
	
}
