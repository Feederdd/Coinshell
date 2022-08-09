<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>全部使用者頭像列表</title>
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
        <h1>使用者頭像列表</h1>
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
                        <th>Alias avatar</th>
                        <th>Avatar photo</th>
                        <th>Edit</th>
                        <th>Delete</th>
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
                var cuaName = url.searchParams.get('name');
                $.ajax({
                    method: "GET", //API的訪問方式，GET或POST
                    url: "http://localhost:8080/coinshell/CUA?name=" + cuaName, //API的URL
                    dataType: "json", //這個API裡面的資料型態有"XML","html","script","json","text"

                    success: function(data) {
                        $.each(data, function(index, value) {
                            $("tbody").append(

                                `<tr>
                            <td>` + value.id + `</td>
                            <td>` + value.alias + `</td>
                            <td><img src="data:image/gif;base64,` + value.base64 + `" width=300px hight=300px></td>
                            <td> <a href="editcua?id=` + value.id + `">編輯</a></td>
                            <td ><a href="deletecua?id=` + value.id + `">刪除</a> </td> 
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