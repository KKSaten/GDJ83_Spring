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
                <img class="masthead-avatar mb-5" src="/resources/assets/img/avataaars.svg" alt="..." />
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">LOGIN</h1>
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
                      
                      <form action="./login" method="post" >
                  
                            <!-- Name input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="member_id" name= "member_id" type="text" placeholder="Enter your id..." data-sb-validations="required" />
                                <label for="member_id">ID</label>
                                <div class="invalid-feedback" data-sb-feedback="name:required">A ID is required.</div>
                            </div>
                            <!-- Email address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control" id="member_pw" type="password"  name= "member_pw" placeholder="Enter your pw..." data-sb-validations="required" />
                                <label for="member_pw">Password</label>
                                <div class="invalid-feedback" data-sb-feedback="member_pw:required">An Password is required.</div>
                            </div>
                        
                            <button class="btn btn-primary btn-xl" id="submitButton" type="submit">Send</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
               
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>