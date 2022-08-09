<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

<head>
<meta charset="UTF-8">
<title>新增圖像 | CoinShell Backend</title>
<link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
</head>

<body>
	<div class="jumbotron col-8 mt-2" style="margin: 0 auto;">
		<h1 class="display-6">新增會員圖像</h1>
		<hr class="my-4">
		<form action="uploadcua" method="post" enctype="multipart/form-data">

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Alias Name</span>
				</div>
				<input type="text" name="alias" value="我是圖像別名" class="form-control"
					placeholder="Username" aria-label="Username"
					aria-describedby="basic-addon1">
			</div>

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Upload
						Image</span>
				</div>
				<input type="file" name="file" required="required"
					accept="image/png, image/gif, image/jpeg">

			</div>
			<input type="submit" value="Add a new avatar picture"
				class="btn btn-success btn-lg btn-block">
		</form>
		<hr class="my-4">
	<a href="${contextRoot}/adm-showAllAvatars" style="text-decoration:none; color:#fff;"><button class="btn btn-secondary btn-lg btn-block">
				Discard and go back
	</button></a>

	</div>
</body>