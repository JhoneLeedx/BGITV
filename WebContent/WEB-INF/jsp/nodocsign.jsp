<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String signtime = (String) request.getAttribute("signtime");
	String counts = (String) request.getAttribute("counts");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/ul.css">
<title>未签约的医生扫码健康档案</title>
<script type="text/javascript">
	var barChartData = {

		labels : [<%=signtime%>],
		datasets : [ {
			fillColor : "#CCCCFF",
			strokeColor : "rgba(220,220,220,1)",
			highlightFill : "rgba(151,187,205,0.75)",
			highlightStroke : "rgba(151,187,205,1)",
			label : "未知医生扫码数据",
			data : [<%=counts%>]
		} ]

	}
	
	window.onload = function() {
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myBar = new Chart(ctx).Line(barChartData,{  /*Bar,Line,Radar  */
			responsive : true
		});
	}
</script>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="<%=path%>/healthNoDocSign?time=1">上月</a></li>
			<li><a href="<%=path%>/healthNoDocSign?time=2">本月</a></li>
			<li><a href="<%=path%>/healthNoDocSign?time=3">上周</a></li>
			<li><a href="<%=path%>/healthNoDocSign?time=4">本周</a></li>
		</ul>
	</div>
	<canvas id="canvas" width="5" height="2"></canvas>
</body>
</html>