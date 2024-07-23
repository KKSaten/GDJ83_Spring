<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c태그 사용 -->
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div id="layoutSidenav">
		<c:import url="/WEB-INF/views/sample/sideBar.jsp"></c:import>
		<div id="layoutSidenav_content">
			
			
			
			
			<div class="container col-md-5 mt-5 justify-content-center">
				<table class="table">
					<thead>
						<tr>
							<td></td>
							<th>${dto.item_name} 상세 정보</th>
						</tr>
					</thead>
					
					<tbody class= "table-group-divider">
						<tr>
							<th>상품 번호</th>
							<td colspan="2">${dto.item_id}</td>
							<td rowspan="3" style="width:160px; height:160px;" align="center" valign="middle">
								<img width=100% height=100% alt=""
									src="/resources/upload/products/item_icon.png">
							</td>
						</tr>
						<tr>
							<th>상품 설명</th>
							<td colspan="2">${dto.item_detail}</td>
						</tr>
						<tr>
							<th>이자율</th>
							<td colspan="2">${dto.item_rate}</td>
						</tr>
					</tbody>
				</table>
				
				<div>
					<h5>첨부파일</h5>
					<c:forEach items="${dto.fileDTOs}" var="f">
						<a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
					</c:forEach>
				</div>
				
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
					<button type = "submit" class="btn btn-primary" onclick="location.href ='/account/add?item_id=${dto.item_id}' ">계좌 개설</button>
				</div>
				
				
				<div class="d-grid gap-2 d-md-flex">
					<button type = "submit" class="btn btn-primary" onclick="location.href ='./update?item_id=${dto.item_id}' ">상품 수정</button>
					<form action="./delete" method="post">
						<input type="hidden" value="${dto.item_id}" name="item_id">
						<button type="submit" class="btn btn-danger">상품 삭제</button>
					</form>
				</div>
				
			</div>
			
			
			
			
			
			
			
			
			
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>