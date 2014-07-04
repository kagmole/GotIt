<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="List of slides">
	<c:choose>
		<c:when test="${empty slidesEntitiesList}">
			<p>There is currently no slide.</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped">
				<thead>
					<tr>
						<th colspan="2">Slide's PK</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="slideEntity" items="${slidesEntitiesList}">
						<tr>
							<td class="col-sm-12"><c:out value="${slideEntity.slidePk}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</l:standard>
