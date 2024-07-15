<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice update</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	<div class="container justify-content-center col-md-4 mt-5">
		<div class="row ">

			<form action="./update" method="post">

				<div class="mb-3">
					<input type="hidden" class="form-control" id="boardNum"
						value="${dto.boardNum}" name="boardNum">
				</div>

				<div class="mb-3">
					<label for="boardWriter" class="form-label">작성자</label> <input
						type="text" class="form-control" id="boardWriter"
						name="boardWriter" value="${dto.boardWriter}" readonly="readonly">
				</div>

				<div class="mb-3">
					<label for="boardTitle" class="form-label">게시글제목</label> <input
						type="text" class="form-control" id="boardTitle" name="boardTitle"
						value="${dto.boardTitle}">
				</div>
				<div class="mb-3">
					<label for="boardContents" class="form-label">게시글내용</label>
					<textarea class="form-control" id="boardContents"
						name="boardContents">${dto.boardContents}</textarea>
				<%-- </div>
					<div class="mb-3">
					<input type="hidden" class="form-control" id="boardCategory" name="boardCategory" value="${dto.boardCategory}">
				</div> --%>


					<div class="d-grid gap-2 d-md-flex mt-4 justify-content-end">
						<button type="submit" class="btn btn-secondary">수정</button>
					</div>
			</form>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</html>