jQuery(document).ready(function($) {
			  $('.theme-login').click(function(){
			    $('.theme-popover-mask').fadeIn(100);
			    $('.theme-popover').slideDown(200);
			  });
			  $('.theme-poptit .close').click(function(){
			    $('.theme-popover-mask').fadeOut(100);
			    $('.theme-popover').slideUp(200);
			  });
			
			});
function login(){
	if( $("[name='account']").val()==""){
		$("#loginMessage").text("账号与密码不许为空！");
		$("#loginMessage").css("color","red");
		$("#loginMessage").css("font-size","15px");
		return false;
	}
	$('#loginForm').ajaxSubmit({
        type: 'post', 
        url: 'loginServlet', 
        data: $('#loginForm').serialize(),
        success: function(data) { 
//       		alert(data);
       	if(data == 0){
//       		alert(data);
       		$('#loginMessage').html("账号或密码错误！");
       		$('#loginMessage').css("color",'red');
       		$('#loginMessage').css("font-size",'16px');
       	 	}else if(data == 1){
//       	   		alert(data);
        		 location.reload();
        	}
        }
    });
    return false; // 阻止表单自动提交事件
}