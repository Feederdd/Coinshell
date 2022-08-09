<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="NavBar/CoinShellNavBar.jsp" />
<!DOCTYPE html>

<html>

<head>
<style type="text/css">
body{
padding-top: 82px;
}
</style>

<meta charset="UTF-8">
<title>Portfolio</title>

<link rel="Shortcut Icon" type="image/x-icon"
	href="https://cdn-icons-png.flaticon.com/512/1490/1490853.png" />
<link rel="stylesheet" href="/resources/demos/style.css">
<!--                 星星圖示導包 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link rel="stylesheet" type="text/css" href="${contextRoot}/css/indexCss.css">

</head>
<body>


<!-- 	<div class="top-coin"> -->
<!-- 		<div class="banner"> -->
<!-- 			<div class="news-banner-font">&emsp;Top Coin</div> -->
<!-- 		</div> -->

			<div id="overview">
				<table class="table table-hover" id="portfolio">
					<thead class="bg-primary">
						<tr>
							<th scope="col">Top</th>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Currency</th>
							<th scope="col">Price</th>
							<th scope="col">1h%</th>
							<th scope="col">24h%</th>
							<th scope="col">7d%</th>
							<th scope="col">30d%</th>
							<th scope="col">Volume24h</th>
							<th scope="col">Market Cap</th>
							<th scope="col">Line Chart</th>
						</tr>
					</thead>
					<tbody class="cointable">
					</tbody>
				</table>
				
	
			</div>
<!-- 		</div> -->
<script src="${contextRoot}/javascripts/indexJs.js"></script>
<script>

followList();
upjquery();

</script>

</body>
</html>