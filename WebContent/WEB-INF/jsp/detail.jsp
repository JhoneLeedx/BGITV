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
<body>
	<div class="container-fluid">
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
										href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=1">首页</a>
									<c:choose>
										<c:when test="${page.pageNow - 1 > 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=${page.pageNow - 1}">上一页</a>
										</c:when>
										<c:when test="${page.pageNow - 1 <= 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=1">上一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}}&pageNow=${page.pageNow}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 < page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=${page.pageNow + 1}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=${page.totalPageCount}">下一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=${page.pageNow}">尾页</a>
										</c:when>
										<c:otherwise>
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=${page.totalPageCount}">尾页</a>
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

	<!-- 未处理的弹窗 -->
	<div id="callfaile"
		style="display: none; width: 500px; height: 380px; margin-left: auto; margin-right: auto; background-color: rgba(0, 0, 0, 0.7); position: fixed; top: 10%; left: 25%;">
		<div
			style="width: 498px; height: 378px; margin: -189px auto 0; background-color: white; border: 1px solid #54c9ff; border-radius: 10px; position: relative; top: 50%; text-align: center;">
			<form id="form"<%-- action="<%=request.getContextPath()%>/insertReason" --%> >
				<p>
					<span style="margin: 10px;">协同服务</span>
				</p>
				<span>填写您联系后的（医生或用户的原因，如果没有就写"无"）</span>
				<p>
					医生:<input type="text" id="docName" style="border-style: none"
						readonly="readonly" /> 用户:<input type="text" id="userName"
						readonly="readonly" style="border-style: none" />
				</p>
				<textarea id="userneirong" name="neirong"
					style="width: 400px; height: 50px;"
					onfocus="if(value=='用户原因：'){value=''}"
					onblur="if (value ==''){value='用户原因：'}"></textarea>
				<!-- 			<p>
					医生:<input type="text" id="docName" name="docName" style="border-style: none"
						readonly="readonly" />
				</p> -->
				<input type="text" id="RegistId" style="display: none;" />
				<p>
					<textarea id="docneirong" name="neirong"
						style="width: 400px; height: 50px;"
						onfocus="if(value=='医生原因：'){value=''}"
						onblur="if (value ==''){value='医生原因：'}"></textarea>
				</p>
				<input type="button" id="submit" value="提交" onclick="btnSubmit()" />
				<!--  -->
				<input type="button" onclick="closeForm()" value="取消">
			</form>
		</div>
	</div>
	<!--未处理弹窗end！  -->


	<!-- 处理了的结果的弹窗 -->

	<div id="handled"
		style="display: none; width: 500px; height: 380px; margin-left: auto; margin-right: auto; background-color: rgba(0, 0, 0, 0.7); position: fixed; top: 10%; left: 25%;">
		<div
			style="width: 498px; height: 378px; margin: -189px auto 0; background-color: white; border: 1px solid #54c9ff; border-radius: 10px; position: relative; top: 50%; text-align: center;">
			<form<%-- action="<%=request.getContextPath()%>/insertReason" --%> >
				<p>
					<span style="margin: 10px;">协同服务</span>
				</p>
				<p>用户原因：
				<input type="text" id="userReason"
					style="width: 300px; margin-top: 40px ;border-style: none"
					readonly="readonly"/></p>
					<p>
				医生原因：
					<input type="text" id="docReason" style="width: 300px; margin-top: 40px;border-style: none"
						readonly="readonly"/>
				<p>
				<input type="button" onclick="closehandled()" value="关闭" style="margin-top: 20px">
			</form>
		</div>
	</div>
	<!--处理弹窗end！  -->

	<script type="text/javascript">
	function showForm(mUserName,docName,mId){
		document.getElementById("callfaile").style.display = "block";
		$("#userName").val(mUserName);
		$("#docName").val(docName);
		$("#RegistId").val(mId);
	}
	function closeForm(){
		document.getElementById("callfaile").style.display = "none";
		$("#userneirong").val("");
	}
	function btnSubmit(){
		 
		var adminId=${admin.mId};
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
				 $('#userReason').val(obj.mUserReason);
				 $('#docReason').val(obj.mDocReason);
			}
			});
	}
	function closehandled(){
		document.getElementById("handled").style.display = "none";
	}
	
	</script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
