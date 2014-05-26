/*(function main() {
	var page = document.getElementById('page-containers');

	page.addEventListener('mouseup', function(event) {
		document.getElementById('window-component-myschool').style.top = event.clientY + 'px';
		document.getElementById('window-component-myschool').style.left = event.clientX + 'px';
	}, false);
})();*/

(function() { // On utilise une IEF pour ne pas polluer l'espace global
    
    var storage = {}; // Contient l'objet du div en cours de déplacement
    
    
    function addEvent(element, event, func) { // Une fonction pour gérer les événements sous tous les navigateurs
        if (element.attachEvent) {
            element.attachEvent('on' + event, func);
        } else {
            element.addEventListener(event, func, true);
        }
    }
    
    
    function init() { // La fonction d'initialisation
        /*var elements = document.getElementsByTagName('div'),
            elementsLength = elements.length;*/
			
		var element = document.getElementById('window-component-myschool');
        
        /*for (var i = 0 ; i < elementsLength ; i++) {
            if (elements[i].className === 'window-title') {*/
        
                addEvent(element, 'mousedown', function(e) { // Initialise le drag & drop
                    var s = storage;
                    s.target = e.target || event.srcElement;
                    s.offsetX = e.clientX - s.target.offsetLeft;
                    s.offsetY = e.clientY - s.target.offsetTop;
                });
        
                addEvent(element, 'mouseup', function() { // Termine le drag & drop
                    storage = {};
                });
            //}
        //}
        
        addEvent(document, 'mousemove', function(e) { // Permet le suivi du drag & drop
            var target = storage.target;
            
            if (target) {
                element.style.top = e.clientY - storage.offsetY + 'px';
                element.style.left = e.clientX - storage.offsetX + 'px';
            }
        });
    }
      
    init(); // On initialise le code avec notre fonction toute prête
    
})();

/*user-select: none;
-moz-user-select: none;
-khtml-user-select: none;
-webkit-user-select: none;*/