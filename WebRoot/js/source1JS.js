$(function(){
	$("#tabs a:first").tab("show");
	$("#tabs a").click(function(){
		$(this).tab("show");
		alert(123);
	})
})
