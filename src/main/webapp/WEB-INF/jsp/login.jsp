<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/coinshell/login" method="post" >
<h3>登入</h3>
信箱:<input type="email" name="eMail" placeholder="enter mail" /> 
密碼:<input type="password" name="password" placeholder="enter password"/> 
<input type="hidden" /> 
<br/>
<input type="hidden"/>
<br/>
<button type="submit">登入會員</button> <p>${loginError}</p>
</form>

</body>
</html>