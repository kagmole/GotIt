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
		<li class="active"><a href="#">Description</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/trainings">Trainings</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/modules">Modules</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/employees">Employees</a></li>
		<li><a href="/schools/${schoolEntity.schoolPk}/students">Students</a></li>
	</ul>
	<br>
	<p>
		<c:out value="${schoolEntity.description}" />
	</p>
</l:standard>
