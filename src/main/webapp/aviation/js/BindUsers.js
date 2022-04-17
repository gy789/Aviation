/*标记已读按钮点击事件*/
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

        $(".btn-primary").click(function () {
            var uid = $("input[name='uid']").val();
            var company_number = $("select[name='company']").find("option:selected").val();
            var company_name = $("select[name='company']").find("option:selected").text();

            var params = {"uid":uid,"company_number":company_number,"company_name":company_name};

            $.ajax({
                type: "POST",
                url: "/aviation/binduser",
                traditional: true,
                datatype: "json",
                data: {
                    params: JSON.stringify(params)
                },
                success: function (data) {
                    var $toast = toastr["success"](data.msginfo, "成功");
                    $toastlast = $toast;
                    $(".btn-primary").attr("disabled",true);
                },
                error: function (data) {
                    var $toast = toastr["error"](data.msginfo, "系统异常");
                    $toastlast = $toast;
                }
            });
        });
});
