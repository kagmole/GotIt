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
		<li class="active"><a href="#">Description</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/classes">Classes</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/teachers">Teachers</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/assessments">Assessments</a></li>
		<li><a href="/schools/${courseEntity.module.school.schoolPk}/modules/${courseEntity.module.modulePk}/courses/${courseEntity.coursePk}/exercises">Exercises</a></li>
	</ul>
	<br>
	<p>
		<c:out value="${courseEntity.description}" />
	</p>
</l:standard>
