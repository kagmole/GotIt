<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="Home">
	<nav class="gotit-standard-navigation-container">
		<sec:authorize access="isAnonymous()">
			<div class="gotit-row">
				<div class="gotit-column gotit-column-width-3-of-12">
					<a href="/about" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_about.png" alt="About" />
							<p>About</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<a href="/sign-up" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_sign_up.png" alt="Sign up" />
							<p>Sign up</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<a href="/sign-in" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_sign_in.png" alt="Sign in" />
							<p>Sign in</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-3-of-12">
					<a href="/contact" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_contact.png" alt="Contact" />
							<p>Contact</p>
						</div>
					</a>
				</div>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div class="gotit-row">
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="#" onclick="alert('TODO'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_my_profile.png" alt="My profile" />
							<p>My profile</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="#" onclick="alert('TODO'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_list_of_schools.png" alt="List of schools" />
							<p>List of schools</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="#" onclick="alert('TODO'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_my_schools.png" alt="My schools" />
							<p>My schools</p>
						</div>
					</a>
				</div>
			</div>
			<div class="gotit-row">
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="/about" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_about.png" alt="About" />
							<p>About</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="/contact" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_contact.png" alt="Contact" />
							<p>Contact</p>
						</div>
					</a>
				</div>
				<div class="gotit-column gotit-column-width-4-of-12">
					<a href="/sign-in" onclick="GotIt.doAjaxGet(this, 'gotit-standard-body-container'); return false;">
						<div class="gotit-standard-navigation-component">
							<img src="img/gotit/standard/gotit_menu_sign_out.png" alt="Sign out" />
							<p>Sign out</p>
						</div>
					</a>
				</div>
			</div>
		</sec:authorize>
	</nav>
</l:standard>
