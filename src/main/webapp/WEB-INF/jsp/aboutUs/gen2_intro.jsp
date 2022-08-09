<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
			<jsp:include page="../NavBar/CoinShellNavBar.jsp" />

			<head>
				<meta charset="UTF-8">
				<title> About Us | Coinshell</title>
				<link rel="stylesheet" href="${contextRoot}/css/gen2introStyle.css">
				<link rel="stylesheet" type="text/css" href="${contextRoot}/css/fullpage.css" />
			</head>

			<body>
				<div id="fullpage">
					<div class="section active" id="section0">

						<div class="jumbotron col-10" style=" top: 15%; bottom: -5%; margin: 0 auto;background: rgba(255, 255, 255, 0.5); text-align: center">
							<div class="about-1">
								<h1 class="display-6">About Coin Shell </h1>
								<hr class="my-4">
								<p>Coinshell is a price-tracking website for cryptoassets in
									the rapidly growing cryptocurrency space. Its mission is to make
									crypto discoverable and efficient globally by empowering retail
									users with unbiased, high quality and accurate information for
									drawing their own informed conclusions.</p>
								<p>在區塊鏈高速發展的世界裡，Coinshell提供您最正確的加密貨幣價格追蹤功能以及最即時的一手訊息。</p>

							</div>
							<div class="about-2">
								<div class="content-box-lg">
									<div class="container">
										<div class="row">
											<div class="col-md-4">
												<div class="about-item text-center">
													<i class="fa fa-book"></i>
													<h3>MISSION 使命</h3>
													<hr>
													<p>綜合線上各虛擬貨幣平台優勢，集結成Coinshell</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="about-item text-center">
													<i class="fa fa-globe"></i>
													<h3>VISION 展望</h3>
													<hr>
													<p>成為前五大虛擬貨幣資訊平台</p>
												</div>
											</div>
											<div class="col-md-4">
												<div class="about-item text-center">
													<i class="fa fa-pencil"></i>
													<h3>ACHIEVEMENT 成果</h3>
													<hr>
													<p>價格提醒、關注幣種、新聞彙整、討論社群</p>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<footer class="text-center">
								<p>Copyright &copy; 2022 All rights reserved by Coin Shell.</p>
							</footer>
						</div>

					</div>
					<div class="section" id="section1">
						<div class="slide active">
							<div class="jumbotron col-10"
								style="top: 15%; bottom: -5%; margin: 0 auto;background: #d9e1fb; text-align: center">
								<div class="who-we-are"><h3>Who we are </h3></div>
								<span> Group one. Gruppo uno. Gruppe eins. Groupe un. Grupo um. Gruppe et.</span>
								<hr class="my-4">
								<div class="cards">
									<div class="card">
										<div class="card-img card-imgl"></div>
										<card class="card-body">
											<h3>Yiwen</h3>
											<span>Marketing officer</span>
											<p>Head of CSS/JS and customized Bootstrap </p>
										</card>
									</div>
									<div class="card">
										<div class="card-img card-img2"></div>
										<card class="card-body">
											<h3>Bear</h3>
											<span>Communications officer</span>
											<p>Head of asynchronous Javascript and XML</p>
										</card>
									</div>
									<div class="card">
										<div class="card-img card-img3"></div>
										<card class="card-body">
											<h3>Pieterzite</h3>
											<span>Executive officer</span>
											<p>Project inspiration</p>
											<p>Visual design & overall planning/operation</p>
										</card>
									</div>
									<div class="card">
										<div class="card-img card-img4"></div>
										<card class="card-body">
											<h3>Feeder</h3>
											<span>Information officer</span>
											<p>Head of News API / Marquee API analysis</p>
										</card>
									</div>
									<div class="card">
										<div class="card-img card-img5"></div>
										<card class="card-body">
											<h3>Hoxton</h3>
											<span>Technology officer</span>
											<p>Head of backend Springboot / SQL Database</p>
										</card>
									</div>
								</div>
								<div class="social-media">
									<i class="fa fa-github" style="font-size:24px"></i>
								</div>
							</div>



						</div>
						<div class="slide">
							<div class="jumbotron col-10"
								style=" top: 15%; bottom: -5%; margin: 0 auto;background: #d9e1fb">
								<div style="text-align: center;">
									<h1 class="display-6">Founder of the Coinshell Team</h1>

									<canvas id="myChart" style="width:80%; height:0%"></canvas>
								</div>
							</div>
						</div>
					</div>
					<div class="section" id="section2">

						<!-- footer  -->
						<div class="main-footer">
							<div class="container">
								<div class="footer-item">
									<h4>About Us</h4>
									<nav>
										<a href="${contextRoot}/account/freAQ"><i class="fa fa-angle-right"></i>
											FAQs</a>
										<a href="${contextRoot}/account/cookie"><i class="fa fa-angle-right"></i> 
											Cookie Policy</a>
										<a href="${contextRoot}/account/privacy"><i class="fa fa-angle-right"></i>
											Privacy Policy</a>
										<a href="mailto:arriettybenjamin@gmail.com"><i class="fa fa-angle-right"></i>
											Contact us</a>
									</nav>
								</div>
								<div class="footer-item">
									<h4>Membership</h4>
									<nav>
										<a href="/coinshell/account/set"> <i class="fa fa-angle-right"></i> Accounts</a>
										<a href="${contextRoot}/logout"><i class="fa fa-angle-right"></i> Log Out</a>
										<a href="${contextRoot}"> <i class="fa fa-angle-right"></i> Watchlist</a>
										<a href="${contextRoot}/shop/myshell"> <i
												class="fa fa-angle-right"></i> PunchList</a>
										<a href="${contextRoot}/viewAllArticle"><i class="fa fa-angle-right"></i>
											BeachTown</a>
									</nav>
								</div>
								<div class="footer-item">
									<h4>Socials</h4>
									<nav>
										<a href="https://www.facebook.com/"><i class="fa fa-angle-right"></i>
											Facebook&nbsp;<i class="fa fa-facebook"></i></a>
										<a href="https://twitter.com/"><i class="fa fa-angle-right"></i> Twitter&nbsp;<i
												class="fa fa-twitter"></i></a>
										<a href="https://www.instagram.com/"><i class="fa fa-angle-right"></i>
											Instagram&nbsp;<i class="fa fa-instagram"></i></a>
										<a href="#"><i class="fa fa-angle-right"></i> Interactive Chat&nbsp;<i
												class="fa-solid fa-comments"></i></a>
									</nav>
								</div>
								<div class="footer-item footer-subs">
									<h4>Subscribe</h4>
									<form>
										<input type="text" placeholder="${login.eMail}">
										<input type="submit" value="Subscribe">
									</form>
								</div>
							</div>
							<div class="conpyright">Coin Market &copy; Coin Shell</div>
						</div>


						<script type="text/javascript" src="${contextRoot}/javascripts/fullpage.js"></script>
						<script type="text/javascript">
							// 捲動滾輪就可以拉到下一個 section
							var myFullpage = new fullpage('#fullpage', {
								sectionsColor: ['#C0CFFA', '#3f5494', '#3e5293']
							});
						</script>
						<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
						<script>
							var xValues = ["Pieterzite", "Huginn Hoxton", "Fenrir Feeder", "Bjarki Bear", "Sváfnir"];
							var yValues = [100, 100, 100, 100, 100];
							var barColors = [
								"#ffb7c5",
								"#0e1a40",
								"#946b2d",
								"#222f5b",
								"#5d5d5d"
							];

							new Chart("myChart", {
								type: "doughnut",
								data: {
									labels: xValues,

									datasets: [{
										backgroundColor: barColors,
										data: yValues
									}]

								},
								options: {
									title: {
										display: false,
									}
								}
							});
						</script>


			</body>