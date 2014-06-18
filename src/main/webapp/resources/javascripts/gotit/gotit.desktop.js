/**
 * GotIt.Desktop module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Desktop = function(parentId) {
	
		this.parentElement = document.getElementById(parentId);
		
		this.gadgetDiv = GotIt.createDivWithClass('gotit-gadget-container');
		this.notificationDiv = GotIt.createDivWithClass('gotit-notification-container');
		this.shortcutDiv = GotIt.createDivWithClass('gotit-shortcut-container');
		
		this.desktopDiv = GotIt.createDivWithClass('gotit-desktop-container');
		
		this.desktopDiv.appendChild(this.gadgetDiv);
		this.desktopDiv.appendChild(this.notificationDiv);
		this.desktopDiv.appendChild(this.shortcutDiv);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Desktop.prototype.addComponent = function(component) {
		component.onAddComponent(this);
	}
	
	Desktop.prototype.removeComponent = function(component) {
		component.onRemoveComponent(this);
	}
	
	Desktop.prototype.insertCode = function() {
		this.parentElement.appendChild(this.desktopDiv);
	}
	
	Desktop.prototype.removeCode = function() {
		this.parentElement.removeChild(this.desktopDiv);
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Desktop;
})();
