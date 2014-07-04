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
		<li class="active"><a href="#">Description</a></li>
		<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/courses">Courses</a></li>
		<li><a href="/schools/${moduleEntity.school.schoolPk}/modules/${moduleEntity.modulePk}/dependencies">Dependencies</a></li>
	</ul>
	<br>
	<p>
		<c:out value="${moduleEntity.description}" />
	</p>
</l:standard>
