jQuery(document).ready(function($) {
	$('#modifyIcon').click(function() {
		$('.theme-popover-mask').fadeIn(100);
		$('#changeIcon').slideDown(200);
	});
	$('#theme #close').click(function() {
		$('.theme-popover-mask').fadeOut(100);
		$('#changeIcon').slideUp(200);
	});
	
})