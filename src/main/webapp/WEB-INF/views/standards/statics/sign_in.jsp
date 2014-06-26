<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Sign in">
	<form method="POST" class="form-horizontal">
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username</label>
			<div class="col-sm-10">
				<input type="text" name="username" placeholder="Username" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" name="password" class="form-control">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label><input type="checkbox"> Remember me</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>
</l:standard>
