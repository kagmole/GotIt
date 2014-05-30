<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<l:standard>
	<jsp:attribute name="title">List of schools</jsp:attribute>
	<jsp:body>
		<c:choose>
			<c:when test="${empty schoolsEntitiesList}">
				There is no school.
			</c:when>
			<c:otherwise>
				<c:forEach var="schoolEntity" items="${schoolsEntitiesList}">
					<c:out value="${schoolEntity.name}" />
					<a href="/schools/${schoolEntity.schoolPk}">[MORE]</a>
					<a href="/schools/delete/${schoolEntity.schoolPk}">[DELETE]</a>
					<br />
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</jsp:body>
</l:standard>