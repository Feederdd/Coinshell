<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

				<!DOCTYPE html>
				<html lang="en">

				<head>
					<meta charset="UTF-8">

					<!--響應式網站-->
					<meta name="viewport" content="width=device-width, initial-scale=1.0">

					<!-- Bootstrap CSS -->
					<link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">

					<!-- 這裡放title Logo -->
					<link rel="icon" href="${contextRoot}/images/NavBarImg/icon.png" type="image/x-icon">
					<!-- =導覽列 效果 -->
					<link rel="stylesheet" href="${contextRoot}/css/navBar.css">
					<!-- FONT AWESOME: Place your kit's code here -->
					<script src="https://kit.fontawesome.com/0ef2a35b44.js" crossorigin="anonymous"></script>

					<!--Only for this login modal's CSS 連結-->
					<link rel="stylesheet" href="${contextRoot}/css/loginStyle.css">
					<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">

					<!--reCAPTCHA v2 代碼-->
					<script src="https://www.google.com/recaptcha/api.js"></script>
					
					<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
					<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
					<script src="${contextRoot}/javascripts/bootstrap.bundle.min.js"></script>
					
				</head>

				<body>
					<!-- Start of the nv-->
					<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
						<a class="navbar-brand" href="${contextRoot}"><img
								src="${contextRoot}/images/NavBarImg/CoinShell.png" style="width: 150px;"
								alt="logo"></a>
						<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
							aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						
		<!-- 導覽列 -->
		
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="${contextRoot}/aboutUs/nice-intro" style="color: #3C3C3C">About-Us
						<span class="sr-only">(current)</span></a></li>

				<li class="nav-item active"><a class="nav-link"	href="${contextRoot}/viewAllArticle" style="color: #3C3C3C">BeachTown
						<span class="sr-only">(current)</span></a></li>

<!-- 				<li class="nav-item"><a class="nav-link" href="#" style="color: #3C3C3C">Learn </a></li> -->

				<li class="nav-item active"><a class="nav-link" href="${contextRoot}/shop/myshell" style="color: #3C3C3C">Shop
						<span class="sr-only">(current)</span></a></li>

				<li id="backend" class="nav-item active"><a class="nav-link" href="${contextRoot}/administrator"
					style="color: #3C3C3C">Backend-Administrator </a></li>
			</ul>
		</div>

                        <!-- Button trigger modal  -->
                        <c:choose>
                            <c:when test="${login == null }">
                                <div>
                                    <a href="#" type="button" class="btn btn-primary mr-2" data-toggle="modal" data-target="#loginModal"> <i class="fa-solid fa-anchor"></i> Log In
                                    </a>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="btn-group">
                                    <button type="button" class="btn btn-primary dropdown-toggle mr-2" data-toggle="dropdown" aria-expanded="false">
										${login.eMail}'s Settings
									</button>

									<div class="dropdown-menu dropdown-menu-right">
<!-- 										<button class="dropdown-item" type="button">Watchlist</button> -->
<!-- 										<button class="dropdown-item" type="button">Portfolio</button> -->
										<button class="dropdown-item" type="button"><a href="/coinshell/account/set">Account Settings</a></button>
										<button class="dropdown-item" type="button"><a href="${contextRoot}/logout">Log Out</a></button> <!-- MemController line 110 -->
									</div>
								</div>
							</c:otherwise>
						</c:choose>

						<!--Search navbar-->
<%-- 						<form class="form-inline my-1 my-lg-0"> --%>
<!-- 							<div class="input-group"> -->
<!-- 								<input class="form-control pl-2 p-0" type="search" placeholder="Search" -->
<!-- 									aria-label="Search"> -->
<!-- 								<div class="input-group-append"> -->
<!-- 									<button class="btn btn-secondary input-group-append" type="submit"> -->
<!-- 										<i class="fa-solid fa-magnifying-glass"></i> -->
<!-- 									</button> -->
<!--                                 </div> -->
<!--                             </div> -->
<%--                         </form> --%>
                    </nav>
                    <!-- End of the Navbar -->


                    <!-- Modal -->
                    <div class="modal fade text-left" id="loginModal" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                        <div role="document" class="modal-dialog">
                            <div class="modal-content">
                                <!--Header-->
                                <div class="modal-header row d-flex justify-content-between mx-1 mx-sm-6 mb-0 pb-0 border-0">
                                    <div class="tabs active" id="tab01">
                                        <h6 class="font-weight-bold">Log In</h6>
                                    </div>
                                    <div class="tabs" id="tab02">
                                        <h6 class="text-muted">Sign Up</h6>
                                    </div>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
                                </div>
                                <div class="line"></div>
                                <!--Body-->
                                <div class="modal-body">
                                    <!--tab01 對應的 Log In 頁籤-->
                                    <fieldset class="show" id="tab011">
                                        <!--登入表單-->
                                        <form action="/coinshell/login" method="post">
                                            <!--E-Mail-->
                                            <div class="form-group input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-user-circle"></i>
                                                    </div>
                                                </div>
                                                <input type="email" name="eMail" class="account form-control" placeholder="E-mail" />
                                            </div>
                                            <!--Password-->
                                            <div class="form-floating form-group input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fa-solid fa-lock"></i>
                                                    </div>
                                                </div>
                                                <input type="password" name="password" class="password form-control" placeholder="Password" id="floatingPassword1" />
                                                <div class="input-group-append">
                                                    <span class="input-group-text"> <i id="eye1" class="fas fa-eye"></i>
													</span>
                                                </div>
                                            </div>

                                            <a href="#" style="display: block; text-align: right;">Forgot
												password?</a>
                                            <!--Checkbox-->
                                            <div class="form-group">
                                                <input type="checkbox" class="remember-me">Remember me
                                            </div>
                                            <p>${loginError}</p>
                                            <!--Submit btn-->
                                            <button type="submit" class="btn btn-info">
												<i class="fa-solid fa-anchor"></i> Log In
											</button>
                                        </form>
                                    </fieldset>
                                    <!--tab02 對應的 Sign Up 頁籤-->
                                    <fieldset id="tab021">
                                        <p>Gain access to additional features such as Watchlist and Portfolio tracking.</p>
                                        <!--註冊表單-->
                                        <form method="post" action="/coinshell/signup">
                                            <!--E-Mail-->
                                            <div class="form-group input-group">
                                                <div class="input-group-prepend">
                                                    <div class="input-group-text">
                                                        <i class="fas fa-user-circle"></i>
                                                    </div>
                                                </div>
                                                <input type="email" required name="e-mail" class="account form-control" placeholder="E-mail" />
                                            </div>
                                            <!--Password-->
                                            <div class="form-group form-floating">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fa-solid fa-lock"></i>
                                                        </div>
                                                    </div>
                                                    <input type="password" required name="password" class="password form-control" placeholder="Password" id="floatingPassword2" 
                                                    pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" title="Password should contain both letter and number, with min length of 8 characters." />
                                                    <div class="input-group-append">
                                                        <span class="input-group-text"> <i id="eye2"
																class="fas fa-eye"></i>
														</span>

                                                    </div>
                                                </div>
                                                <div id="pmessage">
                                                    <p><i class="fa-solid fa-triangle-exclamation"></i> Password should contain both letter and number, with minimum length of 8 characters.</p>
                                                    <p id="letter" class="invalid"> A lowercase letter</p>
                                                    <p id="number" class="invalid"> A number</p>
                                                    <p id="length" class="invalid"> Minimum 8 characters</p>
                                                </div>

                                            </div>

                                            <!--Checkbox-->
                                            <div class="form-group">
                                                <input type="checkbox" class="dailyshell">Get a daily post of CoinShell, right to your inbox!
                                            </div>
                                            <!--reCAPTCHA v2-->
                                            <!-- <div class="g-recaptcha" -->
                                            <!-- data-sitekey="6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhIxxxxxxx"></div> -->

                                            <!--Submit btn-->
                                            <button type="submit" class="btn btn-info">
												<i class="fa-solid fa-anchor"></i> Create an account
											</button>
										</form>
									</fieldset>
								</div>
								<div class="line"></div>
								<!--Footer-->
								<div class="modal-footer">
									<div class="tnc-div">
										By creating this account, you agree to our <a
											href="${contextRoot}/account/privacy">privacy policy</a> and <a
											href="${contextRoot}/account/cookie">cookie policy</a>.
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>


					<script>
					var memId = '${login.id}';
					
					$(function run() {
						if(memId != '1' && memId != '2' && memId != '3' && memId != '4' && memId != '5'){
							console.log("成功??");
						$("#backend").hide();
							}
						})
					
						//Password 顯示密碼
						$(document).ready(function () {
							$("#eye1").click(function () {
								if ($(this).hasClass('fa-eye')) {
									$("#floatingPassword1").attr('type', 'text');
								} else {
									$("#floatingPassword1").attr('type', 'password');
								}
								$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
							});
						});

						$(document).ready(function () {
							$("#eye2").click(function () {
								if ($(this).hasClass('fa-eye')) {
									$("#floatingPassword2").attr('type', 'text');
								} else {
									$("#floatingPassword2").attr('type', 'password');
								}
								$(this).toggleClass('fa-eye').toggleClass('fa-eye-slash');
							});
						});

						//Multiple Tabs in a Modal
						$(document).ready(function () {

							$(".tabs").click(function () {

								$(".tabs").removeClass("active");
								$(".tabs h6").removeClass("font-weight-bold");
								$(".tabs h6").addClass("text-muted");
								$(this).children("h6").removeClass("text-muted");
								$(this).children("h6").addClass("font-weight-bold");
								$(this).addClass("active");

								current_fs = $(".active");

								next_fs = $(this).attr('id');
								next_fs = "#" + next_fs + "1";

								$("fieldset").removeClass("show");
								$(next_fs).addClass("show");

								current_fs.animate({}, {
									step: function () {
										current_fs.css({
											'display': 'none',
											'position': 'relative'
										});
										next_fs.css({
											'display': 'block'
										});
									}
								});
							});

						});

						// password validationa form
						var myInput = document.getElementById("floatingPassword2");
						var letter = document.getElementById("letter");
						var number = document.getElementById("number");
						var length = document.getElementById("length");

						// When the user clicks on the password field, show the message box
						myInput.onfocus = function () {
							document.getElementById("pmessage").style.display = "block";
						}

						// // When the user clicks outside of the password field, hide the message box
						// myInput.onblur = function () {
						// 	document.getElementById("pmessage").style.display = "none";
						// }

						// When the user starts to type something inside the password field
						myInput.onkeyup = function () {
							// Validate lowercase letters
							var lowerCaseLetters = /[a-z]/g;
							if (myInput.value.match(lowerCaseLetters)) {
								letter.classList.remove("invalid");
								letter.classList.add("valid");
							} else {
								letter.classList.remove("valid");
								letter.classList.add("invalid");
							}

							// Validate numbers
							var numbers = /[0-9]/g;
							if (myInput.value.match(numbers)) {
								number.classList.remove("invalid");
								number.classList.add("valid");
							} else {
								number.classList.remove("valid");
								number.classList.add("invalid");
							}

							// Validate length
							if (myInput.value.length >= 8) {
								length.classList.remove("invalid");
								length.classList.add("valid");
							} else {
								length.classList.remove("valid");
								length.classList.add("invalid");
							}
						}
					</script>

				</body>

				</html>
