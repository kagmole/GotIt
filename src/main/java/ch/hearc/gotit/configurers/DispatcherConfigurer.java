package ch.hearc.gotit.configurers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ch.hearc.gotit.controllers")
public class DispatcherConfigurer extends WebMvcConfigurerAdapter {
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		// XXX Keep or clean
//		registry.addInterceptor(new LocaleInterceptor());
//        registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/").excludePathPatterns("/admin/");
//        registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/javascripts/").setCachePeriod(31556926);
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/styles/").setCachePeriod(31556926);
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		return viewResolver;
	}
}
