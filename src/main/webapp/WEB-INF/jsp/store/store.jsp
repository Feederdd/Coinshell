<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <jsp:include page="../NavBar/CoinShellNavBar.jsp" />

            <html>
            <!-- 38:00 無法倫播標題-->

            <head>
                <meta charset="UTF-8">
                <title>Shell Shop | Coinshell</title>
                <link rel="Shortcut Icon" href="https://cdn-icons-png.flaticon.com/512/1490/1490853.png" type="image/x-icon" />
                <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">
                <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
                <link rel="stylesheet" type="text/css" href="${contextRoot}/css/storeStyle.css">
                <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
                <script type="text/javascript" src="${contextRoot}/javascripts/store.js"></script>
                <script type="text/javascript" src="${contextRoot}/javascripts/jquery.countdown.min.js"></script>
            </head>

            <body>
                <br>
                <br>
                <br>
                <br>
                <!-- Navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container px-5 px-lg-5">
                        <a class="navbar-brand" href="#!"></a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#!"></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#!">Shell: $ ${login.myShell}</a>

                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="buyShell">Buy Shell</a>

                                </li>

                                <li class="nav-item dropdown">

                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li>
                                            <a class="" href="#!"></a>
                                        </li>
                                        <li>
                                            <hr class="dropdown-divider" />
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="#!"></a>
                                        </li>
                                        <li>
                                            <a class="dropdown-item" href="#!"></a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <form action="goCart" method="post" class="d-flex">
                                <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span id="count" class="badge bg-dark text-white ms-1 rounded-pill count">0</span>
                             </button>
                            </form>
                            <script>
                                $(function() {
                                    $("#count").empty();
                                    var count = parseInt(0, 10);
                                    var url = "http://localhost:8080/coinshell/showCart";
                                    fetch(url).then(function(response) {
                                        return response.json();
                                    }).then(function(array) {
                                        $.each(array, function(index, value) {
                                            count += 1;
                                            // alert(count);
                                            // $(".count").append(count);
                                        })
                                    }).then(function() {
                                        $(".count").append(count);
                                    })
                                })
                            </script>

                        </div>
                    </div>
                </nav>
                <!-- Header-->
                <header class="bg-dark py-5">
                    <div class="container px-4 px-lg-5 my-5">
                        <div class="text-center text-white">
                            <h1 class="display-4 fw-bolder">Shop in style</h1>
                            <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
                        </div>
                    </div>
                </header>
                <!-- Section-->

                <section class="py-5">

                    <div class="container px-4 px-lg-5 mt-5">
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center" id="commodidy-zone">



                        </div>
                    </div>

                </section>


                <script>
                    $(function() {
                        var url = "http://localhost:8080/coinshell/allCommodity";
                        fetch(url).then(function(response) {
                            return response.json();
                        }).then(function(array) {
                            $.each(array, function(index, value) {
                                $("#commodidy-zone").append(
                                    `
                                    <div class="col mb-5">
                                <div class="card h-100">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="data:image/gif;base64,` + value.photo + `" alt="..." />
                                    <!-- Product details-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <h5 class="fw-bolder">` + value.commodityName + `</h5>
                                            <!-- Product reviews-->
                                            <div class="d-flex justify-content-center small text-warning mb-2">
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                                <div class="bi-star-fill"></div>
                                            </div>
                                            <!-- Product price-->
                                          $  ` + value.shell + `
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <form action="addCart" method="post">
                                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                            <div><input name="id"  type="hidden" value="` + value.id + `"></div>
                                            <div><input name="myShell" type="hidden" value="` + value.shell + `"></div>
                                            <div class="text-center">
                                                <button onclick="updateCart()"type="submit" class="btn btn-outline-dark mt-auto btn-add">Add to cart</button>
                                                </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                                `)
                            })
                        })
                    })
                </script>

                <!-- Footer-->
                <footer class="py-5 bg-dark">
                    <div class="container">
                        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p>
                    </div>
                </footer>
                <!-- Bootstrap core JS-->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
                <!-- Core theme JS-->
                <script src="js/scripts.js"></script>



            </body>

            </html>