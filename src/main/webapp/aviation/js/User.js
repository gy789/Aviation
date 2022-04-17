/*删除公司按钮点击事件*/
$(document).ready(function () {
    $('.btn-danger').each(function () {
        $(this).click(function () {
            var uid = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                   type: "POST",
                   url: "/aviation/deleteuser",
                   data: {
                       uid: uid
                   },
                   success: function () {
                       alert("删除成功");
                       window.location.reload()
                   },
                   error: function () {
                       alert("系统异常，删除失败");
                   }
                });
            }
        })
    })
});

$(document).ready(function () {
    $('.center').each(function () {
        var role = $(this).text();
        if(role == 1){
            $(this).text("航空公司人员");
        }
        else if(role == 0){
            $(this).text("管理员");
        }else {
            $(this).text("普通用户");
        }
    });
    $('.role').each(function () {
        var role = $(this).val();
        if(role == 1){
            $(this).text("航空公司人员");
        }
        else if(role == 0){
            $(this).text("管理员");
        }else {
            $(this).text("普通用户");
        }
    });
});