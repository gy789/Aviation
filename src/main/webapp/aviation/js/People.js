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

    toastr.options.onHidden = function(){
        window.location.reload()
    };

    $('.btn-danger').each(function () {
        $(this).click(function () {
            var people_id = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                   type: "POST",
                   url: "/aviation/delpeople",
                   data: {
                       people_id: people_id
                   },
                   success: function (data) {
                       var $toast = toastr["success"](data.msginfo, "成功");
                       $toastlast = $toast;
                   },
                   error: function () {
                       var $toast = toastr["error"]("系统异常", "异常");
                       $toastlast = $toast;
                   }
                });
            }
        })
    })
});