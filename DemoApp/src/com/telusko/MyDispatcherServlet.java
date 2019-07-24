package com.telusko;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletExampleHtmls/mydis")
public class MyDispatcherServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int k = Integer.parseInt(req.getParameter("num1")) + Integer.parseInt(req.getParameter("num2")); 
		
		req.setAttribute("k", k);
		RequestDispatcher rd = req.getRequestDispatcher("/sq");
		rd.include(req, res);
		
		// Az include �tadja a vez�rl�st a /sq url m�g�tti servletnek
		// A servlet �ltal visszak�ld�tt v�laszhoz hozz� f�zz�k az al�bbit:
		res.getWriter().println("<br> test");
		
	}
}
