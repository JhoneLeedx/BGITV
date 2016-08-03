$(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})
$(".accordion-inner").click(function () {
	if( $(this).find(".left-body").text()=="首页"){
		$(".active").html("");
	}else{
    $(".active").html($(this).find(".left-body").text()+"  预约的用户");
	}
})

$(window).resize(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})