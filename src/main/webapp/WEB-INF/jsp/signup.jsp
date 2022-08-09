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

<form:form action="/coinshell/signup" modelAttribute="memberBean"  method="post" >
<h3>註冊</h3>
信箱:<form:input type="email" path="eMail" placeholder="enter mail"/> 
密碼:<form:input type="password" path="password" placeholder="enter password"/> 
<input type="hidden" /> 
<br/>
<input type="hidden"/>
<br/>
<button type="submit">建立帳號</button>
</form:form>

</body>
</html>