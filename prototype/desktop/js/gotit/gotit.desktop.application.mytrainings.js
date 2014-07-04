/**
 * Got it! - Application "My Trainings"
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Application.MyTrainings = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var MyTrainings = function(title, icon) {
	
		/* Attributes */
		this.title = title;
		this.icon = icon;
		
		this.desktop = null;
		
		/* Creation of division elements */
		this.applicationDiv = GotIt.createDivWithClassName('gotit-application-component');
		
		this.applicationBorderLayoutDiv = GotIt.createDivWithClassName('gotit-border-layout');
		this.applicationBorderLayoutMiddleDiv = GotIt.createDivWithClassName('gotit-border-layout-middle');
		this.applicationBorderLayoutWestDiv = GotIt.createDivWithClassName('gotit-border-layout-west');
		this.applicationBorderLayoutCenterDiv = GotIt.createDivWithClassName('gotit-border-layout-center');
		
		this.applicationMainCanvas = document.createElement('canvas');
		this.applicationMainCanvas.width = 500;
		this.applicationMainCanvas.height = 500;
		
		this.applicationMainCanvasContext = this.applicationMainCanvas.getContext('2d');
		
		/* Link division elements together */
		this.applicationBorderLayoutCenterDiv.appendChild(this.applicationMainCanvas);
		
		this.applicationBorderLayoutMiddleDiv.appendChild(this.applicationBorderLayoutWestDiv);
		this.applicationBorderLayoutMiddleDiv.appendChild(this.applicationBorderLayoutCenterDiv);
		
		this.applicationBorderLayoutDiv.appendChild(this.applicationBorderLayoutMiddleDiv);
		
		this.applicationDiv.appendChild(this.applicationBorderLayoutDiv);
		
		/* Creation of bound functions */
		this.applicationMainCanvasMouseDownListener = applicationMainCanvasMouseDownListener.bind(this);
		
		// TODO clean
		this.applicationMainCanvas.addEventListener('mousedown', this.applicationMainCanvasMouseDownListener, false);
		
		this.applicationMainCanvasContext.fillStyle = '#ffffff';
		this.applicationMainCanvasContext.fillRect(0, 0, 500, 500);
		this.applicationMainCanvasContext.fillStyle = '#000000';
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function applicationMainCanvasMouseDownListener(e) {
		var coords = this.applicationMainCanvas.getRelativeMousePosition(e);
		
		this.applicationMainCanvasContext.fillRect(coords.x, coords.y, 5, 5);
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	MyTrainings.prototype.getNothingPublic = function() {
		return null;
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return MyTrainings;
})();
