/*删除新闻按钮点击事件*/
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


    $('.btn-success').each(function () {
        $(this).click(function () {
            var aviation_news_id = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                   type: "POST",
                   url: "/aviation/delnews",
                   data: {
                       aviation_news_id: aviation_news_id
                   },
                   success: function () {
                       var $toast = toastr["success"]("删除成功", "成功");
                       $toastlast = $toast;
                       window.location.reload()
                   },
                   error: function () {
                       var $toast = toastr["error"]("删除失败", "失败");
                       $toastlast = $toast;
                   }
                });
            }
        })
    })
});


