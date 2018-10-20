//用于判断是哪种登陆，0是普通登陆，1是发帖是不再登录状态，唤起登陆窗口登陆
var wherelog = 0;

//当前页码
var page = getQueryString("page");

//判断是否在发布中，避免多次点击重复发送
var public_processing = false;

//下一页按钮
function next() {
    if (page == totalPage) {
        alert("没有下一页了！");
        return false;
    }
    page++;
    var path = "forumsServlet?fid=" + getQueryString("fid") + "&page=" + page;
    window.location.href = path;
}

//上一页按钮
function last() {
    if (page == 1) {
        alert("没有上一页了！");
        return false;
    }
    page--;
    var path = "forumsServlet?fid=" + getQueryString("fid") + "&page=" + page;
    window.location.href = path;
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function public() {
    var div = document.getElementById('thread_public');
    div.setAttribute("class", "thread_public_wraper container visible");
    document.getElementById("anchor_scroll").click();
}

//发布thread
function threadpublic() {
    //检查是否在发布中,保证不会因多次点击多次发送
    if(public_processing == true)
        return;
    var userState = eval('(' + isLogin() + ')');
    //判断是否登陆，未登录的话拉起登陆窗口，让用户登陆，此处登陆成功提交表单
    if (userState.loged == false) {
        wherelog = 1;
        log_window_open();
    } else {
        finalsubmit();
    }
}

//检查并最终提交thread
function finalsubmit() {
    if (document.getElementById("thread_subTextarea").value == '') {
        alert("标题不能为空！");
    } else {
        if (document.getElementById("post_textarea").value == '') {
            alert("内容不能为空！");
        } else {
            public_processing = true;
            document.getElementById("threadpublic").submit();
        }
    }
}

/** 定制版loginJS */
jQuery(document).ready(function ($) {
    $('.theme-login').click(function () {
        wherelog = 0;
        log_window_open();
    })
    $('.theme-poptit .close').click(function () {
        log_window_close()
    })
})

function login() {
    $.ajax({
        type: 'post',
        url: 'loginServlet',
        data: {
            "account" : $("input[name='account']").prop("value"),
            "password" : md5($("input[name='password']").prop("value"))},
        success: function (data) {
            if (data == 0) {
                $('#loginMessage').html("账号或密码错误！");
                $('#loginMessage').css("color", 'red');
                $('#loginMessage').css("font-size", '16px');
            } else if (data == 1) {
                if (wherelog == 0) {
                    //普通登陆
                    location.reload();
                } else if (wherelog == 1) {
                    log_window_close();
                    //登陆成功则提交发帖表单
                    finalsubmit();
                }
            }
        }
    });
    return false; // 阻止表单自动提交事件
}

//获取用户状态，判断是否登陆
function isLogin() {
    var result;
    $.ajax({
        type: 'post',
        url: 'isLoginServlet',
        async: false,
        success: function (data) {
            result = data;
        }
    });
    return result;
}

//显示登陆窗口
function log_window_open() {
    $('.theme-popover-mask').fadeIn(100);
    $('.theme-popover').slideDown(200);
}
//关闭登陆窗口
function log_window_close() {
    $('.theme-popover-mask').fadeOut(100);
    $('.theme-popover').slideUp(200);
}
/**loginJSj结束*/

//下面是添加代码，添加图片窗口打开关闭控制
function openCode() {
    closeImg();
    $("#codeDiv").css("visibility", "visible");
    document.getElementById("code-text").focus();
}

function closeCode() {
    document.getElementById("code-text").value = '';
    $("#codeDiv").css("visibility", "hidden");
    $('#post_textarea').focus();
}

function openImg() {
    $("#codeDiv").css("visibility", "hidden");
    $("#imgDiv").css("visibility", "visible");
}

function closeImg() {
    $("#imgDiv").css("visibility", "hidden");
}

function addCode() {
    var code = document.getElementById("code-text").value;
    document.getElementById("code-text").value = '';
    code = $('#post_textarea').val() + "<pre class='prettyprint'>" + code + "</pre>\n";
    $('#post_textarea').val(code);
    $("#codeDiv").css("visibility", "hidden");
    $('#post_textarea').focus();
}
