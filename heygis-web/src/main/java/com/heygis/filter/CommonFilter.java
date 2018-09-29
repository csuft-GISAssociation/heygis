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
		boolean loged = false;
		HttpServletRequest hsrequest=(HttpServletRequest)request;
		HttpSession session = hsrequest.getSession();
		if(session.getAttribute("loged") != null){ 
			if(session.getAttribute("loged").equals(true)){
				loged = true;
			}
		}
		request.setAttribute("loged", loged);
		//设置uid
		if(session.getAttribute("user") != null){ 
			User user = (User)session.getAttribute("user");
			request.setAttribute("uid", user.getUid());
		}else{
			request.setAttribute("uid", -1);
		}
		
		if(session.isNew()) 
			PageViewCounter.addViewer(request.getRemoteAddr(),hsrequest.getHeader("User-Agent"));			
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}
