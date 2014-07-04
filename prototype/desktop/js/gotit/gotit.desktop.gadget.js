/**
 * GotIt.Gadget module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Gadget = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Gadget = function(title, icon) {
		
		/* Attributes */
		this.title = title;
		this.icon = icon;
		
		this.desktop = null;
		
		/* Creation of division elements */
		this.gadgetDiv = GotIt.createDivWithClassName('gotit-gadget-component');
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function getNothingPrivate() {
		return null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Gadget.prototype.onAddComponent = function(desktop) {
		desktop.gadgetContainerDiv.appendChild(this.gadgetDiv);
		
		this.desktop = desktop;
	};
	
	Gadget.prototype.onRemoveComponent = function(desktop) {
		desktop.gadgetContainerDiv.removeChild(this.gadgetDiv);
		
		this.desktop = null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Gadget;
})();
