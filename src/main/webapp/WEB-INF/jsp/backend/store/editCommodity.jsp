<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

    <head>
        <meta charset="UTF-8">
        <title>修改商品</title>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    </head>

    <body>
        <h1> 修改商品</h1>

        <form action="editCommodity" method="post">
            <br> Commodity Id : <input type="text" name="id" value="${commodity.id}">
            <br> Commodity Name: <input type="text" name="name" value="${commodity.commodityName}">
            <br> Describe:<input type="text" name="describe" value="${commodity.discribe}">
            <br> Volume: <input type="number" name="volume" min="1" max="2147483647" value="${commodity.volume}">
            <br>
            <br> shellOrCoin:

            <input type="radio" id="Shell" name="shellOrCoin" value="Shell" require checked>
            <label for="Shell" onclick="showMyshell()">Shell</label>
            <input type="radio" id="Coin" name="shellOrCoin" value="Coin">
            <label for="Coin" onclick="showMyCoin()">Coin</label>
            <div style="display: none;" id="myShell"> MyShell:<input type="number" value="${commodity.myShell}" name="myShell" min="0" max="2147483647"></div>
            <div style="display: none;" id="myCoin"> Coin:<input type="number" value="${commodity.coin}" name="coin" min="0" max="2147483647"></div>

            <br>
            <input type="submit" value="送出">
        </form>
    </body>
    <script>
        function showMyshell() {
            $("#myShell").toggle()
            $("#myCoin").hide()
        }

        function showMyCoin() {
            $("#myCoin").toggle()
            $("#myShell").hide()
        }
    </script>