<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

    <head>
        <meta charset="UTF-8">
        <title>Store | Coinshell Backend</title>
        <link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
    </head>

    <body>

<!--         <a href="store/addCommodity">新增商品 </a> -->
        <br>
<!--         <a href="store/showAllCommodities">全部商品 </a> -->

<div class="jumbotron text-center">
		<h1>
			<strong>商品</strong>管理
		</h1>
		<p>Backend for store commodities</p>
	</div>

	<div class="container">
		<div class="row justify-content-around">
			<div class="col-6">
				<h3>
 				<a href="store/addCommodity">新增商品 </a>
				</h3>
				<p>Create a new product line</p>
			</div>
			<div class="col-6">
				<h3>
        		<a href="store/showAllCommodities">全部商品 </a>
				</h3>
				<p>Check out all commodities</p>
			</div>
		</div>
	</div>


    </body>
