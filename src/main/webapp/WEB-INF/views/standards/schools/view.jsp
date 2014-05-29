<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<l:standard>
	<jsp:attribute name="title">School's details</jsp:attribute>
	<jsp:body>
		<h2><c:out value="${schoolEntity.name}" /></h2>
		<c:out value="${schoolEntity.description}" /><br />
		<a href="/schools/edit/${schoolEntity.schoolPk}">Edit...</a>
	</jsp:body>
</l:standard>
