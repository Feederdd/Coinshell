<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../NavBar/CoinShellNavBar.jsp" />

			<head>
				<meta charset="UTF-8">
				<title>About Us | CoinShell</title>
				<link rel="stylesheet" href="${contextRoot}/css/aboutsidebar.css">
			</head>

			<body>

				<!-- side bar 側邊欄位 -->
				<div class="sidebar">
					<a href="${contextRoot}/aboutUs/intro">About Our Team</a> <a
						href="${contextRoot}/account/cookie">Cookie Policy</a> <a
						href="${contextRoot}/account/privacy">Privacy Policy</a> 
				</div>

				<!--Page content-->
				<div class="container" style="margin-top: 30px; background-color: #fff; border-radius: 30px;">
					<div class="col-9">
						<h3>About Coinshell</h3>
						<div>Coinshell is a price-tracking website for cryptoassets in
							the rapidly growing cryptocurrency space. Its mission is to make
							crypto discoverable and efficient globally by empowering retail
							users with unbiased, high quality and accurate information for
							drawing their own informed conclusions.</div>
						<h5>Our team:</h5>
						<ul>
							<li>Chief executive officer: Pieterzite Crystal</li>
							<li>Chief technology officer: Huginn Hoxton</li>
							<li>Chief information officer: Fenrir Feeder</li>
							<li>Chief financial officer: Bjarki Bear</li>
							<li>Chief security officer: Sváfnir Celine</li>
						</ul>
						<div>
							<canvas id="myChart" style="width:100%;max-width:600px"></canvas>
						</div>
					</div>
				</div>

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
				      display: true,
				      text: "Founder of the Coinshell Team"
				    }
				  }
				});
				</script>

			</body>