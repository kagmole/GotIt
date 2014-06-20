/**
 * GotIt namespace module
 * 
 * @author Dany Jupille
 * @version 1.0
 */
window.GotIt.Standard = (function () {
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                              NAMESPACE CREATION                              |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var Standard = {};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                                  STATIC CODE                                 |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	var currentMainSection = document.getElementById('gotit-standard-body');
	var currentMainSectionParentElement = currentMainSection.parentElement;
	
	var absoluteMaskDiv1 = GotIt.createDivWithClass('gotit-absolute-mask');
	var absoluteMaskDiv2 = GotIt.createDivWithClass('gotit-absolute-mask');
	
	Standard.doAjaxNavigation = function(anchorElement, toBottomAnimation) {
		currentMainSection.onwheel = 'return false;';
		currentMainSectionParentElement.appendChild(absoluteMaskDiv1);
		
		var anchorLink = anchorElement.getAttribute('href');
		
		
	};
	
/*----------------------------------------------------------------------------*\
|                                                                              |
|                            RETURN MODULE STATEMENT                           |
|                                                                              |
\*----------------------------------------------------------------------------*/
	
	return Standard;
})();
