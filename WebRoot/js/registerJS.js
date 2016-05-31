$(document).ready(function(){ 
        var trueHeight = $(".Top").height(); 
        var needHeight = window.screen.height;
        if(trueHeight<needHeight){
        	$(".Top").height(needHeight-200);
        }
  } );