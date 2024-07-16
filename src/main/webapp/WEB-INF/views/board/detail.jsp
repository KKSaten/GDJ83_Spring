<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice detail</title>
<style type="text/css"></style>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>

<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container col-md-5 mt-5">
		<h1>${board}</h1>
		<div class="row justify-content-center">

			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">수정일</th>
						<th scope="col">조회수</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>${dto.boardNum}</td>
						<td>${dto.boardTitle}</td>
						<td>${dto.boardWriter}</td>
						<td>${dto.createDate}</td>
						<td>${dto.updateDate}</td>
						<td>${dto.boardHit}</td>
					</tr>
					
					<tr>
						<td colspan="6">${dto.boardContents}</td>
					</tr>

				</tbody>
			</table>


			<div class="d-grid gap-2 d-md-flex justify-content-end">
				<c:if test="${board ne 'Notice'}">
					<button type="submit"
						onclick="location.href='./reply?boardNum=${dto.boardNum}'"
						class="btn btn-outline-primary me-md-2">답글
					</button>
				</c:if>
				
				<c:if test="${member.member_id eq dto.boardWriter}">
					<button type="submit"
						onclick="location.href='./update?boardNum=${dto.boardNum}'"
						class="btn btn-primary me-md-2">글수정
					</button>
	
					<form action="./delete?boardNum=${dto.boardNum}" method="post">
						<button type="submit" class="btn btn-danger">글삭제</button>
					</form>
				</c:if>
			</div>
			
		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>