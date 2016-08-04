<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<title>ITV后台管理首页</title>
<link href="styles/Common.css" rel="stylesheet" />
<link href="styles/Index.css" rel="stylesheet" />
</head>
<body>
	<div class="header">

		<img class="logo" src="images/logo.png" /> <label class="logo-title">家庭医生预约协同服务中心</label>
		<ul class="inline">
			<li><img src="images/32/client.png">&nbsp;&nbsp;欢迎您,${user.username }</>
			</li>
			<!-- 			<li class="dropdown"><a class="dropdown-toggle mymsg"
				data-toggle="dropdown" href="#"><img src="images/32/166.png" />&nbsp;&nbsp;修改个人信息<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">修改密码</a></li>
				</ul></li> -->
			<li><img src="images/32/200.png" />&nbsp;&nbsp;<a
				class="loginout" href="<%=request.getContextPath()%>/home">退出</a></li>

		</ul>

	</div>

	<div class="nav">

		<ul class="breadcrumb">
			<li><img src="images/32/5025_networking.png" /></li>
			<li><a href="<%=request.getContextPath()%>/home" target="right">
					<span class="accordion-inner"> <span class="left-body">首页</span>
				</span>
			</a></li>
			<li><span class="divider">>></span></li>
			<li class="active"></li>
		</ul>
	</div>

	<div class="container-fluid content">
		<div class="row-fluid">
			<div class="span2 content-left">
				<div class="accordion">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapseOne"> <img
								class="left-icon" src="images/32/icon.png" /><span
								class="left-title">医生列表</span>
							</a>
						</div>
						<!--显示医生列表  -->
						<ul id="collapseOne" class="accordion-body collapse in">
							<c:if test="${!empty listdoc }">
								<c:forEach items="${listdoc }" var="doctor">
									<li><a
										href="<%=request.getContextPath()%>/detail?id=${doctor.mId}"
										target="right">
											<div class="accordion-inner">
												<img class="left-icon-child" src="images/32/doctoricon.jpg" />
												<span class="left-body" title="预约用户的详细列表">${doctor.mDocName }
												</span> <span class="left-body" style="display: none">
													电话号码：${doctor.mDocPhone } </span>
											</div>
									</a></li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
			<div class="span10 content-right">
				<iframe name="right" src="<%=request.getContextPath()%>/home"
					class="iframe"></iframe>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="foot"></div>
	</script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/Index.js"></script>
	<div style="text-align: center;"></div>
</body>
</html>
