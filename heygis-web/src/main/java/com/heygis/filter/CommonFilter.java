package com.heygis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.heygis.dto.User;
import com.heygis.util.PageViewCounter;

public class CommonFilter implements Filter {

    public CommonFilter() {
        // TODO Auto-generated constructor stub
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        HttpServletRequest hsrequest = (HttpServletRequest) request;
        HttpSession session = hsrequest.getSession();

        //判断登陆情况，设置loged和uid
        boolean loged = false;
        int uid = -1;
        User user = null;
        if (session.getAttribute("loged") != null && session.getAttribute("loged").equals(true)) {
            if (session.getAttribute("user") != null) {
                loged = true;
                user = (User) session.getAttribute("user");
                uid = user.getUid();
            }
        }
        request.setAttribute("loged", loged);
        request.setAttribute("uid", uid);
        request.setAttribute("user", user);

        //收集统计访问记录，一个session算一次
        if (session.isNew())
            PageViewCounter.addViewer(request.getRemoteAddr(), hsrequest.getHeader("User-Agent"));

        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }
}
