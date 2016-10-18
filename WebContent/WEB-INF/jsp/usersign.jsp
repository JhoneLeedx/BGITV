<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String signtime = (String) request.getAttribute("signtime");
	String counts = (String) request.getAttribute("counts");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页扫码</title>
<link href="css/Index2.css" rel="stylesheet" />
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript">
	var barChartData = {

		labels : [<%=signtime%>],
		datasets : [ {
			fillColor : "rgba(151,187,205,0.5)",
			strokeColor : "rgba(151,187,205,0.8)",
			highlightFill : "rgba(151,187,205,0.75)",
			highlightStroke : "rgba(151,187,205,1)",
			data : [<%=counts%>]
		} ]

	}
	window.onload = function() {
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myBar = new Chart(ctx).Line(barChartData, {  /*Bar,Line,Radar  */
			responsive : true
		});
	}
</script>
</head>
<body>
<canvas id="canvas" width="5" height="2"></canvas>
</body>
</html>