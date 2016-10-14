$(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})
$(".accordion-inner").click(function () {
	console.log("1");
	if( $(this).find(".left-body").text()=="首页"){
		$(".active").html("");
		$(".newli").html("");
		$(".newli:last").css("");
	}else{
		console.log(this.getElementsByClassName("left-body"));
		var newli=document.getElementsByClassName('newli');
		while(newli.length > 0){
			newli[0].parentNode.removeChild(newli[0]);
		}
		var htm="";
		var li=this.getElementsByClassName("left-body");
		var l=li.length;
		htm+="<li class='newli'>"+li[0].firstChild.nodeValue+"</li>";
		if(l>1){
		for(var i=1;i<l;i++){
			htm+="<li class='newli'>"+"&nbsp&nbsp&nbsp"+li[i].firstChild.nodeValue+"</li>";
		}
		}
    $(".breadcrumb").append(htm);
	}
})

$(window).resize(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
})