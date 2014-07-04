/**
 * GotIt namespace module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt = (function() {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                              NAMESPACE CREATION                              |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var GotIt = {};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  ENUMERATORS                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	GotIt.CursorType = {
		AUTO: 'auto',
		ALL_SCROLL: 'all-scroll',
		CROSSHAIR: 'crosshair',
		DEFAULT: 'default',
		HELP: 'help',
		INHERIT: 'inherit',
		MOVE: 'move',
		POINTER: 'pointer',
		PROGRESS: 'progress',
		TEXT: 'text',
		VERTICAL_TEXT: 'vertical-text',
		WAIT: 'wait',
		NO_DROP: 'no-drop',
		NOT_ALLOWED: 'not-allowed',
		E_RESIZE: 'e-resize',
		N_RESIZE: 'n-resize',
		S_RESIZE: 's-resize',
		W_RESIZE: 'w-resize',
		COL_RESIZE: 'col-resize',
		ROW_RESIZE: 'row-resize',
		NE_RESIZE: 'ne-resize',
		NW_RESIZE: 'nw-resize',
		SE_RESIZE: 'se-resize',
		SW_RESIZE: 'sw-resize'
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	GotIt.createDivWithClassName = function(className) {
		var divElement = document.createElement('div');
		
		divElement.className = className;
		
		return divElement;
	};
	
	GotIt.createSpanWithClassName = function(className) {
		var spanElement = document.createElement('span');
		
		spanElement.className = className;
		
		return spanElement;
	};
	
	GotIt.setUserSelectEnabled = function(targetElement, userSelectEnabled) {
		if (userSelectEnabled) {
			targetElement.removeEventListener('mousedown', userSelectDisabler, false);
		} else {
			targetElement.addEventListener('mousedown', userSelectDisabler, false);
		}
	};
	
	function userSelectDisabler(e) {
		e.preventDefault();
	}
	
	GotIt.doAjaxGet = function (action, targetElement) {
		var xhr = new XMLHttpRequest();
		
		xhr.timeout = 10000;
		xhr.open('GET', action);
		
		xhr.ontimeout = function() {
			targetElement.innerHTML = 'An error occured while loading (timeout).';
		}
		
		xhr.onprogress = function(e) {
			targetElement.innerHTML = 'Loading... (' + (Math.floor(e.loaded / e.total) * 100) + '%)';
		}
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				targetElement.innerHTML = xhr.responseText.trim();
			}
		}
		
		xhr.send(null);
	};
	
	// XXX Is this prototype addition a good idea?
	// TODO Should recreate our own canvas element
	HTMLCanvasElement.prototype.getRelativeMousePosition = function(e) {
		var totalOffsetX = 0;
		var totalOffsetY = 0;
		
		var currentElement = this;
		
		do {
			totalOffsetX += currentElement.offsetLeft - currentElement.scrollLeft;
			totalOffsetY += currentElement.offsetTop - currentElement.scrollTop;
		} while (currentElement = currentElement.offsetParent);
		
		return {
			x: e.pageX - totalOffsetX,
			y: e.pageY - totalOffsetY
		};
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return GotIt;
})();
