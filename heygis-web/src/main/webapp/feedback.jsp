<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.heygis.dto.FeedbackMsg"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>heygis-意见反馈</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
	<meta name="description" content="中南林业科技大学gis协会官方网站意见反馈">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
	<script type="text/javascript" src="js/loginJS.js"></script>
	<script type="text/javascript" src="js/feedbackJS.js"></script>
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/feedbackStyle.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
    <div class="navbar navbar-default navbar-fixed-top navbar-inverse nav">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle newMsgMark hidden" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="badge">0</span>
					</button>
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.jsp">首页</a>
						</li>
						<li>
							<a href="index.jsp#bbs">论坛区</a>
						</li>
						<li>
							<a href="sourceServlet?index=panel-1">资源区</a>
						</li>
						<li>
							<a href="index.jsp#lkdVR">林科大全景</a>
						</li>
				<%if((Boolean)request.getAttribute("loged")){ %>
						<li>
							<a href="selfCenterServlet">个人中心<span class="badge hidden">0</span></a>
						</li>
						<li>
							<a class="btn" href="javascript:document:logout.submit()" >退出</a>
						</li>
				<%}else{ %>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li>
							<a class="btn " href="register.jsp">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div>
		<br />
		
		<br />
		<br />
		<h1 class="text-primary">意见反馈</h1>
		请提出您对本网站的意见建议或者网站的bug，我们会及时的回复您并解决反馈的问题。希望在大家的帮助下可以将本网站越办越好!
		<hr />
		<%
		List<FeedbackMsg> feedbackMsgList = (List<FeedbackMsg>)request.getAttribute("feedbackMsgList");
		if(feedbackMsgList != null){
			for(FeedbackMsg msg:feedbackMsgList){
				%>
				<div class="message container">
					<div class="face">
						<img src=<%=msg.getAccountImg() %> class=img-responsive>
					</div>
					<div class="messagebox">
						<span class="triangle"></span>
						<div class="name"><strong>访客:<%=msg.getNickname()%></strong></div>
						<div class="date">发表时间:<%=msg.getTime()%></div>
						<div class="content"><%=msg.getFeedbackContent()%></div>
					</div>
				</div>	
		<%	}
		} %>
		<br />
		<div id="form" class="container">
			<div class="content">
				<form action="addFeedbackServlet" method="post" id="publish">
					<input type="hidden" id="check" name="check" value="0">
					<div class="form-group">
						<textarea form="publish" id="content" name="content" class="form-control" rows="4" placeholder="填写您的留言。在您发布前，请先确认已登录或者已勾选游客模式" onblur="vaildnull()" onfocus="clearr()"></textarea>					
					</div>
					<div class="form-group" id="submit" style="text-align: right;">
						<span class="btn btn-default"  onclick="f()"><input type="checkbox" name="checkbox" id="checkbox"/>使用游客身份匿名发布</span>
						<button name="Submit"  onclick="submitt()" class="btn btn-primary">发布</button>
					</div>
				</form>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<div class="container-fluid footer">
			<div class="container row-fluid foot">
				<div class="col-md-4  col-sm-6 foot-left">
					<h1 class="footh1">联系我们</h1> Email:heygis@163.com
					<br /> QQ:12345678
					<br /> Address:长沙市韶山南路498号中南林业科技大学
					<br />
				</div>
				<div class="col-md-4  col-sm-6 foot-right">
					<h1 class="footh1">相关链接</h1>  
					<a href="###">意见反馈</a>
					<br /> <a href="aboutWeb.jsp">关于本网站</a>
					<br /> <a href="aboutMaker.jsp">关于制作者</a>
					<br />
				</div>
				<div class="col-md-4  col-sm-12 shenming">
					<span>注意：本站资源均来源于原创或网络,如有侵权请联系站长清除。</span>
					<br />
					<a href="http://www.miibeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">湘ICP备16006264</a>

				</div>
			</div>
		</div>
	<div class="theme-popover col-md-12">
			<div class="theme-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<h3>登录 是一种态度</h3>
			</div>
			<div class="theme-popbod dform">
				<form id="loginForm" class="theme-signin" name="loginform"  method="post" onsubmit="return login()">
					<ol>
						<li>
							<h4 id="loginMessage">你必须先登录！</h4>
						</li>
						<li><strong>用户名：</strong>
							<input class="ipt" type="text" name="account" value="" size="20" placeholder="账号（邮箱）" required/>
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="" size="20" placeholder="密码" required/>
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录 " />
						</li>
					</ol>
				</form>
				<form id="logout" method="post" action="logoutServlet">
					<INPUT TYPE="submit" name="test" value = "go" style="display:none"> 
				</form>
			</div>
		</div>
		<div class="theme-popover-mask"></div>
  </body>
  <script type="text/javascript" src="js/newMsg.js"></script>
	<script>
		var loged = <%=request.getAttribute("loged") %>;
		var uid = <%=request.getAttribute("uid")%>
	</script>
</html>
