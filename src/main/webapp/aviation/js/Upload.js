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


    var formData = new FormData();
    $("input[name='file']").change(function () {

        if ($(this).val() != ""){
            var files = $(this)[0].files[0];
            formData.append("file",files);
            $.ajax({
                url: "/aviation/addFlight",
                type: "post",
                data: formData,
                processData: false,
                contentType: false,
                beforeSend: function () {
                    var $toast = toastr["info"]("传输中", "等待");
                    $toastlast = $toast;
                },
                success: function (data) {
                    toastr.options.onHidden = function(){
                        window.location.reload()
                    };
                    if(data.msginfo == '成功'){
                        toastr.clear(getLastToast());
                        var $toast = toastr["success"]("上传成功", "成功");
                        $toastlast = $toast;

                    }else {
                        toastr.clear(getLastToast());
                        var $toast = toastr["error"]("上传失败", "失败");
                        $toastlast = $toast;
                    }
                },
                error: function () {
                    toastr.clear(getLastToast());
                    var $toast = toastr["error"]("系统异常", "异常");
                    $toastlast = $toast;
                },

            });
        }

    });
});