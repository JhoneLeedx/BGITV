<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
		<div class="row-fluid">
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr class="tableHead">
								<th>序号</th>
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
										<td>${user.mUserId }</td>
										<td>${user.mUserName }</td>
										<td><fmt:formatDate value="${user.mRegTime }"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> <%-- 	${user.mRegTime } --%>
										</td>
										<td>${user.mSu }</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<!-- 分页开始 -->
				</div>
			</div>
		</div>
</body>
</html>