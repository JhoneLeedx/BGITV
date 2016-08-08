<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

<meta charset="utf-8">
<title>后台登录界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>

<body>

	<div class="page-container">
		<div class="main_box" style="background-color: threedlightshadow;">
			<div class="login_box">
				<div class="login_logo">
					<p style="font-size: 30px">ITV管理登录</p>
				</div>
				<div class="login_form">
					<form action="<%=request.getContextPath()%>/main"
						id="login_form" method="post">
						<div class="form-group">
							<label for="j_username" class="t">用户名：</label> <input id="email"
								value="" name="username" type="text"
								class="form-control x319 in" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="j_password" class="t">密 码：</label> <input
								id="password" value="" name="password" type="password"
								class="password form-control x319 in">
						</div>
						<div class="form-group space">
							<label class="t"></label>
							<button type="submit" class="btn btn-primary btn-lg"
							style="margin-left: 50px">&nbsp;登&nbsp;录&nbsp
							</button>
							<input type="reset" value="&nbsp;重&nbsp;置&nbsp;"
								class="btn btn-default btn-lg"
								style="margin-left: 20px">
						</div>
					</form>
				</div>
			</div>
			<div class="bottom">Copyright &copy; 2016 - 2017</div>
		</div>
	</div>
	<!-- Javascript -->
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<script src="js/scripts.js"></script>
	
	<div style="text-align: center;"></div>
</body>
</html>