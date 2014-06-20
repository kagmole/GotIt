/**
 * GotIt namespace module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                              NAMESPACE CREATION                              |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var GotIt = {};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var domParser = new DOMParser();
	
	GotIt.createDivWithClass = function(className) {
		var divElement = document.createElement('div');
		
		divElement.className = className;
		
		return divElement;
	};
	
	GotIt.addEvent = function(eventTarget, eventType, eventFunction) {
		if (eventTarget.addEventListener) {
			eventTarget.addEventListener(eventType, eventFunction, false);
		} else {
			eventTarget.attachEvent('on' + eventType, eventFunction);
		}
	};
	
	GotIt.removeEvent = function(eventTarget, eventType, eventFunction) {
		if (eventTarget.removeEventListener) {
			eventTarget.removeEventListener(eventType, eventFunction, false);
		} else {
			eventTarget.detachEvent('on' + eventType, eventFunction);
		}
	};
	
	// TODO keep or clean
	/*GotIt.doAjaxGet = function(action, targetElement) {
		var xhr = new XMLHttpRequest();
		
		xhr.timeout = 10000;
		xhr.open('GET', action);
		
		xhr.setRequestHeader('GotIt-Aajx', 'true');
	}*/
	
	GotIt.doAjaxGet = function(aElement, targetElementId) {
		var xhr = new XMLHttpRequest();
		
		xhr.timeout = 10000;
		xhr.open('GET', aElement.getAttribute('href'));
		
		xhr.setRequestHeader('GotIt-Ajax', 'true');
		
		var targetElement = document.getElementById(targetElementId);
		
		xhr.ontimeout = function() {
			targetElement.innerHTML = 'That shit takes much longer than exptected!';
		}
		
		xhr.onprogress = function(e) {
			targetElement.innerHTML = 'Loading... (' + Math.floor(e.loaded / e.total) + '%)';
		}
		
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var xmlDocument = domParser.parseFromString(xhr.responseText.trim(), "text/xml");
				var rootChildNodes = xmlDocument.documentElement.childNodes;
				
				document.title = rootChildNodes[1].textContent;
				targetElement.innerHTML = rootChildNodes[3].textContent;
				
				// TODO implements
				//history.pushState({}, 'yo', aElement.getAttribute('href'));
			}
		}
		
		xhr.send(null);
	}
	
	GotIt.doAjaxPost = function(aElement, targetElementId) {
		
	}
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return GotIt;
})();
