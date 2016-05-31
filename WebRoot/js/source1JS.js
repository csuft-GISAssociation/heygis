$(function(){
	$("#tabs a:first").tab("show");
	$("#tabs a").click(function(){
		$(this).tab("show");
	});
});
function timecho(e,s){
	$(".choose").html("按上传时间 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay=" + s;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function timescho(e,s){
	$(".choose").html("按下载数 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay=" + s;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function alphacho(e,s){
	$(".choose").html("按字母 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay=" + s;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function sizecho(e,s){
	$(".choose").html("按文件大小 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data ="sourceType="+e+"&sortWay=" + s;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}
function defaultcho(e,s){
	$(".choose").html("默认排序 <span class='caret'></span>");
	var _url = "sortServlet";
	var _data = "sourceType="+e+"&sortWay=" + s;
	var _div = "#section_"+e;
	$.ajax({
		type:"post",
		data:_data,
		url:_url,
		success:function(data){
			$(_div).html(data);
		}
	});
}


