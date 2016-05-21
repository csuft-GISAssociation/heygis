$(document).ready(function(){
	var selectedId = $('input:radio[name="radio-set"]:checked').attr("id");
	var str = "content-"+selectedId.charAt(selectedId.length-1);
	var high = $("."+str).height()+"px";
	$(".footer").css("margin-top",high);
});
$(document).change(function(){
	var selectedId = $('input:radio[name="radio-set"]:checked').attr("id");
	var str = "content-"+selectedId.charAt(selectedId.length-1);
	var high = $("."+str).height()+"px";
	$(".footer").css("margin-top",high);
});
$(window).resize(function(){
	var selectedId = $('input:radio[name="radio-set"]:checked').attr("id");
	var str = "content-"+selectedId.charAt(selectedId.length-1);
	var high = $("."+str).height()+"px";
	$(".footer").css("margin-top",high);
});
