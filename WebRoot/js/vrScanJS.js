function f() {
	if ($("#showornot").text() == "隐藏缩略图") {
		$("#test").slideUp();
		$("#showornot").text("显示缩略图");
	} else {
		$("#test").slideDown();
		$("#showornot").text("隐藏缩略图");
	}

}

function pqgc() {
	document.getElementById("myFrame").src = "vtour/pqzx.html";
}
function qrp() {
	document.getElementById("myFrame").src = "vtour/qrp.html";
}
function yst() {
	document.getElementById("myFrame").src = "vtour/yst.html";
}
function dxl() {
	document.getElementById("myFrame").src = "vtour/dxl.html";
}