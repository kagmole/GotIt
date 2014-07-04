<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Create a class">
	<sf:form method="POST" commandName="classEntity" class="form-horizontal">
		<div class="form-group">
			<sf:errors path="name" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="name" cssClass="col-sm-2 control-label">Name</sf:label>
			<div class="col-sm-10">
				<sf:input path="name" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="description" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="description" cssClass="col-sm-2 control-label">Description</sf:label>
			<div class="col-sm-10">
				<sf:textarea path="description" cssClass="form-control" rows="5" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Create a class</button>
			</div>
		</div>
	</sf:form>
</l:standard>
