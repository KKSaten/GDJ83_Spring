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
		
	
			
			<div class="container col-md-7 mt-4 justify-content-center">
		
				<form action="/product/list" method="get"
					class="row row-cols-lg-auto g-3 align-items-center justify-content-end">
					<div class="col-12">
						<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
						<select name="kind" class="form-select" id="inlineFormSelectPref">
							<option value="k1">게시글제목</option>
							<option value="k2">게시글내용</option>
							<option value="k3">작성자</option>
						</select>
					</div>
					<div class="col-12">
						<label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
						<div class="input-group">
							<input type="text" name="search" class="form-control"
								id="inlineFormInputGroupUsername" placeholder="검색어 입력">
						</div>
					</div>
					<div class="col-12">
						<button type="submit" class="btn btn-primary">Search</button>
					</div>
				</form>
		
		
				<table class="table table-hover mt-4">
					<thead class="table">
						<tr>
							<th>상품 번호</th>
							<th>상품 이름</th>
							<th>이자율</th>
						</tr>
					</thead>
					<tbody class="table-group-divider">
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.item_id}</td>
								<td><a href="./detail?item_id=${dto.item_id}">${dto.item_name}</a></td>
								<td>${dto.item_rate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		
				<div class="d-grid gap-2 d-md-flex justify-content-end">
					<a href="./add" class="btn btn-primary">상품 추가</a>
				</div>
		
				<div class="container col-md-4 mt-5 justify-content-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item ${pager.pre?'':'disabled'}"><a
								class="page-link"
								href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
								var="i">
								<li class="page-item ${pager.page==i?'active':''}"><a class="page-link"
									href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
							</c:forEach>
		
							<li class="page-item ${pager.next?'':'disabled'}"><a
								class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
				
			</div>
		
		
		
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>	
	</div>
	
 <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>