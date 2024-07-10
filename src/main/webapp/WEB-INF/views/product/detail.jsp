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
	
	<div class="container col-md-5 mt-4 justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">${dto.item_name} 상세 정보</th>
				</tr>
			</thead>
			<tbody class= "table-group-divider">
				<tr>
					<th scope="row">상품 번호</th>
					<td>${dto.item_id}</td>
				</tr>
				<tr>
					<th scope="row">상품 설명</th>
					<td>${dto.item_detail}</td>
				</tr>
				<tr>
					<th scope="row">이자율</th>
					<td>${dto.item_rate}</td>
				</tr>
			</tbody>
		</table>
		
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<button type = "submit" class="btn btn-primary" onclick="location.href ='/account/add?item_id=${dto.item_id}' ">계좌 개설</button>
		</div>
		
		
		<div class="d-grid gap-2 d-md-flex">
			<button type = "submit" class="btn btn-primary" onclick="location.href ='./update?item_id=${dto.item_id}' ">상품 수정</button>
			<form action="./delete" method="post">
				<button type="submit" class="btn btn-danger">상품 삭제</button>
			</form>
		</div>
		
		

		
		
	</div>
	
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>