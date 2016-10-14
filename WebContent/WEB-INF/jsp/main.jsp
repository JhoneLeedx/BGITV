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
<link href="css/a.css" rel="stylesheet" />

<!-- 3秒验证时间，跳转到登录界面 -->
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
											class="left-title">区域医院列表</span>
										</a>
									</div>
									<!--显示区域医院列表  -->
									<ul id="collapseOne" class="collapse">
										<c:if test="${!empty listHospitals }">
											<c:forEach items="${listHospitals }" var="hospital">
												<li style="cursor: pointer"><a
													onclick="findDoc(this,'${hospital.mId}')" href="<%=request.getContextPath()%>/index?hospitalId=${hospital.mId}" target="right">									
														<div class='accordion-inner'><img class='left-icon-child' src='images/hospital.png'/><span class='left-body' title=''>${hospital.mName}</span></div>
														</a>
													<ul style='display: none'></ul></li>

											</c:forEach>
										</c:if>
									</ul>
 						      <div class="accordion-heading">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion2" href="#collapseTwo"> <img
											class="left-icon" src="images/list.png" /><span
											class="left-title">扫码信息统计</span>
										</a>
									</div>
									<ul id="collapseTwo" class="collapse">
									    <li style="cursor: pointer"><a class="accordion-toggle" data-toggle="collapse" href="#user">用户首页扫码</a>
									    <ul id="user" class="collapse">
									    <li><a href="<%=path%>/userSign" target="right"><div class='accordion-inner'><span class='left-body' title='（iptv首页）'>签约用户扫码</span></div></a></li>
									    <li>未签约用户</li>
									    </ul>
									    </li>
									    <li style="cursor: pointer"><a class="accordion-toggle" data-toggle="collapse" href="#doctor">健康档案扫码</a>
									    <ul id="doctor" class="collapse">
									      <li><a href="<%=path%>/healthDocSign" target="right"><div class='accordion-inner'><span class='left-body' title='（健康档案扫码）'>签约医生</span></a></li>
									      <li><a href="<%=path%>/healthUserSign" target="right"><div class='accordion-inner'><span class='left-body' title='（健康档案扫码）'>签约用户</span></a></li>
									      <li><a href="<%=path%>/healthNoDocSign" target="right"><div class='accordion-inner'><span class='left-body' title='（健康档案扫码）'>未签约医生</span></a></li>
									      <li><a href="<%=path%>/healthNoUserSign" target="right"><div class='accordion-inner'><span class='left-body' title='（健康档案扫码）'>未签约用户</span></a></li>
									    </ul>
									    </li>
									</ul> 
								</div>
							</div>
						</div>
						<div class="span10 content-right" style="overflow:hidden;">
							<iframe name="right" src="<%=request.getContextPath()%>/home"
								class="iframe"></iframe>
						</div>
					</div>
				</div>


				<div style="text-align: center;"></div>
			</c:when>
			<c:otherwise>
				<div style="margin: 20px;">
					<a href="<%=request.getContextPath()%>/logout">自动跳转未成功？请手动点击跳转</a>
				</div>
				<script type="text/javascript">Load("<%=request.getContextPath()%>/logout");
				</script>
			</c:otherwise>
		</c:choose>
	</div>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	//找到地址下的下级地址和医院
<%-- 	function findNext(obj,mCodevalue,mId) {
		var th=$(obj).next();
		th.toggle();
		var htm = "";
		if(th.html()==""){
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/findNext", 
			data:{"pid":mCodevalue},
			dataType : 'json',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
				console.log("发送请求失败！");
			},
			success: function(data) {
				var json = JSON.stringify(data);
				//var obj = eval("("+json+")");  
				var obj =  jQuery.parseJSON(json);
				
				console.log(obj);
				var l = obj.length;
				for (var j=0;j<l;j++) {
					var address=obj[j];
					if(address.mLevel==2){
						htm += "<li style='list-style:none;'><a onclick='findNext(this,"+address.mCodevalue+","+address.mId+")'><img  src='images/city.png'/>" + address.mName + "</a><ul id='"+address.mId+"' style='display:none'></ul></li>";
					}else if(address.mLevel==3){
						htm += "<li style='list-style:none;'><a onclick='findNext(this,"+address.mCodevalue+","+address.mId+")'><img  src='images/county.png'/>" + address.mName + "</a><ul id='"+address.mId+"' style='display:none'></ul></li>";	
					}else if(address.mLevel==4){
						htm += "<li style='list-style:none;'><a onclick='findNext(this,"+address.mCodevalue+","+address.mId+")'><img  src='images/community.png'/>" + address.mName + "</a><ul id='"+address.mId+"' style='display:none'></ul></li>";
					}else{
						htm += "<li style='list-style:none;'><a onclick='findNext(this,"+address.mCodevalue+","+address.mId+")'><img  src='images/sjw.png'/>" + address.mName + "</a><ul id='"+address.mId+"' style='display:none'></ul></li>";
					}
			}
					console.log(htm);
					th.html(htm);

			}
		});
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/findHospital", 
			data:{"addressId":mId},
			dataType : 'json',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
				console.log("发送请求失败！");
			},
			success: function(data) {
				var json = JSON.stringify(data);
				//var obj = eval("("+json+")");  
				var obj =  jQuery.parseJSON(json);
				console.log(obj);
				var l = obj.length;
				for (var j=0;j<l;j++) {
					var hospital=obj[j];
							htm += "<li style='list-style:none;'><a onclick='findDoc(this,"+hospital.mId+")'><img src='images/hospital.png'/>"+hospital.mName+"</a><ul style='display:none'></ul></li>";	
					}
				console.log(htm);
				th.html(htm);
			}
		});
		}
		
	} --%>
	//找到对应医院下属的所有医生
	function findDoc(obj,mId){
		var th=$(obj).next();
		th.toggle();
		var htm = "";
		if(th.html()==""){
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/findDoc", 
			data:{"hospitalId":mId},
			dataType : 'json',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
			console.log("发送请求失败！");
			},
			success: function(data) {
				var json = JSON.stringify(data);
				//var obj = eval("("+json+")");  
				var obj =  jQuery.parseJSON(json);
				var l = obj.length;
				for (var j=0;j<l;j++) {
					var doctor=obj[j];
								
				 /* 	 htm+="<li style='list-style:none;'><a onclick='openDetail(this,"+doctor.mDocId+",\""+doctor.mDoctor.mDocName + "\")'>"+doctor.mDoctor.mDocName+"</a><ul style='display:block'></ul></li>"   */
				 	htm += "<li style='list-style:none;'><a onclick='OpenDocsign("+doctor.mDocId+")' target='right' href='<%=request.getContextPath()%>/detail?id="+doctor.mDocId+"&docName="+doctor.mName+"'><div class='accordion-inner'><img class='left-icon-child' src='images/32/doctoricon.jpg'/><span class='left-body' title=''>"+doctor.mName+"</span><span class='left-body' style='display: none'>电话为："+doctor.mDoctor.mDocPhone+"</span></div></a></li>";
				
				}
				th.html(htm);
				//console.log($(".accordion-inner"));
				$(".accordion-inner").click(function () {
					console.log("1");
					if( $(this).find(".left-body").text()=="首页"){
						$(".active").html("");
						$(".newli").html("");
					}else{
						console.log(this.getElementsByClassName("left-body"));
						var newli=document.getElementsByClassName('newli');
						while(newli.length > 0){
							newli[0].parentNode.removeChild(newli[0]);
						}
						var htm="";
						var li=this.getElementsByClassName("left-body");
						var l=li.length;
						htm+="<li class='newli'>"+li[0].firstChild.nodeValue+"&nbsp&nbsp&nbsp"+li[0].title+"</li>";
						for(var i=1;i<l;i++){
							htm+="<li class='newli'>"+"&nbsp&nbsp&nbsp"+li[i].firstChild.nodeValue+"</li>";
						}
				    $(".breadcrumb").append(htm);
				    $(".newli:last").css({'position':'absolute','right':'300px'});
					}
				})
			}
		});
		}
}
	//异步执行医生的签到信息查询并显示
	function OpenDocsign(mid){
		console.log(mid);
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/docsign", 
			data:{"id":mid},
			dataType : 'text',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
			console.log("发送请求失败！");
			},
			success: function(data) {
				console.log(data);
			}
		});
	}
	</script>
	<script src="js/Index.js"></script>
</body>
</html>
