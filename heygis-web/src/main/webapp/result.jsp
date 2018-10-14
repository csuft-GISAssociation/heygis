<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="commonPage/cdnJS_cdnCSS.html"></jsp:include>

</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-md-10 col-sm-12 col-center-block">
					<div style="padding-top: 20px;font-size:30px">
						<%=request.getAttribute("message") %>
					</div>
				</div>
			</div>
	</div>			
</body>
</html>