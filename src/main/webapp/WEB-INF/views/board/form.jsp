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



			<div class="container justify-content-center mt-5" style="width: 50%">
				<div class="row">
					<h1>
						<c:choose>
							<c:when test="${board=='Notice'}">
								공지사항
							</c:when>
							<c:when test="${board=='Qna'}">
								QnA
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</h1>

					<form method="post" enctype="multipart/form-data">
						<!-- action은 생략이 가능한데 생략시 현재주소가 url로 들어감 -->

						<%-- <input type="hidden" value="${dto.boardNum}" name="boardNum"> --%>

						<div class="mb-3">
							<label for="boardWriter" class="form-label">작성자</label> <input
								type="text" class="form-control" id="boardWriter"
								name="boardWriter" value="${member.member_id}"
								readonly="readonly">
						</div>

						<div class="mb-3">
							<label for="boardTitle" class="form-label">글제목</label> <input
								type="text" class="form-control" id="boardTitle"
								name="boardTitle" value="${dto.boardTitle}">
						</div>
						<div class="mb-3">
							<label for="boardContents" class="form-label">글내용</label>
							<textarea class="form-control" id="boardContents"
								name="boardContents">${dto.boardContents}</textarea>
						</div>
						
						
						<div>
                        	<button type="button" class="btn btn-outline-primary" id="add_btn">첨부파일추가</button>
                        	
                        	<div id="result">
                        	</div>
                        </div>
						

						<div class="d-grid gap-2 d-md-flex justify-content-end">
							<button type="submit" class="btn btn-secondary">등록</button>
						</div>

					</form>
				</div>
			</div>










			<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>
	</div>
	
	
	<script type="text/javascript" src="/resources/js/commons/files.js"></script>
	<script type="text/javascript">
		setMax(5);
	</script>

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>