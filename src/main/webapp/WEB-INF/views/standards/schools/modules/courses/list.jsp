<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${moduleEntity.name}'s details">
	<ol class="breadcrumb">
		<li><a href="/">Home</a></li>
		<li><a href="/schools/${moduleEntity.school.schoolPk}"><c:out value="${moduleEntity.school.name}" /></a></li>
		<li class="active"><c:out value="${moduleEntity.name}" /></li>
	</ol>
	<hr>
	<ul class="nav nav-tabs">
		<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}">Description</a></li>
		<li class="active"><a href="#">Courses</a></li>
		<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/dependencies">Dependencies</a></li>
	</ul>
	<br>
	<c:choose>
		<c:when test="${empty coursesEntitiesList}">
			<p>There is currently no courses.</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-bordered">
				<tbody>
					<c:forEach var="courseEntity" items="${coursesEntitiesList}">
						<tr>
							<td>
								<a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses/edit/${courseEntity.coursePk}" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses/delete/${courseEntity.coursePk}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
								<a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses/${courseEntity.coursePk}" class="btn btn-link btn-lg"><c:out value="${courseEntity.name}" /></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="text-center">
				<ul class="pagination">
					<c:choose>
						<c:when test="${currentPageNumber == 1}">
							<li class="disabled"><a href="#">&laquo;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses?page=${currentPageNumber - 1}">&laquo;</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="pageNumberIterator" begin="1" end="${lastPageNumber}">
						<c:choose>
							<c:when test="${currentPageNumber == pageNumberIterator}">
								<li class="active"><a href="#">${pageNumberIterator}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses?page=${pageNumberIterator}">${pageNumberIterator}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPageNumber == lastPageNumber}">
							<li class="disabled"><a href="#">&raquo;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses?page=${currentPageNumber + 1}">&raquo;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	<a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses/add" class="btn btn-success btn-lg btn-block">New course</a>
</l:standard>
