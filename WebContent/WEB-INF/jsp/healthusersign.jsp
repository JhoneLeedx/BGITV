<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="css/Index2.css" rel="stylesheet" />
<link rel="stylesheet" href="css/ul.css">
</head>
<body>

	<div class="menu">
		<ul>
			<li><a href="<%=path%>/healthUserSign?num=0">所有时间</a>
			<li><a href="<%=path%>/healthUserSign?num=1">今天</a>
			<li><a href="<%=path%>/healthUserSign?num=2">本周</a>
			<li><a href="<%=path%>/healthUserSign?num=3">本月</a>
		</ul>
	</div>
	<div class="row-fluid">
		<div class="w">
			<div class="span12">
				<table class="table table-condensed table-bordered table-hover tab">
					<thead>
						<tr class="tableHead">
							<th>地区id</th>
							<th>地区名称</th>
							<th>医院名称</th>
							<th>医生id</th>
							<th>医生姓名</th>
							<th>用户编号</th>
							<th>用户姓名</th>
							<th>最后一次扫码时间</th>
							<th>扫码总次数</th>
						</tr>
					</thead>
					<tbody id="tbody">
						<c:if test="${!empty list }">
							<c:forEach items="${list}" var="user">
								<tr class="patient">
									<td>${user.mId }</td>
									<td>${user.mPlaceName }</td>
									<td>${user.mHospitalName }</td>
									<td>${user.mDocId }</td>
									<td>${user.mDocName }</td>
									<td>${user.mUserId }</td>
									<td>${user.mUserName }</td>
									<td><fmt:formatDate value="${user.mSignInTime }"
											pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> <%-- 	${user.mRegTime } --%>
									</td>
									<td>${user.mCu }</td>
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
									href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=1">首页</a>
								<c:choose>
									<c:when test="${page.pageNow - 1 > 0}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.pageNow - 1}">上一页</a>
									</c:when>
									<c:when test="${page.pageNow - 1 <= 0}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=1">上一页</a>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${page.totalPageCount==0}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.pageNow}">下一页</a>
									</c:when>
									<c:when test="${page.pageNow + 1 < page.totalPageCount}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.pageNow + 1}">下一页</a>
									</c:when>
									<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.totalPageCount}">下一页</a>
									</c:when>
								</c:choose>
								<c:choose>
									<c:when test="${page.totalPageCount==0}">
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.pageNow}">尾页</a>
									</c:when>
									<c:otherwise>
										<a
											href="<%=request.getContextPath()%>/healthUserSign?num=${num }&pageNow=${page.totalPageCount}">尾页</a>
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
</body>
</html>