<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<l:standard>
	<jsp:attribute name="title">Edit school</jsp:attribute>
	<jsp:body>
		<sf:form method="POST" commandName="schoolEntity">
			<sf:label path="name">Name</sf:label><sf:input path="name" /><sf:errors path="name" /><br />
			<sf:label path="description">Description</sf:label><sf:textarea path="description" /><sf:errors path="description" /><br />
			
			<input type="submit" value="Edit school" />
		</sf:form>
	</jsp:body>
</l:standard>
