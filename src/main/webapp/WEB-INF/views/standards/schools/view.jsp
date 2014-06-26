<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${schoolEntity.name}'s details">
	<p><c:out value="${schoolEntity.description}" /></p>
	<a href="/schools/edit/${schoolEntity.schoolPk}" class="btn btn-default">Edit</a>
	<a href="/schools/delete/${schoolEntity.schoolPk}" class="btn btn-danger">Delete</a>
</l:standard>
