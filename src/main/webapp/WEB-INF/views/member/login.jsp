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
			<div id="layoutAuthentication_content">
				<main>
					<div class="container">
						<div class="row justify-content-center">
							<div class="col-lg-5">
								<div class="card shadow-lg border-0 rounded-lg mt-5">
									<div class="card-header">
										<h3 class="text-center font-weight-light my-4">로그인</h3>
									</div>
									<div class="card-body">
										<form action="./login" method="post">
											<div class="form-floating mb-3">
												<input class="form-control" id="member_id"
												type="text" placeholder="ID" name="member_id" value="${id}"/>
												<label for="member_id" >ID</label>
											</div>
											<div class="form-floating mb-3">
												<input class="form-control" id="member_pw"
												type="password" placeholder="Password" name="member_pw"/>
												<label for="member_pw">Password</label>
											</div>
											<div class="form-check mb-3">
												<input class="form-check-input" id="inputRememberID"
													type="checkbox" value="" name="remember" checked/>
												<label class="form-check-label" for="inputRememberID">ID 기억하기</label>
											</div>
											<div class="row mb-2 mt-4 mx-0 px-0">
												<button type="submit" class="btn btn-primary">로그인</button>
											</div>
										</form>
									</div>
									<div class="card-footer text-center py-3">
										<div class="small">
											<a href="/member/join">회원가입</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</main>
			</div>
			
			
			
			
			
		
		<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
		</div>
	</div>

	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>