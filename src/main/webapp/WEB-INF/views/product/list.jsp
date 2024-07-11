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
					<th>상품 번호</th>
					<th>상품 이름</th>
					<th>이자율</th>
				</tr>
			</thead>

			<tbody class="table-group-divider">
				<c:forEach items="${map.list}" var="dto">
					<tr>
						<td>${dto.item_id}</td>
						<td><a href="./detail?item_id=${dto.item_id}">${dto.item_name}</a></td>
						<td>${dto.item_rate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div>
			<a href="./add" class="btn btn-primary">상품 추가</a>
		</div>

		<div class="container col-md-5 mt-5 justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item ${map.pre?'':'disabled'}">
						<a class="page-link" href="./list?page=${map.startNum - 1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>							</a>
					</li>
					<c:forEach begin="${map.startNum}" end="${map.lastNum}" step="1" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}">${i}</a></li>
					</c:forEach>
	
					<li class="page-item ${map.next?'':'disabled'}">
						<a class="page-link" href="./list?page=${map.lastNum + 1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	






	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>