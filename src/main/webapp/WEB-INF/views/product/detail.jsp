<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습용 웹페이지</title>
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
			<h1 class="masthead-heading text-uppercase mb-0">
				-${dto.item_name}-
</h1>
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

	<!-- About Section-->

	<section class="page-section portfolio" id="portfolio">

		<div class="container">
			<!-- Portfolio Section Heading-->

			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<div class="container col-md-5 mt-4 justify-content-center">
			
			

			<div class="page-section-heading text-center text-uppercase text-secondary mb-0" >
			
			<h3>${dto.item_name} </h3>
			</div>
			<div class="divider-custom">
			
				<table class="table table-hover"
					style="text-align: center; margin-top: 30px; width: 70%;">
					<thead
						class="page-section-heading text-center text-uppercase text-secondary mb-0"
						style="font-size: 1.5rem;">
						<tr>
							<th scope="col">상품 번호</th>
							<th scope="col">상품 이름</th>
							<th scope="col">이자율</th>
						</tr>
					</thead>
					<tbody
						class="page-section-heading text-center text-uppercase text-secondary mb-0"
						style="font-size: 1rem;">
						
							<tbody>
								<tr>
									<td>${dto.item_id}</td>
									<td>${dto.item_detail}</td>
									<td>${dto.item_rate}</td>
								</tr>
							</tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="d-grid gap-2 d-md-flex">
			<button type = "submit" class="btn btn-primary" onclick="location.href ='./update?item_id=${dto.item_id}' ">상품 수정</button>
			<form action="./delete" method="post">
				<input type="hidden" value="${dto.item_id}" name="item_id">
				<button type="submit" class="btn btn-danger">상품 삭제</button>
			</form>
		</div>
		<div>
			<c:forEach items="${dto.fileDTOs}" var="f">
				<a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
			</c:forEach>
		</div>
	</div>
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>