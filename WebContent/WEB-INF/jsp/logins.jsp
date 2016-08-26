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

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
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
					<p style="font-size: 30px">ITV预约协同服务中心首页管理登录</p>
				</div>
				<div class="login_form">
					<form id="loginForm">
						<div class="form-group">
							<label for="j_username" class="t">用户名：</label>
							 <input id="adminName"
								type="text" class="form-control x319 in" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="j_password" class="t">密 码：</label> <input
								id="password"  type="password"
								class="password form-control x319 in">
						</div>
						<div class="form-group space">
							<label class="t"></label>
							<input type="button" onclick="login()" class="btn btn-primary btn-lg"
								style="margin-left: 50px" value="&nbsp;登&nbsp;录&nbsp;">
							<input type="reset" value="&nbsp;重&nbsp;置&nbsp;"
								class="btn btn-default btn-lg" style="margin-left: 20px">
						</div>
					</form>
				</div>
			</div>
			<div class="bottom">Copyright &copy; 2016 - 2017</div>
		</div>
	</div>
	<div id="load" style="width: 500px; height: 360px; overflow: hidden;display: none; position: fixed; left: 60%; margin: -180px 0 0 -250px; top: 80%;">
	  <img src="images/loading.gif"/>登录中.....
	</div>
	<script type="text/javascript">
	function login() {
		document.getElementById("load").style.display = "block";
		var adminName = $("#adminName").val();
		var password = $("#password").val();
		
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/login", 
			data:{"adminName":adminName,"password":password},
			dataType : 'text',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
			//alert("发送请求失败！");
			},
			success: function(data) {
				var reason =data;
				
				if(reason=='登录成功'){
					location.href="<%=request.getContextPath()%>/main"; 
				}else if(reason=='密码错误')
				{
					alert("密码错误");
					 $("#password").val("");
					 document.getElementById("load").style.display = "none";
				}else if(reason =='用户名不存在'){
					alert("用户名不存在");
					document.getElementById("load").style.display = "none";
				}else{
					
				}
			}
			
		});
		
		
	}
	
	</script>
	
	<!-- Javascript -->
	<script src="js/supersized.3.2.7.min.js"></script>
	<script src="js/supersized-init.js"></script>
	<script src="js/scripts.js"></script>

	<div style="text-align: center;"></div>
</body>
</html>