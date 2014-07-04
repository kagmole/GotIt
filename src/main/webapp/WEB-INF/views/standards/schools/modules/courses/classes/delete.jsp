<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Delete ${classEntity.name}">
	<form method="POST" class="form-horizontal">
		<p>Are you sure you want to delete <c:out value="${classEntity.name}" />?</p>
		<button type="submit" class="btn btn-danger">Confirm delete</button>
	</form>
</l:standard>
