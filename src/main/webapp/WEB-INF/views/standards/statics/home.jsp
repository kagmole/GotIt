<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Home">
	<nav class="gotit-standard-navigation-container">
		<div class="gotit-row">
			<sec:authorize access="isAnonymous()">
				<div class="gotit-column gotit-column-width-3-of-12">
					<div class="gotit-standard-navigation-component">
						<img src="img/gotit/standard/gotit_menu_about.png" alt="About" />
						<p>About</p>
					</div>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<div class="gotit-standard-navigation-component">
						<img src="img/gotit/standard/gotit_menu_sign_up.png" alt="Sign up" />
						<p>Sign up</p>
					</div>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<div class="gotit-standard-navigation-component">
						<img src="img/gotit/standard/gotit_menu_sign_in.png" alt="Sign in" />
						<p>Sign in</p>
					</div>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<div class="gotit-standard-navigation-component">
						<img src="img/gotit/standard/gotit_menu_contact.png" alt="Contact" />
						<p>Contact</p>
					</div>
				</div>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<!-- TODO -->
			</sec:authorize>
		</div>
	</nav>
</l:standard>
