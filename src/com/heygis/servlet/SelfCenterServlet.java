package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumMsgPage;
import com.heygis.service.NewMsgService;

/**
 * Servlet implementation class SelfCenterServlet
 */
public class SelfCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelfCenterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(Boolean)request.getAttribute("loged")){
			response.sendRedirect("index.jsp");
			return;
		}
		int uid = Integer.parseInt(request.getAttribute("uid").toString());
		ForumMsgPage fMsgPage = new NewMsgService().getMsgPage(uid, 1, 1);
		request.setAttribute("fMsgPage", fMsgPage);
		RequestDispatcher dis =  request.getRequestDispatcher("selfCenter.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
