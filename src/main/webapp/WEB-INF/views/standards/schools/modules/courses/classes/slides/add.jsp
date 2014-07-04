<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Create a slide">
	<sf:form method="POST" commandName="slideEntity" class="form-horizontal">
		<div class="form-group">
			<sf:errors path="content" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="content" cssClass="col-sm-2 control-label">Content</sf:label>
			<div class="col-sm-10">
				<sf:textarea path="content" cssClass="form-control" rows="10" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Create a slide</button>
			</div>
		</div>
	</sf:form>
</l:standard>
