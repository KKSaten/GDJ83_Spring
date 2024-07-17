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
			<h1 class="masthead-heading text-uppercase mb-0">NoticeList</h1>
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
				<form action="/notice/list" method="get"
					class="row row-cols-lg-auto g-3 align-items-center justify-content-end">
					<div class="col-12 justify-content-center">
						<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
						<select name="kind" class="form-select" id="inlineFormSelectPref">
							<option value="k1">게시글제목</option>
							<option value="k2">게시글내용</option>
							<option value="k3">작성자</option>
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
			</div>

			<div class="divider-custom">
				<table class="table table-hover"
					style="text-align: center; margin-top: 30px; width: 70%;">
					<thead
						class="page-section-heading text-center text-uppercase text-secondary mb-0"
						style="font-size: 2rem;">
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody
						class="page-section-heading text-center text-uppercase text-secondary mb-0"
						style="font-size: 1rem;">
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

												<a href="./detail?boardNum=${dto.boardNum}"> <c:catch>
														<c:forEach begin="1" end="${dto.depth}">
												-->
											</c:forEach>
													</c:catch> ${dto.boardTitle}
												</a>
											</c:when>
											<c:otherwise>
										삭제된 게시글입니다.
									</c:otherwise>

										</c:choose></td>
									<c:choose>

										<c:when test="${dto.del eq 0}">
											<td>${dto.boardWriter}</td>
											<td>${dto.createDate}</td>
											<td>${dto.boardHit}</td>
										</c:when>
										<c:otherwise>
											<td colspan="3" style="text-align: center;">
										</c:otherwise>
									</c:choose>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	<a href="./add" class="btn btn-primary" style="margin-left: 1000px;">글쓰기</a>	

			<div class="container col-md-2 mt-5 justify-content-center">
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
	</section>

	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>