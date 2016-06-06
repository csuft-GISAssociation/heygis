<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
		<meta name="description" content="中南林业科技大学gis协会官方网站注册页面">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/registerJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/registerStyle.css" rel="stylesheet" type="text/css" />
		<title>heygis-注册</title>
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
							<a href="sourceServlet">资源区</a>
						</li>
						<li>
							<a href="index.jsp#lkdVR">林科大全景</a>
						</li>
					<%if(session.getAttribute("loged") != null){ %>
						<%if(session.getAttribute("loged").equals(true)){ %>
						<li>
							<a href="selfCenterServlet">个人中心</a>
						</li>
						<li>
							<a class="btn" href="javascript:document:logout.submit()" >退出</a>
						</li>
						<%} %>
				<%}else{ %>
						<li>
							<a class="btn theme-login" href="javascript:;">登录</a>
						</li>
						<li class="active">
							<a class="btn " href="javascript:;">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div class="container Top">
			<div class="row">
				<h1 class="text-primary">注册</h1>
				<br />
				<div class="col-sm-offset-3 col-sm-6">
					<form class="form-horizontal" role="form" id="registerForm" action="registerServlet" method="post">
							<div class="form-group">
								<div class="col-xs-3 textRight">
									<label class="control-label">Email</label>
								</div>
								<div class="col-xs-8">
									<input type="email" name="account" class="form-control" id="inputEmail3" placeholder="Email" onblur="testEmail()" onclick="clear()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark1"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3 textRight">
									<label class="control-label">Password</label>
								</div>
								<div class="col-xs-8">
									<input type="password" name="passWord" class="form-control" id="inputPassword1" placeholder="Password 6~22位数字字符或者特殊符号" onblur="testPwd()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark2"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3 textRight">
									<label class="control-label">Reenter password</label>
								</div>
								<div class="col-xs-8">
									<input type="password" class="form-control" id="inputPassword2" placeholder="Reenter password" onblur="testRePwd()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark3"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3 textRight">
									<label class="control-label">nickName</label>
								</div>
								<div class="col-xs-8">
									<input type="text" name="nickName" class="form-control" id="inputnickName" placeholder="nickName" onblur="testNickName()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark4"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3 textRight">
									<label for="inputPassword3" class="control-label">Grade</label>
								</div>
								<div class="col-xs-8">
									<input type="text" name="grade" class="form-control" id="inputGrade" placeholder="入学年份 例如：2013" onblur="testGrade()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark5"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-8" id="submitt">
									<button class="btn btn-primary btn-block" type="button"  onclick="register()">Sign in</button>
								</div>
							</div>
						</form>
				</div>
			</div>
		</div>
		
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
					<a href="feedbackServlet">意见反馈</a>
					<br /> <a href="aboutWeb.jsp">关于本网站</a>
					<br /> <a href="aboutMaker.jsp"> 关于制作者</a>
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
							<input class="ipt" type="text" name="account" value="" size="20" placeholder="Your Email"/>
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="" placeholder="password" size="20" />
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" value=" 登 录    " />
							<a href="register.jsp">&nbsp;注册</a>
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
</html>