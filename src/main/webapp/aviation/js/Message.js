/*标记已读按钮点击事件*/
$(document).ready(function () {
        $("#read").click(function () {
            var message_id = [];
            $('input:checkbox:checked').each(function() {
                message_id.push($(this).val());
                console.log(message_id);
                var bool = confirm("确定标记为已读状态？");
                if (bool) {
                    $.ajax({
                        type: "POST",
                        url: "/expressage/updateMessage",
                        traditional: true,
                        data: {
                            message_id: message_id
                        },
                        success: function () {
                            window.location.reload()
                        },
                        error: function () {
                            alert("系统异常，失败");
                        }
                    });
                }
            });
        })
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
