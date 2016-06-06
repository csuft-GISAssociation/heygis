//$(document).ready(function(){
//	$("#post_submit").click(function(){
//		alert($("#textarea_post").val());
//		$("#test").html($("#textarea_post").val());
//	});
//});
var whichsubmit = 0;

var posi;
var uid;
var nickname;
var account;
var redpid;
var redmes;
jQuery(document).ready(function($) {
	$('.reply .close').click(function(){
	    $('.reply').slideUp(200);
	})		
})
function postPublic(){
	if(loged == false){
		whichsubmit = 1;
	    $('.theme-popover-mask').fadeIn(100);
	    $('.theme-popover').slideDown(200);
	}else{
		finalpostPublic();
	}
}
function finalpostPublic(){
	if(document.getElementById("textarea_post").value == ''){
		alert("帖子内容不能为空！");
 		if(whichsubmit == 1){
 			location.reload();}
	}else{
		document.getElementById('postpubllic').submit();
	}
}

function reply(_posi,_uid,_account,_nickname,_redpid){
//	$("#posi_subButton").click(posiReplyPublic(posi,uid,account,nickname,redmes));
//	document.getElementById('posi_subButton').onclick = posiReplyPublic(posi,uid,account,nickname,redmes);
	posi = _posi;
	uid = _uid;
	account = _account;
	nickname = _nickname;
	redpid = _redpid;
	$('.reply').slideDown(200);
}
function posiReplyPublic(){
	document.getElementById('posi').value = posi;
	document.getElementById('postauthor_uid').value = uid;
	document.getElementById('postauthor_account').value = account;
	document.getElementById('replypid').value = redpid;
	document.getElementById('replyhead').value = "<fieldset id=''><legend>回复:"+posi+"楼"+nickname+"</legend><blockquote>";
	if(loged == false){
		whichsubmit = 2;
	    $('.reply').slideUp(200);
	    $('.theme-popover-mask').fadeIn(100);
	    $('.theme-popover').slideDown(200);
	}else{
		replyfinalsubmit();
	}
}
function replyfinalsubmit(){
	if(document.getElementById("posi_reply_textarea").value == ''){
		alert("帖子内容不能为空！");
 		if(whichsubmit == 2){
 			location.reload();}
	}else{
		document.getElementById('posi_reply_form').submit();
	}
}
/*
 * 定制版loginJS
 */
jQuery(document).ready(function($) {
	  $('.theme-login').click(function(){
		whichsubmit == 0;
	    $('.theme-popover-mask').fadeIn(100);
	    $('.theme-popover').slideDown(200);
	  })
	  $('.theme-poptit .close').click(function(){
	    $('.theme-popover-mask').fadeOut(100);
	    $('.theme-popover').slideUp(200);
	  })
	
	})
function login(){
$('#loginForm').ajaxSubmit({
type: 'post', 
url: 'loginServlet', 
data: $('#loginForm').serialize(),
success: function(data) {
	if(data == 0){
//		alert(data);
		$('#loginMessage').html("账号或密码错误！");
		$('#loginMessage').css("color",'red');
		$('#loginMessage').css("font-size",'16px');
	 	}else if(data == 1){
//	   		alert(whichsubmit);
	 		if(whichsubmit == 0){
	 			location.reload();
	 		}else if(whichsubmit == 1){
	 			finalpostPublic();
	 		}else if(whichsubmit == 2){
				replyfinalsubmit();
	 		}
	}
}
});
return false; // 阻止表单自动提交事件
}