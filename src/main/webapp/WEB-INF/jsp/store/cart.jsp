<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!DOCTYPE html>
    <html>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
    <head>
        <meta charset="UTF-8">
        <title>購物車</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="${contextRoot}/javascripts/jquery.countdown.min.js"></script>
        <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css"/>
        <script src="${contextRoot}/javascripts/bootstrap.bundle.min.js"></script>
        <link rel="Shortcut Icon" href="https://cdn-icons-png.flaticon.com/512/1490/1490853.png" type="image/x-icon" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
        <style>
            /* table,
            tr,
            th,
            td {
                border: 1px solid black;
                border-collapse: collapse;
            } */
            #total-section{
                padding-right: 15px;
            }
        </style>
    </head>

    <body>
    <div class="row justify-content-center">
        <div id="commodityList" class="col-9">
            <table class="table table hover table-primary table-article">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="col-1">ID</th>
                        <th scope="col" class="col-1">Commodity Name</th>
                        <th scope="col" class="col-1">Quantity</th>
                        <th scope="col" class="col-1">Shell</th>
                        <th scope="col" class="col-1">Total Price</th>
                        <th scope="col" class="col-1">DELETE</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="row d-flex justify-content-end" id="total-section">
                <div>目前擁有:$ ${login.myShell} Shell</div>  
                <div>              
                    <form action="checkout" method="post">
                        <input type="text" name="shell" id="" value="${login.myShell}">
                        <span id="total">總價: <input id="value" type="text" name="total" id=""> </span>
                        <button type="submit">CheckOut</button>
                    </form>
                </div>
            </div>
        </div>
    </div>



    </body>
    <script>
        $(function() {
            var url = "http://localhost:8080/coinshell/showCart";
            fetch(url).then(function(response) {
                return response.json();
            }).then(function(array) {
                $.each(array, function(index, value) {
                    $("tbody").append(`
                        <tr>
                        <td>` + value.commodity.id + `</td>
                        <td>` + value.commodity.commodityName + `</td>
                        <td>` + value.quantity + `</td>
                        <td>` + value.commodity.shell + `</td>
                        <td>` + value.price + `</td>
                        <td>
                            <form action="deleteCart" method="get">
                            <input  type="hidden" name="id" value="` + value.commodity.id + `">
                            <button type="submit">delete</button>
                            </form>
                        </td>                        
                        </tr>
                        `);
                })
            })
        })
        $(function() {
            var url = "http://localhost:8080/coinshell/showCart";
            var sum = parseInt(0, 10);
            fetch(url).then(function(response) {
                return response.json();
            }).then(function(array) {
                $.each(array, function(index, value) {
                    sum += value.price;
                    document.getElementById("value").value = sum;
                })
            }).then(function() {
                $("#total").append(sum);
                document.getElementById("input-value").value = 123;
            }).then(function() {
                document.getElementById("value").value = 123;
            })
        })
    </script>


    </html>