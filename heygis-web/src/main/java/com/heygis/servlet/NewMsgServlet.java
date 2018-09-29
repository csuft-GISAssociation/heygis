package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.NewMsgService;

public class NewMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewMsgServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nw = 0,uid = 0;
		try {
			nw = Integer.parseInt(request.getParameter("nw"));
			uid = Integer.parseInt(request.getParameter("uid"));
		} catch (Exception e) {
			return;
		}
		if(nw == 1){
			int num = new NewMsgService().howManyNewMsg(uid);
			response.getWriter().println(num);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
