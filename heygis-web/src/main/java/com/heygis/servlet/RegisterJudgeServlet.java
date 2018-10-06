package com.heygis.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注册时比较邮箱和昵称是否重复
 */
public class RegisterJudgeServlet extends HttpServlet {

	@Autowired
	private UserService userService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		int judgeIndex = Integer.parseInt(request.getParameter("judgeIndex"));
		PrintWriter out = response.getWriter();
		if(judgeIndex==1){
			String account = request.getParameter("account");
			if(userService.judgeEmail(account)){
				out.print(account);
			}else{
				out.print(account+" 该email已被注册！");
			}
		}
		if(judgeIndex==2){
			String nickName = request.getParameter("nickName");
			if(userService.judgeNickName(nickName)){
				out.print(nickName);
			}else{
				out.print(nickName+"该昵称已被注册！");
			}
		}
	}

}
