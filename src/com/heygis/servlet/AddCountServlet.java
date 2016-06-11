package com.heygis.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.SourceServie;

public class AddCountServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in");
		PrintWriter out = response.getWriter();
		String sourceName = request.getParameter("sourceName");
		if(new SourceServie().addCount(sourceName)){
			out.print("true");
		}else{
			out.print("false");
		}
	}

}
