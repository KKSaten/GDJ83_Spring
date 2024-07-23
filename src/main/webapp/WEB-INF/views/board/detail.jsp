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
			<%-- 			<h1 class="masthead-heading text-uppercase mb-0">
				-${dto.item_name}-
</h1> --%>
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
			<div class="container col-md-8 mt-8 justify-content-center">
				<div
					class="page-section-heading text-center text-uppercase text-secondary mb-0">
					<h3>${board}</h3>
				</div>
				<div class="divider-custom">

					<table class="table table-hover"
						style="text-align: center; margin-top: 30px; width: 70%;">
						<thead
							class="page-section-heading text-center text-uppercase text-secondary mb-0"
							style="font-size: 1.5rem;">
							<tr>
								<th scope="col">번호</th>
								<th scope="col">제목</th>
								<th scope="col">작성자</th>
								<th scope="col">작성일</th>
								<th scope="col">수정일</th>
								<th scope="col">조회수</th>
							</tr>
						</thead>
						<tbody
							class="page-section-heading text-center text-uppercase text-secondary mb-0"
							style="font-size: 1rem;">
						<tbody>
							<tr>
								<td>${dto.boardNum}</td>
								<td>${dto.boardTitle}</td>
								<td>${dto.boardWriter}</td>
								<td>${dto.createDate}</td>
								<td>${dto.updateDate}</td>
								<td>${dto.boardHit}</td>
							</tr>

						</tbody>
						</tbody>
					</table>
					
					
					<div>
						<c:forEach items="${boardDTO.boardFileDTOs}" var="f">
							<a href="/resources/upload/${board}/${f.fileName}">${f.oriName}</a>
						</c:forEach>
					</div>


					<div class="d-grid gap-2 d-md-flex justify-content-end">
						<c:if test="${board ne 'Notice'}">
							<button type="submit"
								onclick="location.href='./reply?boardNum=${dto.boardNum}'"
								class="btn btn-outline-primary me-md-2"
								style="margin-left: 20px; margin-top: 180px;">답글</button>
						</c:if>


						<c:if test="${member.member_id eq dto.boardWriter}">
							<button type="submit"
								onclick="location.href='./update?boardNum=${dto.boardNum}'"
								class="btn btn-primary me-md-2">글수정</button>

							<form action="./delete?boardNum=${dto.boardNum}" method="post">
								<button type="submit" class="btn btn-danger">글삭제</button>
							</form>
						</c:if>
					</div>
				</div>
			</div>
		</div>

	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>