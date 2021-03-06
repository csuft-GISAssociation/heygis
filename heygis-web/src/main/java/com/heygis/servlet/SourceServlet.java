package com.heygis.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;
import com.heygis.service.interfaces.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SourceServlet extends HttpServlet {

	@Autowired
	SourceService sourceService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		List<SourceOne> sourceOneList = sourceService.getSourceOneList();
		List<SourceTwo> sourceTwoList = sourceService.getSourceTwoList();
		List<SourceThree> sourceThreeList = sourceService.getSourceThreeList();
		List<SourceFour> sourceFourList = sourceService.getSourceFourList();;
		request.setAttribute("sourceOneList",sourceOneList);
		request.setAttribute("sourceTwoList",sourceTwoList);
		request.setAttribute("sourceThreeList",sourceThreeList);
		request.setAttribute("sourceFourList",sourceFourList);
		request.setAttribute("index",index);
		request.getRequestDispatcher("/source1.jsp").forward(request, response);
	}
	
}
