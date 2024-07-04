<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/product/list">금융상품</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">미정</a>
		</li>
		
		<c:choose>
			<c:when test="${not empty member}">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/member/mypage">내정보</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/member/logout">로그아웃</a>
				</li>
			</c:when>
			
			<c:otherwise>
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/member/login">로그인</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/member/join">회원가입</a>
				</li>
			</c:otherwise>
		</c:choose>

<%--	위랑 똑같음
		<c:if test="${empty member}">
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/login">로그인</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/join">회원가입</a>
			</li>
		</c:if>

		<c:if test="${not empty member}">
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/mypage">내정보</a>
			</li>
			<li class="nav-item">
				<a class="nav-link active" aria-current="page" href="/member/logout">로그아웃</a>
			</li>
		</c:if>
--%>


      </ul>
    </div>
  </div>
</nav>