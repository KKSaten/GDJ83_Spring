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

	<div class="container ms-2 mt-3">
		<div class="row col-md-5">
			<form action="./update" method="post">

				<input type="hidden" name="item_id"
					value="${dto.item_id}">

				<div class="mb-3">
					<label for="item_name" class="form-label">상품 이름</label> <input
						type="text" value="${dto.item_name}" class="form-control"
						id="item_name" name="item_name">
				</div>
				<div class="mb-3">
					<label for="item_detail" class="form-label">상품 설명</label> <input
						type="text" value="${dto.item_detail}" class="form-control"
						id="item_detail" name="item_detail">
				</div>
				<div class="mb-3">
					<label for="item_rate" class="form-label">이자율</label> <input
						type="text" value="${dto.item_rate}" class="form-control"
						id="item_rate" name="item_rate">
				</div>

				<button type="submit" class="btn btn-primary">수정</button>
				
			</form>
		</div>
	</div>







	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>