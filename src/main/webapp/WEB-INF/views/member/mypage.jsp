<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BANK - 내정보</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<div class="container col-md-6 mt-4 justify-content-center">
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
				</tr>
			</thead>
			
			<tbody class="table-group-divider">
				<tr>
					<td>${member.member_id}</td>
					<td>${member.member_name}</td>
					<td>${member.member_phone}</td>
					<td>${member.member_email}</td>
				</tr>
			</tbody>
		</table>
		
		<div class="d-grid gap-2 d-md-flex justify-content-md-end">
			<button type = "submit" class="btn btn-primary"
				onclick="location.href ='./update?member_id=${member.member_id}' ">
				회원정보 수정
			</button>
			
			<form action="./delete?member_id=${member.member_id}" method="post">
				<button type="submit" class="btn btn-danger">회원 탈퇴</button>
			</form>		
		</div>
		
		<div class="mt-5">
			<table class="table">
				<thead>
					<tr>
						<th>계좌번호</th>
						<th>상품 번호</th>
						<th>계좌 개설일</th>
						<th>잔액</th>
					</tr>
				</thead>
				
				
				<tbody class="table-group-divider">
					<c:forEach items="${member.dtos}" var="ac">	
						<tr>
							<td><a href="/account/detail?bank_id=${ac.bank_id}"> ${ac.bank_id}</a></td>
							<td>${ac.item_id}</td>
							<td>${ac.open_date}</td>
							<td>${ac.balance}</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
			
			<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<button type = "submit" class="btn btn-primary"
					onclick="location.href ='/account/add?member_id=${account.member_id}' ">
					계좌 개설
				</button>
				
			</div>
		</div>
		
	</div>

	<div class="container col-md-6 mt-3 justify-content-center">
		
		
		
	</div>





	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>