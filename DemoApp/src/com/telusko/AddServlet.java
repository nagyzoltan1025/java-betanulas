package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// A http k�r�st kezel� servlet egy java oszt�ly, 
// amely kiterjeszti a HttpServlet oszt�lyt
public class AddServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// http param�terekb�l kinyerj�k az �rt�ket
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		// k�t �rt�ket �sszeadjuk
		int k = i + j;
		
		// servlet eset�n egy html el��ll�t�s�hoz 
		// egy PrintWritet objektumra van sz�ks�g
		// Ezt a getWriter met�dus visszaadja nek�nk
		PrintWriter out = res.getWriter();
		
		// ez a html lesz visszak�ldve v�laszk�nt
		out.println("result is " + k);
	}
}
