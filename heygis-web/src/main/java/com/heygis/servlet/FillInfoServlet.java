package com.heygis.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.User;
import com.heygis.service.FillInfoService;

public class FillInfoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User(
				((User)request.getSession().getAttribute("user")).getUid(),
				request.getParameter("account"),
				request.getParameter("nickName"),
				request.getParameter("grade"),
				request.getParameter("optionsRadios"),
				request.getParameter("QQ"),
				request.getParameter("tel"),
				request.getParameter("selfintroduction"),
				((User)request.getSession().getAttribute("user")).getIconImg());
		if(new FillInfoService().fillInfo(user)){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("selfCenterServlet");
		}else{
			request.setAttribute("message", "修改个人信息错误！");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

}
