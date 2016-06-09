package com.heygis.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.User;
import com.heygis.service.UserIconService;

public class UserIconServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String base64 = request.getParameter("imgURL");
		base64 = base64.substring(22,request.getParameter("imgURL").length());
		User user = (User)request.getSession().getAttribute("user");
		boolean bool = new UserIconService(user).toImg(base64);
		if(bool){
			user.setIconImg("/heygis_img/icon/"+user.getAccount()+"_img.jpg");
			request.getSession().setAttribute("user", user);
			response.sendRedirect("selfCenterServlet");
		}else{
			System.out.println("die");
		}
		
	}
	
}
