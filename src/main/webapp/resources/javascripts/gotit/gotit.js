(function() {

	window.GotIt = {
		Desktop: (typeof gotItDesktopModule !== 'undefined' ? gotItDesktopModule : null),
		Frame: (typeof gotItFrameModule !== 'undefined' ? gotItFrameModule : null),
		Gadget: (typeof GadgetModule !== 'undefined' ? GadgetModule : null),
		Notification: (typeof NotificationModule !== 'undefined' ? NotificationModule : null),
		Shortcut: (typeof gotItShortcutModule !== 'undefined' ? gotItShortcutModule : null),
		Standard: (typeof StandardModule !== 'undefined' ? StandardModule : null)
	}
	
	var myDesktop = new GotIt.Desktop('page-container');
	
	myDesktop.addComponent(new GotIt.Shortcut('Prout frame', 'prout', '/desktop/test'));
	myDesktop.addComponent(new GotIt.Shortcut('Tutu frame', 'prout', '/desktop/test'));
	
	myDesktop.insertCode();
})();
