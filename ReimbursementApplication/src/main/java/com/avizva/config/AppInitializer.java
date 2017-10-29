package com.avizva.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Application initializer class
 * 
 * @author Parul.Sharma
 *
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class, ApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}