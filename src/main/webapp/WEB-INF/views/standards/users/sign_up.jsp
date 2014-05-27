<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<l:standard>
	<jsp:attribute name="title">Sign up</jsp:attribute>
	<jsp:body>
		<sf:form method="POST" commandName="userEntity">
			<sf:label path="username">Username</sf:label><sf:input path="username" /><sf:errors path="username" /><br />
			<sf:label path="password">Password</sf:label><sf:password path="password" /><sf:errors path="password" /><br />
			<sf:label path="confirmPassword">Confirm password</sf:label><sf:password path="confirmPassword" /><br />
			<sf:label path="firstname">Firstname</sf:label><sf:input path="firstname" /><sf:errors path="firstname" /><br />
			<sf:label path="lastname">Lastname</sf:label><sf:input path="lastname" /><sf:errors path="lastname" /><br />
			<sf:label path="mainEmail">Main email</sf:label><sf:input path="mainEmail" /><sf:errors path="mainEmail" /><br />
			<sf:label path="confirmMainEmail">Confirm main email</sf:label><sf:input path="confirmMainEmail" /><br />
			<sf:label path="secondaryEmail">Secondary email</sf:label><sf:input path="secondaryEmail" /><sf:errors path="secondaryEmail" /><br />
			<sf:label path="confirmSecondaryEmail">Confirm secondary email</sf:label><sf:input path="confirmSecondaryEmail" /><br />
			<sf:label path="location">Location</sf:label><sf:input path="location" /><sf:errors path="location" /><br />
			<sf:label path="homePhone">Home phone</sf:label><sf:input path="homePhone" /><sf:errors path="homePhone" /><br />
			<sf:label path="privatePhone">Private phone</sf:label><sf:input path="privatePhone" /><sf:errors path="privatePhone" /><br />
			<sf:label path="biography">Biography</sf:label><sf:textarea path="biography" /><sf:errors path="biography" /><br />
			
			<input type="submit" value="Sign up" />
		</sf:form>
	</jsp:body>
</l:standard>
