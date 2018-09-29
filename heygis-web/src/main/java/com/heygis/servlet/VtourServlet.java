package com.heygis.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VtourServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String htmlURL = request.getParameter("html");
		request.setAttribute("htmlURL", htmlURL);
		request.getRequestDispatcher("vtourScan.jsp").forward(request, response);		
	}
	
}
