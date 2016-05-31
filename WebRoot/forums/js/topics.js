$(document).ready(function(){
	$("#post_submit").click(function(){
		alert($("#textarea_post").val());
		$("#test").html($("#textarea_post").val());
	});
});