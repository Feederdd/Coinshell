<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="../NavBar/CoinShellNavBar.jsp" />
<head>
<meta charset="UTF-8">
<title>Cookie Policy | Coinshell</title>
<link rel="stylesheet" href="${contextRoot}/css/aboutsidebar.css">
</head>
<body>

	<!-- side bar 側邊欄位 -->
	<div class="sidebar">
		<a href="${contextRoot}/aboutUs/nice-intro">About Our Team</a> 
		<a href="${contextRoot}/account/cookie">Cookie Policy</a> 
			<a href="${contextRoot}/account/privacy">Privacy Policy</a> 
			<a href="${contextRoot}/account/freAQ">Frequently Asked Questions</a> 
	</div>

	<div class="container"  style="margin-top: 30px; background-color: #fff; border-radius: 30px;">
		<div class="col-9">
			<h3 style="margin-top: 30px;">How does Coinshell use cookies?</h3>
			<h6 style="margin-top: 30px;">Last updated: 23 May, 2022</h6>
			<div>A cookie is a small piece of data that a website asks your
				browser to store on your computer or mobile device. The cookie
				allows the website to “remember” your actions or preferences over
				time.</div>
			<div>Most browsers support cookies, but users can set their
				browsers to decline them and can delete them whenever they like.</div>
			<div>If you use CoinShell, both CoinShell and third parties
				will use cookies to track and monitor some of your activities on and
				off CoinShell, and store and access some data about you, your
				browsing history, and your usage of CoinShell.</div>
			<div>This policy describes how both CoinShell and other third
				parties use cookies both within and without CoinShell and how you
				can exercise a better control over cookies. Please keep in mind that
				this may alter your experience with our platform, and may limit
				certain features (including being logged in as a user).</div>
			<div>General Browsing: We use cookies that are important for
				certain technical features of our website, like logging into user
				accounts and implementing fixes and improvements to our platform.</div>
			<div>These cookies help us:</div>
			<ul>
				<li>Remember users’ custom preferences and help create more
					useful products</li>
				<li>Allow users to opt out of certain types of modeling,
					tailoring, or personalization in our products</li>
				<li>Collect information on our users’ preferences in order to
					create more useful products</li>
				<li>Cookies can also be used for online behavioural target
					advertising and to show adverts relevant to something that the user
					searched for in the past</li>
			</ul>

			<h5 style="margin-top: 30px;">WHAT INFORMATION IS COLLECTED ON ME VIA COOKIES?</h5>
			<div>In general, we collect most data from you via form
				submission. However, there are cases when visiting our site and/or
				using our platforms in which we may receive certain information
				through the use of cookies. This data will generally not include
				personally identifying information about you.</div>
			<ul>
				<li>Unique identification tokens</li>
				<li>User preferences</li>
			</ul>

			<h5 style="margin-top: 30px;">HOW DO I RESTRICT COOKIES?</h5>
			<div>Please note that CoinShell may not work properly and you
				may have diminished functionality if you wish to opt-out of certain
				cookies.</div>
			<br /> <br /> 
			<a href="${contextRoot}/account/privacy">Privacy
				Policy @ Coinshell</a> <br /> <br />

		</div>
	</div>
</body>