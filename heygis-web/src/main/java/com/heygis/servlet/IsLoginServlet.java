package com.heygis.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IsLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean loged = (Boolean) request.getAttribute("loged");
        Integer uid = (Integer) request.getAttribute("uid");
        response.getWriter().println("{\"loged\":" + loged + ",\"uid\":\"" + uid + "\"}");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
