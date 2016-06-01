$(function(){
    $('#thread_subTextarea').focus(function(){
        if($(this).val() == '发表新帖：标题'){
        		$(this).css("color","#000000");
                $(this).val('');//清空
            }
    }).blur(function(){
        if($(this).val() == ''){
        		$(this).css("color","#ADADAD");
                $(this).val('发表新帖：标题');//填充提示文字
            }
    });
   
});
$(function(){
    $('#post_textarea').focus(function(){
        if($(this).val() == '发表新帖：内容'){
        		$(this).css("color","#000000");
                $(this).val('');//清空
            }
    }).blur(function(){
        if($(this).val() == ''){
        		$(this).css("color","#ADADAD");
                $(this).val('发表新帖：内容');//填充提示文字
            }
    });
   
});

function public(){
	var div = document.getElementById('thread_public'); 
	div.setAttribute("class", "thread_public_wraper container visible"); 
	document.getElementById("anchor_scroll").click();
}

function threadpublic(){
	if(document.getElementById("thread_subTextarea").value == '发表新帖：标题' || document.getElementById("thread_subTextarea").value == ''){
		alert("标题不能为空！");
	}else{
		if(document.getElementById("post_textarea").value == '发表新帖：内容' || document.getElementById("post_textarea").value == ''){
			alert("内容不能为空！");
		}else{
			document.getElementById("threadpublic").submit();
		}
	}
}
