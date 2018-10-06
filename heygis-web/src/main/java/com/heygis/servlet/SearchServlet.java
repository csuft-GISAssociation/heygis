package com.heygis.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heygis.service.CreateHTMLService;
import com.heygis.service.interfaces.SourceService;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchServlet extends HttpServlet {

	@Autowired
	private SourceService sourceService;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;chatset=UTF-8");
		PrintWriter out = response.getWriter();
		String sourceType = request.getParameter("sourceType");
		String searchCtx = request.getParameter("searchCtx");
		int currPageNo = Integer.parseInt(request.getParameter("currPageNo"));
		Boolean loged = (Boolean)request.getAttribute("loged");
		List list = sourceService.searchByCtx(sourceType, searchCtx);
		if(list.size()==0){
			out.print("<div class='container'><h1 style='color:white;text-align:center'>啥也没有找到！</h1></div>");
		}else{
			int maxIndex = list.size()/15+1;
			String script = null;
			if(currPageNo > maxIndex){
				currPageNo = maxIndex;
				script ="<script>currPageNo"+sourceType+"="+maxIndex+"</script>";
			}
			String html = new CreateHTMLService(loged).createHTML(list, sourceType, currPageNo);	
			out.print(html+script);	  
		}
		
	}

}
