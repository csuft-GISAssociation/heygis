//$(document).ready(function(){
//	$("#post_submit").click(function(){
//		alert($("#textarea_post").val());
//		$("#test").html($("#textarea_post").val());
//	});
//});

function postPublic(){
	if(document.getElementById("textarea_post").value == ''){
		alert("帖子内容不能为空！");
	}else{
		document.getElementById('postpubllic').submit();
	}
}
