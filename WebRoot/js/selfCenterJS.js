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
    var trueHeight = $(".Top").height(); 
    var needHeight = window.screen.height;
    if(trueHeight<needHeight){
    	$(".Top").height(needHeight-200);
    }
} );