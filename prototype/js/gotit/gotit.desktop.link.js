/**
 * GotIt.Link module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Link = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Link = function(title, icon, actionCallback) {
	
		/* Attributes */
		this.title = title;
		this.icon = icon;
		this.actionCallback = actionCallback;
		
		this.desktop = null;
		
		/* Creation of division elements */
		this.linkDiv = GotIt.createDivWithClassName('gotit-link-component');
		
		this.linkImg = document.createElement('img');
		this.linkImg.src = icon;
		this.linkImg.alt = title;
		
		this.linkP = document.createElement('p');
		this.linkP.textContent = title;
		
		/* Link division elements together */
		this.linkDiv.appendChild(this.linkImg);
		this.linkDiv.appendChild(this.linkP);
		
		/* Creation of bound functions */
		this.linkDivDblClickListener = linkDivDblClickListener.bind(this);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function linkDivDblClickListener(e) {
		this.actionCallback();
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Link.prototype.onAddComponent = function(desktop) {	
		this.linkDiv.addEventListener('dblclick', this.linkDivDblClickListener, false);
		
		desktop.linkContainerDiv.appendChild(this.linkDiv);
		
		this.desktop = desktop;
	}
	
	Link.prototype.onRemoveComponent = function(desktop) {	
		this.linkDiv.removeEventListener('dblclick', this.linkDivDblClickListener, false);
		
		desktop.linkContainerDiv.removeChild(this.linkDiv);
		
		this.desktop = null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Link;
})();
