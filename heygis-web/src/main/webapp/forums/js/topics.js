var page = getQueryString("page");
function next(){
	if(page == totalPage){
		alert("没有下一页了！");
		return false;
	}
	page++;
	var path = "topicsServlet?fPage="+getQueryString("fpage")+"&tid="+getQueryString("tid")+"&page="+page;
	window.location.href=path;
}
function last(){
	if(page == 1){
		alert("没有上一页了！");
		return false;
	}
	page--;
	var path = "topicsServlet?fPage="+getQueryString("fpage")+"&tid="+getQueryString("tid")+"&page="+page;
	window.location.href=path;
}
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 


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
//	document.getElementById('posi').value = posi;
	document.getElementById('postauthor_uid').value = uid;
//	document.getElementById('postauthor_account').value = account;
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

//
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
} 

jQuery(document).ready(function($) {
	if(getQueryString("seeposi") != null){
//		$("#posi"+getQueryString("seeposi")).css('backgroundColor','#FFFF77');
//		setTimeout(function(){
//	        $("#posi"+getQueryString("seeposi")).css('backgroundColor','');
//	    },1300);
//		$("#posi"+getQueryString("seeposi")).css('backgroundColor','');
//		$("#posi"+getQueryString("seeposi")).animate({
//			opacity:'0.3'
//		},"slow");
//		$("#posi"+getQueryString("seeposi")).animate({
//			opacity:'1'
//		},"slow");
		$("#posi"+getQueryString("seeposi")).animate({
			backgroundColor:'#FFFF77'
		},300);
		$("#posi"+getQueryString("seeposi")).animate({
			backgroundColor:''
		},3000);
	}
})
function openCode(i){
	if(i==1){
		closeImg(1);
		$("#codeDiv1").css("visibility","visible");
	}else if(i==2){
		closeImg(2);
		$("#codeDiv2").css("visibility","visible");
	}
}
function closeCode(i){
	if(i==1){
		document.getElementById("code-text1").value = '';
		$("#codeDiv1").css("visibility","hidden");
	}else if(i==2){
		document.getElementById("code-text2").value = '';
		$("#codeDiv2").css("visibility","hidden");
	}
}
function openImg(i){
	if(i==1){
		$("#codeDiv1").css("visibility","hidden");
		$("#imgDiv1").css("visibility","visible");
	}else if(i==2){
		$("#codeDiv2").css("visibility","hidden");
		$("#imgDiv2").css("visibility","visible");
	}
}
function closeImg(i){
	if(i==1){
		$("#imgDiv1").css("visibility","hidden");
	}else if(i==2){
		$("#imgDiv2").css("visibility","hidden");
	}
}

function addCode(i){
	if(i==1){
		var code = document.getElementById("code-text1").value;
		document.getElementById("code-text1").value = '';
		code = "<pre class='prettyprint prettyprinted'>" + code + "</pre>";
		$('#textarea_post').html(code);
		$("#codeDiv1").css("visibility","hidden");
	}else if(i==2){
		var code = document.getElementById("code-text2").value;
		document.getElementById("code-text2").value = '';
		code = "<pre class='prettyprint'>" + code + "</pre>";
		$('#posi_reply_textarea').html(code);
		$("#codeDiv2").css("visibility","hidden");
	}
}
