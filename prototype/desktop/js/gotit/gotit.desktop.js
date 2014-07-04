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
	
	var Desktop = function() {
		
		/* Attributes */
		this.framesList = [];
		this.linksList = [];
		this.gadgetsList = [];
		this.notificationsList = [];
		
		this.nextFrameZIndex = 0;
		
		/* Creation of division elements */
		this.desktopContainerDiv = GotIt.createDivWithClassName('gotit-desktop-container');
		GotIt.setUserSelectEnabled(this.desktopContainerDiv, false);
		
		this.workspaceContainerDiv = GotIt.createDivWithClassName('gotit-workspace-container');
		this.taskbarContainerDiv = GotIt.createDivWithClassName('gotit-taskbar-container');
		
		this.linkContainerDiv = GotIt.createDivWithClassName('gotit-link-container');
		this.gadgetContainerDiv = GotIt.createDivWithClassName('gotit-gadget-container');
		this.notificationContainerDiv = GotIt.createDivWithClassName('gotit-notification-container');
		
		this.menuContainerDiv = GotIt.createDivWithClassName('gotit-menu-container');
		
		/* Link division elements together */
		this.taskbarContainerDiv.appendChild(this.menuContainerDiv);
		
		this.workspaceContainerDiv.appendChild(this.linkContainerDiv);
		this.workspaceContainerDiv.appendChild(this.gadgetContainerDiv);
		this.workspaceContainerDiv.appendChild(this.notificationContainerDiv);
		
		this.desktopContainerDiv.appendChild(this.workspaceContainerDiv);
		this.desktopContainerDiv.appendChild(this.taskbarContainerDiv);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                             PROTOTYPE ADDITION(S)                            |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Desktop.prototype.setCursorType = function(cursorType) {
		this.desktopContainerDiv.style.cursor = cursorType;
	}
	
	Desktop.prototype.addComponent = function(component) {
		component.onAddComponent(this);
	}
	
	Desktop.prototype.removeComponent = function(component) {
		component.onRemoveComponent(this);
	}
	
	Desktop.prototype.insertCode = function(parentElement) {
		parentElement.appendChild(this.desktopContainerDiv);
	}
	
	Desktop.prototype.removeCode = function() {
		this.desktopContainerDiv.parentNode.removeChild(this.desktopContainerDiv);
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Desktop;
})();
