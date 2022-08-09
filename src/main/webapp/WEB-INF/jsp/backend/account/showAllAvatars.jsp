<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />
    
<head>
<meta charset="UTF-8">
<title>圖像管理 | CoinShell Backend</title>
<link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
<style type="text/css">
.zoom:hover {
  -ms-transform: scale(3);
  -webkit-transform: scale(3); 
  transform: scale(3); 
}

td {
	height: 150px;
	    text-align: center; 
    vertical-align: middle;
}

</style>
</head>

    <body>
	<div class="jumbotron col-8 mt-2" style="margin: 0 auto;">
		<h1 class="display-6">使用者頭像列表</h1>
		<hr class="my-4">
 		<a href="${contextRoot}/adm-addAvatar" style="color:white; text-decoration: none;"><button class="btn btn-success btn-lg btn-block mb-3">Add Avatar</button></a>

    <form class="form-inline my-1 my-lg-0">
		<div class="input-group">
			<input id="text-search" class="form-control pl-2 p-0" type="text" aria-label="Search">
			<div class="input-group-append">
				<input type="button" name="submit" value="Search" id="searchNews" class="btn btn-outline-dark my-2 my-sm-0" />
            </div>
        </div>
    </form>

        <div id="cuaList">
            <table class="table table-hover table-bordered">

                <thead class="bg-primary">
                    <tr>
                        <th scope="col" class="avatarid">ID</th>
                        <th scope="col" class="alias">Alias Avatar</th>
                        <th scope="col" class="avatar">Avatar Photo</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>
            </table>
</div>

        </div>
        <script>
            $(function() {
                $.ajax({
                    method: "GET", //API的訪問方式，GET或POST
                    url: "http://localhost:8080/coinshell/allCUA", //API的URL
                    dataType: "json", //這個API裡面的資料型態有"XML","html","script","json","text"

                    success: function(data) {
                        $.each(data, function(index, value) {
                            $("tbody").append(

                                `<tr>
                            <td>` + value.id + `</td>
                            <td>` + value.aliasAvatar + `</td>
                            <td><img class="zoom" src="data:image/gif;base64,` + value.userAvatar + `" width=65px hight=65px></td>
                            <td> <button class="btn btn-info" ><a href="editcua?id=` + value.id + `"style="color:white; text-decoration: none;">Update</a></td>
                            <td ><button class="btn btn-danger" ><a href="deletecua?id=` + value.id + `"style="color:white; text-decoration: none;">Delete</a> </button> </td> 
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

    </html>