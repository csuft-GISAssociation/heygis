<%@page import="com.heygis.beans.ForumThread"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.heygis.beans.ForumPostPage" %>
<%@ page import="com.heygis.beans.ForumPost" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	ForumPostPage postPage = (ForumPostPage)request.getAttribute("postPage");
	SimpleDateFormat formatter = new SimpleDateFormat ("yy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<!--<script type="text/javascript" src="js/loginJS.js"></script>
		<script src="http://twemoji.maxcdn.com/twemoji.min.js"></script>-->
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/topics.js"></script>
		<script type="text/javascript" src="forums/google-code-prettify/prettify.js"></script>
		<link href="forums/google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/css.css">
		<link rel="stylesheet" type="text/css" href="css/loginStyle.css" />
		<link rel="stylesheet" type="text/css" href="css/topics.css" />
		<link rel="stylesheet" type="text/css" href="css/navCSS.css" />
	</head>

	<body onload="prettyPrint()">
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
						<li class="active">
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
				<%if((Boolean)request.getAttribute("loged")){ %>
						<li>
							<a href="selfCenterServlet">个人中心</a>
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
							<input class="ipt" type="text" name="account" value="1234" size="20" />
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" name="password" value="1234" size="20" />
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
		<div class="theme-popover-mask">
		</div>
		<div class="post_wraper container">
			<div class="row">
				<div class="thread_title col-md-10 col-sm-12 col-center-block">
					<h1 style="font-size: 30px;">
						<span><%=postPage.getPost(0).getSubject()%></span>
					</h1>
				</div>
				<div  class="col-md-10 col-sm-12 col-center-block thread_path">
						<a href="forumsServlet?fid=<%=postPage.getPost(0).getFid() %>&page=<%=postPage.getfPage() %>">> 返回帖子列表 </a>
						<div class="clear"></div>
				</div>
				<div class="postlist col-md-10 col-sm-12 col-center-block">
				<%
					ForumPost post = null;
				    for(int i=0;i<30;i++){
						if(postPage.getPost(i) == null)
							break;
						post = postPage.getPost(i);
				%>
					<div id="position<%=post.getPosition() %>"></div>
					<div class="post">
						<div class="p_author col-md-2 col-sm-2 col-xs-2 ">
							<div class="p_author_icon  col-md-8 col-sm-9 col-xs-12 col-center-block">
								<img class="img-responsive" src="img/max.png" />
							</div>
							<a herf="">
								<%=post.getAuthor() %>
							</a>
						</div>
						<div class="p_content col-md-10 col-sm-10 col-xs-10">
							<div class="p_detail" id="message<%=post.getPosition() %>"><%=post.getMessage() %></div>
							<div class="replay_tail">
								<ul>
									<li>
										<a class="replay" href="#">管理</a>
									</li>
									<li>
										<a class="replay" href="###" onclick="reply(<%=post.getPosition()%>,<%=post.getAuthorUid()%>,'<%=post.getAuthorAccount()%>','<%=post.getAuthor()%>',<%=post.getPid()%>)">回复</a>
									</li>
									<li><%=formatter.format(post.getDateline()) %></li>
								</ul>
							</div>
						</div>
					</div>
				<%} %>
				</div>
			</div>
		</div>
		<div class="post_reply_wraper container">
			<div class="row">
				<form action='addPostServlet?fid=<%=post.getFid() %>&tid=<%=postPage.getTid() %>' method="post" id="postpubllic">
					<div class="post_reply_content col-center-block col-md-10 col-sm-12">
						<!--<div style="height: auto;">
							<div class="post_reoly_head col-md-8 col-sm-12">
								发表回复
							</div>
							<div class="clear"></div>
						</div>-->
						<div id="textarea" style="height: auto;">
							<div class="post_reply_textarea col-md-9 col-sm-12">
								<a herf="#">添加表情</a>
								<p>|</p>
								<a herf="#">添加代码</a>
								<p>|</p>
								<a herf="#">添加图片</a>
								<textarea id="textarea_post" name="message"></textarea>
							</div>	
							<div class="clear"></div>
						</div>
						<div id="submit">
							<input type="button" class="post_reply_submit  btn btn-primary" value="发表" id="post_submit" onclick="postPublic()"/>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>	
		<div class="reply col-md-12">
			<div class="reply-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<p>回复:</p>
				<div class="clear"></div>
			</div>
				<form id="posi_reply_form" action="replyPostServlet?fid=<%=post.getFid() %>&tid=<%=postPage.getTid() %>" method="post">
					<div class="posi_reply_content col-center-block col-md-12 col-sm-12">
						<div id="textarea" style="height: auto;">
							<div class="posi_reply_textarea col-md-9 col-sm-12">
								<a herf="#">添加表情</a>
								<p>|</p>
								<a herf="#">添加代码</a>
								<p>|</p>
								<a herf="#">添加图片</a>
								<textarea id="posi_reply_textarea" name="message"></textarea>
							</div>	
							<div class="clear"></div>
						</div>
						<input type="text" name="postauthor_uid" id="postauthor_uid" style="display: none; " value="0"/>
						<input type="text" name="postauthor_account" id="postauthor_account" style="display: none; " value="0"/>
						<input type="text" name="posi" id="posi" style="display: none; " value="0"/>
						<input type="text" name="replyhead" id="replyhead" style="display: none; " value="0" />
						<input type="hidden" name="replypid" id="replypid" value="0"/> 
						<input type="text" name="subject" id="subject" style="display: none; " value="<%=postPage.getPost(0).getSubject()%>"/>
						<div id="submit">
							<input type="button" class="posi_subButton btn btn-primary" value="发表" id="post_submit" onclick="posiReplyPublic()"/>
						</div>
						<div class="clear"></div>
					</div>
				</form>
		</div>
	</body>
	<script>
		var loged = <%=request.getAttribute("loged") %>;
	</script>
</html>