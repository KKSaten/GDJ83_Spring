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
					<c:forEach items="${map.list}" var="notice"> 
						<tbody>
							<tr>
							<td>${notice.board_num}</td>
								<td><a href="./detail?board_num=${notice.board_num}">${notice.board_title}</a></td>
								<td>${notice.board_writer}</td> 
								<td>${notice.create_date}</td> 
								<td>${notice.board_hit}</td> 
							</tr>
					</c:forEach> 

				</tbody>
			</table>
			<div class="d-grid gap-2 d-md-flex justify-content-end">
				<a href="./write" class="btn btn-primary"
					style="margin: 30px; margin-right: 185px;">글쓰기</a>
			</div>


		
			<form action="/notice/list" method="get" style=" width: 50%;" class="row row-cols-lg-auto g-3 align-items-center justify-content-center">
					<div class="col-12" >
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
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>