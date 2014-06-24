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
	
	desktop.addComponent(link);
	desktop.addComponent(link2);
	desktop.addComponent(link3);
	
	desktop.insertCode(document.getElementById('gotit-page-container'));
})();
