<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link href="bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
<title></title>
<link href="styles/Common.css" rel="stylesheet" />
<link href="styles/Index2.css" rel="stylesheet" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<!--        <div class="add"><a class="btn btn-success" onclick="openadd();">新增</a></div> -->
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr>
								<th>用户ID</th>
								<th>用户姓名</th>
								<th>用户电话</th>
								<th>预约时间</th>
								<th>用户ITV编码</th>
								<th>是否签约</th>
								<th>扫码次数</th>
								<th>联系状态</th>
								<th>最后更新时间</th>
								<c:if test="${statusId!=1 }">
								<th>通知状态</th>
								</c:if>
							</tr>
						</thead>
						<tbody id="tbody">
							<c:if test="${!empty listUser }">
								<c:forEach items="${listUser}" var="user">
									<tr>
										<td>${user.mUserId }</td>
										<td>${user.mUserName }</td>
										<td>${user.mUserPhone }</td>
										<td><fmt:formatDate value="${user.mRegTime }"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> <%-- 	${user.mRegTime } --%>
										</td>
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
										通话完成
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
																		<c:if test="${statusId!=1 }">
								<td><button onclick="showForm('${user.mUserName }',${user.mUserId },${user.mDocId })">添加通知状态</button></td>
								</c:if>
										
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
										href="<%=request.getContextPath()%>/detail?id=${id}&pageNow=1&status=${statusId}">首页</a>
									<c:choose>
										<c:when test="${page.pageNow - 1 > 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.pageNow - 1}">上一页</a>
										</c:when>
										<c:when test="${page.pageNow - 1 <= 0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=1">上一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.pageNow}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 < page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.pageNow + 1}">下一页</a>
										</c:when>
										<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.totalPageCount}">下一页</a>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${page.totalPageCount==0}">
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.pageNow}">尾页</a>
										</c:when>
										<c:otherwise>
											<a
												href="<%=request.getContextPath()%>/detail?id=${id}&status=${statusId}&pageNow=${page.totalPageCount}">尾页</a>
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
	<div id="callfaile" 
		style="display: none; width: 500px; height: 380px; margin-left:auto;margin-right:auto; background-color: rgba(0, 0, 0, 0.7); position: fixed; top: 10%; left: 25%;">
		<div
			style="width: 498px; height: 378px; margin: -189px auto 0; background-color: white; border: 1px solid #54c9ff; border-radius: 10px; position: relative; top: 50%; text-align: center;">
			<form action="<%=request.getContextPath()%>/insert">
				<p>
					 用 户<input type="text" id="userid" name="userid"/>
				</p>
				<p>
					医生 <input type="text" id="docid" name="docid" />
				</p>
				
				<select id="notifcation" name="notifcat">
					<option>选择通知状态</option>
				<option>已通知医生</option>
				<option>已通知用户</option>
				</select>
				<textarea   name="neirong" style="width: 450px;height: 150px;" onfocus="if(value=='原因：'){value=''}"  
    onblur="if (value ==''){value='原因：'}"></textarea>
				<input type="submit" value="提交" />
				<input type="button" onclick="closeForm()" value="取消">
			</form>
		</div>
	</div>
	<script type="text/javascript">
	function showForm(mUserName,mUserId,docId){
		document.getElementById("callfaile").style.display = "block";
		$("#userid").val(mUserId+"."+mUserName);
		document.getElementById("docid").value= docId;
	}
	function closeForm(){
		document.getElementById("callfaile").style.display = "none";
	}
	</script>
	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="layer-v2.3/layer/layer.js"></script>
	<script src="laypage-v1.3/laypage/laypage.js"></script>
	<script src="js/Index2.js"></script>
</body>
</html>
