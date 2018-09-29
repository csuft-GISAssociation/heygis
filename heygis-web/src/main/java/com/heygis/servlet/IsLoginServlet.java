package com.heygis.servlet;

import com.heygis.dto.ForumPost;
import com.heygis.dto.User;
import com.heygis.service.AddPostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class IsLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean loged = (Boolean)request.getSession().getAttribute("loged");
        if(loged != null && loged.equals(true)){
                response.getWriter().println(1);//登陆状态
        }else{
            response.getWriter().println(0);//不在登陆状态
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


}
