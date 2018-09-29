package com.heygis.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;
import com.heygis.service.SourceServie;

public class SourceServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String index = request.getParameter("index");
		SourceServie sourceService = new SourceServie();
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
