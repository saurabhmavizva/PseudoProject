package com.avizva.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.avizva.enums.Role;
import com.avizva.service.impl.EmployeeServiceImpl;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("/*")
public class SessionFilter implements Filter {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeServiceImpl.class);

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if (session.getAttribute("id") == null) {

			if (req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1].equals("loginpage")
					|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
							.equals("ReimbursementApplication")
					|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1].equals("login")
					|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1].equals("logout")
					|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
							.equals("forgotpassword")
					|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
							.equals("forgotpasswordform")) {

			} else {

				req.setAttribute("msg", "You Must Login First");
				request.getRequestDispatcher("/loginpage").forward(request, response);
			}
		} else {

			if (session.getAttribute("role") == Role.Manager || session.getAttribute("role") == Role.Finance
					|| session.getAttribute("role") == Role.Employee) {
				if (req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1].equals("adminpanel")
						|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("employeemanagement")
						|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("categorymanagement")
						|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("manageDesignation")
						|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("projectManagement")) {
					req.setAttribute("msg", "You don't have Admin Privilege");
					request.getRequestDispatcher("/dashboard").forward(request, response);
				}

				if (session.getAttribute("role") == Role.Employee
						&& req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("reimbursementqueue")
						|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
								.equals("reporting")) {
					req.setAttribute("msg", "You don't have Manager or Finance Privilege");
					request.getRequestDispatcher("/dashboard").forward(request, response);

				}
			} else if (session.getAttribute("role") == Role.ROLE_ADMIN
					&& (req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
							.equals("reimbursementqueue")
							|| req.getRequestURI().split("/")[req.getRequestURI().split("/").length - 1]
									.equals("reporting"))) {
				req.setAttribute("msg", "You don't have Manager or Finance Privilege");
				request.getRequestDispatcher("/dashboard").forward(request, response);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
