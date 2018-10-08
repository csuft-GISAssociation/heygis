package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.ForumMsgPage;
import com.heygis.service.interfaces.NewMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet implementation class SelfCenterServlet
 */
@Component
public class SelfCenterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private NewMsgService newMsgService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(Boolean)request.getAttribute("loged")){
			response.sendRedirect("index.jsp");
			return;
		}
		int uid = Integer.parseInt(request.getAttribute("uid").toString());
		ForumMsgPage fMsgPage = newMsgService.getMsgPage(uid, 1, 1);
		request.setAttribute("fMsgPage", fMsgPage);
		RequestDispatcher dis =  request.getRequestDispatcher("selfCenter.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
