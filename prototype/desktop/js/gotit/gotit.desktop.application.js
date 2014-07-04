/**
 * GotIt.Application module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Application = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Application = function(title, icon) {
	
		/* Attributes */
		this.title = title;
		this.icon = icon;
		
		this.desktop = null;
		
		/* Creation of division elements */
		//this.linkDiv = GotIt.createDivWithClassName('gotit-link-component');
		
		/* Link division elements together */
		//this.linkDiv.appendChild(this.linkImg);
		
		/* Creation of bound functions */
		//this.linkDivDblClickListener = linkDivDblClickListener.bind(this);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function getNothingPrivate() {
		return null;
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Application.prototype.onAddComponent = function(desktop) {
		this.desktop = desktop;
	}
	
	Application.prototype.onRemoveComponent = function(desktop) {
		this.desktop = null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Application;
})();
