<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${courseEntity.name}'s details">
	<ol class="breadcrumb">
		<li><a href="/">Home</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}"><c:out value="${courseEntity.module.school.name}" /></a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}"><c:out value="${courseEntity.module.name}" /></a></li>
		<li class="active"><c:out value="${courseEntity.name}" /></li>
	</ol>
	<hr>
	<ul class="nav nav-tabs">
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}">Description</a></li>
		<li class="active"><a href="#">Classes</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/teachers">Teachers</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/assessments">Assessments</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/exercises">Exercises</a></li>
	</ul>
	<br>
	<c:choose>
		<c:when test="${empty classesEntitiesList}">
			<p>There is currently no classes.</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-bordered">
				<tbody>
					<c:forEach var="classEntity" items="${classesEntitiesList}">
						<tr>
							<td>
								<a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes/edit/${classEntity.classPk}" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes/delete/${classEntity.classPk}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
								<a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes/${classEntity.classPk}" class="btn btn-link btn-lg"><c:out value="${classEntity.name}" /></a>
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
							<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes?page=${currentPageNumber - 1}">&laquo;</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="pageNumberIterator" begin="1" end="${lastPageNumber}">
						<c:choose>
							<c:when test="${currentPageNumber == pageNumberIterator}">
								<li class="active"><a href="#">${pageNumberIterator}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes?page=${pageNumberIterator}">${pageNumberIterator}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPageNumber == lastPageNumber}">
							<li class="disabled"><a href="#">&raquo;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes?page=${currentPageNumber + 1}">&raquo;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	<a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes/add" class="btn btn-success btn-lg btn-block">New class</a>
</l:standard>
