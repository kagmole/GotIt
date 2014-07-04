<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${schoolEntity.name}'s details">
	<ol class="breadcrumb">
		<li><a href="/">Home</a></li>
		<li class="active"><c:out value="${schoolEntity.name}" /></li>
	</ol>
	<hr>
	<ul class="nav nav-tabs">
		<li><a href="/schools/${schoolEntity.schoolPk}">Description</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/trainings">Trainings</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/modules">Modules</a></li>
		<li class="active"><a href="#">Employees</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/students">Students</a></li>
	</ul>
	<br>
	<c:choose>
		<c:when test="${empty employeesEntitiesList}">
			<p>There is currently no employees.</p>
		</c:when>
		<c:otherwise>
			<table class="table table-striped table-bordered">
				<tbody>
					<c:forEach var="employeeEntity" items="${employeesEntitiesList}">
						<tr>
							<td>
								<a href="/schools/${schoolEntity.schoolPk}/employees/edit/${employeeEntity.employeePk}" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="/schools/${schoolEntity.schoolPk}/employees/delete/${employeeEntity.employeePk}" class="btn btn-danger"><span class="glyphicon glyphicon-remove"></span></a>
								<a href="/users/${employeeEntity.user.userPk}" class="btn btn-link btn-lg"><c:out value="${employeeEntity.user.lastname}" /> <c:out value="${employeeEntity.user.firstname}" /></a>
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
							<li><a href="/schools/${schoolEntity.schoolPk}/employees?page=${currentPageNumber - 1}">&laquo;</a></li>
						</c:otherwise>
					</c:choose>
					<c:forEach var="pageNumberIterator" begin="1" end="${lastPageNumber}">
						<c:choose>
							<c:when test="${currentPageNumber == pageNumberIterator}">
								<li class="active"><a href="#">${pageNumberIterator}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/schools/${schoolEntity.schoolPk}/employees?page=${pageNumberIterator}">${pageNumberIterator}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:choose>
						<c:when test="${currentPageNumber == lastPageNumber}">
							<li class="disabled"><a href="#">&raquo;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/schools/${schoolEntity.schoolPk}/employees?page=${currentPageNumber + 1}">&raquo;</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
	<a href="/schools/${schoolEntity.schoolPk}/employees/add" class="btn btn-success btn-lg btn-block">New employee</a>
</l:standard>
