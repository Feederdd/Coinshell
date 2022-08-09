<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="backendNavBar.jsp" />
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" type="text/css"
	href="${contextRoot}/css/backend.css">

<meta charset="UTF-8">
<title>Backend | Coinshell</title>
</head>

<body>



	<h1>後台管理介面</h1>
	<h3>Backend Interface for Admins</h3>




	<video class="video-back" autoplay loop muted>
		<source src="${contextRoot}/video/star3.mp4">
	</video>

</body>

</html>