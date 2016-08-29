<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="date" uri="/WEB-INF/datetag.tld"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/Index2.css" rel="stylesheet" />
<title></title>
<style type="text/css">
.Menubox {
	height: 28px;
	border-bottom: 1px solid #64B8E4;
	background: #E4F2FB;
}

.Menubox ul {
	list-style: none;
	margin: 7px 40px;
	padding: 0;
	position: absolute;
}

.Menubox ul li {
	float: left;
	background: #64B8E4;
	line-height: 20px;
	display: block;
	cursor: pointer;
	width: 120px;
	text-align: center;
	color: #fff;
	font-weight: bold;
	border-top: 1px solid #64B8E4;
	border-left: 1px solid #64B8E4;
	border-right: 1px solid #64B8E4;
}

.Menubox ul li.hover {
	background: #fff;
	border-bottom: 1px solid #fff;
	color: #147AB8;
}
</style>
<script>

	function setTab(name,cursel,n){
		for(i=1;i<=n;i++){
			var menu=document.getElementById(name+i);
			var con=document.getElementById("con_"+name+"_"+i);
			menu.className=i==cursel?"hover":"";
			con.style.display=i==cursel?"block":"none";
		}
	}
	
 </script>

</head>
<body>
	<div class="Menubox">
		<ul>
			<li id="menu1" onmouseover="setTab('menu',1,2)">医生签到信息</li>
			<li id="menu2" onmouseover="setTab('menu',2,2)" class="hover">医生预约用户</li>
		</ul>
		<select id="time_select" style="float: right; margin-top: 10px"
			onchange="FindtimeUser()">
			<c:choose>
				<c:when test="${timeInt==0 }">
					<option>所有时间</option>
					<option value="0" selected="selected">今天</option>
					<option value="1">昨天</option>
					<option value="2">前天</option>
				</c:when>
				<c:when test="${timeInt==1 }">
					<option>所有时间</option>
					<option value="0">今天</option>
					<option value="1" selected="selected">昨天</option>
					<option value="2">前天</option>
				</c:when>
				<c:when test="${timeInt==2 }">
					<option>所有时间</option>
					<option value="0">今天</option>
					<option value="1">昨天</option>
					<option value="2" selected="selected">前天</option>
				</c:when>
				<c:otherwise>
					<option selected="selected">所有时间</option>
					<option value="0">今天</option>
					<option value="1">昨天</option>
					<option value="2">前天</option>
				</c:otherwise>
			</c:choose>
		</select>
	</div>
	<div id="con_menu_1" style="display: none; margin-top: 5px"
		class="container-fluid">
		<div class="row-fluid">
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr class="tableHead">
								<th>ID</th>
								<th>医生的ID</th>
								<th>签到时间</th>
								<th>扫码标识</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>


	</div>
	<div id="con_menu_2" class="container-fluid" style="margin-top: 5px">
		<div class="row-fluid">
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr class="tableHead">
								<th>用户ID</th>
								<th>用户姓名</th>
								<th>用户电话</th>
								<th>预约时间</th>
								<th>已经预约时间</th>
								<th>用户ITV编码</th>
								<th>是否签约</th>
								<th>扫码次数</th>
								<th>联系状态</th>
								<th>最后更新时间</th>
								<th>协同服务</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<c:if test="${!empty listUser }">
								<c:forEach items="${listUser}" var="user">
									<tr class="patient">
										<td>${user.mUserId }</td>
										<td>${user.mUserName }</td>
										<td>${user.mUserPhone }</td>
										<td><fmt:formatDate value="${user.mRegTime }"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> <%-- 	${user.mRegTime } --%>
										</td>
										<td><jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
											<c:set var="interval"
												value="${now.getTime() - user.mRegTime.getTime()}" /> <date:date
												parttern="d天 HH小時mm分" value="${interval }" /></td>
										<td>${user.mItvToken }</td>
										<td><c:choose>
												<c:when test="${user.mIsSign==1 }">
										是
										</c:when>
												<c:otherwise>
										否
										</c:otherwise>
											</c:choose></td>
										<td>${user.mScanCount }</td>
										<td><c:choose>
												<c:when test="${user.mRegState==1 }">
										预约成功  
										</c:when>
												<c:when test="${user.mRegState==2 }">
										服务完成
										</c:when>
												<c:when test="${user.mRegState==3 }">
										用户取消
										</c:when>
												<c:otherwise>
										网络问题
										</c:otherwise>
											</c:choose></td>
										<td>
											<%-- ${user.mUpdateTime } --%> <fmt:formatDate
												value="${user.mUpdateTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
										</td>
										<c:choose>
											<c:when test="${user.mRegState==1 }">
												<c:choose>
													<c:when test="${user.mItvRecord.mHandle==1 }">
														<td style="color: green;">
															<%-- 医生:${user.mItvRecord.mReason } --%>
															<button style="color: green;"
																onclick="showReason(${user.mId})">已处理</button>
														</td>
													</c:when>
													<c:otherwise>
														<td>
															<button style="color: red;"
																onclick="showForm('${user.mUserName }','${docName }',${user.mId })">未处理</button>
														</td>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<td></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<!-- 分页开始 -->
					<div align="center" style="margin-top: 20px">

						<c:choose>
							<c:when test="${page.totalPageCount==0}">

							</c:when>
							<c:otherwise>
								<div>
									<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
										${page.pageNow} 页</font> <a
										href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=1">首页</a>
									<c:choose>
										<c:when test="${page.pageNow - 1 > 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.pageNow - 1}">上一页</a>
										</c:when>
										<c:when test="${page.pageNow - 1 <= 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=1">上一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.pageNow}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 < page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.pageNow + 1}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.totalPageCount}">下一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.pageNow}">尾页</a>
										</c:when>
										<c:otherwise>
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&timeInt=${timeInt }&docName=${docName }&pageNow=${page.totalPageCount}">尾页</a>
										</c:otherwise>
									</c:choose>

								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- 分页功能 End -->
				</div>
			</div>
		</div>
	</div>

	<!-- 未处理的弹窗 -->
	<div id="callfaile"
		style="display: none; width: 100%; height: 100%; position: fixed; top: 0; left: 0;">
		<div
			style="width: 500px; height: 360px; overflow: hidden; border-radius: 8px; box-shadow: 0 0 4px 4px #116A9A; background: #f6f6f6; position: fixed; left: 50%; margin: -180px 0 0 -250px; top: 50%;">
			<div
				style="height: 36px; line-height: 36px; padding-left: 15px; background: linear-gradient(#116a9a, skyblue); margin-bottom: 20px;">协同服务</div>
			<form style="width: 336px; margin: 10px auto 0;">
				<span>填写您联系后的（医生或用户的原因，如果没有就写"无"）</span> <input type="text"
					id="RegistId" style="display: none;" />
				<div style="width: 336px; margin-top: 10px; height: 30px;">
					用户姓名：<input id="userName"
						style="display: inline-block; color: #cc1616; background: #f6f6f6; border-style: none; font-weight: bold;"
						readonly="readonly" />
				</div>
				<label class="reason"
					style="line-height: 50px; vertical-align: top;" for="reason1">原&nbsp;&nbsp;因：</label>
				<textarea id="userneirong"
					style="width: 230px; height: 30px; padding: 10px; border-radius: 5px; margin-bottom: 15px; border: 1px solid black;"
					onfocus="if(value=='用户原因：'){value=''}"
					onblur="if (value ==''){value='用户原因：'}"></textarea>
				<br />
				<div class="uad" style="width: 336px; height: 30px;">
					医生姓名：<input id="docName"
						style="display: inline-block; color: #cc1616; background: #f6f6f6; border-style: none; font-weight: bold;"
						readonly="readonly">
				</div>
				<label class="reason"
					style="line-height: 50px; vertical-align: top;" for="reason2">原&nbsp;&nbsp;因：</label>
				<textarea id="docneirong"
					style="width: 230px; height: 30px; padding: 10px; border-radius: 5px; margin-bottom: 15px; border: 1px solid black;"
					onfocus="if(value=='医生原因：'){value=''}"
					onblur="if (value ==''){value='医生原因：'}"></textarea>
				<br />
				<div class="btns" style="width: 160px; margin: 0 auto;">
					<input type="button" id="submit" value="提交" onclick="btnSubmit()"
						style="width: 76px; height: 30px; background: white; border: 1px solid black; border-radius: 8px;" />
					<input type="button"
						style="width: 76px; height: 30px; background: white; border: 1px solid black; border-radius: 8px;"
						onclick="closeForm()" value="取消">
				</div>
			</form>
		</div>
	</div>

	<!--未处理弹窗end！  -->


	<!-- 处理了的结果的弹窗 -->

	<div id="handled"
		style="display: none; width: 100%; height: 100%; position: fixed; top: 0; left: 0;">
		<div class="pop"
			style="width: 500px; height: 360px; overflow: hidden; border-radius: 8px; box-shadow: 0 0 4px 4px #116A9A; background: #f6f6f6; position: fixed; left: 50%; margin: -180px 0 0 -250px; top: 50%;">
			<div class="bg"
				style="height: 36px; background: linear-gradient(#116a9a, skyblue); margin-bottom: 20px; padding-left: 15px; line-height: 36px;">协同服务</div>
			<div
				style="width: 360px; height: 52px; margin: 0 auto 45px; line-height: 52px; border-bottom: 2px solid #e1e1e1;">
				管理员：<input id="admin"
					style="display: block; float: right; width: 280px; height: 50px; background: #f6f6f6; color: #cc1616; font-weight: bold; border-style: none;"
					readonly="readonly" />
			</div>
			<div style="width: 360px; height: 56px; margin: 0 auto 15px;">
				用户原因：
				<div id="userReason"
					style="float: right; width: 280px; background: #f6f6f6; color: #cc1616;"></div>
			</div>
			<div style="width: 360px; height: 56px; margin: 0 auto 15px;">
				医生原因：
				<div id="docReason"
					style="float: right; width: 280px; height: 56px; background: #f6f6f6; color: #cc1616;"></div>
			</div>
			<button
				style="border: 1px solid black; background: white; border-radius: 8px; width: 76px; height: 30px; margin: 0 auto; display: block;"
				onclick="closehandled()">取消</button>
		</div>
	</div>
	<!--处理弹窗end！  -->

	<script type="text/javascript">
	function showForm(mUserName,docName,mId){//显示弹窗，极其内容
	//	alert(docName);
		document.getElementById("callfaile").style.display = "block";
		/* $("#userName").val(mUserName); */
		$("#userName").val(mUserName);
		$("#docName").val(docName);
		$("#RegistId").val(mId);
	}
	function closeForm(){//关闭弹窗
		document.getElementById("callfaile").style.display = "none";
		$("#userneirong").val("");
	}
	function btnSubmit(){//提交数据到数据库
		 
		var adminId=${admin.mId};
		if(adminId!=""){
			var registid =$("#RegistId").val();
			var userreason = $('#userneirong').val();
			var docreason= $('#docneirong').val();
			if($('#userneirong').val() == '用户原因：'||$('#userneirong').val() == ''||$('#docneirong').val() == '医生原因：'||$('#docneirong').val() == ''){
				$('#userneirong').focus();
				$('#docneirong').focus();
			}else{
			var	handle =1;/* 1：表示处理状态  0：表示未处理状态 */
				$.ajax({
					cache: false,
					url: "<%=request.getContextPath()%>/insertReason", 
					data:{'adminid':adminId,'registid':registid,'userreason':userreason,'docreason':docreason,'handle':handle}, //要发送的是ajaxFrm表单中的数据
					dataType : 'text',
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					async: true,
					error: function(data) {
					alert("发送请求失败！");
					},
					success: function(data) {
						 alert(data); //将返回的结果显示到ajaxDiv中
						closeForm(); 
						location.href="<%=request.getContextPath()%>/detail?id=${id}";
					}
					 
					});
			}	
		}
	}
	//显示处理的具体内容
	function showReason(mid) {
		
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/showRecord", 
			data:{"id":mid},
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
				document.getElementById("handled").style.display = "block";
				 $('#admin').val(obj.mAdmin.mAdminName);
				 document.getElementById('userReason').innerHTML=obj.mUserReason;
				 document.getElementById('docReason').innerHTML=obj.mDocReason;
				// $('#userReason').innerHTML="obj.mUserReason";
				// $('#docReason').innerHTML=obj.mDocReason;
			}
			});
	}
	function closehandled(){
		document.getElementById("handled").style.display = "none";
	}
	function FindtimeUser() {
		var timeSelect = $("#time_select").val();
		var id = ${id};
		$.ajax({
			cache: false,
			url: "<%=request.getContextPath()%>/timeDetail", 
			data:{"timeInt":timeSelect},
			dataType : 'text',
			contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			async: true,
			error: function(data) {
			alert("发送请求失败！");
			},
			success: function(data) {
		      switch (Number(data)) {
			case 0:
				location.href="<%=request.getContextPath()%>/detail?id=${id}&docName=${docName }&timeInt=0";
				break;
			case 1:
				location.href="<%=request.getContextPath()%>/detail?id=${id}&docName=${docName }&timeInt=1";
				break;
			case 2:
				location.href="<%=request.getContextPath()%>/detail?id=${id}&docName=${docName }&timeInt=2";
				break;
			default:
				location.href="<%=request.getContextPath()%>/detail?id=${id}&docName=${docName }&timeInt=3";
				break;
			}
				
			}
			});
	}
	
</script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
