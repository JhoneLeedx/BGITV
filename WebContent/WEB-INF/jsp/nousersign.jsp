<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
    String signtime = (String)request.getAttribute("signtime");
   String counts =(String) request.getAttribute("counts");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

  var barChartData = {
		 
      labels: [<%=signtime%>],
      datasets: [
          {
              fillColor: "rgba(151,187,205,0.5)",
              strokeColor: "rgba(151,187,205,0.8)",
              highlightFill: "rgba(151,187,205,0.75)",
              highlightStroke: "rgba(151,187,205,1)",
              data: [<%=counts%>]
          }
      ]

  }
  window.onload = function () {
      var ctx = document.getElementById("canvas").getContext("2d");
      window.myBar = new Chart(ctx).Bar(barChartData, {
          responsive: true
      });
  }
   
</script>
</head>
<body>
	<canvas id="canvas" height="140" width="400"></canvas>
</body>
</html>