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

	<form action="./join" method="post">
		<div class="container col-md-3 ms-2 mt-3">

			<div class="mb-3">
				<label for="member_id" class="form-label">아이디</label>
				<input type="text" class="form-control" id="member_id"
				name="member_id" placeholder="ID">
			</div>

			<div class="mb-3">
				<label for="member_pw" class="form-label">비밀번호</label>
				<input type="password" class="form-control" id="member_pw"
				name="member_pw" placeholder="Password">
			</div>

			<div class="mb-3">
				<label for="member_name" class="form-label">이름</label>
				<input type="text" class="form-control" id="member_name"
				name="member_name" placeholder="Name">
			</div>

			<div class="mb-3">
				<label for="member_phone" class="form-label">전화번호</label>
				<input type="text" class="form-control" id="member_phone"
				name="member_phone" placeholder="Phone Number">
			</div>

			<div class="mb-3">
				<label for="member_email" class="form-label">이메일 주소</label>
				<input type="email" class="form-control" id="member_email"
				name="member_email" placeholder="email@example.com">
			</div>


			<button type="submit" class="btn btn-primary">회원가입</button>
			
		</div>
	</form>







	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>