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
                <img class="masthead-avatar mb-5" src="/resources/assets/img/avataaars.svg" alt="..." />
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">add</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                <p class="masthead-subheading font-weight-light mb-0">Graphic Artist - Web Designer - Illustrator</p>
            </div>
        </header>


	   <!-- Contact Section Form-->
	    <section class="page-section" id="contact">
            <div class="container">
                <!-- Contact Section Heading-->
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Contact Section Form-->
                <div class="row justify-content-center">
                    <div class="col-lg-8 col-xl-7">
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- * * SB Forms Contact Form * *-->
                        <!-- * * * * * * * * * * * * * * *-->
                        <!-- This form is pre-integrated with SB Forms.-->
                        <!-- To make this form functional, sign up at-->
                        <!-- https://startbootstrap.com/solution/contact-forms-->
                        <!-- to get an API token!-->
                      <form action="./update" method="post">

				<input type="hidden" name="item_id"
					value="${dto.item_id}">

				<div class="mb-3">
					<label for="item_name" class="form-label">상품 이름</label> <input
						type="text" value="${dto.item_name}" class="form-control"
						id="item_name" name="item_name">
				</div>
				<div class="mb-3">
					<label for="item_detail" class="form-label">상품 설명</label> <input
						type="text" value="${dto.item_detail}" class="form-control"
						id="item_detail" name="item_detail">
				</div>
				<div class="mb-3">
					<label for="item_rate" class="form-label">이자율</label> <input
						type="text" value="${dto.item_rate}" class="form-control"
						id="item_rate" name="item_rate">
				</div>

				<button type="submit" class="btn btn-primary">수정</button>
				
			</form>
                    </div>
                </div>
            </div>
        </section>
               
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>