package com.heygis.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.ForumMessage;
import com.heygis.dto.ForumPost;
import com.heygis.dto.User;
import com.heygis.service.interfaces.ForumsPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet implementation class AddReplyPostServlet
 */
public class ReplyPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private ForumsPostService postService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        if (request.getSession().getAttribute("loged") == null) {
            request.setAttribute("message", "请先登录");
            RequestDispatcher dis = request.getRequestDispatcher("/result.jsp");
            dis.forward(request, response);
            return;
        }
        String message = request.getParameter("message");
        String replyhread = request.getParameter("replyhead");
        String subject = request.getParameter("subject");
        int pid = Integer.parseInt(request.getParameter("replypid"));
        int tid = Integer.parseInt(request.getParameter("tid"));
        int fid = Integer.parseInt(request.getParameter("fid"));
//		String replyedaccount = request.getParameter("postauthor_account");
//		int attchment = Integer.parseInt(request.getParameter("attchment"));
        int t_uid = Integer.parseInt(request.getParameter("t_uid"));
        int rd_uid = Integer.parseInt(request.getParameter("postauthor_uid"));
        int rp_posi = Integer.parseInt(request.getParameter("replyposi"));
        String replyedmessage = replyhread + postService.getPostMessage(pid) + "</blockquote></fieldset>";
        int attchment = 0;
        User user = (User) request.getSession().getAttribute("user");

        ForumPost post = new ForumPost(-1, fid, tid, 0, user.getNickName(), user.getUid(), user.getAccount(), "",
                new Date(), replyedmessage + message, request.getRemoteAddr(), attchment, 1, rd_uid, rp_posi);
        ForumMessage fmsg = new ForumMessage(user.getNickName(), user.getUid(), rd_uid, subject, new Date().getTime(), 2, fid, tid);

        if (postService.addReplyPost(post, fmsg, t_uid, user.getUid())) {
            response.sendRedirect(request.getHeader("referer"));
        } else {
            request.setAttribute("message", "回帖失败");
            RequestDispatcher dis = request.getRequestDispatcher("/result.jsp");
            dis.forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
