/*删除公司按钮点击事件*/
$(document).ready(function () {
    $('.btn-info').each(function () {
        $(this).click(function () {
            var expressagecompany_id = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                   type: "POST",
                   url: "/expressage/deleteCompany",
                   data: {
                       expressagecompany_id: expressagecompany_id
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

