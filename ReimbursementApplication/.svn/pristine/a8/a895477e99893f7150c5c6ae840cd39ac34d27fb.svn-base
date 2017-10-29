package com.avizva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * MVC configuration class
 * 
 * @author Pratyaksh.Kumar
 *
 */
@Configuration
@EnableWebMvc
@EnableScheduling
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * Creates the ViewResolver bean
	 * 
	 * @return ViewResolver the view resolver bean
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MultipartResolver multipartResolver() {
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(5242880);
	    return multipartResolver;
	}

	/**
	 * Method to specify the location of static resources to be handled by
	 * dispatcher servlet
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(3600);

	}

}
