<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${trainingEntity.name}'s details">
	<ol class="breadcrumb">
		<li><a href="/">Home</a></li>
		<li><a href="/schools/${trainingEntity.school.schoolPk}"><c:out value="${trainingEntity.school.name}" /></a></li>
		<li class="active"><c:out value="${trainingEntity.name}" /></li>
	</ol>
	<hr>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">Description</a></li>
		<li><a href="/schools/${trainingEntity.school.schoolPk}/trainings/${trainingEntity.trainingPk}/modules">Modules</a></li>
		<li><a href="/schools/${trainingEntity.school.schoolPk}/trainings/${trainingEntity.trainingPk}/students">Students</a></li>
	</ul>
	<br>
	<p>
		<c:out value="${trainingEntity.description}" />
	</p>
</l:standard>
