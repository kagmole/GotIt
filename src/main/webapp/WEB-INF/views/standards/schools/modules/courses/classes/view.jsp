<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${classEntity.name}'s details">
	<ol class="breadcrumb">
		<li><a href="/">Home</a></li>
		<li><a href="/schools/${classEntity.course.module.school.schoolPk}"><c:out value="${classEntity.course.module.school.name}" /></a></li>
		<li><a href="/schools/${classEntity.course.module.school.schoolPk}/modules/${classEntity.course.module.modulePk}"><c:out value="${classEntity.course.module.name}" /></a></li>
		<li><a href="/schools/${classEntity.course.module.school.schoolPk}/modules/${classEntity.course.module.modulePk}/courses/${classEntity.course.coursePk}"><c:out value="${classEntity.course.name}" /></a></li>
		<li class="active"><c:out value="${classEntity.name}" /></li>
	</ol>
	<hr>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">Description</a></li>
		<li><a href="/schools/${classEntity.course.module.school.schoolPk}/modules/${classEntity.course.module.modulePk}/courses/${classEntity.course.coursePk}/classes/${classEntity.classPk}/slides">Slides</a></li>
	</ul>
	<br>
	<p>
		<c:out value="${classEntity.description}" />
	</p>
</l:standard>
