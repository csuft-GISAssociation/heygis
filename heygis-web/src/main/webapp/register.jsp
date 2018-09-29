<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
		<meta name="description" content="中南林业科技大学gis协会官方网站注册页面">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/registerJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/registerStyle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" media="screen" href="css/BGstyle.css">
		
		<title>heygis-注册</title>
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
							<a class="btn " href="javascript:;">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div>		
		
		<div style="position:absolute; width:100%;height:100%">
			<div id="particles-js"></div>
			<script src="js/particles.js"></script>
			<script src="js/app.js"></script>
		</div>
				
		<div class="container mainbody">
			<div class="row"><br /> <br /> <br /> 
				<h1 class="text-primary">注册</h1>
				<br /> 
				<div class="col-sm-offset-3 col-sm-6">
					<form class="form-horizontal" role="form" id="registerForm" action="registerServlet" method="post">
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="email" name="account1" class="form-control" id="inputEmail3" placeholder="邮箱   将作为您登陆的账号" onblur="testEmail()" onclick="clear()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark1"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="password" name="passWord" class="form-control" id="inputPassword1" placeholder="密码(已使用md5加密) 6~22位数字字符或者特殊符号" onblur="testPwd()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark2"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="password" class="form-control" id="inputPassword2" placeholder="请再次输入密码" onblur="testRePwd()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark3"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="text" name="nickName" class="form-control" id="inputnickName" placeholder="昵称" onblur="testNickName()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark4"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<input type="text" name="grade" class="form-control" id="inputGrade" placeholder="入学年份 例如：2013" onblur="testGrade()">
								</div>
								<div class="col-xs-1 judge">
									<label class="control-label" id="mark5"></label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10" id="submitt">
									<button class="btn btn-primary btn-block" type="button"  onclick="register()">注册</button>
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
							<input class="ipt" type="text" name="account" value="" size="20" placeholder="账号（邮箱）" required/>
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="" placeholder="密码" size="20" required/>
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
	<script type="text/javascript" src="js/newMsg.js"></script>
	<script>
		var loged = <%=request.getAttribute("loged") %>;
		var uid = <%=request.getAttribute("uid")%>
	</script>
</html>