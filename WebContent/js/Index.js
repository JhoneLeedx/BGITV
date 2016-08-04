$(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})
$(".accordion-inner").click(function () {
	if( $(this).find(".left-body").text()=="首页"){
		$(".active").html("");
	}else{
		console.log(this.getElementsByClassName("left-body"));
		var newli=document.getElementsByClassName('newli');
		while(newli.length > 0){
			newli[0].parentNode.removeChild(newli[0]);
		}
		var htm="";
		var li=this.getElementsByClassName("left-body");
		var l=li.length;
		htm+="<li class='newli'>"+li[0].firstChild.nodeValue+"&nbsp&nbsp&nbsp"+li[0].title+"</li>";
		for(var i=1;i<l;i++){
			htm+="<li class='newli'>"+"&nbsp&nbsp&nbsp"+li[i].firstChild.nodeValue+"</li>";
		}
    $(".breadcrumb").append(htm);
    $(".newli:last").css({'position':'absolutew]','right':'0'});
	}
})

$(window).resize(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})