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
	<div class="container">
		<div class="row justify-content-center">

			<table class="table table-striped table-hover"
				style="text-align: center; margin-top: 30px; width: 70%;">
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
				<tbody>
					<tr>
						<td>${requestScope.dto.board_num}</td>
						<td>${requestScope.dto.board_title}</td>
						<td>${requestScope.dto.board_writer}</td>
						<td>${requestScope.dto.create_date}</td>
						<td>${requestScope.dto.board_hit}</td>
					</tr>


				</tbody>
			</table>
			<table class="table table-striped table-hover"
				style="text-align: center; margin-top: 30px; width: 70%;">
				<thead>
					<tr>
						<th scope="col">내용</th>
					</tr>
				</thead>
				<tbody>
				<tbody>
					<tr>
						<td>${requestScope.dto.board_contents}</td>
					</tr>


				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-end"
				style="margin-top: 30px; width: 65%;">

				<button type="button"
					onclick="location.href='./update?board_num=${dto.board_num}'"
					class="btn btn-secondary me-md-2">게시글 수정</button>

				<form action="./delete?board_num=${dto.board_num}" method="post">
					<button type="submit" class="btn btn-danger  ">게시글 삭제</button>
				</form>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>