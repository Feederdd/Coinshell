<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="../NavBar/CoinShellNavBar.jsp" />
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${contextRoot}/css/article.css">
<title>New comment | Coinshell</title>
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
				<div class="card-header">Post a new article</div>
				<div class="card-body">
					<!-- 			如果getmapping和postmapping的路徑一樣，action=""可以不用寫 -->
					<form:form action="${contextRoot}/article/add" method="post"
						modelAttribute="article" class="articleForm">
						<div class="input-group">
							<label>Type of Crypto: &nbsp;</label>						
							<form:select path="tag" class="article-sections">
								<form:option value="NONE" label="Choose a type of currency" />
								<form:options items="${tagList}"/>
							</form:select>
						</div>
						<div class="input-group">
							<label>Title:&nbsp; </label>												
							<form:input path="title" class="article-sections" id="edit-title" placeholder="Please enter title ⋯"/>
						</div>
						<label>Content:&nbsp; </label><br>
						<div class="input-group">							
							<form:textarea id="edit-textarea" wrap="Virtual" path="text" class="form-control article-sections" placeholder="Please enter article content ⋯"/>							
						</div>
						<div>
						<form:input path="readNum" value="0" type="hidden"/>
						<form:input path="commentNum" value="0" type="hidden"/>
						<form:input path="goodNum" value="0" type="hidden"/>
						<form:input path="deleted" value="n" type="hidden"/>
						<form:input path="authorId" value="${login.id}" type="hidden"/>
						</div>
						<div class=" text-right">
							<input class="btn btn-primary btn-sm shadow-none" type="submit" name="submit" value="Submit">
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>	
</div>
<!-- <script type="text/javascript">
function upload(){
var content = document.getElementById("#textarea").val();
// var reg=new RegExp("\r\n","g");
// str = str.replace(reg,"<br>");
content = content.replace(/\n|\r\n/g,"<br>");
// $("#textarea").value = content;
document.getElementById(".articleForm").submit();
}

</script> -->
</body>