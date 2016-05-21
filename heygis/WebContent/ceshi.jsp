<%@page import="com.heygis.beans.SourceThree"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ceshi.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/npm.js"></script>
	<script type="text/javascript" src="js/loginJS.js"></script>
	<script type="text/javascript" src="js/source1JS.js"></script>
	<link href="css/source1Style.css" rel="stylesheet" type="text/css" />
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/navCSS.css" rel="stylesheet" type="text/css">
	<link href="css/footStyle.css" rel="stylesheet" type="text/css">
	<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
	<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />

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
					<a class="navbar-brand"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="index.html#bbs">论坛区</a>
						</li>
						<li>
							<a href="index.html#sourceDownLoad">资源区</a>
						</li>
						<li>
							<a href="#">关于我们</a>
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
		<div class="container tabs">
			<div class="row">
				<div class="col-lg-12">
					<div class="tabbable" id="tabs">
						<ul class="nav nav-tabs">
							<li class="active col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-1" >总结大会</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-2" >课堂源码</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-3" >开发工具</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-4" >拓展强化</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-1">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary">总结大会</h1>
											<p>Etiam quis viverra lorem, in semper lorem. Sed nisl arcu euismod sit amet nisi euismod sed cursus arcu elementum ipsum arcu vivamus quis venenatis orci lorem ipsum et magna feugiat veroeros aliquam. Lorem ipsum dolor sit amet nullam dolore.</p>
										</header>
										<section class="tiles">

											<article class="style1">
												<span class="image">
																<img src="img/xingkong.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Magna</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style2">
												<span class="image">
																<img src="img/myeclipse.png" alt="" />
															</span>
												<div class="detail">
													<h2>MyEclipse</h2>
													<h4>nihai</h4>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
														<a>官方下载地址</a>|<a>本站下载地址</a>
													</div>
												</div>
												
											</article>
											<article class="style3">
												<span class="image">
																<img src="img/eclipse.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Feugiat</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style4">
												<span class="image">
																<img src="img/sublime.png" alt="" />
															</span>
												<div class="detail">
													<h2>Tempus</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style5">
												<span class="image">
																<img src="img/visualstudio.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Aliquam</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style6">
												<span class="image">
																<img src="img/oracle.png" alt="" />
															</span>
												<div class="detail">
													<h2>Veroeros</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style2">
												<span class="image">
																<img src="img/tomcat.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Ipsum</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style3">
												<span class="image">
																<img src="img/heidisql.png" alt="" />
															</span>
												<div class="detail">
													<h2>Dolor</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style1">
												<span class="image">
																<img src="img/navicat.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Nullam</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style5">
												<span class="image">
																<img src="img/pic10.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Ultricies</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style6">
												<span class="image">
																<img src="img/pic11.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Dictum</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
											<article class="style4">
												<span class="image">
																<img src="img/pic12.jpg" alt="" />
															</span>
												<div class="detail">
													<h2>Pretium</h2>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
													</div>
												</div>
											</article>
										</section>
									</div>
								</div>
							</div>

							<div class="tab-pane" id="panel-2">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary">开发工具</h1>
											<p>Etiam quis viverra lorem, in semper lorem. Sed nisl arcu euismod sit amet nisi euismod sed cursus arcu elementum ipsum arcu vivamus quis venenatis orci lorem ipsum et magna feugiat veroeros aliquam. Lorem ipsum dolor sit amet nullam dolore.</p>
										</header>
										<section class="tiles">
											
											<article class="style2">
												<span class="image">
													<img src="img/myeclipse.png" alt="" />
												</span>
												<div class="detail">
													<h2>MyEclipse</h2>
													<h4>nihai</h4>
													<div class="content">
														<p>Sed nisl arcu euismod sit amet nisi lorem etiam dolor veroeros et feugiat.</p>
														<a>官方下载地址</a>|<a>本站下载地址</a>
													</div>
												</div>
											</article>
										</section>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-3">
								<!-- 
								
								 --><%=Math.random() %>
								 
							</div>
							<div class="tab-pane" id="panel-4">
								<p>
									第二部分内容.
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

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
					<br /> 关于制作者
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
							<input class="ipt" type="text" name="log" value="caibaojian" size="20" />
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="pwd" value="***" size="20" />
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
