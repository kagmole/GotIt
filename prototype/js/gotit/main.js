(function() {
	var desktop = new GotIt.Desktop();
	
	var link = new GotIt.Desktop.Link('My schools', 'img/gotit/links/link_my_schools.jpg', function() {
		desktop.addComponent(new GotIt.Desktop.Frame('My schools', 'img/gotit/links/link_my_schools.jpg'));
	});
	
	var link2 = new GotIt.Desktop.Link('My employees', 'img/gotit/links/link_my_employees.jpg', function() {
		desktop.addComponent(new GotIt.Desktop.Frame('My employees', 'img/gotit/links/link_my_employees.jpg'));
	});
	
	var link3 = new GotIt.Desktop.Link('My notifications', 'img/gotit/links/link_my_notifications.jpg', function() {
		desktop.addComponent(new GotIt.Desktop.Notification('My notifications', 'img/gotit/links/link_my_notifications.jpg'));
	});
	
	var link4 = new GotIt.Desktop.Link('Trainings app.', 'img/gotit/links/link_trainings_app.jpg', function() {
		var frame = new GotIt.Desktop.Frame('Trainings app.', 'img/gotit/links/link_trainings_app.jpg');
		var application = new GotIt.Desktop.Application.MyTrainings();
		
		frame.frameContentDiv.appendChild(application.applicationDiv);
		
		desktop.addComponent(frame);
	});
	
	desktop.addComponent(link);
	desktop.addComponent(link2);
	desktop.addComponent(link3);
	desktop.addComponent(link4);
	
	desktop.insertCode(document.getElementById('gotit-page-container'));
})();
