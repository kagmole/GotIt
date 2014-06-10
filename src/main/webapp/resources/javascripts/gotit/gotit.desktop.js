/**
 * Got it! - Desktop module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
var gotItDesktopModule = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Desktop = function(parentId) {
	
		this.parentElement = document.getElementById(parentId);
		
		this.gadgetBlock = createBlockWithClass('gotit-gadget-container');
		this.notificationBlock = createBlockWithClass('gotit-notification-container');
		this.shortcutBlock = createBlockWithClass('gotit-shortcut-container');
		
		this.desktopBlock = createBlockWithClass('gotit-desktop-container');
		
		this.desktopBlock.appendChild(this.gadgetBlock);
		this.desktopBlock.appendChild(this.notificationBlock);
		this.desktopBlock.appendChild(this.shortcutBlock);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function createBlockWithClass(className) {
		var block = document.createElement('div');
		block.className = className;
		
		return block;
	}
	
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
		this.parentElement.appendChild(this.desktopBlock);
	}
	
	Desktop.prototype.removeCode = function() {
		this.parentElement.removeChild(this.desktopBlock);
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Desktop;
})();
