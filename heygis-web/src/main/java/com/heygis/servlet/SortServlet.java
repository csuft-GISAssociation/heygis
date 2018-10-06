package com.heygis.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.dto.SourceFour;
import com.heygis.dto.SourceOne;
import com.heygis.dto.SourceThree;
import com.heygis.dto.SourceTwo;
import com.heygis.service.CreateHTMLService;
import com.heygis.service.interfaces.SourceService;
import org.springframework.beans.factory.annotation.Autowired;


public class SortServlet extends HttpServlet {
	
	@Autowired
	private SourceService sourceService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sortWay = request.getParameter("sortWay");
		String sourceType = request.getParameter("sourceType");
		int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));
		Boolean loged = (Boolean)request.getAttribute("loged");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		if(sourceType.equals("1")){
			if(sortWay.equals("0")){
				List<SourceOne> sourceOneList = sourceService.getSourceOneList();
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
				List<SourceTwo> sourceTwoList = sourceService.getSourceTwoList();
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
				List<SourceThree> sourceThreeList = sourceService.getSourceThreeList();
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
				List<SourceFour> sourceFourList = sourceService.getSourceFourList();
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
