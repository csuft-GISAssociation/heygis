package com.heygis.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.FeedbackMsg;
import com.heygis.dto.User;
import com.heygis.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddFeedbackServlet extends HttpServlet {

	@Autowired
	private FeedbackService feedbackService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String check = request.getParameter("check");
		System.out.println(check);
		String account = null;
		String nickname = null;
		if(check.equals("2")){
			//判断登录
			account = ((User)request.getSession().getAttribute("user")).getAccount();
			nickname = ((User)request.getSession().getAttribute("user")).getNickName();
		}else{
			account = "visitor@163.com";
			nickname = "匿名";
		}
		Date dtime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(dtime);
		String feedbackContent = request.getParameter("content");
		String accountImg = "img/bbs-1.JPG";
		FeedbackMsg feedbackMsg = new FeedbackMsg(account, nickname, time, feedbackContent, accountImg);
		if(feedbackService.addMsg(feedbackMsg)){
			response.sendRedirect("feedbackServlet");
			//request.getRequestDispatcher("/feedbackServlet").forward(request, response);
		}else{
			//返回错误页面；
		}
		
	}

}
