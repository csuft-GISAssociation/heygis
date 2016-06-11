package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumPostPage;
import com.heygis.service.TopicsService;

public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fPage = 1;
		if(request.getParameter("fPage") != null){
			fPage = Integer.parseInt(request.getParameter("fPage"));
		}
		fPage = 1;
		int page = Integer.parseInt(request.getParameter("page"));
		int tid = Integer.parseInt(request.getParameter("tid"));
//		System.out.println(tid);
		TopicsService ts = new TopicsService();
		ForumPostPage postPage = ts.getPostPage(tid, page);
		postPage.setfPage(fPage);
//		System.out.println(postPage.getPost_number());
		if(postPage.getPost_number() != 0){
			request.setAttribute("postPage", postPage);
			RequestDispatcher dis = request.getRequestDispatcher("/forums/topics.jsp");
			dis.forward(request, response);
		}else{
			request.setAttribute("message", "访问帖子不存在");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
