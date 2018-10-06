package com.heygis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Servlet implementation class RegisterServlet
 * date:2016/5/23/17:28
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account1");
		String passWord = request.getParameter("passWord");
		String nickName = request.getParameter("nickName");
		String grade = request.getParameter("grade");
		int result = userService.addUser(account, passWord, nickName, grade);
		if(result == 1){
			System.out.println("suce");
			request.getSession().setAttribute("loged",true);
			request.getSession().setAttribute("user",userService.getUser(account));//将信息提交到个人中心页面。
			response.sendRedirect("selfCenterServlet");
//			RequestDispatcher dis =  request.getRequestDispatcher("/selfCenter.html");
//			dis.forward(request, response);
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
