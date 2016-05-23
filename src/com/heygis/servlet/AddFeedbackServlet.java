package com.heygis.servlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.FeedbackMsg;
import com.heygis.service.FeedbackService;

public class AddFeedbackServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = "1234@163.com";
		String nickname = "1234";
		Date dtime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(dtime);
		String feedbackContent = request.getParameter("content");
		String accountImg = "123";
		FeedbackMsg feedbackMsg = new FeedbackMsg(account, nickname, time, feedbackContent, accountImg);
		FeedbackService feedbackService = new FeedbackService();
		if(feedbackService.addMsg(feedbackMsg)){
			request.getRequestDispatcher("/feedbackServlet").forward(request, response);
		}else{
			//返回错误页面；
		}
		
	}

}
