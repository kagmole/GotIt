<%-- JSP DIRECTIVES --%>

<%@ tag description="Base of all pages before login" pageEncoding="UTF-8" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- JSP CONTENT --%>

<c:choose>
	<c:when test="${!requestedWithAjax}">
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
					<div class="gotit-border-layout-north">
						<header id="gotit-standard-header">
							<img src="img/gotit/standard/gotit_logo.png" alt="Got it!" />
						</header>
					</div>
					<div class="gotit-border-layout-middle gotit-vertical-align-middle">
						<div class="gotit-border-layout-center">
							<section id="gotit-standard-body">
								<jsp:doBody />
							</section>
						</div>
					</div>
					<div class="gotit-border-layout-south">
						<footer id="gotit-standard-footer">
							Copyright &copy; Dany Jupille, HE-Arc Engineering
						</footer>
					</div>
				</div>
				<script src="<c:url value="/js/gotit/gotit.js" />"></script>
				<script src="<c:url value="/js/gotit/gotit.standard.js" />"></script>
			</body>
		</html>
	</c:when>
	<c:otherwise>
		<?xml version="1.0" encoding="UTF-8"?>
		<ajax-response>
			<page-title>Got it! - ${pageTitle}</page-title>
			<page-html>
				<%= "<![CDATA[" %>
					<jsp:doBody />
				<%= "]]>" %>
			</page-html>
		</ajax-response>
	</c:otherwise>
</c:choose>
