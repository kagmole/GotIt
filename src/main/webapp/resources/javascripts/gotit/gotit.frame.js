/**
 * GotIt.Frame module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Frame = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  ENUMERATORS                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var GrabType = {
		NONE: 0,
		MOVE: 1,
		RESIZE_TOP_LEFT: 2,
		RESIZE_TOP: 3,
		RESIZE_TOP_RIGHT: 4,
		RESIZE_LEFT: 5,
		RESIZE_RIGHT: 6,
		RESIZE_BOTTOM_LEFT: 7,
		RESIZE_BOTTOM: 8,
		RESIZE_BOTTOM_RIGHT: 9
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Frame = function(title, x, y, width, height) {
		
		this.title = title;
		this.x = x;
		this.y = y;
		this.zIndex = 0;
		this.width = width;
		this.height = height;
		
		this.currentGrapType = GrabType.NONE;
		this.maximized = false;
		this.minimized = false;
		
		this.offsetX = 0;
		this.offsetY = 0;
		
		this.titleBlock = GotIt.createDivWithClass('gotit-frame-title');
		this.titleBlock.textContent = this.title;
		
		this.contentBlock = GotIt.createDivWithClass('gotit-frame-content');
		
		this.frameDiv = GotIt.createDivWithClass('gotit-frame-component');
		this.frameDiv.style.left = this.x + 'px';
		this.frameDiv.style.top = this.y + 'px';
		this.frameDiv.style.width = this.width + 'px';
		this.frameDiv.style.height = this.height + 'px';
		
		this.frameTopLeftDiv = GotIt.createDivWithClass('gotit-frame-top-left');
		this.frameTopDiv = GotIt.createDivWithClass('gotit-frame-top');
		this.frameTopRightDiv = GotIt.createDivWithClass('gotit-frame-top-right');
		
		this.frameMiddleLeftDiv = GotIt.createDivWithClass('gotit-frame-middle-left');
		this.frameMiddleDiv = GotIt.createDivWithClass('gotit-frame-middle');
		this.frameMiddleRightDiv = GotIt.createDivWithClass('gotit-frame-middle-right');
		
		this.frameBottomLeftDiv = GotIt.createDivWithClass('gotit-frame-bottom-left');
		this.frameBottomDiv = GotIt.createDivWithClass('gotit-frame-bottom');
		this.frameBottomRightDiv = GotIt.createDivWithClass('gotit-frame-bottom-right');
		
		this.frameDiv.appendChild(this.frameTopLeftDiv);
		this.frameDiv.appendChild(this.frameTopDiv);
		this.frameDiv.appendChild(this.frameTopRightDiv);
		
		this.frameDiv.appendChild(this.frameMiddleLeftDiv);
		this.frameDiv.appendChild(this.frameMiddleDiv);
		this.frameDiv.appendChild(this.frameMiddleRightDiv);
		
		this.frameDiv.appendChild(this.frameBottomLeftDiv);
		this.frameDiv.appendChild(this.frameBottomDiv);
		this.frameDiv.appendChild(this.frameBottomRightDiv);
		
		this.frameDiv.appendChild(this.titleBlock);
		this.frameDiv.appendChild(this.contentBlock);
		
		this.titleBlockMouseDownListener = titleBlockMouseDownListener.bind(this);
		this.titleBlockDblClickListener = titleBlockDblClickListener.bind(this);
		this.frameTopLeftDivMouseDownListener = frameTopLeftDivMouseDownListener.bind(this);
		this.frameTopDivMouseDownListener = frameTopDivMouseDownListener.bind(this);
		this.frameTopRightDivMouseDownListener = frameTopRightDivMouseDownListener.bind(this);
		this.frameMiddleLeftDivMouseDownListener = frameMiddleLeftDivMouseDownListener.bind(this);
		this.frameMiddleRightDivMouseDownListener = frameMiddleRightDivMouseDownListener.bind(this);
		this.frameBottomLeftDivMouseDownListener = frameBottomLeftDivMouseDownListener.bind(this);
		this.frameBottomDivMouseDownListener = frameBottomDivMouseDownListener.bind(this);
		this.frameBottomRightDivMouseDownListener = frameBottomRightDivMouseDownListener.bind(this);
		this.desktopBlockMouseUpListener = desktopBlockMouseUpListener.bind(this);
		this.desktopBlockMouseMoveListener = desktopBlockMouseMoveListener.bind(this);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function setBorderVisible(visible) {
		var value = visible ? null : 'none';
		
		this.frameTopLeftDiv.style.display = value;
		this.frameTopDiv.style.display = value;
		this.frameTopRightDiv.style.display = value;
		
		this.frameMiddleLeftDiv.style.display = value;
		this.frameMiddleRightDiv.style.display = value;
		
		this.frameBottomLeftDiv.style.display = value;
		this.frameBottomDiv.style.display = value;
		this.frameBottomRightDiv.style.display = value;
	}
	
	function titleBlockMouseDownListener(e) {
		this.currentGrabType = GrabType.MOVE;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - this.y;
	}
	
	function titleBlockDblClickListener(e) {
		this.maximized = !this.maximized;
	
		setBorderVisible.bind(this)(!this.maximized);
	
		if (this.maximized) {
			this.frameDiv.style.left = '0px';
			this.frameDiv.style.top = '0px';
		
			this.frameDiv.style.width = '100%';
			this.frameDiv.style.height = '100%';
		} else {
			this.frameDiv.style.left = this.x + 'px';
			this.frameDiv.style.top = this.y + 'px';
		
			this.frameDiv.style.width = this.width + 'px';
			this.frameDiv.style.height = this.height + 'px';
		}
	}
	
	function frameTopLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_TOP_LEFT;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - this.y;
	}
	
	function frameTopDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_TOP;
		
		this.offsetY = e.clientY - this.y;
	}
	
	function frameTopRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_TOP_RIGHT;
		
		this.offsetX = e.clientX - (this.x + this.width);
		this.offsetY = e.clientY - this.y;
	}
	
	function frameMiddleLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_LEFT;
		
		this.offsetX = e.clientX - this.x;
	}
	
	function frameMiddleRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_RIGHT;
		
		this.offsetX = e.clientX - (this.x + this.width);
	}
	
	function frameBottomLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_BOTTOM_LEFT;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - (this.y + this.height);
	}
	
	function frameBottomDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_BOTTOM;
		
		this.offsetY = e.clientY - (this.y + this.height);
	}
	
	function frameBottomRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.RESIZE_BOTTOM_RIGHT;
		
		this.offsetX = e.clientX - (this.x + this.width);
		this.offsetY = e.clientY - (this.y + this.height);
	}
	
	function desktopBlockMouseUpListener(e) {
		this.currentGrabType = GrabType.NONE;
	};
	
	function desktopBlockMouseMoveListener(e) {
		if (this.maximized) {
			return; // TODO moving while maximized should minimized then move instead of aborting
		}
	
		switch (this.currentGrabType) {
			case GrabType.MOVE:
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
				break;
				
			case GrabType.RESIZE_TOP_LEFT:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
				break;
				
			case GrabType.RESIZE_TOP:
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
				break;
				
			case GrabType.RESIZE_TOP_RIGHT:
				this.width = (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
				break;
				
			case GrabType.RESIZE_LEFT:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				break;
				
			case GrabType.RESIZE_RIGHT:
				this.width = (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				break;
				
			case GrabType.RESIZE_BOTTOM_LEFT:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height = (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				break;
				
			case GrabType.RESIZE_BOTTOM:
				this.height = (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				break;
				
			case GrabType.RESIZE_BOTTOM_RIGHT:
				this.width = (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height = (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				break;
		}
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Frame.prototype.sendRequest = function(method, action, parameters) {
		var xhr = new XMLHttpRequest();
		
		xhr.timeout = 10000;
		xhr.open(method, action);
		
		var frame = this;
		
		xhr.ontimeout = function() {
			// TODO error message
		}
		
		xhr.onprogress = function(e) {
		    frame.contentBlock.innerHTML = 'Loading... (' + Math.floor(e.loaded / e.total) + '%)';
		};
		
		xhr.onreadystatechange = function() {	
			if (xhr.readyState == 4) {
				frame.contentBlock.innerHTML = xhr.responseText;
			}
		};
		
		xhr.send(null);
	}
	
	Frame.prototype.onAddComponent = function(desktop) {
		addEvent(this.titleBlock, 'mousedown', this.titleBlockMouseDownListener);
		addEvent(this.titleBlock, 'dblclick', this.titleBlockDblClickListener);
		addEvent(this.frameTopLeftDiv, 'mousedown', this.frameTopLeftDivMouseDownListener);
		addEvent(this.frameTopDiv, 'mousedown', this.frameTopDivMouseDownListener);
		addEvent(this.frameTopRightDiv, 'mousedown', this.frameTopRightDivMouseDownListener);
		addEvent(this.frameMiddleLeftDiv, 'mousedown', this.frameMiddleLeftDivMouseDownListener);
		addEvent(this.frameMiddleRightDiv, 'mousedown', this.frameMiddleRightDivMouseDownListener);
		addEvent(this.frameBottomLeftDiv, 'mousedown', this.frameBottomLeftDivMouseDownListener);
		addEvent(this.frameBottomDiv, 'mousedown', this.frameBottomDivMouseDownListener);
		addEvent(this.frameBottomRightDiv, 'mousedown', this.frameBottomRightDivMouseDownListener);
		addEvent(desktop.desktopBlock, 'mouseup', this.desktopBlockMouseUpListener);
		addEvent(desktop.desktopBlock, 'mousemove', this.desktopBlockMouseMoveListener);
		
		desktop.desktopBlock.appendChild(this.frameDiv);
	}
	
	Frame.prototype.onRemoveComponent = function(desktop) {
		removeEvent(this.titleBlock, 'mousedown', this.titleBlockMouseDownListener);
		removeEvent(this.titleBlock, 'dblclick', this.titleBlockDblClickListener);
		removeEvent(this.frameTopLeftDiv, 'mousedown', this.frameTopLeftDivMouseDownListener);
		removeEvent(this.frameTopDiv, 'mousedown', this.frameTopDivMouseDownListener);
		removeEvent(this.frameTopRightDiv, 'mousedown', this.frameTopRightDivMouseDownListener);
		removeEvent(this.frameMiddleLeftDiv, 'mousedown', this.frameMiddleLeftDivMouseDownListener);
		removeEvent(this.frameMiddleRightDiv, 'mousedown', this.frameMiddleRightDivMouseDownListener);
		removeEvent(this.frameBottomLeftDiv, 'mousedown', this.frameBottomLeftDivMouseDownListener);
		removeEvent(this.frameBottomDiv, 'mousedown', this.frameBottomDivMouseDownListener);
		removeEvent(this.frameBottomRightDiv, 'mousedown', this.frameBottomRightDivMouseDownListener);
		removeEvent(desktop.desktopBlock, 'mouseup', this.desktopBlockMouseUpListener);
		removeEvent(desktop.desktopBlock, 'mousemove', this.desktopBlockMouseMoveListener);
		
		desktop.desktopBlock.removeChild(this.frameDiv);
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Frame;
})();
