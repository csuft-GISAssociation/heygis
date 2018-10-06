package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginServlet extends HttpServlet {

    @Autowired
	private UserService userService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(userService.login(account,password)){
			request.getSession().setAttribute("loged",true);
			request.getSession().setAttribute("user",userService.getUser(account) );
//			System.out.println(request.getHeader("referer"));
//			response.sendRedirect(request.getHeader("referer"));
			response.getWriter().println(1);//这儿是干什么？//这儿是登陆成功
		}else{
			response.getWriter().println(0);
		}
	}
}
