<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/npm.js"></script>
		<script type="text/javascript" src="js/loginJS.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="css/navCSS.css" rel="stylesheet" type="text/css">
		<link href="css/footStyle.css" rel="stylesheet" type="text/css">
		<link href="css/indexSourceStyle.css" rel="stylesheet" type="text/css">
		<link href="css/loginStyle.css" rel="stylesheet" type="text/css" />
		<link href="css/main.css" rel="stylesheet" type="text/css" />
		<title>Insert title here</title>
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
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#bbs">论坛区</a>
						</li>
						<li>
							<a href="#sourceDownLoad">资源区</a>
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
		<div class="site-wrapper area">
			<div class="site-wrapper-inner area">
				<div class="cover-container">
					<div class="innered">
						<h1 class="cover-heading">欢迎来到GIS协会</h1>
						<p class="lead">LET US TAKE YOU DOWN!</p>
					</div>
				</div>
			</div>
		</div>
		<br />
		<br />
		<div class="section">
			<h1 class="text-primary" id="bbs">论坛区</h1>
			<div class="container-fluid" style="padding: 0px;">
				<section id="one" class="wrapper spotlight style1">
					<div class="inner">
						<a href="#" class="image"><img src="img/bbs-1.JPG" alt="" /></a>
						<div class="content">
							<h2 class="major">课程区</h2>
							<p>Lorem ipsum dolor sit amet, etiam lorem adipiscing elit. Cras turpis ante, nullam sit amet turpis non, sollicitudin posuere urna. Mauris id tellus arcu. Nunc vehicula id nulla dignissim dapibus. Nullam ultrices, neque et faucibus viverra, ex nulla
								cursus.
							</p>
							<a href="#" class="special">Learn more</a>
						</div>
					</div>
				</section>

				<!-- Two -->
				<section id="two" class="wrapper alt spotlight style2">
					<div class="inner style22">
						<a href="#" class="image"><img src="img/bbs-3.JPG" /></a>
						<div class="content">
							<h2 class="major">讨论区</h2>
							<p>Lorem ipsum dolor sit amet, etiam lorem adipiscing elit. Cras turpis ante, nullam sit amet turpis non, sollicitudin posuere urna. Mauris id tellus arcu. Nunc vehicula id nulla dignissim dapibus. Nullam ultrices, neque et faucibus viverra, ex nulla
								cursus.
							</p>
							<a href="#" class="special">Learn more</a>
						</div>
					</div>
				</section>

				<!-- Three -->
				<section id="three" class="wrapper spotlight style3">
					<div class="inner">
						<a href="#" class="image"><img src="img/mainbodybgimg.jpg" alt="" /></a>
						<div class="content">
							<h2 class="major">灌水区</h2>
							<p>Lorem ipsum dolor sit amet, etiam lorem adipiscing elit. Cras turpis ante, nullam sit amet turpis non, sollicitudin posuere urna. Mauris id tellus arcu. Nunc vehicula id nulla dignissim dapibus. Nullam ultrices, neque et faucibus viverra, ex nulla
								cursus.
							</p>
							<a href="#" class="special">Learn more</a>
						</div>
					</div>
				</section>
				<!--iframe src="indexIN.html" width="100%" height="100%" scrolling="no" frameborder="0"></iframe-->
				<!--div class="row">
					<div class="col-md-12">
						<h1 class="text-center text-primary">论坛区</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 col-sd-5">
						<img src="img/bbs-1.JPG" class="img-responsive">
					</div>
					<div class="col-md-7 col-sd-7">
						<h2 class="text-muted">课程区</h2>
						<h3>A subtitle</h3>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
							quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras
							dapibus. Vivamus elementum semper nisi.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-7 col-sd-7">
						<img src="img/bbs-3.JPG" class="img-responsive">
					</div>
					<div class="col-md-5 col-sd-5">
						<h2 class="text-muted">讨论区</h2>
						<h3>A subtitle</h3>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
							quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras
							dapibus. Vivamus elementum semper nisi.</p>
						
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 col-sd-6">
						<img src="img/mainbodybgimg.jpg" class="img-responsive">
					</div>
					<div class="col-md-7 col-sd-6">
						<h2 class="text-muted">灌水区</h2>
						<h3>A subtitle</h3>
						<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium
							quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras
							dapibus. Vivamus elementum semper nisi.</p>
					</div>
				</div-->
			</div>
		</div>

		<br />
		<br />
		<div class="section">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<h1 class="text-center text-primary" id="sourceDownLoad">资源下载区</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-sm-6 box">
						<a href="source1.html" id="f-diw" class="footer-box">
							<h5>总结大会</h5>
							<p>
								A book and blog co-authored by Jeff Starr and myself about the World's most popular publishing platform.
							</p>
						</a>
					</div>
					<div class="col-md-3 col-sm-6 box">
						<a href="source1.html" id="f-qod" class="footer-box">
							<h5>课堂源码</h5>
							<p>
								Design, like Art, can be an elusive word to define and an awfully fun thing to have opinions about.
							</p>
						</a>
					</div>
					<div class="col-md-3 col-sm-6 box">
						<a href="source1.html" id="f-htmlipsum" class="footer-box">
							<h5>开发工具</h5>
							<p>
								One-click copy to clipboard access to <em>Lorem Ipsum</em> text that comes wrapped in a variety of HTML.
							</p>
						</a>
					</div>
					<div class="col-md-3 col-sm-6 box">
						<a href="source1.html" id="f-bookshelf" class="footer-box">
							<h5>拓展强化</h5>
							<p>
								Hey Chris, what books do you recommend? These, young fertile mind, these.
							</p>
						</a>
					</div>
				</div>
			</div>
		</div>
		<br />
		<br />
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<ul class="pagination"></ul>
						<h1 class="text-center text-primary" id="aboutUS">关于我们</h1>
						<p class="text-center">We are a group of skilled individuals.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png" class="center-block img-circle img-responsive">
						<h3 class="text-center">John Doe</h3>
						<p class="text-center">Developer</p>
					</div>
					<div class="col-md-4">
						<img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png" class="center-block img-circle img-responsive">
						<h3 class="text-center">John Doe</h3>
						<p class="text-center">Developer</p>
					</div>
					<div class="col-md-4">
						<img src="http://pingendo.github.io/pingendo-bootstrap/assets/user_placeholder.png" class="center-block img-circle img-responsive">
						<h3 class="text-center">John Doe</h3>
						<p class="text-center">Developer</p>
					</div>
				</div>
			</div>
		</div>
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
				<form id="loginForm" action="" class="theme-signin" name="loginform"  method="post">
					<ol>
						<li>
							<h4>你必须先登录！</h4></li>
						<li><strong>用户名：</strong>
							<input class="ipt" type="text" id="account" name="account" value="1234" size="20" />
						</li>
						<li><strong>密码：</strong>
							<input class="ipt" type="password" id="password" name="password" value="1234" size="20" />
						</li>
						<li>
							<input class="btn btn-primary" type="submit" name="submit" onclick=login() value=" 登 录 " />
						</li>
					</ol>
				</form>
			</div>
		</div>
		<div class="theme-popover-mask"></div>
</body>
</html>