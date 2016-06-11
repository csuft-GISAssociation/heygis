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