// JavaScript Document
//支持Enter键登录
document.onkeydown = function(e) {
	if ($(".bac").length == 0) {
		if (!e)
			e = window.event;
		if ((e.keyCode || e.which) == 13) {
			var obtnLogin = document.getElementById("submit_btn")
			obtnLogin.focus();
		}
	}
}

$(function() {
	// 提交表单
	$('#submit_btn')
			.click(
					function() {
						if ($('#adminName').val() == '') {
							show_err_msg('用户名还没填呢！');
							document.getElementById("load").style.display = "none";
							$('#adminName').focus();
						} else if ($('#password').val() == '') {
							show_err_msg('密码还没填呢！');
							document.getElementById("load").style.display = "none";
							$('#password').focus();
						} else {

							var adminName = $("#adminName").val();
							var password = $("#password").val();
							$.ajax({
										cache : false,
										url : "<%=request.getContextPath()%>/login",
										data : {"adminName" : adminName,"password" : password},
										dataType : 'text',
										contentType : "application/x-www-form-urlencoded; charset=utf-8",
										async : true,
										error : function(data) {
											// alert("发送请求失败！");
										},
										success : function(data) {
											var reason = data;

											if (reason == '登录成功') {
												location.href = "<%=request.getContextPath()%>/main";
											} else if (reason == '密码错误') {
												alert("密码错误");
												$("#password").val("");
												document.getElementById("load").style.display = "none";
											} else if (reason == '用户名不存在') {
												alert("用户名不存在");
												document.getElementById("load").style.display = "none";
											} else {
												alert("该管理员不属于协同服务");
												location.reload();
											}
										}

									});
						}

					});
});