package com.heygis.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.ForumPost;
import com.heygis.dto.User;
import com.heygis.service.interfaces.ForumsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ForumsPostService postService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loged") == null){
			request.setAttribute("message", "请先登录");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
			return;
		}
		int fid = Integer.parseInt(request.getParameter("fid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		int t_uid = Integer.parseInt(request.getParameter("t_uid"));
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		User user = (User)request.getSession().getAttribute("user");
		String author = user.getNickName();
		int authorUid = user.getUid();
		String authorAccount = user.getAccount();
		ForumPost post = new ForumPost(-1, fid, tid, 0, author, authorUid, authorAccount, "",
				new Date(), message, request.getRemoteAddr(), attchment,0);

		if(postService.addPost(post,t_uid) != -1){
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
