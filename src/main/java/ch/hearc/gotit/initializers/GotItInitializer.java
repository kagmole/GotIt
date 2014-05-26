package ch.hearc.gotit.initializers;

import ch.hearc.gotit.configurers.DispatcherConfigurer;
import ch.hearc.gotit.configurers.PersistenceConfigurer;
import ch.hearc.gotit.configurers.ServiceConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class GotItInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		rootContext.register(PersistenceConfigurer.class);
		rootContext.register(ServiceConfigurer.class);
		
		container.addListener(new ContextLoaderListener(rootContext));
		
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		
		dispatcherContext.register(DispatcherConfigurer.class);
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/webapp/*");
	}
}
