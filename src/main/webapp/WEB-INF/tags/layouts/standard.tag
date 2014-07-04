<%-- JSP DIRECTIVES --%>

<%@ tag description="Layout of all pages standard pages" pageEncoding="UTF-8" %>
<%@ attribute name="pageScripts" fragment="true" required="false" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>

<%-- JSP CONTENT --%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Got it! - <c:out value="${pageTitle}" /></title>
		<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
		<br>
		<div class="container">
			<div class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/">Got it!</a>
					</div>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="/">Home</a></li>
							<li><a href="/schools">List of schools</a></li>
							<li><a href="/about">About</a></li>
							<li><a href="/contact">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<sec:authorize access="isAnonymous()">
								<li><a href="/sign-in">Sign in</a></li>
								<li><a href="/sign-up">Sign up</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li><p class="navbar-text">Signed in as <sec:authentication property="principal.username" /></p></li>
								<li><a href="/sign-out">Sign out</a></li>
							</sec:authorize>
						</ul>
					</div>
				</div>
			</div>
			<div class="page-header">
				<h1><c:out value="${pageTitle}" /></h1>
			</div>
			<c:if test="${not empty successMessage}">
				<div class="alert alert-success alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					${successMessage}
				</div>
			</c:if>
			<c:if test="${not empty infoMessage}">
				<div class="alert alert-info alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					${infoMessage}
				</div>
			</c:if>
			<c:if test="${not empty warningMessage}">
				<div class="alert alert-warning alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					${warningMessage}
				</div>
			</c:if>
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger alert-dismissable">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					${errorMessage}
				</div>
			</c:if>
			<jsp:doBody />
			<div id="footer">
				<hr>
				<p>Copyright &copy; Dany Jupille, HE-Arc Engineering</p>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
		<c:if test="${not empty pageScripts}">
			<jsp:invoke fragment="pageScripts" />
		</c:if>
	</body>
</html>
