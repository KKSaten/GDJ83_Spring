<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice list</title>
<style type="text/css"></style>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>

<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container col-md-6">
		<h1>${board}</h1>
		<div class="row justify-content-center">

			<form action="/notice/list" method="get"
				class="row row-cols-lg-auto g-3 align-items-center justify-content-end">
				<div class="col-12">
					<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
					<select name="kind" class="form-select" id="inlineFormSelectPref">
						<option value="title">글제목</option>
						<option value="contents">글내용</option>
						<option value="writer">작성자</option>
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

			<table class="table table-striped table-hover mt-4">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list}" var="dto">
						<tbody>
							<tr>
								<td>
									<c:if test="${dto.del eq 0}">
										${dto.boardNum}
									</c:if>
								</td>
								<td>
									<c:choose>
										<c:when test="${dto.del eq 0}">	
											<a href="./detail?boardNum=${dto.boardNum}">
												<c:catch>
													<c:forEach begin="1" end="${dto.depth}">
														&nbsp;&nbsp;
													</c:forEach>
												</c:catch>
												${dto.boardTitle}
											</a>
										</c:when>
										<c:otherwise>
											삭제된 글입니다.
										</c:otherwise>
									</c:choose>
								</td>
								<td>${dto.boardWriter}</td>
								<td>${dto.createDate}</td>
								<td>${dto.boardHit}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>

			<div class="d-grid gap-2 d-md-flex justify-content-end">
				<a href="./add" class="btn btn-primary mt-4">글쓰기</a>
			</div>

			<div class="container col-md-3 mt-5 justify-content-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item ${pager.pre?'':'disabled'}"><a
							class="page-link"
							href="./list?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
							step="1" var="i">
							<li class="page-item"><a class="page-link"
								href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
						</c:forEach>

						<li class="page-item ${pager.next?'':'disabled'}"><a
							class="page-link"
							href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>


		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>