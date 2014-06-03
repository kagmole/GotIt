<%@ tag description="Desktop page layout" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Got it! - Desktop</title>
		<link href="<c:url value="/css/desktop.css" />" rel="stylesheet">
	</head>
	<body>
		<jsp:doBody />
		<script src="<c:url value="/js/desktop.js" />"></script>
	</body>
</html>
