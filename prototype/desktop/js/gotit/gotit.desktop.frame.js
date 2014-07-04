/**
 * GotIt.Frame module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Desktop.Frame = (function() {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  ENUMERATORS                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var GrabType = {
		NONE: 0,
		MOVE: 1,
		NW_RESIZE: 2,
		N_RESIZE: 3,
		NE_RESIZE: 4,
		W_RESIZE: 5,
		E_RESIZE: 6,
		SW_RESIZE: 7,
		S_RESIZE: 8,
		SE_RESIZE: 9
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Frame = function(title, icon) {
		
		/* Attributes */
		this.title = title;
		this.x = 0;
		this.y = 0;
		this.zIndex = 0;
		this.width = 400;
		this.height = 300;
		
		this.currentGrapType = GrabType.NONE;
		this.maximized = false;
		this.minimized = false;
		
		this.offsetX = 0;
		this.offsetY = 0;
		
		this.desktop = null;
		
		/* Creation of division elements */
		this.frameDiv = GotIt.createDivWithClassName('gotit-frame-component');
		
		this.frameTopLeftDiv = GotIt.createDivWithClassName('gotit-frame-top-left');
		this.frameTopDiv = GotIt.createDivWithClassName('gotit-frame-top');
		this.frameTopRightDiv = GotIt.createDivWithClassName('gotit-frame-top-right');
		
		this.frameMiddleLeftDiv = GotIt.createDivWithClassName('gotit-frame-middle-left');
		this.frameMiddleDiv = GotIt.createDivWithClassName('gotit-frame-middle');
		this.frameMiddleRightDiv = GotIt.createDivWithClassName('gotit-frame-middle-right');
		
		this.frameBottomLeftDiv = GotIt.createDivWithClassName('gotit-frame-bottom-left');
		this.frameBottomDiv = GotIt.createDivWithClassName('gotit-frame-bottom');
		this.frameBottomRightDiv = GotIt.createDivWithClassName('gotit-frame-bottom-right');
		
		this.frameTitleBarDiv = GotIt.createDivWithClassName('gotit-frame-title-bar');
		this.frameContentDiv = GotIt.createDivWithClassName('gotit-frame-content');
		
		this.frameTitleTextSpan = GotIt.createSpanWithClassName('gotit-frame-title-text');
		this.frameTitleTextSpan.textContent = this.title;
		
		this.frameTitleIconSpan = GotIt.createSpanWithClassName('gotit-frame-title-icon');
		
		this.frameTitleButtonMinimizeSpan = GotIt.createSpanWithClassName('gotit-frame-title-button');
		this.frameTitleButtonMaximizeSpan = GotIt.createSpanWithClassName('gotit-frame-title-button');
		this.frameTitleButtonCloseSpan = GotIt.createSpanWithClassName('gotit-frame-title-button');
		
		this.frameMiniatureSpan = GotIt.createSpanWithClassName('gotit-frame-miniature');
		this.frameMiniatureSpan.textContent = this.title;
		
		/* Link division elements together */
		this.frameTitleBarDiv.appendChild(this.frameTitleTextSpan);
		this.frameTitleBarDiv.appendChild(this.frameTitleIconSpan);
		this.frameTitleBarDiv.appendChild(this.frameTitleButtonCloseSpan);
		this.frameTitleBarDiv.appendChild(this.frameTitleButtonMaximizeSpan);
		this.frameTitleBarDiv.appendChild(this.frameTitleButtonMinimizeSpan);
		
		this.frameMiddleDiv.appendChild(this.frameTitleBarDiv);
		this.frameMiddleDiv.appendChild(this.frameContentDiv);
		
		this.frameDiv.appendChild(this.frameTopLeftDiv);
		this.frameDiv.appendChild(this.frameTopDiv);
		this.frameDiv.appendChild(this.frameTopRightDiv);
		
		this.frameDiv.appendChild(this.frameMiddleLeftDiv);
		this.frameDiv.appendChild(this.frameMiddleDiv);
		this.frameDiv.appendChild(this.frameMiddleRightDiv);
		
		this.frameDiv.appendChild(this.frameBottomLeftDiv);
		this.frameDiv.appendChild(this.frameBottomDiv);
		this.frameDiv.appendChild(this.frameBottomRightDiv);
		
		/* Creation of bound functions */
		this.toggleMinimized = toggleMinimized.bind(this);
		this.toggleMaximized = toggleMaximized.bind(this);
		this.close = close.bind(this);
		this.setBorderDisplayed = setBorderDisplayed.bind(this);
		this.setZIndex = setZIndex.bind(this);
		
		this.frameDivMouseDownListener = frameDivMouseDownListener.bind(this);
		this.frameTitleBarDivMouseDownListener = frameTitleBarDivMouseDownListener.bind(this);
		this.frameTitleBarDivDblClickListener = frameTitleBarDivDblClickListener.bind(this);
		this.frameTitleButtonMinimizeSpanClickListener = frameTitleButtonMinimizeSpanClickListener.bind(this);
		this.frameTitleButtonMaximizeSpanClickListener = frameTitleButtonMaximizeSpanClickListener.bind(this);
		this.frameTitleButtonCloseSpanClickListener = frameTitleButtonCloseSpanClickListener.bind(this);
		this.frameTopLeftDivMouseDownListener = frameTopLeftDivMouseDownListener.bind(this);
		this.frameTopDivMouseDownListener = frameTopDivMouseDownListener.bind(this);
		this.frameTopRightDivMouseDownListener = frameTopRightDivMouseDownListener.bind(this);
		this.frameMiddleLeftDivMouseDownListener = frameMiddleLeftDivMouseDownListener.bind(this);
		this.frameMiddleRightDivMouseDownListener = frameMiddleRightDivMouseDownListener.bind(this);
		this.frameBottomLeftDivMouseDownListener = frameBottomLeftDivMouseDownListener.bind(this);
		this.frameBottomDivMouseDownListener = frameBottomDivMouseDownListener.bind(this);
		this.frameBottomRightDivMouseDownListener = frameBottomRightDivMouseDownListener.bind(this);
		this.frameMiniatureSpanClickListener = frameMiniatureSpanClickListener.bind(this);
		this.desktopContainerDivMouseUpListener = desktopContainerDivMouseUpListener.bind(this);
		this.desktopContainerDivMouseMoveListener = desktopContainerDivMouseMoveListener.bind(this);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	function toggleMinimized() {
		this.minimized = !this.minimized;
		
		var displayValue = !this.minimized ? null : 'none';
		
		this.frameDiv.style.display = displayValue;
	}
	
	function toggleMaximized() {
		this.maximized = !this.maximized;
		
		this.setBorderDisplayed(!this.maximized);
		
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
	
	function close() {
		this.desktop.removeComponent(this);
	}
	
	function setBorderDisplayed(displayed) {
		var displayValue = displayed ? null : 'none';
		var middlePosition = displayed ? null : '0px';
		
		this.frameTopLeftDiv.style.display = displayValue;
		this.frameTopDiv.style.display = displayValue;
		this.frameTopRightDiv.style.display = displayValue;
		
		this.frameMiddleLeftDiv.style.display = displayValue;
		this.frameMiddleRightDiv.style.display = displayValue;
		
		this.frameBottomLeftDiv.style.display = displayValue;
		this.frameBottomDiv.style.display = displayValue;
		this.frameBottomRightDiv.style.display = displayValue;
		
		this.frameMiddleDiv.style.top = middlePosition;
		this.frameMiddleDiv.style.bottom = middlePosition;
		this.frameMiddleDiv.style.left = middlePosition;
		this.frameMiddleDiv.style.right = middlePosition;
	}
	
	function setZIndex(zIndex) {
		this.zIndex = zIndex;
		
		this.frameDiv.style.zIndex = zIndex;
	}
	
	function frameDivMouseDownListener(e) {
		this.setZIndex(this.desktop.nextFrameZIndex++);
	}
	
	function frameTitleBarDivMouseDownListener(e) {
		this.currentGrabType = GrabType.MOVE;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - this.y;
		
		this.desktop.setCursorType(GotIt.CursorType.MOVE);
	}
	
	function frameTitleBarDivDblClickListener(e) {
		this.toggleMaximized();
	}
	
	function frameTitleButtonMinimizeSpanClickListener(e) {
		this.toggleMinimized();
	}
	
	function frameTitleButtonMaximizeSpanClickListener(e) {
		this.toggleMaximized();
	}
	
	function frameTitleButtonCloseSpanClickListener(e) {
		this.close();
	}
	
	function frameTopLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.NW_RESIZE;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - this.y;
		
		this.desktop.setCursorType(GotIt.CursorType.NW_RESIZE);
	}
	
	function frameTopDivMouseDownListener(e) {
		this.currentGrabType = GrabType.N_RESIZE;
		
		this.offsetY = e.clientY - this.y;
		
		this.desktop.setCursorType(GotIt.CursorType.N_RESIZE);
	}
	
	function frameTopRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.NE_RESIZE;
		
		this.offsetX = e.clientX - (this.x + this.width);
		this.offsetY = e.clientY - this.y;
		
		this.desktop.setCursorType(GotIt.CursorType.NE_RESIZE);
	}
	
	function frameMiddleLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.W_RESIZE;
		
		this.offsetX = e.clientX - this.x;
		
		this.desktop.setCursorType(GotIt.CursorType.W_RESIZE);
	}
	
	function frameMiddleRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.E_RESIZE;
		
		this.offsetX = e.clientX - (this.x + this.width);
		
		this.desktop.setCursorType(GotIt.CursorType.E_RESIZE);
	}
	
	function frameBottomLeftDivMouseDownListener(e) {
		this.currentGrabType = GrabType.SW_RESIZE;
		
		this.offsetX = e.clientX - this.x;
		this.offsetY = e.clientY - (this.y + this.height);
		
		this.desktop.setCursorType(GotIt.CursorType.SW_RESIZE);
	}
	
	function frameBottomDivMouseDownListener(e) {
		this.currentGrabType = GrabType.S_RESIZE;
		
		this.offsetY = e.clientY - (this.y + this.height);
		
		this.desktop.setCursorType(GotIt.CursorType.S_RESIZE);
	}
	
	function frameBottomRightDivMouseDownListener(e) {
		this.currentGrabType = GrabType.SE_RESIZE;
		
		this.offsetX = e.clientX - (this.x + this.width);
		this.offsetY = e.clientY - (this.y + this.height);
		
		this.desktop.setCursorType(GotIt.CursorType.SE_RESIZE);
	}
	
	function frameMiniatureSpanClickListener(e) {
		this.toggleMinimized();
		
		if (!this.minimized) {
			this.setZIndex(this.desktop.nextFrameZIndex++);
		}
	}
	
	function desktopContainerDivMouseUpListener(e) {
		this.currentGrabType = GrabType.NONE;
		
		this.desktop.setCursorType(GotIt.CursorType.AUTO);
	};
	
	function desktopContainerDivMouseMoveListener(e) {
		if (this.maximized) {
			return;
		}
		
		switch (this.currentGrabType) {
			case GrabType.MOVE:
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
			break;
				
			case GrabType.NW_RESIZE:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
			break;
				
			case GrabType.N_RESIZE:
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
			break;
				
			case GrabType.NE_RESIZE:
				this.width = (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height -= (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
				
				this.y = e.clientY - this.offsetY;
				this.frameDiv.style.top = this.y + 'px';
			break;
				
			case GrabType.W_RESIZE:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
			break;
				
			case GrabType.E_RESIZE:
				this.width = (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
			break;
				
			case GrabType.SW_RESIZE:
				this.width -= (e.clientX - this.offsetX) - this.x;
				this.frameDiv.style.width = this.width + 'px';
				
				this.height = (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
			
				this.x = e.clientX - this.offsetX;
				this.frameDiv.style.left = this.x + 'px';
			break;
				
			case GrabType.S_RESIZE:
				this.height = (e.clientY - this.offsetY) - this.y;
				this.frameDiv.style.height = this.height + 'px';
			break;
				
			case GrabType.SE_RESIZE:
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
	
	/*Frame.prototype.sendRequest = function(method, action, parameters) {
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
	}*/
	
	Frame.prototype.onAddComponent = function(desktop) {
		this.frameDiv.addEventListener('mousedown', this.frameDivMouseDownListener, false);
		this.frameTitleBarDiv.addEventListener('mousedown', this.frameTitleBarDivMouseDownListener, false);
		this.frameTitleBarDiv.addEventListener('dblclick', this.frameTitleBarDivDblClickListener, false);
		this.frameTitleButtonMaximizeSpan.addEventListener('click', this.frameTitleButtonMaximizeSpanClickListener, false);
		this.frameTitleButtonMinimizeSpan.addEventListener('click', this.frameTitleButtonMinimizeSpanClickListener, false);
		this.frameTitleButtonCloseSpan.addEventListener('click', this.frameTitleButtonCloseSpanClickListener, false);
		this.frameTopLeftDiv.addEventListener('mousedown', this.frameTopLeftDivMouseDownListener, false);
		this.frameTopDiv.addEventListener('mousedown', this.frameTopDivMouseDownListener, false);
		this.frameTopRightDiv.addEventListener('mousedown', this.frameTopRightDivMouseDownListener, false);
		this.frameMiddleLeftDiv.addEventListener('mousedown', this.frameMiddleLeftDivMouseDownListener, false);
		this.frameMiddleRightDiv.addEventListener('mousedown', this.frameMiddleRightDivMouseDownListener, false);
		this.frameBottomLeftDiv.addEventListener('mousedown', this.frameBottomLeftDivMouseDownListener, false);
		this.frameBottomDiv.addEventListener('mousedown', this.frameBottomDivMouseDownListener, false);
		this.frameBottomRightDiv.addEventListener('mousedown', this.frameBottomRightDivMouseDownListener, false);
		this.frameMiniatureSpan.addEventListener('click', this.frameMiniatureSpanClickListener, false);
		desktop.desktopContainerDiv.addEventListener('mouseup', this.desktopContainerDivMouseUpListener, false);
		desktop.desktopContainerDiv.addEventListener('mousemove', this.desktopContainerDivMouseMoveListener, false);
		
		this.x = (desktop.workspaceContainerDiv.offsetWidth / 2) - (this.width / 2);
		this.y = (desktop.workspaceContainerDiv.offsetHeight / 2) - (this.height / 2);
		
		this.frameDiv.style.left = this.x + 'px';
		this.frameDiv.style.top = this.y + 'px';
		this.frameDiv.style.width = this.width + 'px';
		this.frameDiv.style.height = this.height + 'px';
		
		this.setZIndex(desktop.nextFrameZIndex++);
		
		desktop.framesList.push(this);
		desktop.workspaceContainerDiv.appendChild(this.frameDiv);
		desktop.taskbarContainerDiv.appendChild(this.frameMiniatureSpan);
		
		this.desktop = desktop;
	}
	
	Frame.prototype.onRemoveComponent = function(desktop) {
		this.frameDiv.removeEventListener('mousedown', this.frameDivMouseDownListener, false);
		this.frameTitleBarDiv.removeEventListener('mousedown', this.frameTitleBarDivMouseDownListener, false);
		this.frameTitleBarDiv.removeEventListener('dblclick', this.frameTitleBarDivDblClickListener, false);
		this.frameTitleButtonMaximizeSpan.removeEventListener('click', this.frameTitleButtonMaximizeSpanClickListener, false);
		this.frameTitleButtonMinimizeSpan.removeEventListener('click', this.frameTitleButtonMinimizeSpanClickListener, false);
		this.frameTitleButtonCloseSpan.removeEventListener('click', this.frameTitleButtonCloseSpanClickListener, false);
		this.frameTopLeftDiv.removeEventListener('mousedown', this.frameTopLeftDivMouseDownListener, false);
		this.frameTopDiv.removeEventListener('mousedown', this.frameTopDivMouseDownListener, false);
		this.frameTopRightDiv.removeEventListener('mousedown', this.frameTopRightDivMouseDownListener, false);
		this.frameMiddleLeftDiv.removeEventListener('mousedown', this.frameMiddleLeftDivMouseDownListener, false);
		this.frameMiddleRightDiv.removeEventListener('mousedown', this.frameMiddleRightDivMouseDownListener, false);
		this.frameBottomLeftDiv.removeEventListener('mousedown', this.frameBottomLeftDivMouseDownListener, false);
		this.frameBottomDiv.removeEventListener('mousedown', this.frameBottomDivMouseDownListener, false);
		this.frameBottomRightDiv.removeEventListener('mousedown', this.frameBottomRightDivMouseDownListener, false);
		this.frameMiniatureSpan.removeEventListener('click', this.frameMiniatureSpanClickListener, false);
		desktop.desktopContainerDiv.removeEventListener('mouseup', this.desktopContainerDivMouseUpListener, false);
		desktop.desktopContainerDiv.removeEventListener('mousemove', this.desktopContainerDivMouseMoveListener, false);
		
		desktop.framesList.splice(desktop.framesList.indexOf(this), 1);
		desktop.workspaceContainerDiv.removeChild(this.frameDiv);
		desktop.taskbarContainerDiv.removeChild(this.frameMiniatureSpan);
		
		this.desktop = null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Frame;
})();
