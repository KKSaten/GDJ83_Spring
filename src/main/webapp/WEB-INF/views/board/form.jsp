<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body id="page-top">

	<c:import url="../template/nav.jsp"></c:import>
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5"
				src="/resources/assets/img/avataaars.svg" alt="..." />
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">reply</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Graphic
				Artist - Web Designer - Illustrator</p>
		</div>
	</header>
	<div class="row justify-content-center">
		<div class="col-lg-6 col-xl-6">
			<form method="post" enctype="multipart/form-data">
				<!-- action은 생략이 가능한데 생략시 현재주소가 url로 들어감 -->

				<input type="hidden" value="${dto.boardNum}" name="boardNum">

				<div class="form-floating mb-3">
					<input class="form-control" id="boardWriter" name="boardWriter"	type="text" placeholder="Enter your boardWriter..."	data-sb-validations="required" /> 
						<label for="boardWriter">작성자</label>
					<div class="invalid-feedback"data-sb-feedback="boardWriter:required">A boardWriter is required.</div>
				</div>

				<div class="form-floating mb-3">
					<input class="form-control" id="boardTitle" name="boardTitle" type="text" placeholder="Enter your boardTitle..."data-sb-validations="required" /> 
						<label for="boardTitle">글제목</label>
					<div class="invalid-feedback"data-sb-feedback="boardTitle:required">A boardTitle is	required.</div>
				</div>

				<div class="form-floating mb-3">
					<input class="form-control" id="boardContents" name="boardContents"	type="text" placeholder="Enter your boardContents..."data-sb-validations="required" /> 
						<label for="boardContents">글내용</label>
					<div class="invalid-feedback" data-sb-feedback="boardContents:required">A boardTitle is	required.</div>
				</div>
				
				<div>
                	<button type="button" class="btn btn-outline-primary"
                	id="add">첨부파일추가</button>
                	<div id="result"></div>
                </div>

				<button type="submit" class="btn btn-primary btn-l" style="margin-left: 700px;margin-bottom: 20px; ">Send</button>
			</form>
		</div>
	</div>
	
	
	
	
	
	<script type="text/javascript" src="/resources/js/commons/files.js"></script>
	<script type="text/javascript">
		setMax(5);
	</script>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>