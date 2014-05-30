<%@ tag description="Standard page layout" pageEncoding="UTF-8" %>
<%@ attribute name="title" fragment="true" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Got it! - <jsp:invoke fragment="title" /></title>
	</head>
	<body>
		<div id="page-header">
			<h1><jsp:invoke fragment="title" /></h1>
		</div>
		<div id="page-body">
			<jsp:doBody />
		</div>
		<div id="page-footer">
			Copyright 2014
		</div>
	</body>
</html>
