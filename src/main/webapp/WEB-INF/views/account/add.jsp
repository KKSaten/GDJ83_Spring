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
	
	
	<h3>계좌 개설 페이지</h3>
	
	<form action="/account/add" method="post">
		<div class="container col-md-3 mt-5 justify-content-center">

			<div class="mb-3">
				<label for="member_pw" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="member_pw"
				name="member_pw" placeholder="Password">
			</div>
			
		</div>
	</form>
	
	
	
	
	

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>