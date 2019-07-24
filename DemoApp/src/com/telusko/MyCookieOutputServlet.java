package com.telusko;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletExampleHtmls/cookie-output")
public class MyCookieOutputServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String allCookies = "";
		Cookie cookies[] = req.getCookies();
		for (Cookie cookie : cookies) {
			allCookies = allCookies.concat(cookie.getName() + " : " + cookie.getValue() + "\n");
		}
		
		res.getWriter().println(allCookies);
	}
}

