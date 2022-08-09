<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <c:set var="contextRoot" value="${pageContext.request.contextPath}" />
            <jsp:include page="../NavBar/CoinShellNavBar.jsp" />

            <head>
                <title>Account Settings | CoinShell</title>
                <style type="text/css">
                    body {
                        padding-top: 82px;
                    }
                    
                    .label {
                        margin-top: 20px;
                    }
                    
                    label img {
                        size: 100px;
                        border-radius: 50%;
                    }
                </style>
            </head>

            <body>
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <div class="lead" style="background-color:#fff; border-radius:30px; padding: 25px; box-shadow: 1px 4px 5px 2px #AAAAFF;">
                            <h3 class="display-5">Account Settings</h3>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text font-weight-bold" id="inputGroup-sizing-default"><i class="fa-solid fa-user-astronaut"></i>&nbsp;Avatar</span>
                                </div>
                                <div id="user-img">
                                    <img src="data:image/gif;base64,${memImg}" style="border-radius: 50%; height: 100px; ">
                                </div>
                                <button class="btn btn-outline-primary" type="button" data-toggle="modal" data-target="#chooseAvatar">Avatar</button>
                                <script>
                                    var memId = '${login.id}';
                                    var url = "http://localhost:8080/coinshell/selectMemberAvatar?id=";
                                        $(function() {
                                            $("#user-img").empty()
                                            var url = "http://localhost:8080/coinshell/selectMemAvatar?id=";
                                            var id = `${login.id}`;
                                            fetch(url + id).then(function(response) {
                                                return response.text()
                                            }).then(function(img) {                                            
                                                $("#user-img").append(`<img src="data:image/gif;base64,`+img+`"

                                            style="border-radius: 50%; height: 100px; ">`);
                                            }).catch(err => console.log(err));
                                        })
                                </script>
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default"><i class="fa-solid fa-id-card"></i>&nbsp;User Referral
										ID</span>
                                </div>
                                <input type="text" disabled value="${ login.id }" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>
                            <!--Start 變更使用者名稱 -->
                            <form action="changeUsername" method="post">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text font-weight-bold" id="inputGroup-sizing-default"><i class="fa-solid fa-file-signature"></i>&nbsp;UserName</span>
                                    </div>
                                    <input name="customizedUserName" type="text" value="${ login.customizedUserName }" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                    <input type="hidden" name="eMail" value="${login.eMail}">
                                    <input type="hidden" name="id" value="${login.id}">
                                    <button class="btn btn-outline-primary" type="sumbit">Change UserName</button>
                                </div>
                            </form>
                            <!--End 變更使用者名稱 -->

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default"><i class="fa-solid fa-envelope-open-text"></i>&nbsp;Email Address</span>
                                </div>
                                <input type="email" disabled value="${login.eMail}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default"><i class="fa-solid fa-anchor"></i>&nbsp;MyShell Balance</span>
                                </div>
                                <input type="text" disabled value="${login.myShell}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">

                                    <span class="input-group-text" id="inputGroup-sizing-default"><i class="fa-solid fa-sack-dollar"></i>&nbsp;Coin Balance</span>
                                </div>
                                <input type="text" disabled value="${login.coin}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>

                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default"><i class="fa-regular fa-calendar-check"></i>&nbsp;Join Time</span>
                                </div>
                                <input type="text" disabled value="${login.joinTime}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>
                            <div class="card">
                                <h5 class="card-header font-weight-normal"><i class="fa-solid fa-lock"></i>&nbsp;Password</h5>
                                <div class="card-body">
                                    <p class="card-text">Set a unique password to protect your personal account.</p>
                                    <a type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#changePwd">Change password</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                </div>


                <!-- 選擇 avatar 的modal -->
                <div class="modal fade text-left" id="chooseAvatar" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Your Avatar</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
                            </div>

                            <form action="selectAvatar" method="post">
                                <div class="modal-body">
                                    <p>Select an avatar for your profile. You can redeem more avatars from the Rewards page.
                                    </p>
                                    <input type="hidden" value="${login.id}" name="id">
                                    <input type="radio" name="radio-emotion" id="sad" class="input-hidden" value="1" />
                                    <label for="sad">
										<img src="${contextRoot}/images/NavBarImg/1_bubbleAvatar.png" alt="Bubble" />
									</label>

                                    <input type="radio" name="radio-emotion" id="happy1" class="input-hidden" value="2" />
                                    <label for="happy1">
										<img src="${contextRoot}/images/NavBarImg/2_hulaAvatar.png" alt="HulaHoop" />
									</label>

                                    <input type="radio" name="radio-emotion" id="happy2" class="input-hidden" value="3" />
                                    <label for="happy2">
										<img src="${contextRoot}/images/NavBarImg/3_magnetaAvatar.png" alt="Magneta" />
									</label>

                                    <input type="radio" name="radio-emotion" id="happy3" class="input-hidden" value="4" />
                                    <label for="happy3">
										<img src="${contextRoot}/images/NavBarImg/4_purAvatar.png" alt="Purple" />
									</label>

                                    <input type="radio" name="radio-emotion" id="happy4" class="input-hidden" value="5" />
                                    <label for="happy4">
										<img src="${contextRoot}/images/NavBarImg/5_defaultAvatar.png" alt="Default" />
									</label>
                            </form>



                            <p style="margin-top: 30px;">Unlock more cool avatars with myShells. <a href="#">Go to
									Rewards page →</a></p>
                            <button type="submit" class="btn btn-info btn-block mt-4">Select</button>
                            </div>

                        </div>
                    </div>
                </div>
                </div>

                <!-- 變更密碼的 modal -->
                <div class="modal fade text-left" id="changePwd" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Reset password</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">

									<span aria-hidden="true">&times;</span>
								</button>
                            </div>
                            <form action="sendResetEmail" method="post">
                                <div class="modal-body">
                                    <p>You will receive an email with instructions on how to reset your password in a few minutes. You can also set a new password if you've never set one before.</p>
                                    <h6 style="margin-top: 30px;">Email Address</h6>
                                    <form action="#sendpswmail" method="#doOrPost"></form>
                                    <!--這裡要加上 javax.mail 寄送密碼驗證-->
                                    <input type="email" name="eMail" value="${login.eMail}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                                    <input type="text" name="id" value="${login.id}">
                                    <button class="btn btn-info btn-block mt-1" type="submit">Send Instructions</button>
                                </div>
                            </form>
                            </form>
                        </div>
                    </div>
                </div>
                </div>

            </body>