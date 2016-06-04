package com.heygis.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumPost;
import com.heygis.beans.ForumThread;
import com.heygis.beans.User;
import com.heygis.service.ForumsService;

/**
 * Servlet implementation class AddThreadServlet
 */
public class AddThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddThreadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loged") == null){
			request.setAttribute("message", "请先登录");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
			return;
		}
		int fid = Integer.parseInt(request.getParameter("fid"));
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		User user = (User)request.getSession().getAttribute("user");
		String author = user.getNickName();
		int authorUid = user.getUid();
		String authorAccount = user.getAccount();
//		System.out.println(author+authorUid+authorAccount);
		ForumThread thread = new ForumThread(0, fid, 0, 0, author, authorUid, authorAccount, subject, 
				new Date(), new Date(), "", 0, 0, 0, 0, 0, 1);
		ForumPost post = new ForumPost(0, fid, 0, 1, author, authorUid, authorAccount, subject,
				new Date(), message, request.getRemoteAddr(), attchment, 0);
		if(new ForumsService().addthread(thread, post)){
			response.sendRedirect(request.getHeader("referer"));
		}else{
			request.setAttribute("message", "发帖失败");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
