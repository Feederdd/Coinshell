<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <jsp:include page="../NavBar/CoinShellNavBar.jsp" />

            <head>
                <meta charset="UTF-8">
                <title>My Shell</title>
                <style type="text/css">
                    @import url('https://fonts.googleapis.com/css2?family=Mulish:wght@300&display=swap');
                    /* @import url("https://fonts.googleapis.com/css?family=Noto+Sans+TC:100,300,400,500,700,900&display=swap"); */
                    
                    @import url("https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css");
                    * {
                        margin: 0;
                        */ padding: 0;
                        */ list-style: none;
                        */ word-spacing: 0.1em;
                        */ font-family: 'Mulish', sans-serif;
                        */
                    }
                    /*   .buttonPic {  */
                    /*   display: flex; */
                    /*   	padding-top: 50px;  */
                    /*   	border-style: none;  */
                    /*   	width: 200px;  */
                    /*  	height: 200px; */
                    /*   	object-fit: cover;  */
                    /*   }  */
                </style>


                <!-- 上方 -->
                <style>
                    body {
                        padding-top: 160px;
                    }
                    
                    .container {
                        column-gap: 20px;
                        display: flex;
                        justify-content: space-between;
                    }
                    
                    .card {
                        box-sizing: border-box;
                        display: flex;
                        flex-direction: column;
                        justify-content: center;
                        align-items: center;
                        width: 30%;
                        height: 400px;
                        padding: 10px 20px;
                        border-radius: 10px;
                        background: linear-gradient(#0078EE, #A3A3FF, #EBEBFF);
                        box-shadow: 0 0 20px 1px Gray;
                    }
                    
                    .card-title {
                        color: white;
                        text-align: center;
                        line-height: 2;
                        font-size: 32px;
                        text-shadow: 0 0 2px Lightgray;
                    }
                    
                    .card-txt {
                        color: WhiteSmoke;
                        height: 80%;
                        width: 100%;
                        line-height: 32px;
                    }
                </style>

                <div class="container">
                    <div class="card">
                        <div class="card-title">What is Coin Shell?</div>
                        <div class="card-txt">Shell is the currency exclusively for circulation on our platform.
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-title">What can the shell do?</div>
                        <div class="card-txt">You can go to the store to buy a variety of pictures, as a unique photo of the user</div>
                    </div>
                    <div class="card">
                        <div class="card-title">How to get it?</div>
                        <div class="card-txt">It can be obtained through two channels.</div>
                    </div>
                    <div class="card">
                        <div class="card-title">Punch In List</div>
                        <a href="OK?Id=${sessionScope.login.id}" class="btn btn-primary">Punch In</a>
                        <a href="${contextRoot}/shellshop" class="btn btn-primary">Store</a>

                    </div>
                </div>

                <style>
                    .card-txt {
                        height: 0;
                        overflow: hidden;
                        opacity: 0;
                    }
                </style>

                <style>
                    .card:hover .card-title {
                        text-shadow: 1px 1px 5px DimGray;
                    }
                    
                    .card:hover .card-txt {
                        height: 80%;
                        opacity: 1;
                        overflow: auto;
                    }
                </style>

                <style>
                    .card-txt {
                        transition: all .3s;
                    }
                </style>


                </style>

            </head>

            <body>

                <!-- 	</div> -->
                <!-- 	Page content -->
                <!-- 	<div class="container" -->
                <!-- 		style="margin-top: 30px; background-color: #fff; border-radius: 30px;"> -->
                <!-- 		<div class="col-9"> -->

                <!-- "簽到" 跳轉頁面 -->
                <!-- <div> -->
                <%-- <a href="OK?Id=${sessionScope.login.id}"><button>簽到</button></a> --%>
                    <!-- </div> -->


                    <!-- 			"圖片" 跳轉頁面 -->
                    <!-- 			<div class="buttonPic "> -->
                    <%-- 				<a href="OK?Id=${sessionScope.login.id}"><img --%>
                        <!-- 					src="https://i.imgur.com/ktLtWdV.jpg" -->
                        <!-- 					alt=""></a> -->

                        </div>
                        </div>
                        </div>
                        </div>


            </body>

            </style>