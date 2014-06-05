<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags" %>
<l:standard pageTitle="Home" showHeader="false">
	<sec:authorize access="isAnonymous()">
		<div class="row">
			<div class="large-4 columns text-center">
				ABOUT
			</div>
			<div class="large-4 columns text-center">
				SIGN UP
			</div>
			<div class="large-4 columns text-center">
				SIGN IN
			</div>
		</div>
		<div class="row">
			<div class="large-6 columns text-center">
				LIST SCHOOLS
			</div>
			<div class="large-6 columns text-center">
				ABOUT
			</div>
		</div>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<!-- TODO -->
	</sec:authorize>
<!-- 
	<div class="row">
		<div class="large-3 columns text-center">
			<a href="/about">
				<img src="http://www.placehold.it/100/ff0000/000000&text=ABOUT" alt="ABOUT" />
			</a>
		</div>
		<div class="large-6 columns text-center">
			<a href="/">
				<img src="http://www.placehold.it/100/0000ff/000000&text=GOT+IT!" alt="GOT IT!" />
			</a>
		</div>
		<div class="large-3 columns text-center">
			
		</div>
	</div>
	<div class="row">
		<div class="large-6 columns text-center">
			<a href="#">
				<img src="http://www.placehold.it/100/ffff00/000000&text=GO+TO+SCHOOL" alt="GO TO SCHOOL" />
			</a>
		</div>
		<div class="large-6 columns text-center">
			<a href="/schools">
				<img src="http://www.placehold.it/100/00ffff/000000&text=LIST+OF+SCHOOLS" alt="LIST OF SCHOOLS" />
			</a>
		</div>
	</div>
	<div class="row">
		<div class="large-6 columns text-center">
		
		</div>
		<div class="large-6 columns text-center">
			<a href="/contacts">
				<img src="http://www.placehold.it/100/00ff00/000000&text=CONTACTS" alt="CONTACTS" />
			</a>
		</div>
	</div>

		<div class="large-3 columns collapse">
			<sec:authorize access="isAnonymous()">
				<a href="/users/sign-in">
					<img src="http://www.placehold.it/300x375/ff00ff/000000&text=SIGN+IN" alt="SIGN IN" />
				</a>
				<a href="/users/sign-up">
					<img src="http://www.placehold.it/300x375/969600/000000&text=SIGN+UP" alt="SIGN UP" />
				</a>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<a href="/users/sign-out">
					<img src="http://www.placehold.it/300x375/ff00ff/000000&text=SIGN+OUT" alt="SIGN OUT" />
				</a>
				<a href="/users">
					<img src="http://www.placehold.it/300x375/969600/000000&text=MY+ACCOUNT" alt="MY ACCOUNT" />
				</a>
			</sec:authorize>
		</div>
	</div>-->
</l:standard>
