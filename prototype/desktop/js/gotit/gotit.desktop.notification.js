/**
 * GotIt.Notification module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Notification = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Notification = function(title, icon) {
		
		/* Attributes */
		this.title = title;
		this.icon = icon;
		
		this.desktop = null;
		
		/* Creation of division elements */
		this.notificationDiv = GotIt.createDivWithClassName('gotit-notification-component');
		
		this.notificationTextDiv = GotIt.createDivWithClassName('gotit-notification-text');
		this.notificationIconDiv = GotIt.createDivWithClassName('gotit-notification-icon');
		this.notificationButtonCloseDiv = GotIt.createDivWithClassName('gotit-notification-button');
		
		/* Link division elements together */
		this.notificationDiv.appendChild(this.notificationTextDiv);
		this.notificationDiv.appendChild(this.notificationIconDiv);
		this.notificationDiv.appendChild(this.notificationButtonCloseDiv);
		
		/* Creation of bound functions */
		this.close = close.bind(this);
		
		this.notificationButtonCloseDivClickListener = notificationButtonCloseDivClickListener.bind(this);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function close() {
		this.desktop.removeComponent(this);
	}
	
	function notificationButtonCloseDivClickListener(e) {
		this.close();
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Notification.prototype.onAddComponent = function(desktop) {
		this.notificationButtonCloseDiv.addEventListener('click', this.notificationButtonCloseDivClickListener, false);
		
		desktop.notificationContainerDiv.appendChild(this.notificationDiv);
		
		this.desktop = desktop;
	};
	
	Notification.prototype.onRemoveComponent = function(desktop) {
		this.notificationButtonCloseDiv.removeEventListener('click', this.notificationButtonCloseDivClickListener, false);
		
		desktop.notificationContainerDiv.removeChild(this.notificationDiv);
		
		this.desktop = null;
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Notification;
})();
