<%@page import="com.heygis.dto.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(!(Boolean)request.getAttribute("loged")){
	response.sendRedirect("index.jsp");
	return;
}
User user = (User)request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<script src="//cdn.bootcss.com/jquery.form/3.51/jquery.form.js"></script>
		
		<script type="text/javascript" src="js/loginJS.js"></script>
		<script type="text/javascript" src="js/fillInfoJS.js"></script>
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/fillInfoStyle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" media="screen" href="css/BGstyle.css">
		
		<title>heygis-完善信息</title>
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
							<a class="active" href="selfCenterServlet">个人中心<span class="badge hidden">0</span></a>
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
		<div style="position:absolute; width:100%;height:100%">
			<div id="particles-js"></div>
			<script src="js/particles.js"></script>
			<script src="js/app.js"></script>
		</div>
		<div class="section">
			<div class="container">
				<br /><br /><br />
				<h1 class="text-primary">完善信息</h1>
				<div class="row" style="color:white">
					<div class="col-md-12">
						<form class="form-horizontal" role="form" id="fillInfoForm" action="fillInfoServlet" method="post">
							<div class="form-group">
								<h3>必填信息</h3>
							    <label class="col-sm-offset-2 col-xs-2 text-right">邮箱</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="email" class="form-control" id="Email"  value="<%=user.getAccount() %>" disabled="true">
							    	 <input type="hidden" class="form-control" name="account" value="<%=user.getAccount() %>">
							    </div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">昵称</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="nickName" name="nickName" value="<%=user.getNickName() %>" onblur="testNickName()">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark1"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">年级</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="grade" name="grade" value="<%=user.getGrade() %>" onblur="testGrade()">
							    </div>
							     <div class="col-xs-1 judge">
									<label class="control-label" id="mark2"></label>
								</div>
							</div>
							<div class="form-group">
								<h3>选填信息</h3>
							    <label class="col-sm-offset-2 col-xs-2 text-right">个性签名</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="selfintroduction" name="selfintroduction" value="<%=user.getSelfIntroduction() %>">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark3"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">性别</label>
							    <div class="col-xs-9 col-sm-6">
							    	<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios0" value="保密">保密
										</label>
									</div>
							    	<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios1" value="男">男
										</label>
									</div>
									<div class="radio-inline col-xs-3 col-sm-2">
										<label>
										    <input type="radio" name="optionsRadios" id="optionsRadios2" value="女">女
										</label>
									</div>
							    </div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">QQ</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="QQ" name="QQ" value="<%=user.getQQ() %>">
							    </div>
							    <div class="col-xs-1 judge">
									<label class="control-label" id="mark4"></label>
								</div>
							</div>
							<div class="form-group">
							    <label class="col-sm-offset-2 col-xs-2 text-right">电话</label>
							    <div class="col-xs-9 col-sm-6">
							    	 <input type="text" class="form-control" id="tel" name="tel" value="<%=user.getTel() %>">
							    </div>
							     <div class="col-xs-1 judge">
									<label class="control-label" id="mark5"></label>
								</div>
							</div>
							<div class="col-sm-offset-3 col-sm-7" id="submitt">
								<button class="btn btn-primary btn-block" onclick="fillInfo()">确定修改</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<br /><br />
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
<script type="text/javascript">
   	var gender = "<%=user.getGender()%>";
   	if(gender=="男"){
   		$("#optionsRadios1").prop("checked",true);
   	}
   	if(gender=="女"){
   		$("#optionsRadios2").prop("checked",true);
   	}
   	if(gender=="保密"){
   		$("#optionsRadios0").prop("checked",true);
   	}
   </script>
