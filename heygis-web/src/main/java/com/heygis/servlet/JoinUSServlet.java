package com.heygis.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.NewMember;
import com.heygis.service.interfaces.JoinUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class JoinUSServlet extends HttpServlet {

	@Autowired
	private JoinUsService joinUsService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("in");
		NewMember member = new NewMember();
		member.setName(request.getParameter("name"));
		member.setProfession(request.getParameter("profession"));
		member.setTel(request.getParameter("tel"));
		member.setQQ(request.getParameter("QQ"));
		member.setOther(request.getParameter("other"));
		member.setSelfIntro(request.getParameter("selfIntro"));
		member.setGoal(request.getParameter("goal"));

		boolean result = joinUsService.addMember(member);

		if(result){
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			System.out.println("报名失败！");
			request.setAttribute("message", "你有不规范的填写，请重新填写！！");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

}
