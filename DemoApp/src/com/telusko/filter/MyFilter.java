package com.telusko.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(servletNames="MyServletId")
public class MyFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void destroy() {
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request.getParameter("name").contentEquals("John Doe") ) {
			chain.doFilter(request, response);
		} else {
			response.getWriter().println("Go away!");
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
}
