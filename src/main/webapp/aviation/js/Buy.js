$(document).ready(function () {
    $('.btn-info').each(function () {
        $(this).click(function () {
            var flight_id = $(this).children("span").text();
            var date = $('#date').val();
            window.location.href = "/aviation/makeorder?flight_id="+flight_id+"&date="+date;
        })
    });

    $("body").delegate('.btn-info','click',function () {
            var flight_id = $(this).children("span").text();
            var date = $('#date').val();
            window.location.href = "/aviation/makeorder?flight_id="+flight_id+"&date="+date;
    });

});