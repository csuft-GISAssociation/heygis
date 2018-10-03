package com.heygis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.ForumsThreadService;
import com.heygis.service.NewMsgService;

public class SelfCenMsgList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ForumsThreadService threadService = new ForumsThreadService();
	NewMsgService newMsgService = new NewMsgService();

    public SelfCenMsgList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getAttribute("uid").toString());
		int page = Integer.parseInt(request.getParameter("page"));
		int n = Integer.parseInt(request.getParameter("n"));
		String msgList;
		if(n == 3){
			msgList = threadService.getMyThread(uid, page);
		}else{
			msgList = newMsgService.getMsgList(uid, page, n);
		}
//		String msgList = new NewMsgService().getMsgList(uid, page, n);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		response.getWriter().println(msgList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
