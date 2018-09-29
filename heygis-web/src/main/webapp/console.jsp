<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.heygis.util.PageViewCounter"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		try {
			String instruct = request.getParameter("instruct");
			System.out.print(instruct);
			if(instruct.equals("pvstore")){
				if(PageViewCounter.store())
					response.getWriter().println("储存成功");
				else
					response.getWriter().println("储存失败");
					
			}else if(instruct.equals("pvsnumber")){
				response.getWriter().println(PageViewCounter.getNum());
			}else{
				response.getWriter().println("无该指令");
			}
		} catch (Exception e) {
			response.getWriter().println("未输入指令");
			return;
		}

%>
</body>
</html>