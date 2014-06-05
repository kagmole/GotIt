<%-- TAG DECLARATION --%>

<%@ tag description="Base for a simple page using Foundation" pageEncoding="UTF-8" %>
<%@ attribute name="showHeader" type="java.lang.Boolean" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- ATTRIBUTES DEFAULT VALUES --%>

<c:if test="${showHeader == null}">
	<c:set var="showHeader" value="${true}" />
</c:if>

<%-- TAG CONTENT --%>

<!DOCTYPE html>
<html class="no-js" lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Got it! - ${pageTitle}</title>
		<link rel="stylesheet" href="<c:url value="/css/foundation.css" />" />
	</head>
	<body>
		<br />
		<c:if test="${showHeader}">
			<header class="row">
				<div class="large-12 columns">
					<div class="row">
						<div class="large-3 columns">
							<a href="/">
								<img src="http://www.placehold.it/300x250/00ff00/000000&text=RETURN" alt="RETURN" />
							</a>
						</div>
						<div class="large-6 columns">
							<a href="/">
								<img src="http://www.placehold.it/600x250/00ff00/000000&text=GOT+IT!" alt="GOT IT!" />
							</a>
						</div>
						<div class="large-3 columns">
							<a href="/">
								<img src="http://www.placehold.it/300x250/00ff00/000000&text=MENU" alt="MENU" />
							</a>
						</div>
					</div>
					<hr />
				</div>
			</header>
		</c:if>
		<jsp:doBody />
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
