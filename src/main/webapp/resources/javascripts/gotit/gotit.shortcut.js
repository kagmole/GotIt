/**
 * Got it! - Shortcut module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
var gotItShortcutModule = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  CONSTRUCTOR                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Shortcut = function(title, icon, action) {
	
		this.title = title;
		this.icon = icon;
		this.action = action;
		
		this.desktop = null;
		
		this.shortcutBlock = createBlockWithClass('gotit-shortcut-component');
		
		this.shortcutBlockDblClickListener = shortcutBlockDblClickListener.bind(this);
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
	
	function addEvent(eventTarget, eventType, eventFunction) {
		if (eventTarget.addEventListener) {
			eventTarget.addEventListener(eventType, eventFunction, false);
		} else {
			eventTarget.attachEvent('on' + eventType, eventFunction);
		}
	}
	
	function removeEvent(eventTarget, eventType, eventFunction) {
		if (eventTarget.removeEventListener) {
			eventTarget.removeEventListener(eventType, eventFunction, false);
		} else {
			eventTarget.detachEvent('on' + eventType, eventFunction);
		}
	}
	
	function shortcutBlockDblClickListener(e) {
		var frame = new GotIt.Frame(this.title, 10, 10, 400, 300);
		
		this.desktop.addComponent(frame);
		
		frame.sendRequest('GET', this.action);
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            PROTOTYPE ADDITION(S)                             |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	Shortcut.prototype.onAddComponent = function(desktop) {	
		addEvent(this.shortcutBlock, 'dblclick', this.shortcutBlockDblClickListener);
		
		desktop.shortcutBlock.appendChild(this.shortcutBlock);
		
		this.desktop = desktop;
	}
	
	Shortcut.prototype.onRemoveComponent = function(desktop) {	
		removeEvent(this.shortcutBlock, 'dblclick', this.shortcutBlockDblClickListener);
		
		desktop.shortcutBlock.removeChild(this.shortcutBlock);
		
		this.desktop = null;
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Shortcut;
})();
