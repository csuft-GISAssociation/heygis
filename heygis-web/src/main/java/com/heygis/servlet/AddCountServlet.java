package com.heygis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.interfaces.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * 这名字起的。。。应该是下载次数+1????
 */
public class AddCountServlet extends HttpServlet {

    @Autowired
    private SourceService sourceServcie;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in");
        PrintWriter out = response.getWriter();
        String sourceName = request.getParameter("sourceName");
        if (sourceServcie.addCount(sourceName)) {
            out.print("true");
        } else {
            out.print("false");
        }
    }

}
