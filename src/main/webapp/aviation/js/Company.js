/*删除公司按钮点击事件*/
$(document).ready(function () {
    function getLastToast() {
        return $toastlast;
    }
    $('#cleartoasts').click(function () {
        toastr.clear();
    });

    var $toastlast;
    toastr.options = {
        "closeButton": "true",
        "debug": "false",
        "progressBar": "true",
        "positionClass": "toast-top-center",
        "showDuration": "400",
        "hideDuration": "1000",
        "timeOut": "7000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut",
        "onclick": "null"
    };


    $('.btn-info').each(function () {
        $(this).click(function () {
            var company_number = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                    type: "POST",
                    datatype: "json",
                    url: "/aviation/deleteCompany",
                    data: {
                        company_number: company_number
                    },
                    success: function (data) {
                        var $toast = toastr["success"](data.msginfo, "成功");
                        $toastlast = $toast;
                       window.location.reload()
                    },
                    error: function () {
                        var $toast = toastr["error"]("删除失败", "系统异常");
                        $toastlast = $toast;
                    }
                });
            }
        })
    })
});

