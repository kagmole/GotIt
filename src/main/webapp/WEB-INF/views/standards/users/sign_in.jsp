<%@ page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<l:standard>
	<jsp:attribute name="title">Sign in</jsp:attribute>
	<jsp:body>
		<form method="POST">
			<label for="username">Username</label><input type="text" name="username" /><br />
			<label for="password">Password</label><input type="password" name="password" /><br />
			
			<input type="submit" value="Sign in" />
		</form>
	</jsp:body>
</l:standard>
