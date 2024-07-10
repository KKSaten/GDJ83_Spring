<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	
		<div class="container col-md-6 mt-4 justify-content-center">
			<table class="table">
				<thead>
					<tr>
						<th>계좌번호</th>
						<th>상품명</th>
						<th>계좌 개설일</th>
						<th>잔액</th>
						<th>이자율</th>
					</tr>
				</thead>
				
				
				<tbody class="table-group-divider">
					<tr>
						<td>${dto.bank_id}</td>
						<td>${dto.productDTO.item_name}</td>
						<td>${dto.open_date}</td>
						<td>${dto.balance}</td>
						<td>${dto.productDTO.item_rate}</td>
					</tr>
	
				</tbody>
			</table>
			
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type = "submit" class="btn btn-primary"
					onclick="location.href ='/account/transfer?bank_id=${dto.bank_id}' ">
					계좌 이체
				</button>
			</div>
			
			
			<div class="d-grid gap-2 d-md-flex mt-5 justify-content-md-end">
				<button type = "submit" class="btn btn-primary"
					onclick="location.href ='/account/list?bank_id=${dto.bank_id}&order=0' ">
					이체 내역
				</button>
			</div>
			
			
			
			
			
		</div>	

	
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>