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

			<form action="/account/add" method="post">
				<div class="container col-md-3 mt-5 justify-content-center">

					<div class="mb-3">
						<label for="item_id" class="form-label">상품 번호</label> <input
							type="text" class="form-control" id="item_id" name="item_id"
							value="${dto.item_id}">
					</div>

					<div class="mb-3">
						<label for="bank_pw" class="form-label">이체 비밀번호</label> <input
							type="password" class="form-control" id="bank_pw" name="bank_pw"
							placeholder="Password">
					</div>

					<div class="justify-content-md-end mt-4">
						<button type="submit" class="btn btn-primary">계좌 개설</button>
					</div>

				</div>
			</form>












			<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>