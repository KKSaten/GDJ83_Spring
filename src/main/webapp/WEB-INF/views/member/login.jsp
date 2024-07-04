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

	<form action="./login" method="post">
		<div class="container col-md-3 mt-5 justify-content-center">

			<div class="mb-3">
				<label for="member_id" class="form-label">아이디</label>
				<input type="text" class="form-control" id="member_id"
				name="member_id" placeholder="ID" value="${id}">
			</div>

			<div class="mb-3">
				<label for="member_pw" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="member_pw"
				name="member_pw" placeholder="Password">
			</div>
			
			<div class="mb-3 form-check">
    			<input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
    			<label class="form-check-label" for="exampleCheck1" >ID기억하기</label>
  			</div>
			<div class="justify-content-md-end">
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
			
		</div>
	</form>







	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>