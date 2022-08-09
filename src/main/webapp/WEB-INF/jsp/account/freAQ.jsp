<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
      <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
      <jsp:include page="../NavBar/CoinShellNavBar.jsp" />

      <head>
        <meta charset="UTF-8">
        <title>FAQs | Coinshell</title>
        <link rel="stylesheet" href="${contextRoot}/css/aboutsidebar.css">
        <style type="text/css">
          .q {
            font-weight: 700;
          }

          .a {
            display: flex;
            flex-direction: row-reverse;
          }
        </style>
      </head>

      <body>
        <!-- side bar 側邊欄位 -->
        <div class="sidebar">
          <a href="${contextRoot}/aboutUs/nice-intro">About Our Team</a> <a href="${contextRoot}/account/cookie">Cookie
            Policy</a> <a href="${contextRoot}/account/privacy">Privacy Policy</a> <a
            href="${contextRoot}/account/freAQ">Frequently Asked Questions</a>
        </div>

        <div class="container" style="margin-top: 30px; background-color: #fff; border-radius: 30px;">
          <div class="col-9">
            <h3>Frequently Asked Questions</h3>

            <div class="accordion" id="accordionExample">
              <div class="card">
                <div class="card-header" id="headingOne">
                  <h2 class="mb-0">
                    <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse"
                      data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                      What is "Market Capitalization" and how is it calculated?
                    </button>
                  </h2>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne"
                  data-parent="#accordionExample">
                  <div class="card-body">
                    <p>Market Capitalization is one way to rank the relative size of a cryptocurrency. It's calculated
                      by multiplying the Price by the Circulating Supply.
                    </p>
                    <p>Market Cap = Price X Circulating Supply.</p>

                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" id="headingTwo">
                  <h2 class="mb-0">
                    <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse"
                      data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                      What is the difference between "Circulating Supply", "Total Supply", and "Max Supply"?
                    </button>
                  </h2>
                </div>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
                  <div class="card-body">
                    <p>Circulating Supply is the best approximation of the number of coins that are circulating in the
                      market and in the general public's hands.</p>
                    <p>Total Supply is the total amount of coins in existence right now (minus any coins that have been
                      verifiably burned).
                      Max Supply is the best approximation of the maximum amount of coins that will ever exist in the
                      lifetime of the cryptocurrency.</p>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" id="headingThree">
                  <h2 class="mb-0">
                    <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse"
                      data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                      What is the difference between a "Coin" and a "Token" on the site?
                    </button>
                  </h2>
                </div>
                <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
                  <div class="card-body">
                    <p>A Coin is a cryptocurrency that can operate independently.</p>
                    <p>A Token is a cryptocurrency that depends on another cryptocurrency as a platform to operate.
                      Check out the crypto tokens listings to view a list of tokens and their respective platforms.</p>
                  </div>
                </div>
              </div>
              <div class="card">
                <div class="card-header" id="headingFour">
                  <h2 class="mb-0">
                    <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse"
                      data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                      Why are markets with no fees excluded from the price average and total trading volume?
                    </button>
                  </h2>
                </div>
                <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
                  <div class="card-body">
                    When no fees are being charged at the exchange, it is possible for a trader (or bot) to trade back and forth with themselves and generate a lot of "fake" volume without penalty. It's impossible to determine how much of the volume is fake so we exclude it entirely from the calculations.
                  </div>
                </div>
              </div>


            </div>
          </div>
        </div>


      </body>