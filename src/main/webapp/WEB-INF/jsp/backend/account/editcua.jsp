<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../backendNavBar.jsp" />

<head>
<meta charset="UTF-8">
<title>修改使用者圖像</title>
  <link rel="stylesheet" href="${contextRoot}/css/backendNews.css">
</head>

<body>
  <div class="jumbotron col-8 mt-2" style="margin: 0 auto;">
    <h1 class="display-6">修改使用者圖像</h1>
    <hr class="my-4">
<form action="editcua" method="post">

      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text" id="basic-addon1">Avatar Id</span>
        </div>
        <input type="text" name="id" value="${cua.id}" class="form-control" placeholder="Username" aria-label="Username"
          aria-describedby="basic-addon1">
      </div>
      <div class="input-group mb-3">
        <div class="input-group-prepend">
          <span class="input-group-text" id="basic-addon1">Alias Avatar</span>
        </div>
        <input type="text" name="alias" value="${cua.aliasAvatar}" class="form-control" placeholder="Username" aria-label="Username"
          aria-describedby="basic-addon1">
      </div>
 

<br> 
  
<input type="submit" class="btn btn-info btn-lg btn-block" value="Update Alias-Avatar">
</form>

</div>
</body>
