<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
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
			<h1 class="masthead-heading text-uppercase mb-0">JOIN</h1>
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


	<!-- Contact Section Form-->
	<c:if test="${not empty member.memberFileDTO}">
		<img alt=""
			src="/resources/upload/members/${member.memberFileDTO.fileName}">
	</c:if>
	<c:if test="${empty member.memberFileDTO}">
		<img alt="" src="/resources/upload/members/default.png">
	</c:if>


	<c:import url="../template/footer.jsp"></c:import>
	<script type="text/javascript"
		src="../resources/js/member/memberJoinCheck.js"></script>
	<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>