<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="List of schools">
	<a href="/schools/add" class="btn btn-default" role="button">Create a school</a>
	<c:choose>
		<c:when test="${empty schoolsEntitiesList}">
			<p>There is currently no school.</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped">
				<thead>
					<tr>
						<th colspan="2">School's name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="schoolEntity" items="${schoolsEntitiesList}">
						<tr>
							<td class="col-sm-10"><c:out value="${schoolEntity.name}" /></td>
							<td class="col-sm-2"><a href="/schools/${schoolEntity.schoolPk}">More</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</l:standard>
