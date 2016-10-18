<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				window.top.location = URL;
			}
		}
	</script>
<div style="margin: 20px;">
	<a href="<%=request.getContextPath()%>/logout">自动跳转未成功？请手动点击跳转</a>
</div>
<script type="text/javascript">Load("<%=request.getContextPath()%>/logout");
</script>