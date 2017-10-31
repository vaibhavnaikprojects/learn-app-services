package com.zensar.learnappservices.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
public class ApplicationInterceptor implements Filter{

	public void init(FilterConfig fc) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fc) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		fc.doFilter(req, res);
	}

	public void destroy() {
		// Do nothing because will get called automatically by container.
	}
}
