package com.heygis.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.ForumPost;
import com.heygis.beans.User;
import com.heygis.service.AddPostService;
import com.heygis.service.ReplyPostService;

/**
 * Servlet implementation class AddReplyPostServlet
 */
public class ReplyPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if(request.getSession().getAttribute("loged") == null){
			request.setAttribute("message", "请先登录");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
			return;
		}
		String message = request.getParameter("message");
		int pid = Integer.parseInt(request.getParameter("replypid"));
		String replyhread = request.getParameter("replyhead");
		String subject = request.getParameter("subject");
		int tid = Integer.parseInt(request.getParameter("tid"));
		int fid = Integer.parseInt(request.getParameter("fid"));
		int posi = Integer.parseInt(request.getParameter("posi"));
		int uid = Integer.parseInt(request.getParameter("postauthor_uid"));
		String replyedaccount = request.getParameter("postauthor_account");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
		int attchment = 0;
		User user = (User)request.getSession().getAttribute("user");
		ReplyPostService replyPostService = new ReplyPostService();
		String replyedmessage = replyhread + replyPostService.getPostMessage(pid) + "</blockquote></fieldset>";
		
		ForumPost post = new ForumPost(-1, fid, tid, 0, user.getNickName(), user.getUid(), user.getAccount(), "",
				new Date(),replyedmessage+message, request.getRemoteAddr(), attchment, -1);
		AddPostService aps = AddPostService.getInstance();
		int replyposi = aps.getFpdi().addPost(post);
		if(replyposi != 0){
			
			response.sendRedirect(request.getHeader("referer"));
		}else{
			request.setAttribute("message", "回帖失败");
			RequestDispatcher dis =  request.getRequestDispatcher("/result.jsp");
			dis.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
