<%@ tag description="Menu page layout using Foundation" pageEncoding="UTF-8" %>
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
		<br />
		<div class="row collapse">
			<div class="large-3 columns">
				<div class="row collapse">
					<div class="large-12 columns">
						<a href="/about">
							<img src="http://www.placehold.it/300x300/ff0000/000000&text=ABOUT" alt="ABOUT" />
						</a>
					</div>
				</div>
				<div class="row collapse">
					<div class="large-12 columns">
						<a href="/contacts">
							<img src="http://www.placehold.it/300x300/00ff00/000000&text=CONTACTS" alt="CONTACTS" />
						</a>
					</div>
				</div>
			</div>
			<div class="large-6 columns">
				<div class="row collapse">
					<div class="large-12 columns">
						<a href="/">
							<img src="http://www.placehold.it/600x200/0000ff/000000&text=GOT+IT!" alt="GOT IT!" />
						</a>
					</div>
				</div>
				<div class="row collapse">
					<div class="large-12 columns">
						<a href="#">
							<img src="http://www.placehold.it/600x200/ffff00/000000&text=GO+TO+SCHOOL" alt="GO TO SCHOOL" />
						</a>
					</div>
				</div>
				<div class="row collapse">
					<div class="large-12 columns">
						<a href="/schools">
							<img src="http://www.placehold.it/600x200/00ffff/000000&text=LIST+OF+SCHOOLS" alt="LIST OF SCHOOLS" />
						</a>
					</div>
				</div>
			</div>
			<div class="large-3 columns">
				<sec:authorize access="isAnonymous()">
					<div class="row collapse">
						<div class="large-12 columns">
							<a href="/users/sign-in">
								<img src="http://www.placehold.it/300x300/ff00ff/000000&text=SIGN+IN" alt="SIGN IN" />
							</a>
						</div>
					</div>
					<div class="row collapse">
						<div class="large-12 columns">
							<a href="/users/sign-up">
								<img src="http://www.placehold.it/300x300/969600/000000&text=SIGN+UP" alt="SIGN UP" />
							</a>
						</div>
					</div>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<div class="row collapse">
						<div class="large-12 columns">
							<a href="/users/sign-out">
								<img src="http://www.placehold.it/300x300/ff00ff/000000&text=SIGN+OUT" alt="SIGN OUT" />
							</a>
						</div>
					</div>
					<div class="row collapse">
						<div class="large-12 columns">
							<a href="/users">
								<img src="http://www.placehold.it/300x300/969600/000000&text=MY+ACCOUNT" alt="MY ACCOUNT" />
							</a>
						</div>
					</div>
				</sec:authorize>
			</div>
		</div>
		<br />
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
