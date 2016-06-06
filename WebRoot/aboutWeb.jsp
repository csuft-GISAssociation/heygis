<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="keywords" content="heygis,地理信息科学,中南林业科技大学GIS">
		<meta name="description" content="中南林业科技大学gis协会官方网站">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery.form.js"></script>
		<script type="text/javascript" src="js/loginJS.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/aboutWebStyle.css" rel="stylesheet" type="text/css" />
		<title>heygis-关于本网站</title>
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
						<li>
							<a class="btn " href="register.jsp">注册</a>
						</li>
					<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
            <h1 class="marTop">关于本网站</h1>
            <h2 class="ss-subtitle">从想法到实际</h2>
            <div id="ss-container" class="ss-container">
                <div class="ss-row">
                    <div class="ss-left">
                        <h2 id="november">一切开始</h2>
                    </div>
                    <div class="ss-right">
                        <h2>2015底</h2>
                    </div>
                </div>
                <div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a class="ss-circle ss-circle-1"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>December, 2015</span>
                            <a href="javascript:0;">想为协会制作一个网站的想法萌发。。。</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <h3>
                            <span>January 15, 2016</span>
                            <a href="javascript:0;">参与老师的vr项目，接触网站设计</a>
                        </h3>
                    </div>
					<div class="ss-right">
                        <a href="" class="ss-circle ss-circle-2"></a>
                    </div>
                </div>
                <div class="ss-row ss-small">
                    <div class="ss-left">
						<a href="" class="ss-circle ss-circle-3"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>February, 2016</span>
                            <a href="">寒假中自学jsp,学习百度lbs,学习使用axure进行网页界面原型设计。</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <h3>
                            <span>March, 2016</span>
                            <a href="">有学弟学妹来询问开发工具的下载，确定了为协会制作一网站的决心。开始讨论网站功能。</a>
                        </h3>
                    </div>
					<div class="ss-right">
                        <a href="" class="ss-circle ss-circle-4"></a>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-5"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>March 17, 2016</span>
                            <a href="">利用Axure设计出首页的原型，雏形初现</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-6"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>March, 2016</span>
                            <a href="">讨论完善其余功能，确定下资源下载板块与论坛版块两大部分。</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <h3>
                            <span>April, 2016</span>
                            <a href="">开始着手其他个界面的UI设计，</a>
                        </h3>
                    </div>
					<div class="ss-right">
                        <a href="" class="ss-circle ss-circle-7"></a>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                        <h3>
                            <span>April,2016</span>
                            <a href="">最终确定网站所有功能。开始做着手UI界面设计。讨论网站域名</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="" class="ss-circle ss-circle-8"></a>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-9"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>April 24, 2016</span>
                            <a href="">首页的html界面写完，域名备案成功</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-10"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>April, 2016</span>
                            <a href="">讨论bbs的数据库设计，网上看了discuz，确定bbs数据结构</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <h3>
                            <span>April, 2016</span>
                            <a href="">其余界面的html逐渐编写完成，添加了意见反馈模块</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="" class="ss-circle ss-circle-11"></a>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-12"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>May 1, 2016</span>
                            <a href="">开始写后台逻辑</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <h3>
                            <span>May 10, 2016</span>
                            <a href="">逻辑逐渐完成，网站基本功能实现</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="" class="ss-circle ss-circle-13"></a>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-14"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>May 9, 2016</span>
                            <a href="">重新设计UI</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row">
                    <div class="ss-left">
                        <h2 id="september">September</h2>
                    </div>
                    <div class="ss-right">
                        <h2>2011</h2>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                        <h3>
                            <span>September 30, 2011</span>
                            <a href=""></a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="" class="ss-circle ss-circle-15"></a>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-16"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>September 27, 2011</span>
                            <a href="">Multi-level Photo Map</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-17"></a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>September 20, 2011</span>
                            <a href="">Responsive Image Gallery with Thumbnail Carousel</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
						<h3>
                            <span>September 12, 2011</span>
                            <a href="">Elastislide - A Responsive jQuery Carousel Plugin</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="" class="ss-circle ss-circle-18">Elastislide - A Responsive jQuery Carousel Plugin</a>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a href="" class="ss-circle ss-circle-19">Slicebox - A fresh 3D image slider with graceful fallback </a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>September 5, 2011</span>
                            <a href="">Slicebox - A fresh 3D image slider with graceful fallback </a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row">
                    <div class="ss-left">
                        <h2 id="august">August</h2>
                    </div>
                    <div class="ss-right">
                        <h2>2011</h2>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
						<h3>
                            <span>August 30, 2011</span>
                            <a href="">Automatic Image Montage with jQuery</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Development/AutomaticImageMontage/" class="ss-circle ss-circle-20">Automatic Image Montage with jQuery</a>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a href="http://tympanus.net/Development/ImageZoomTour/" class="ss-circle ss-circle-21">Image Zoom Tour with jQuery</a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>August 23, 2011</span>
                            <a href="http://tympanus.net/Development/ImageZoomTour/">Image Zoom Tour with jQuery</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
						<h3>
                            <span>August 16, 2011</span>
                            <a href="http://tympanus.net/Development/CircularContentCarousel/">Circular Content Carousel with jQuery</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Development/CircularContentCarousel/" class="ss-circle ss-circle-22">Circular Content Carousel with jQuery</a>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="http://tympanus.net/Tutorials/PortfolioImageNavigation/" class="ss-circle ss-circle-23">Portfolio Image Navigation with jQuery</a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>August 9, 2011</span>
                            <a href="http://tympanus.net/Tutorials/PortfolioImageNavigation/">Portfolio Image Navigation with jQuery</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
						<h3>
                            <span>August 4, 2011</span>
                            <a href="http://tympanus.net/Development/FullscreenGridPortfolioTemplate/">Expanding Fullscreen Grid Portfolio</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Development/FullscreenGridPortfolioTemplate/" class="ss-circle ss-circle-24">Expanding Fullscreen Grid Portfolio</a>
                    </div>
                </div>
				<div class="ss-row">
                    <div class="ss-left">
                        <h2 id="july">July</h2>
                    </div>
                    <div class="ss-right">
                        <h2>2011</h2>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                        <a href="http://tympanus.net/Development/ContentRotator/example1.html" class="ss-circle ss-circle-25">Content Rotator with jQuery</a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>July 29, 2011</span>
                            <a href="http://tympanus.net/Development/ContentRotator/example1.html">Content Rotator with jQuery</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
						<h3>
                            <span>July 22, 2011</span>
                            <a href="http://tympanus.net/Development/VerticalSlidingAccordion/example1.html">Vertical Sliding Accordion with jQuery</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Development/VerticalSlidingAccordion/example1.html" class="ss-circle ss-circle-26">Vertical Sliding Accordion with jQuery</a>
                    </div>
                </div>
				<div class="ss-row ss-medium">
                    <div class="ss-left">
                        <a href="http://tympanus.net/Tutorials/AnimatedTextIconMenu/example1.html" class="ss-circle ss-circle-27">Animated Text and Icon Menu with jQuery</a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>July 12, 2011</span>
                            <a href="http://tympanus.net/Tutorials/AnimatedTextIconMenu/example1.html">Animated Text and Icon Menu with jQuery</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
						<h3>
                            <span>July 5, 2011</span>
                            <a href="http://tympanus.net/Tutorials/FullscreenSlideshowAudio/">Fullscreen Slideshow with HTML5 Audio and jQuery</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Tutorials/FullscreenSlideshowAudio/" class="ss-circle ss-circle-30">Fullscreen Slideshow with HTML5 Audio and jQuery</a>
                    </div>
                </div>
				<div class="ss-row ss-large">
                    <div class="ss-left">
                        <a href="http://tympanus.net/Development/SlidingBackgroundImageMenu/example5.html" class="ss-circle ss-circle-28">Sliding Background Image Menu with jQuery</a>
                    </div>
                    <div class="ss-right">
                        <h3>
                            <span>July 3, 2011</span>
                            <a href="http://tympanus.net/Development/SlidingBackgroundImageMenu/example5.html">Sliding Background Image Menu with jQuery</a>
                        </h3>
                    </div>
                </div>
				<div class="ss-row">
                    <div class="ss-left">
                        <h2 id="june">June</h2>
                    </div>
                    <div class="ss-right">
                        <h2>2011</h2>
                    </div>
                </div>
				<div class="ss-row ss-small">
                    <div class="ss-left">
                       <h3>
                            <span>June 9, 2011</span>
                            <a href="http://tympanus.net/Development/GridNavigationEffects/example5.html">Grid Navigation Effects with jQuery</a>
                        </h3>
                    </div>
                    <div class="ss-right">
						<a href="http://tympanus.net/Development/GridNavigationEffects/example5.html" class="ss-circle ss-circle-29">Grid Navigation Effects with jQuery</a>
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
    