<%@page import="com.heygis.beans.SourceFour"%>
<%@page import="com.heygis.beans.SourceTwo"%>
<%@page import="com.heygis.beans.SourceOne"%>
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
    
    <title>heygis-资源下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
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
					<a class="navbar-brand" href="index.html"><span class="heygis">HeyGIS</span></a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.html">首页</a>
						</li>
						<li>
							<a href="forums/forums.jsp">论坛区</a>
						</li>
						<li class="active" >
							<a href="#">资源区</a>
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
		<div class="container tabs">
			<div class="row">
				<div class="col-lg-12">
					<div class="tabbable" id="tabs">
						<ul class="nav nav-tabs">
							<li class="active col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-1" data-toggle="tab">总结大会</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-2" data-toggle="tab">课堂源码</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-3" data-toggle="tab">开发工具</a>
							</li>
							<li class="col-lg-3 col-md-3 col-xs-6">
								<a href="#panel-4" data-toggle="tab">拓展强化</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-1">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle" >总结大会</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
												    	<div class="input-group input-group-sm">
													      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3">
													      <span class="input-group-btn">
													        <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
													      </span>
													    </div>
													</li>
											    <li><a href="javascript:timecho(1,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(1,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(1,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(1,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(1,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>每一年的总结大会的作品都整理在了这里，欢迎大家互相借鉴，互相学习。</p>
										</header>
										<section class="tiles" id="section_1">
											<%
											for(SourceOne sourceOne : (List<SourceOne>)request.getAttribute("sourceOneList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceOne.getName() %>(<%=sourceOne.getLevel() %>)</h2>
													<h4>作者:<%=sourceOne.getUploader() %></h4>
													<h4>下载次数:<%=sourceOne.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceOne.getFile_size() %></h5>
													<h5>上传时间:<%=sourceOne.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceOne.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg" href="<%=sourceOne.getDownload_link()%>">本站下载地址</a>
													</div>
												</div>
											</article>
											 <%}%>
										</section>
									</div>
								</div>
							</div>

							<div class="tab-pane" id="panel-2">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">课堂源码</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
												    	<div class="input-group input-group-sm">
													      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3">
													      <span class="input-group-btn">
													        <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
													      </span>
													    </div>
													</li>
											    <li><a href="javascript:timecho(2,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(2,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(2,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(2,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(2,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>不仅要看懂课堂上的代码，还要多敲多练。锻炼手指的记忆，增强代码熟练度。</p>
										</header>
										<section class="tiles" id="section_2">
											<%
											for(SourceTwo sourceTwo : (List<SourceTwo>)request.getAttribute("sourceTwoList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceTwo.getName() %></h2>
													<h4>作者:<%=sourceTwo.getUploader() %></h4>
													<h4>下载次数:<%=sourceTwo.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceTwo.getFile_size() %></h5>
													<h5>上传时间:<%=sourceTwo.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceTwo.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg" href="<%=sourceTwo.getDownload_link()%>">本站下载地址</a>
													</div>
												</div>
											</article>
											<%}%>
										</section>
										
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-3">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">开发工具</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
											    	<div class="input-group input-group-sm">
												      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3">
												      <span class="input-group-btn">
												        <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
												      </span>
												    </div>
													</li>
											    <li><a href="javascript:timecho(3,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(3,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(3,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(3,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(3,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>如果只是在面临老师布置的各种课程设计时才想到我的话，那就太可惜了。</p>
										</header>
										<section class="tiles" id="section_3">
											<%
											for(SourceThree sourceThree : (List<SourceThree>)request.getAttribute("sourceThreeList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceThree.getName() %></h2>
													<h4>下载次数:<%=sourceThree.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceThree.getFile_size() %></h5>
													<h5>上传时间:<%=sourceThree.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceThree.getIntroduction() %></p>
														<a class="btn btn-primary btn-md" href="<%=sourceThree.getDownload_link_offical()%>">官方下载地址</a> 
														<a class="btn btn-primary btn-md" href="<%=sourceThree.getDownload_link()%>">本站下载地址</a>
													</div>
												</div>
											</article>
											 <%}%>
										</section>
										
									</div>
								</div>
							</div>
							<div class="tab-pane" id="panel-4">
								<div id="main">
									<div class="inner">
										<header class="page-header">
											<h1 class="text-primary sourceTitle">拓展强化</h1>
											<div class="btn-group btn-choose" >
											  <button type="button" class="btn btn-primary dropdown-toggle choose" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
											    默认排序 <span class="caret"></span>
											  </button>
											  <ul class="dropdown-menu">
											  	<li>
												    	<div class="input-group input-group-sm">
													      <input type="text" class="form-control" placeholder="search" aria-describedby="sizing-addon3">
													      <span class="input-group-btn">
													        <button class="btn btn-default btn-sm" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
													      </span>
													    </div>
													</li>
											    <li><a href="javascript:timecho(4,1)" id="timecho">按上传时间</a></li>
											    <li><a href="javascript:timescho(4,2)" id="timescho">按下载数</a></li>
											    <li><a href="javascript:alphacho(4,3)" id="alphacho">按字母</a></li>
											    <li><a href="javascript:sizecho(4,4)"  id="sizecho">按文件大小</a></li>
											    <li role="separator" class="divider"></li>
											    <li><a href="javascript:defaultcho(4,0)" id="defaultcho">默认排序</a></li>
											  </ul>
											</div>
											<p>青春不是用来虚度的，而是用来投资自己的。</p>
										</header>
										<section class="tiles" id="section_4">
											<%
											for(SourceFour sourceFour : (List<SourceFour>)request.getAttribute("sourceFourList")){
											String st = "style"+(new Random().nextInt(5)+1);
											String bg = "img/pic"+(new Random().nextInt(14)+1)+".jpg";
											%><article class="<%=st%>">
											        <span class="image">
														<img src="<%=bg%>" alt="" />
													</span>
													<div class="detail">
													<h2><%=sourceFour.getName() %></h2>
													<h4>作者:<%=sourceFour.getUploader() %></h4>
													<h4>下载次数:<%=sourceFour.getDownload_times() %></h4>
													<h5>文件大小:<%=sourceFour.getFile_size() %></h5>
													<h5>上传时间:<%=sourceFour.getUpload_time() %></h5>
													<div class="content">
														<p><%=sourceFour.getIntroduction() %></p>
														<a class="btn btn-primary btn-lg" href="<%=sourceFour.getDownload_link()%>">本站下载地址</a>
													</div>
												</div>
											</article>
											<%}%>
										</section>
									</div>
								</div>
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
					<br /><a href="aboutMaker.html"> 关于制作者</a>
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
							<input class="ipt" type="password" name="pwd" value="password" size="20" />
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
