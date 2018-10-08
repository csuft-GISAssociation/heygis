package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.ForumsThreadPage;
import com.heygis.service.interfaces.ForumsThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet implementation class ForumsServlet
 */
public class ForumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ForumsThreadService threadService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page,fid = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
			fid = Integer.parseInt(request.getParameter("fid"));
		} catch (Exception e) {
			error("版块访问失败",request,response);
			return;
		}
		ForumsThreadPage threadPage = threadService.getThreadPage(fid, page);
		if(threadPage.getFid() < 4){
			request.setAttribute("threadPage", threadPage);
			RequestDispatcher dis = request.getRequestDispatcher("/forums/forums.jsp");
			dis.forward(request, response);
		}else{
			error("访问版块不存在",request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	void error(String msg,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("message", msg);
		RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
		dis.forward(request, response);
	}

}
