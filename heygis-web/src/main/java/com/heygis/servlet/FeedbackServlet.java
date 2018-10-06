package com.heygis.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.FeedbackMsg;
import com.heygis.service.interfaces.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;

public class FeedbackServlet extends HttpServlet {

	@Autowired
	private FeedbackService feedbackService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FeedbackMsg> feedbackMsgList = null;
		feedbackMsgList = feedbackService.getMsg();
		request.setAttribute("feedbackMsgList", feedbackMsgList);
		request.getRequestDispatcher("/feedback.jsp").forward(request, response);

	}

}
