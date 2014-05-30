<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="l" tagdir="/WEB-INF/tags/layouts" %>
<l:desktop>
	<jsp:body>
		<!-- Take 100% width and height by default -->
		<div id="page-containers">
			<!-- Desktop -->
			<div id="desktop-containers">
				<!-- N window-component-$UNIQUE_NAME -->
				<div id="window-component-myschool" class="window-component">
					<div class="window-title">
						Je suis un titre !
					</div>
					<div class="window-content">
						Quis enim aut eum diligat quem metuat, aut eum a quo se
						metui putet? Coluntur tamen simulatione dumtaxat ad tempus.
						Quod si forte, ut fit plerumque, ceciderunt, tum
						intellegitur quam fuerint inopes amicorum. Quod Tarquinium
						dixisse ferunt, tum exsulantem se intellexisse quos fidos
						amicos habuisset, quos infidos, cum iam neutris gratiam
						referre posset.

						Ut enim benefici liberalesque sumus, non ut exigamus
						gratiam (neque enim beneficium faeneramur sed natura
						propensi ad liberalitatem sumus), sic amicitiam non spe
						mercedis adducti sed quod omnis eius fructus in ipso amore
						inest, expetendam putamus.

						Fuerit toto in consulatu sine provincia, cui fuerit,
						antequam designatus est, decreta provincia. Sortietur an
						non? Nam et non sortiri absurdum est, et, quod sortitus
						sis, non habere. Proficiscetur paludatus? Quo? Quo
						pervenire ante certam diem non licebit. ianuario, Februario,
						provinciam non habebit; Kalendis ei denique Martiis
						nascetur repente provincia.
					</div>
				</div>
				
				<div id="window-component-myprofile" class="window-component">
					<div class="window-title">
					
					</div>
					<div class="window-content">
						Je suis tout petit !
					</div>
				</div>
				<!-- ... -->
				
				<!-- Files on background -->
				<div id="files-container">
					<!-- N file-component-$UNIQUE_NAME -->
					<div id="file-component-myschool" class="file-component"></div>
					<div id="file-component-myprofile" class="file-component"></div>
					<!-- ... -->
				</div>
								
				<!-- Gadgets on top-right -->
				<div id="gadgets-container">
					<!-- N gadget-component-$UNIQUE_NAME -->
					<div id="gadget-component-calendar" class="gadget-component"></div>
					<div id="gadget-component-clock" class="gadget-component"></div>
					<!-- ... -->
				</div>
				
				<!-- Alerts on right -->
				<div id="alerts-container">
					<!-- N alert-component-$UNIQUE_ID -->
					<div id="alert-component-17" class="alert-component"></div>
					<div id="alert-component-23" class="alert-component"></div>
					<!-- ... -->
				</div>
			</div>
			
			<!-- Task bar -->
			<div id="taskbar-containers">
				<!-- Menu on bottom-left -->
				<div id="menu-container">
					<!-- N menu-component-$UNIQUE_NAME -->
					<div id="menu-component-help" class="menu-component"></div>
					<div id="menu-component-disconnect" class="menu-component"></div>
					<!-- ... -->
				</div>
				
				<!-- Miniatures of windows -->
				<div id="miniatures-container">
					<!-- N miniature-component-$UNIQUE_NAME -->
					<div id="miniature-component-myschool" class="miniature-component"></div>
					<div id="miniature-component-myprofile" class="miniature-component"></div>
					<!-- ... -->
				</div>
			</div>
		</div>
	</jsp:body>
</l:desktop>