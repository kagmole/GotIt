package ch.hearc.gotit.initializers;

import ch.hearc.gotit.configurers.PersistenceConfigurer;
import ch.hearc.gotit.configurers.SecurityConfigurer;
import ch.hearc.gotit.configurers.ServiceConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class GotItInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

		rootContext.register(PersistenceConfigurer.class);
		rootContext.register(SecurityConfigurer.class);
		rootContext.register(ServiceConfigurer.class);

		container.addListener(new ContextLoaderListener(rootContext));
	}
}

// FIXME JBoss Web 7.0.10 doesn't support root context override with the initializer method...
//import javax.servlet.Filter;
//
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//import ch.hearc.gotit.configurers.DispatcherConfigurer;
//import ch.hearc.gotit.configurers.PersistenceConfigurer;
//import ch.hearc.gotit.configurers.ServiceConfigurer;
//
//public class GotItInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return new Class<?>[] {PersistenceConfigurer.class,	ServiceConfigurer.class};
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[] {DispatcherConfigurer.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[] {"/"};
//	}
//	
//	@Override
//	protected Filter[] getServletFilters() {
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//	    characterEncodingFilter.setEncoding("UTF-8");
//	    
//	    return new Filter[] {characterEncodingFilter};
//	}
//}
