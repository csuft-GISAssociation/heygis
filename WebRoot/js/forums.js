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
	if(loged == false){
	    $('.theme-popover-mask').fadeIn(100);
	    $('.theme-popover').slideDown(200);
	}else{
		finalsubmit();
	}
}
function finalsubmit(){
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
/*
 * 定制版loginJS
 */
jQuery(document).ready(function($) {
	  $('.theme-login').click(function(){
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
//		alert(data);
	if(data == 0){
//		alert(data);
		$('#loginMessage').html("账号或密码错误！");
		$('#loginMessage').css("color",'red');
		$('#loginMessage').css("font-size",'16px');
	 	}else if(data == 1){
//	   		alert(data);
		    $('.theme-popover-mask').fadeOut(100);
		    $('.theme-popover').slideUp(200);
			finalsubmit();
	}
}
});
return false; // 阻止表单自动提交事件
}