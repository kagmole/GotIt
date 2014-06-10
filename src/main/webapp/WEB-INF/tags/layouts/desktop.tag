<%@ tag description="Desktop page layout using Foundation" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="no-js" lang="en">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Got it! - Desktop</title>
		<link rel="stylesheet" href="<c:url value="/css/foundation.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/gotit/gotit.desktop.css" />" />
	</head>
	<body>
		<jsp:doBody />
		
		<%-- Foundation dependencies --%>
		<script src="<c:url value="/js/vendor/modernizr.js" />"></script>
		<script src="<c:url value="/js/vendor/jquery.js" />"></script>
		
		<%-- Foundation framework --%>
		<script src="<c:url value="/js/foundation/foundation.js" />"></script>
		<script src="<c:url value="/js/foundation/foundation.alert.js" />"></script>
		<script src="<c:url value="/js/foundation/foundation.topbar.js" />"></script>
		<script>
			$(document).foundation();
		</script>
		
		<%-- Got it! javascripts --%>
		<script src="<c:url value="/js/gotit/gotit.desktop.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.frame.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.gadget.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.notification.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.shortcut.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.standard.js" />"></script>
		<script src="<c:url value="/js/gotit/gotit.js" />"></script>
	</body>
</html>
