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
</head>
<c:if test="${!empty admin }">
<body>
	<div class="container-fluid">
		<select id="timeHomeselect" style="float: right; right:"
			onchange="FindHometimeUser()">
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
		<div class="row-fluid">
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr class="tableHead">
								<th>医生姓名</th>
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
										<td>${user.mDoctor.mDocName }</td>
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
																onclick="showHomeReason(${user.mId})">已处理</button>
														</td>
													</c:when>
													<c:otherwise>
														<td>
															<button style="color: red;"
																onclick="showHomeForm()">未处理</button>
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
										href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=1">首页</a>
									<c:choose>
										<c:when test="${page.pageNow - 1 > 0}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.pageNow - 1}">上一页</a>
										</c:when>
										<c:when test="${page.pageNow - 1 <= 0}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=1">上一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.pageNow}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 < page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.pageNow + 1}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.totalPageCount}">下一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.pageNow}">尾页</a>
										</c:when>
										<c:otherwise>
											<a
												href="<%=request.getContextPath()%>/home?&timeInt=${timeInt }&pageNow=${page.totalPageCount}">尾页</a>
										</c:otherwise>
									</c:choose>

								</div>
							</c:otherwise>
						</c:choose>
					</div>
					<!-- 分页功能 End -->
					<div id="page" class="tr"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- 处理了的结果的弹窗 -->
	
	<div id="home_handled" style="display: none;width:100%;height:100%;position:fixed;top:0;left:0;">
			<div class="pop" style="width: 500px;height: 360px;overflow: hidden;border-radius: 8px;box-shadow: 0 0 4px 4px #116A9A;background: #f6f6f6;position: fixed;left: 50%;margin: -180px 0 0 -250px;top: 50%;">
			<div class="bg" style="height: 36px;background: linear-gradient(#116a9a,skyblue);margin-bottom: 20px;"></div>
			<div style="width: 360px;height:52px;margin:0 auto 45px;line-height:52px;border-bottom: 2px solid #e1e1e1;">
				管理员：<input id="home_admin" style="display:block;float: right;width: 280px;height:50px;background:#f6f6f6;color: #cc1616;font-weight: bold;border-style: none;" readonly="readonly"/>
			</div>
			<div style="width: 360px;height: 56px;margin:0 auto 15px;">
				用户原因：<div id="home_userReason" style="float: right;width: 280px;background:#f6f6f6;color: #cc1616;" ></div>
			</div>
			<div style="width: 360px;height: 56px;margin:0 auto 15px;">
				医生原因：<div id="home_docReason" style="float: right;width: 280px;height:56px;background:#f6f6f6;color: #cc1616;" ></div>
			</div>
			<button style="border: 1px solid black;background: white;border-radius: 8px;width: 76px;height: 30px;margin: 0 auto;display: block;"onclick="closeHomehandled()">取消</button>
		</div>
	</div>
	
	<!--处理弹窗end！  -->

	<script type="text/javascript">
	function showHomeForm(){

		alert("请到具体医生界面去处理用户预约问题");
	}
	//显示处理的具体内容
	function showHomeReason(mid) {
		
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
				document.getElementById("home_handled").style.display = "block";
				 $('#home_admin').val(obj.mAdmin.mAdminName);
				 document.getElementById('home_userReason').innerHTML=obj.mUserReason;
				 document.getElementById('home_docReason').innerHTML=obj.mDocReason;
				/*  $('#home_userReason').val(obj.mUserReason);
				 $('#home_docReason').val(obj.mDocReason); */
			}
			});
	}
	function closeHomehandled(){
		document.getElementById("home_handled").style.display = "none";
	}
	function FindHometimeUser() {
		var timeSelect = $("#timeHomeselect").val();
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
				location.href="<%=request.getContextPath()%>/home?timeInt=0";
				break;
			case 1:
				location.href="<%=request.getContextPath()%>/home?timeInt=1";
				break;
			case 2:
				location.href="<%=request.getContextPath()%>/home?timeInt=2";
				break;
			default:
				location.href="<%=request.getContextPath()%>/home?timeInt=3";
				break;
			}
			}
			});
	}
	</script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</c:if>
</html>
