package com.avizva.controller;

import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class acts as controller for request mappings to error and an exception
 * handler
 * 
 * @author Campus2017
 * 
 *
 */
@Controller
@ControllerAdvice
public class ErrorExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Used to map all requests for /error onto error.jsp
	 * 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping("/error")
	public ModelAndView callErrorPage(HttpServletRequest request) {
		LOGGER.error(
				request.getAttribute("javax.servlet.error.status_code") + " Http Error Occured, Loading Error Page");
		return new ModelAndView("error");
	}

	/**
	 * Used to intercept all type of exceptions
	 * 
	 * @param request
	 * @param exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionHandler(HttpServletRequest request, Exception exception) {
		LOGGER.error("The following exception occured:", exception);
		return new ModelAndView("error");
	}

	/**
	 * Used to intercept SQL exceptions
	 * 
	 * @param request
	 * @param exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(HttpServletRequest request, SQLException exception) {
		LOGGER.error("SQL Exception Occured: ", exception);
		return new ModelAndView("error");
	}

	/**
	 * Used to intercept Input Output exceptions
	 * 
	 * @param request
	 * @param exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(IOException.class)
	public ModelAndView ioExceptionHandler(HttpServletRequest request, IOException exception) {
		LOGGER.error("Input Output Exception Occured: ", exception);
		return new ModelAndView("error");
	}

	/**
	 * Used to intercept Null Pointer exceptions
	 * 
	 * @param request
	 * @param exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView nullPointerExceptionHandler(HttpServletRequest request, NullPointerException exception) {
		LOGGER.error("Null Pointer Exception Occured: ", exception);
		return new ModelAndView("error");
	}

	/**
	 * Used to intercept Socket exceptions
	 * 
	 * @param request
	 * @param exception
	 * @return ModelAndView
	 */
	@ExceptionHandler(SocketException.class)
	public ModelAndView socketExceptionHandler(HttpServletRequest request, SocketException exception) {
		LOGGER.error("Socket Exception Occured: ", exception);
		return new ModelAndView("error");
	}
}
