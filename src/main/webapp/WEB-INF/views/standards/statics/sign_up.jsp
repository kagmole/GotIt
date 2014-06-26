<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Sign up">
	<sf:form method="POST" commandName="userEntity" class="form-horizontal">
		<div class="form-group">
			<sf:errors path="username" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="username" cssClass="col-sm-2 control-label">Username</sf:label>
			<div class="col-sm-10">
				<sf:input path="username" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="password" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="password" cssClass="col-sm-2 control-label">Password</sf:label>
			<div class="col-sm-10">
				<sf:password path="password" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="confirmPassword" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="confirmPassword" cssClass="col-sm-2 control-label">Confirm password</sf:label>
			<div class="col-sm-10">
				<sf:password path="confirmPassword" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="firstname" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="firstname" cssClass="col-sm-2 control-label">Firstname</sf:label>
			<div class="col-sm-10">
				<sf:input path="firstname" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="lastname" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="lastname" cssClass="col-sm-2 control-label">Lastname</sf:label>
			<div class="col-sm-10">
				<sf:input path="lastname" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="mainEmail" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="mainEmail" cssClass="col-sm-2 control-label">Main email</sf:label>
			<div class="col-sm-10">
				<sf:input type="email" path="mainEmail" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="confirmMainEmail" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="confirmMainEmail" cssClass="col-sm-2 control-label">Confirm main email</sf:label>
			<div class="col-sm-10">
				<sf:input type="email" path="confirmMainEmail" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="secondaryEmail" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="secondaryEmail" cssClass="col-sm-2 control-label">Secondary email</sf:label>
			<div class="col-sm-10">
				<sf:input type="email" path="secondaryEmail" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="confirmSecondaryEmail" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="confirmSecondaryEmail" cssClass="col-sm-2 control-label">Confirm secondary email</sf:label>
			<div class="col-sm-10">
				<sf:input type="email" path="confirmSecondaryEmail" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="location" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="location" cssClass="col-sm-2 control-label">Location</sf:label>
			<div class="col-sm-10">
				<sf:input path="location" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="homePhone" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="homePhone" cssClass="col-sm-2 control-label">Home phone</sf:label>
			<div class="col-sm-10">
				<sf:input path="homePhone" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="privatePhone" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="privatePhone" cssClass="col-sm-2 control-label">Private phone</sf:label>
			<div class="col-sm-10">
				<sf:input path="privatePhone" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<sf:errors path="biography" cssClass="col-sm-offset-2 col-sm-10" />
			<sf:label path="biography" cssClass="col-sm-2 control-label">Biography</sf:label>
			<div class="col-sm-10">
				<sf:textarea path="biography" cssClass="form-control" rows="5" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign up</button>
			</div>
		</div>
	</sf:form>
</l:standard>
