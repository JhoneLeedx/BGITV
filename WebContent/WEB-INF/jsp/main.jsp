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
<script type="text/javascript">
		var secs = 3; //倒计时的秒数
		var URL;
		function Load(url) {
			URL = url;
			for (var i = secs; i >= 0; i--) {
				window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
			}
		}
		function doUpdate(num) {
			if (num == 0) {
				window.location = URL;
			}
		}
	</script>
<title>家庭医生预约协同服务中心首页</title>
<link href="css/Common.css" rel="stylesheet" />
<link href="css/Index.css" rel="stylesheet" />
</head>
<body>
	<div>
		<c:choose>
			<c:when test="${!empty admin}">
				<div class="header">
					<img class="logo" src="images/u4.png" /> <label class="logo-title">家庭医生预约协同服务中心</label>
					<a class="btn btn-default"
						href="<%=request.getContextPath()%>/logout">退出登录</a>
					<div class="admin">
						当前管理员：<span>${admin.mAdminName }</span>
					</div>
				</div>
				<div class="nav">

					<ul class="breadcrumb">
						<li><img src="images/home.png" /></li>
						<li><a href="<%=request.getContextPath()%>/home"
							target="right"> <span class="accordion-inner"> <span
									class="left-body">首页</span>
							</span>
						</a></li>
						<li><span class="divider">>></span></li>
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
											class="left-icon" src="images/list.png" /><span
											class="left-title">医生列表</span>
										</a>
									</div>
									<!--显示医生列表  -->
									<ul id="collapseOne" class="collapse in">
									
									<c:if test="${!empty listAddress }">
									<c:forEach items="${listAddress }" var="address">
									<li>
									<a onclick="findNext(this,'${address.mCodevalue}')">${address.mName }</a>
									<ul id="${address.mId }" ></ul>
									</li>
									</c:forEach>
									</c:if>
									
										<%-- <c:if test="${!empty listdoc }">
											<c:forEach items="${listdoc }" var="doctor">

												<li><a
													href="<%=request.getContextPath()%>/detail?id=${doctor.mId}&docName=${doctor.mDocName }"
													target="right">
														<div class="accordion-inner">
															<img class="left-icon-child"
																src="images/32/doctoricon.jpg" /> <span
																class="left-body" title="预约用户的详细列表">${doctor.mDocName }
															</span> <span class="left-body" style="display: none">
																电话号码：${doctor.mDocPhone } </span>
														</div>
												</a></li>
											</c:forEach>
										</c:if> --%>
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


				<div style="text-align: center;"></div>
			</c:when>
			<c:otherwise>
			<div style="margin:20px;">
				<a href="<%=request.getContextPath()%>/logout">自动跳转未成功？请手动点击跳转</a>
			</div>
				<script type="text/javascript">Load("<%=request.getContextPath()%>/logout");
				</script>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/Index.js"></script>
	<script type="text/javascript">
	
	function findNext(obj,mCodevalue) {
		console.log(obj);
		var th=$(obj).next();
		console.log(th.attr('id'));
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/findNext", 
			data:{"pid":mCodevalue},
			dataType : 'json',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
			alert("发送请求失败！");
			},
			success: function(data) {
				var json = JSON.stringify(data);
				//var obj = eval("("+json+")");  
				var obj =  jQuery.parseJSON(json);
				
				console.log(obj);
				var l = obj.length;
				var htm = "";
				for (var j=0;j<l;j++) {
					var address=obj[j];
					for (var i in address) {
						if(i=="mName"){
							htm += "<li>" + address[i] + "</li>";
							}
						}	
					}
					console.log(htm);
					th.html(htm);

			}
		});
		
	}
	
	</script>

</body>
</html>
