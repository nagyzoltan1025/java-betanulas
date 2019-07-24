package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A http kérést kezelõ servlet egy java osztály, 
// amely kiterjeszti a HttpServlet osztályt
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// http paraméterekbõl kinyerjük az értéket
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		// két értéket összeadjuk
		int k = i + j;
		
		// servlet esetén egy html elõállításához 
		// egy PrintWritet objektumra van szükség
		// Ezt a getWriter metódus visszaadja nekünk
		PrintWriter out = res.getWriter();
		
		// ez a html lesz visszaküldve válaszként
		out.println("result is " + k);
	}
}
