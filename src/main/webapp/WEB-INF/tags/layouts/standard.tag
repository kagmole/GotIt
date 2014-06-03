<%@ tag description="Standard page layout using Foundation" pageEncoding="UTF-8" %>
<%@ attribute name="title" fragment="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Got it! - <jsp:invoke fragment="title" /></title>
		<link rel="stylesheet" href="<c:url value="/css/foundation.css" />" />
	</head>
	<body>
		<header class="row">
			<div class="large-12 columns text-center">
				<img src="<c:url value="/img/gotit_logo.png" />" alt="Got it!" />
			</div>
		</header>
		<div class="row">
			<div class="large-12 columns">
				<nav class="top-bar" data-topbar data-options="sticky_on: large">
					<ul class="title-area">
						<li class="name"></li>
						<li class="toggle-topbar menu-icon">
							<a href="#"><span>menu</span></a>
						</li>
					</ul>
					<section class="top-bar-section">
						<ul class="left">
							<li>
								<a href="/">Home</a>
							</li>
							<li>
								<a href="/schools">List of schools</a>
							</li>
							<li>
								<a href="/contacts">Contacts</a>
							</li>
							<li>
								<a href="/about">About</a>
							</li>
						</ul>
						<ul class="right">
							<sec:authorize access="isAnonymous()">
								<li>
									<a href="/users/sign-up">Sign up</a>
								</li>
								<li>
									<a href="/users/sign-in">Sign in</a>
								</li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<li>
									<a href="#">${pageContext.request.userPrincipal.name}</a>
								</li>
								<li>
									<a href="/users/sign-out">Sign out</a>
								</li>
							</sec:authorize>
						</ul>
					</section>
				</nav>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="large-12 columns">
				<c:if test="${not empty successMessage}">
					<div data-alert class="alert-box alert">
						${successMessage}
						<a href="#" class="close">&times;</a>
					</div>
				</c:if>
				<c:if test="${not empty infoMessage}">
					<div data-alert class="alert-box alert">
						${infoMessage}
						<a href="#" class="close">&times;</a>
					</div>
				</c:if>
				<c:if test="${not empty warningMessage}">
					<div data-alert class="alert-box alert">
						${warningMessage}
						<a href="#" class="close">&times;</a>
					</div>
				</c:if>
				<c:if test="${not empty errorMessage}">
					<div data-alert class="alert-box alert">
						${errorMessage}
						<a href="#" class="close">&times;</a>
					</div>
				</c:if>
				<h1><jsp:invoke fragment="title" /></h1>
				<hr />
				<jsp:doBody />
			</div>
		</div>
		<footer class="row">
			<div class="large-12 columns">
				<hr />
				<div class="row">
					<div class="large-12 columns text-center">
						<p>Copyright &copy; 2014 HE-Arc Engineering</p>
					</div>
				</div>
			</div>
		</footer>
		<script src="<c:url value="/js/vendor/modernizr.js" />"></script>
		<script src="<c:url value="/js/vendor/jquery.js" />"></script>
		<script src="<c:url value="/js/foundation/foundation.js" />"></script>
		<script src="<c:url value="/js/foundation/foundation.alert.js" />"></script>
		<script src="<c:url value="/js/foundation/foundation.topbar.js" />"></script>
		<script>
			$(document).foundation();
		</script>
	</body>
</html>
