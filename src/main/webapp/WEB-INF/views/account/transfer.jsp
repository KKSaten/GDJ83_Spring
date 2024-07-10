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
	
	<form action="./transfer" method="post">
		<div class="container col-md-3 mt-5 justify-content-center">
			
			<input type="hidden" name="bank_id"
			value="${dto.bank_id}">
			
			<div class="mb-3">
				<label for="bank_id" class="form-label">출금하실 계좌</label>
				<input class="form-control" id="bank_id" type="text"
				value="${dto.bank_id}" disabled>
			</div>
		
			<div class="mb-3">
				<label for="account_u" class="form-label">입금하실 계좌번호</label>
				<input type="text" class="form-control" id="account_u"
				name="account_u">
			</div>
			
			<div class="mb-3">
				<label for="difference" class="form-label">입금하실 금액</label>
				<input type="text" class="form-control" id="difference"
				name="difference">
			</div>
			
			<div class="mb-3">
				<label for="bank_pw" class="form-label">이체 비밀번호</label>
				<input type="password" class="form-control" id="bank_pw"
				name="bank_pw" placeholder="Password">
			</div>
			
			<div class="justify-content-md-end">
				<button type="submit" class="btn btn-primary">계좌 이체</button>
			</div>
		</div>
		
	</form>
	
	
	
	
	
	
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>