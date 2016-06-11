$(document).ready(function(){
	if(loged == true){
		$.post("newMsgServlet",{
			'nw' : 1,
			'uid': uid
		},function(data){
			if(data > 0){
//				alert(data);
//				$('.badge').css("background-color","red");
				$('.badge').text(data);
				$('.newMsgMark').removeClass("hidden-xs");
				$('.newMsgMark').removeClass("hidden-md");
			}else{
				$('.badge').css("display",'none');
			}
		});
	}else{
		$('.badge').css("display",'none');
	}
});