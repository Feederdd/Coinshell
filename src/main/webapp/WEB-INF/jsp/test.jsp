<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <title>購物車顯示頁面</title>
            <style>
                body {
                    font-family: Arial;
                    font-size: 17px;
                    padding: 8px;
                }
                
                * {
                    box-sizing: border-box;
                }
                
                .row {
                    display: -ms-flexbox;
                    /* IE10 */
                    display: flex;
                    -ms-flex-wrap: wrap;
                    /* IE10 */
                    flex-wrap: wrap;
                    margin: 0 -16px;
                }
                
                .col-25 {
                    -ms-flex: 25%;
                    /* IE10 */
                    flex: 25%;
                }
                
                .col-50 {
                    -ms-flex: 50%;
                    /* IE10 */
                    flex: 50%;
                }
                
                .col-75 {
                    -ms-flex: 75%;
                    /* IE10 */
                    flex: 75%;
                }
                
                .col-25,
                .col-50,
                .col-75 {
                    padding: 0 16px;
                }
                
                .container {
                    background-color: #f2f2f2;
                    padding: 5px 20px 15px 20px;
                    border: 1px solid lightgrey;
                    border-radius: 3px;
                }
                
                input[type=text] {
                    width: 100%;
                    margin-bottom: 20px;
                    padding: 12px;
                    border: 1px solid #ccc;
                    border-radius: 3px;
                }
                
                label {
                    margin-bottom: 10px;
                    display: block;
                }
                
                .icon-container {
                    margin-bottom: 20px;
                    padding: 7px 0;
                    font-size: 24px;
                }
                
                .btn {
                    background-color: #4CAF50;
                    color: white;
                    padding: 12px;
                    margin: 10px 0;
                    border: none;
                    width: 100%;
                    border-radius: 3px;
                    cursor: pointer;
                    font-size: 17px;
                }
                
                .btn:hover {
                    background-color: #45a049;
                }
                
                a {
                    color: #2196F3;
                }
                
                hr {
                    border: 1px solid lightgrey;
                }
                
                span.price {
                    float: right;
                    color: grey;
                }
                /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
                
                @media (max-width: 800px) {
                    .row {
                        flex-direction: column-reverse;
                    }
                    .col-25 {
                        margin-bottom: 20px;
                    }
                }
            </style>
        </head>

        <body>
            <div class="row">
                <div class="col-75">
                    <div class="container">
                        <form method="post" action="pay">
                            <div class="col-50">
                                <h3>Payment</h3>
                                <label>Accepted Cards</label>
                                <div class="icon-container">
                                    <i class="fa fa-cc-visa" style="color:navy;"></i>
                                    <i class="fa fa-cc-amex" style="color:blue;"></i>
                                    <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                    <i class="fa fa-cc-discover" style="color:orange;"></i>
                                </div>
                                <label for="price">Total</label>
                                <input type="text" id="price" name="price" value="10">
                                <label for="currency">Currency</label>
                                <input type="text" id="currency" name="currency" value="USD">
                                <label for="method">Payment Method</label>
                                <input type="text" id="method" name="method" value="paypal">
                                <label for="intent">Intent</label>
                                <input type="text" id="intent" name="intent" value="sale">
                                <label for="description">Payment Description</label>
                                <input type="text" id="description" name="description" value="testing">

                            </div>

                            <input type="submit" value="Continue to checkout" class="btn">
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>