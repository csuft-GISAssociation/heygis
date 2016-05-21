package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		if(loginService.login(account,password)){
			request.getSession().setAttribute("user",loginService.getUser(account) );
			response.getWriter().println("success");
		}else{
			response.getWriter().println("wrong");
		}
	}

    

}
