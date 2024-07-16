<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container justify-content-center mt-5" style="width: 50%">
		<div class="row">
			<h1>${board}</h1>

			<form method="post"> <!-- action은 생략이 가능한데 생략시 현재주소가 url로 들어감 -->

				<input type="hidden" value="${dto.boardNum}" name="boardNum">
				
				<div class="mb-3">
					<label for="boardWriter" class="form-label">작성자</label>
					<input type="text" class="form-control" id="boardWriter"
					name="boardWriter" value="${member.member_id}" readonly="readonly">
				</div>

				<div class="mb-3">
					<label for="boardTitle" class="form-label">글제목</label>
					<input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${dto.boardTitle}">
				</div>
				<div class="mb-3">
					<label for="boardContents" class="form-label">글내용</label>
					<textarea class="form-control" id="boardContents" name="boardContents">${dto.boardContents}</textarea>
				</div>


				<div class="d-grid gap-2 d-md-flex justify-content-end">
					<button type="submit" class="btn btn-secondary">등록</button>
				</div>

			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>