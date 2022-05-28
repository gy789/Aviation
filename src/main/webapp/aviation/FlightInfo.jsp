<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>航班信息修改</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=basePath%>/aviation/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>航班信息修改</h5>
                       
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="<%=basePath%>updateflight" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">航班号</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_number" value="${flight.flight_number}" class="form-control">
                                    <input type="text" name="flight_id" style="display: none" value="${flight.flight_id}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">出发地</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_start" value="${flight.flight_start}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
                                <label class="col-sm-2 control-label">目的地</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_end" value="${flight.flight_end}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">起飞时间</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_start_time" value="${flight.flight_start_time}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">落地时间</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_arrive_time" value="${flight.flight_arrive_time}"  class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名</label>

                                <div class="col-sm-10">
                                    <input type="text" name="company_name" value="${flight.company_name}" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">价格</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_price" value="${flight.flight_price}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">飞行时长</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_time" value="${flight.flight_time}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">座位数</label>

                                <div class="col-sm-10">
                                    <input type="text" name="seat_basic_count" readonly value="${flight.seat_basic_count}"  class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">修改</button>
                                    <font style="color: red">${error}</font>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="<%=basePath%>/aviation/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>/aviation/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="<%=basePath%>/aviation/js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="<%=basePath%>/aviation/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    
    

</body>

</html>
