<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<l:standard>
	<jsp:attribute name="title">List of schools</jsp:attribute>
	<jsp:body>
		<c:choose>
			<c:when test="${empty schoolsEntitiesList}">
				<p>There is no school.</p>
			</c:when>
			<c:otherwise>
				<div class="row">
					<div class="medium-2 columns">
						<a class="button expand" href="#">&lt;</a>
					</div>
					<div class="medium-8 columns">
						<c:forEach var="schoolEntity" items="${schoolsEntitiesList}">
							<div class="row">
								<div class="small-8 columns">
									<c:out value="${schoolEntity.name}" />
								</div>
								<div class="small-2 columns">
									<a href="/schools/${schoolEntity.schoolPk}">More</a>
								</div>
								<div class="small-2 columns">
									<a href="/schools/delete/${schoolEntity.schoolPk}">Delete</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="medium-2 columns">
						<a class="button expand" href="#">&gt;</a>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</jsp:body>
</l:standard>