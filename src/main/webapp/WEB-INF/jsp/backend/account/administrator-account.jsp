<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

<head>
<meta charset="UTF-8">
<title>會員與圖像 | CoinShell Backend</title>
<link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
</head>

<body>

	<div class="jumbotron text-center">
		<h1>
			<strong>會員</strong>與<strong>圖像</strong>管理
		</h1>
		<p>Backend management page for members and user avatar</p>
	</div>

	<div class="container">
		<div class="row justify-content-around">
			<div class="col-6">
				<h3>
					<a href="${contextRoot}/adm-showAllMembers">查看所有會員</a>
				</h3>
				<p>Check out all of the members</p>
			</div>
			<div class="col-6">
				<h3>
					<a href="${contextRoot}/adm-showAllAvatars">查看所有圖像</a>
				</h3>
				<p>Check out all of the user avatars</p>
			</div>
		</div>
	</div>
</body>
