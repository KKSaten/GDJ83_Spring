<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보 수정</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<div class="container col-md-3 mt-4 justify-content-center" >
		<form action="./update" method="post">	
			<div class="mb-3">
				<label for="member_id" class="form-label">아이디</label>
				<input class="form-control" id="disabledInput" type="text" placeholder="${member.member_id}" disabled>
				<div id="idHelp" class="form-text">ID는 변경할 수 없습니다.</div>
			</div>
			<div class="mb-3">
				<label for="member_name" class="form-label">이름</label>
				<input type="text" value="${member.member_name}" class="form-control"
					id="member_name" name="member_name">
			</div>
			<div class="mb-3">
				<label for="member_phone" class="form-label">전화번호</label>
				<input type="text" value="${member.member_phone}" class="form-control"
					id="member_phone" name="member_phone">
			</div>
			<div class="mb-3">
				<label for="member_email" class="form-label">이메일</label>
				<input type="text" value="${member.member_email}" class="form-control"
					id="member_email" name="member_email">
			</div>
			
			<button type="submit" class="btn btn-primary">수정</button>
			
		</form>
	</div>







	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>