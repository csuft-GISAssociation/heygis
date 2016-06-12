var newMsgPage = 1;
var oldMsgPage = 1;
var mythread = 1;
var showOld = true;

jQuery(document).ready(function($) {
	$('#modifyIcon').click(function() {
		$('.theme-popover-mask').fadeIn(100);
		$('#changeIcon').slideDown(200);
	});
	$('#theme #close').click(function() {
		$('.theme-popover-mask').fadeOut(100);
		$('#changeIcon').slideUp(200);
	});
	
});
$(document).ready(function(){ 
	var needHeight = window.screen.height-150;
	//document.getElementById("mainbody").style.minHeight=needHeight;
	$(".mainbody").css("minHeight",needHeight);
} );
function readMsg(mid){
	$.post("readMsgServlet",{
		'mid' : mid
	},function(data){
		return ture;
	});
}
function showOldMsg(){
	if(showOld){
		getOldMsg(1);
		showOld = false;
	}
}
function getOldMsg(page){
	$.post("selfCenMsgList",{
		'n'    : 0,
		'page' : page
	},function(data){
		showOlsMsg(data);
	});
}
function showOlsMsg(res){
	var content=res.msgArray;
	if(res.page == 1 && res.size == 0){
		$('#panel-2').innerHTML = "没有已读消息";
	}else{
		$.each(content, function(i, item){
			if(item.type == 1){
				$('#panel-2').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>在’"+item.subject+"‘中回复了你！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}else if(item.type == 2){
				$('#panel-2').append(
					"<div class='message-cotent'><div class='col-md-9 col-xs-9 message-detail'>"
						+"<a href='topicsServlet?fPage=1&tid="+item.tid+"&page="+item.page+"&seeposi="+item.position+"#position"+(item.position-1)+"'>"
						+item.author+"<br/>回复了你在”"+item.subject+"“中的回复！"
						+"</a></div><div class='col-md-3 col-xs-3 message-date'>"
						+"<p >"+item.dateline+"</p></div></div>"
				);
			}
		});
	}
	
}
