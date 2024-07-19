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
                <h1 class="masthead-heading text-uppercase mb-0">JOIN</h1>
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
                        <form action="./join" method="post" data-sb-form-api-token="API_TOKEN" id="frm"> 
                            <!-- Name input-->
                            
                            <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_id" name= "member_id" type="text" placeholder="Enter your id..." data-sb-validations="required" />
                                <label for="member_id">ID</label>
                                <div class="text-danger" id="id_error" > </div>
                            </div>
                            
                            <!-- password address input-->
                            <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_pw" type="password"  placeholder="Enter your pw..." data-sb-validations="required" />
                                <label for="member_pw">Password</label>
                                <div class="text-danger" id="password_error"  style="font-weight: bold;"> </div>
                            </div>
                               <!-- password address input-->
                               <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_pw_ck" type="password"  name= "member_pw" placeholder="Enter your pw..." data-sb-validations="required" />
                                <label for="member_pw">Password 확인</label>
                                <div class="text-danger" id="password_eqError" style="font-weight: bold;" > </div>
                            </div>

                            <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_name" type="text"  name= "member_name" data-sb-validations="required" placeholder="Enter your name..."/>
                                <label for="member_name">Name</label>
                                <div class="invalid-feedback" data-sb-feedback="member_name:required">An Name is required.</div>
                            </div>
                            <!-- Phone number input-->
                            <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_phone"  name ="member_phone" type="tel" placeholder="(123) 456-7890" data-sb-validations="required" />
                                <label for="member_phone">Phone number</label>
                                <div class="invalid-feedback" data-sb-feedback="member_phone:required">A phone number is required.</div>
                            </div>
                            
                            <div class="form-floating mb-3">
                                <input class="form-control ch" id="member_email" type="email" name ="member_email"placeholder="name@example.com" data-sb-validations="required,email" />
                                <label for="member_email">Email address</label>
                                <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                            </div>                        
                                <button class="btn btn-primary btn-l" id="add" type="button" style="margin-bottom: 10px;">파일추가</button>
                                <div id="result">


                              
                                 </div>
                            <button class="btn btn-primary btn-l" id="joinBtn" type="button">join</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
               
	<c:import url="../template/footer.jsp"></c:import>
	<script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
    <script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>