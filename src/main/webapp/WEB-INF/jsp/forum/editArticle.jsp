<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../NavBar/CoinShellNavBar.jsp" />
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextRoot}/css/article.css">
<title>Edit Article | Coinshell</title>
<style type="text/css">
body{
padding-top: 82px;
}
</style>
</head>
<body>

<div class="container">
	<div class="row justify-content-center">
		<div class="col-9">
			<div class="card border-info" id="edit-card">
				<div class="card-header">Edit an article</div>
				<div class="card-body">
					<!--如果getmapping和postmapping的路徑一樣，action=""可以不用寫 -->
					<form:form action="${contextRoot}/postEditArticle" method="post"
						modelAttribute="article">
						<div class="input-group">
							<label>Type of Crypto: &nbsp;</label>
							<form:select path="tag">
								<form:option value="NONE" label="Choose a type of currency" />
								<form:options items="${tagList}"/>
							</form:select>
						</div>
						<div class="input-group">	
							<label>Title:&nbsp;</label>												
							<form:input path="title" id="edit-title"/>
						</div>
						<label>Content:&nbsp; </label><br>
						<div class="input-group">
							<form:textarea wrap="Virtual" path="text" class="form-control" id="edit-textarea"/>							
						</div>
						<div>
							<form:input path="readNum" type="hidden"/>
							<form:input path="commentNum" type="hidden"/>
							<form:input path="deleted" type="hidden"/>
							<form:input path="id" type="hidden"/>
							<form:input path="added" type="hidden"/>
							<form:input path="authorId" type="hidden"/>
							<form:input path="goodNum" type="hidden"/>
						</div>
						<div class=" text-right">							
							<input class="btn btn-primary btn-sm shadow-none" type="submit" name="submit" value="Confirm Revision">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>