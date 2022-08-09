<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

        <head>
            <meta charset="UTF-8">
            <title>新增商品</title>
            <link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
            <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
            <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
            <script src="${contextRoot}/javascripts/indexJs.js"></script>
            <script>
            </script>
        </head>

        <body>
        <div class="jumbotron col-8 mt-2" style="margin: 0 auto;">
        <h1 class="display-6">新增商品</h1>
        <hr class="my-4">
            <form action="commodityUpload" method="post" enctype="multipart/form-data">
                <br> Commodity Name: <br/>
                <input type="text" name="name" value="我是商品名稱">

                <div id="Shell"> Shell: <br/>
                <input type="number" value="100" name="shell" min="0" max="2147483647" required></div>

                <br> Photo: <input type="file" name="photo" required="required" accept="image/png, image/gif, image/jpeg">
                <br>
                <input type="submit" value="Add" class="btn btn-success btn-lg btn-block">
            </form>
		</div>
        </body>
        <script>
        </script>
