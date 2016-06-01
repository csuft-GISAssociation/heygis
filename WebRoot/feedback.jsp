<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.heygis.beans.FeedbackMsg"%>
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
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/loginJS.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="index.html#bbs">论坛区</a>
						</li>
						<li>
							<a href="source1.jsp">资源区</a>
						</li>
						<li>
							<a href="index.html#lkdVR">林科大全景</a>
						</li>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">个人中心 </a>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="#">一</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<br />
		
		<br />
		<br />
		<h1 class="text-primary">意见反馈</h1>
		<p>您有任何关于本网站的建议或意见都可以在这里提出来，包括您找到的bug，我们会仔细阅读每一条反馈，并及时回复您的反馈。</p>
		<hr />
		<%
		List<FeedbackMsg> feedbackMsgList = (List<FeedbackMsg>)request.getAttribute("feedbackMsgList");
		if(feedbackMsgList != null){
			for(FeedbackMsg msg:feedbackMsgList){
				%>
				<div class="message container">
					<div class="face">
						<img src=img/bbs-1.JPG class=img-responsive>
					</div>
					<div class="messagebox">
						<span class="triangle"></span>
						<div class="name"><strong>作者:<%=msg.getNickname()%></strong></div>
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
					<div class="form-group">
						<textarea form="publish" name="content" class="form-control" rows="4" placeholder="请填写您的留言" required></textarea>					
					</div>
					<div class="form-group" style="text-align: right;">
						<input type="submit" name="Submit" value="发布 " class="submitButton btn btn-primary"/>
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
					<a href="feedback.html">意见反馈</a>
					<br /> <a href="aboutWeb.html">关于本网站</a>
					<br /> <a href="aboutMaker.html">关于制作者</a>
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
				<form class="theme-signin" name="loginform" action="" method="post">
					<ol>
						<li>
							<h4>你必须先登录！</h4></li>
						<li><strong>用户名：</strong>
							<input class="ipt" type="text" name="log" value="account" size="20" />
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="pwd" value="" size="20" />
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录 " />
						</li>
					</ol>
				</form>
			</div>
		</div>
		<div class="theme-popover-mask"></div>
  </body>
</html>
