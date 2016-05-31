package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 * date:2016/5/23/17:28
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String passWord = request.getParameter("passWord");
		String nickName = request.getParameter("nickName");
		String grade = request.getParameter("grade");
		RegisterService registerServer = new RegisterService();
		int rsult = registerServer.addUser(account, passWord, nickName, grade);
		if(rsult == 1){
			response.sendRedirect("index.jsp");
		}else{
			request.setAttribute("message", "注册失败");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
