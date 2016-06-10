package com.heygis.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.beans.SourceFour;
import com.heygis.beans.SourceOne;
import com.heygis.beans.SourceThree;
import com.heygis.beans.SourceTwo;
import com.heygis.dao.SourceDAOImpl;
import com.heygis.service.CreateHTMLService;
import com.heygis.service.SourceServie;


public class SortServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sortWay = request.getParameter("sortWay");
		String sourceType = request.getParameter("sourceType");
		int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));
		Boolean loged = (Boolean)request.getAttribute("loged");
		SourceServie sourceService = new SourceServie();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		if(sourceType.equals("1")){
			if(sortWay.equals("0")){
				List<SourceOne> sourceOneList = new SourceDAOImpl().getSourceOne();
				String html = new CreateHTMLService(loged).createHTML(sourceOneList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("1")){
				List<SourceOne> sourceOneList = sourceService.sortByTime(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceOneList,sourceType,currPageNo);
				out.print(html);	
			}
			if(sortWay.equals("2")){
				List<SourceOne> sourceOneList = sourceService.sortByDown(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceOneList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("3")){
				List<SourceOne> sourceOneList = sourceService.sortByAlpha(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceOneList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("4")){
				List<SourceOne> sourceOneList = sourceService.sortByFileSize(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceOneList,sourceType,currPageNo);
				out.print(html);
			}
		}
		if(sourceType.equals("2")){
			if(sortWay.equals("0")){
				List<SourceTwo> sourceTwoList = new SourceDAOImpl().getSourceTwo();
				String html = new CreateHTMLService(loged).createHTML(sourceTwoList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("1")){
				List<SourceTwo> sourceTwoList = sourceService.sortByTime(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceTwoList,sourceType,currPageNo);
				out.print(html);	
			}
			if(sortWay.equals("2")){
				List<SourceTwo> sourceTwoList = sourceService.sortByDown(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceTwoList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("3")){
				List<SourceTwo> sourceTwoList = sourceService.sortByAlpha(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceTwoList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("4")){
				List<SourceTwo> sourceTwoList = sourceService.sortByFileSize(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceTwoList,sourceType,currPageNo);
				out.print(html);
			}		
		}
		if(sourceType.equals("3")){
			if(sortWay.equals("0")){
				List<SourceThree> sourceThreeList = new SourceDAOImpl().getSourceThree();
				String html = new CreateHTMLService(loged).createHTML(sourceThreeList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("1")){
				List<SourceThree> sourceThreeList = sourceService.sortByTime(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceThreeList,sourceType,currPageNo);
				out.print(html);	
			}
			if(sortWay.equals("2")){
				List<SourceThree> sourceThreeList = sourceService.sortByDown(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceThreeList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("3")){
				List<SourceThree> sourceThreeList = sourceService.sortByAlpha(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceThreeList,sourceType,currPageNo);
				
				out.print(html);
			}
			if(sortWay.equals("4")){
				List<SourceThree> sourceThreeList = sourceService.sortByFileSize(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceThreeList,sourceType,currPageNo);
				
				out.print(html);
			}
		}
		if(sourceType.equals("4")){
			if(sortWay.equals("0")){
				List<SourceFour> sourceFourList = new SourceDAOImpl().getSourceFour();
				String html = new CreateHTMLService(loged).createHTML(sourceFourList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("1")){
				List<SourceFour> sourceFourList = sourceService.sortByTime(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceFourList,sourceType,currPageNo);
				out.print(html);	
			}
			if(sortWay.equals("2")){
				List<SourceFour> sourceFourList = sourceService.sortByDown(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceFourList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("3")){
				List<SourceFour> sourceFourList = sourceService.sortByAlpha(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceFourList,sourceType,currPageNo);
				out.print(html);
			}
			if(sortWay.equals("4")){
				List<SourceFour> sourceFourList = sourceService.sortByFileSize(sourceType);
				String html = new CreateHTMLService(loged).createHTML(sourceFourList,sourceType,currPageNo);
				out.print(html);
			}
		}
		
	}

}
