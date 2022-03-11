/*删除新闻按钮点击事件*/
$(document).ready(function () {
    $('.btn-success').each(function () {
        $(this).click(function () {
            var expressage_news_id = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                   type: "POST",
                   url: "/expressage/delnews",
                   data: {
                       expressage_news_id: expressage_news_id
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

/*删除新闻按钮点击事件*/
$(document).ready(function () {
    $('.fa-trash-o').each(function () {
        $(this).click(function () {
            var expressage_news_id = $(this).children("span").text();
            var bool = confirm("确定删除？");
            if (bool){
                $.ajax({
                    type: "POST",
                    url: "/expressage/delnews",
                    data: {
                        expressage_news_id: expressage_news_id
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



