package com.heygis.servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.User;
import com.heygis.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class UserIconServlet extends HttpServlet {

    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String base64 = request.getParameter("imgURL");
        base64 = base64.substring(22, request.getParameter("imgURL").length());

        User user = (User) request.getSession().getAttribute("user");
        boolean bool = userService.toImg(base64, user);
        if (bool) {
            user.setIconImg("/heygis_img/icon/" + user.getAccount() + "_img.jpg");
            request.getSession().setAttribute("user", user);
            response.sendRedirect("selfCenterServlet");
        } else {
            request.setAttribute("message", "头像修改失败");
            RequestDispatcher dis = request.getRequestDispatcher("/result.jsp");
            dis.forward(request, response);
        }

    }

}
