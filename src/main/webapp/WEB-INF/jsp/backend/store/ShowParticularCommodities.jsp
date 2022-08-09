<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

    <head>
        <meta charset="UTF-8">
        <title>All Commodities | Backend Coinshell</title>
        <link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
        <style>
            table,
            tr,
            th,
            td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>

    <body>
        <h1>上架之商品列表</h1>
        <div id="text-search">
            <form action="search" method="get">
                搜尋:<input type="text" name="name">
                <input type="submit" value="開始搜尋">
            </form>

        </div>
        <div id="commodityList">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Commodity Name</th>
                        <th>Photo</th>
                        <th>Describe</th>
                        <th>Volume</th>
                        <th>ShellOrCoin</th>
                        <th>Shell</th>
                        <th>Coin</th>
                        <th>Edit</th>
                        <th>DELETE</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>



        </div>
        <script>
            $(function() {
                var getUrlString = location.href;
                var url = new URL(getUrlString);
                var commodityName = url.searchParams.get('name');
                $.ajax({
                    method: "GET", //API的訪問方式，GET或POST
                    url: "http://localhost:8080/coinshell/Commodity?name=" + commodityName, //API的URL
                    dataType: "json", //這個API裡面的資料型態有"XML","html","script","json","text"

                    success: function(data) {
                        $.each(data, function(index, value) {
                            $("tbody").append(

                                `<tr>
                            <td>` + value.id + `</td>
                            <td>` + value.commodityName + `</td>
                            <td><img src="data:image/gif;base64,` + value.photo + `" width=300px hight=300px></td>
                            <td>` + value.discribe + `</td>
                            <td>` + value.volume + `</td>
                            <td>` + value.shellOrCoin + `</td>
                            <td>` + value.myShell + `</td>
                            <td>` + value.coin + `</td>
                            <td> <a href="editCommodity?id=` + value.id + `">編輯</a></td>
                            <td ><a href="deleteCommodity?id=` + value.id + `">刪除</a> </td> 
                                </tr>
                                `

                            )
                        })
                    },
                    error: function() {}
                })
            })
        </script>

    </body>
