<%-- JSP DIRECTIVES --%>

<%@ tag description="Base of all pages before login" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- JSP CONTENT --%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Got it! - ${pageTitle}</title>
		<link rel="stylesheet" href="<c:url value="/css/gotit.css" />" />
	</head>
	<body>
		<div class="gotit-border-layout">
			<header class="gotit-border-layout-north">
				<div class="gotit-standard-logo-container">
					<img src="img/gotit/standard/gotit_logo.png" alt="Got it!" />
				</div>
			</header>
			<section class="gotit-border-layout-center">
				<div class="gotit-standard-body-container">
					<jsp:doBody />
				</div>
			</section>
			<footer class="gotit-border-layout-south">
				<div class="gotit-standard-copyright-container">
					Copyright &copy; Dany Jupille, HE-Arc Engineering
				</div>
			</footer>
		</div>
		<script src="<c:url value="/js/gotit/gotit.standard.js" />"></script>
	</body>
</html>
