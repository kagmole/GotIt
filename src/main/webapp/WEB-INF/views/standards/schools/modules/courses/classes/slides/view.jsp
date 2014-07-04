<%-- JSP DIRECTIVES --%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>

<%-- JSP CONTENT --%>

<l:standard pageTitle="${slideEntity.classEntity.name}'s slides">
	<jsp:attribute name="pageScripts">
		<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
		<script src="http://cdn.ckeditor.com/4.4.2/standard/ckeditor.js"></script>
		<script>
			$(function() {
				var slideId = 0;
				
				$('#gotit-slide-navigation-container').sortable();
				$('#gotit-slide-navigation-container').disableSelection();
				
				$('#gotit-slide-button-add').click( function() {
					$('#gotit-slide-navigation-container').append(
						'<li><a href="#gotit-slide-' + slideId + '"><span class="glyphicon glyphicon-resize-vertical"></span> ' + 'SLIDE_' + slideId + '</a></li>'
					);
					
					$('#gotit-slide-content-container').append(
						'<div class="tab-pane" id="gotit-slide-' + slideId + '"><textarea id="gotit-slide-' + slideId + '-content">' + 'SLIDE_' + slideId + '_CONTENT' + '</textarea></div>'
					);
					
					$('#gotit-slide-navigation-container a[href="#gotit-slide-' + slideId + '"]').click(function(e) {
						e.preventDefault();
						
						$(this).tab('show');
					});
					
					CKEDITOR.replace('gotit-slide-' + slideId + '-content');
					
					++slideId;
				});
			});
		</script>
	</jsp:attribute>
	<jsp:body>
		<form method="POST">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-3">
						<div class="form-group">
							<button id="gotit-slide-button-add" type="button" class="btn btn-success btn-lg btn-block">Add slide</button>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<button type="submit" class="btn btn-warning btn-lg btn-block">Save changes</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<ul id="gotit-slide-navigation-container" class="nav nav-pills nav-stacked">
							<%-- <li[ class="active"]><a href="#SLIDE_ID" data-toggle="pill">#SLIDE_NAME</a></li> --%>
						</ul>
					</div>
					<div class="col-sm-9">
						<div id="gotit-slide-content-container" class="tab-content">
							<%-- <div class="tab-pane [active]" id="#SLIDE_ID">#SLIDE_CONTENT</div> --%>
						</div>
					</div>
				</div>
			</div>
		</form>
	</jsp:body>
</l:standard>
