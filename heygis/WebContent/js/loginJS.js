jQuery(document).ready(function($) {
			  $('.theme-login').click(function(){
			    $('.theme-popover-mask').fadeIn(100);
			    $('.theme-popover').slideDown(200);
			  })
			  $('.theme-poptit .close').click(function(){
			    $('.theme-popover-mask').fadeOut(100);
			    $('.theme-popover').slideUp(200);
			  })
			
			});

function login(){
	 $('#loginForm').ajaxSubmit({
         type: 'post', 
         url: 'LoginServlet', 
         data: $('#loginForm').serialize(),
         success: function(data) { 
        	 alert(data);
         }
     });
     return false; // 阻止表单自动提交事件
}

//function login(){
//	alert($('#account').value());
//	$.GET("LoginServlet",{
//				account : $('#account'),
//				password: $('#password')
//			},function(data) {
//				if(data.equals("success")){
//					alert("s");
//				}else if(data.equals("wrong")){
//					alert("w");
//				}
//			});
//}
//function login(){
//	alert("as");
	
//}