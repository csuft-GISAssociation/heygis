package com.heygis.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.service.SourceServie;

public class SourceServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SourceServie sourceService = new SourceServie();
		List<SourceOne> sourceOneList = sourceService.getSourceOneList();
		List<SourceTwo> sourceTwoList = sourceService.getSourceTwoList();
		List<SourceThree> sourceThreeList = sourceService.getSourceThreeList();
		List<SourceFour> sourceFourList = sourceService.getSourceFourList();;
		request.setAttribute("sourceOneList",sourceOneList);
		request.setAttribute("sourceTwoList",sourceTwoList);
		request.setAttribute("sourceThreeList",sourceThreeList);
		request.setAttribute("sourceFourList",sourceFourList);
		request.getRequestDispatcher("/source1.jsp").forward(request, response);
	}
	
}
