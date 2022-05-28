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


        $(".btn-outline").click(function () {
            var flight_start = $("input[name='flight_start']").val();
            var flight_end = $("input[name='flight_end']").val();
            var date = $("#date").val();
            var params = {"flight_start":flight_start,"flight_end":flight_end,"date":date};
            $.ajax({
                type: "POST",
                url: "/aviation/searchFlight",
                traditional: true,
                datatype: "json",
                data: {
                    params: JSON.stringify(params)
                },
                success: function (data) {
                    var $toast = toastr["success"]("查询成功", "成功");
                    $toastlast = $toast;
                    var jsonArr = eval(data.msginfo);
                    var html = "";
                    $("#flights").html("");
                    if (jsonArr == null){
                        html = "<tr class=\"odd\">"+
                        "<td valign='top' colspan='6' class='dataTables_empty'>没有数据</td>"+
                        "</tr>";
                        $("#flights").append(html);
                    }
                    for(var i = 0;i < jsonArr.length;i++){
                        html = "<tr class=\"gradeX\">\n" +
                            "                                            <td>"+jsonArr[i].company_name+"</td>\n" +
                            "                                            <td>"+jsonArr[i].flight_start+"<br>\n" +
                            "                                                "+jsonArr[i].flight_start_time+"\n "+
                            "                                            </td>\n" +
                            "                                            <td>"+jsonArr[i].flight_end+"<br>\n" +
                            "                                                "+jsonArr[i].flight_arrive_time+"\n" +
                            "                                            </td>\n" +
                            "                                            <td class=\"center\">￥"+jsonArr[i].flight_price+"</td>\n" +
                            "                                            <td class=\"center\">"+jsonArr[i].seat_count+"</td>\n" +
                            "                                            <td>\n" +
                            "                                                <button class=\"btn btn-info btn-rounded\">抢购<span style=\"display:none;\">"+jsonArr[i].flight_id+"</span></button>\n" +
                            "                                            </td>\n" +
                            "                                        </tr>";
                        $("#flights").append(html);
                    }
                },
                error: function () {
                    var $toast = toastr["error"]("系统异常", "异常");
                    $toastlast = $toast;
                }
            });
        });
});

/*删除按钮点击事件*/
$(document).ready(function () {
    $("#delete").click(function () {
        var message_id = [];
        $('input:checkbox:checked').each(function() {
            message_id.push($(this).val());
            var bool = confirm("确定删除？");
            if (bool) {
                $.ajax({
                    type: "POST",
                    url: "/expressage/delMessage",
                    traditional: true,
                    data: {
                        message_id: message_id
                    },
                    success: function () {
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
