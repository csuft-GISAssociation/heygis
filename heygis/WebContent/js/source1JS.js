$(function(){
	$("#tabs a:first").tab("show");
	$("#tabs a").click(function(e){
		e.preventDefault();
		$(this).tab("show");
	})
})
