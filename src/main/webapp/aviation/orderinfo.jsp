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


    <title>订单信息</title>
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
                        <h5>航班信息填写</h5>
                       
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="<%=basePath%>submitorder" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">航班号</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_number" readonly value="${orders.flight_number}"  class="form-control">
                                    <input type="text" name="flight_id" readonly style="display: none" value="${orders.flight_id}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">出发地</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_start" readonly value="${orders.flight_start}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
                                <label class="col-sm-2 control-label">目的地</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_end" readonly value="${orders.flight_end}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">起飞时间</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_start_time" readonly value="${orders.flight_start_time}" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">落地时间</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_arrive_time" readonly value="${orders.flight_arrive_time}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">日期</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_date" readonly value="${orders.flight_date}"  class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公司名</label>

                                <div class="col-sm-10">
                                    <input type="text" name="company_name" readonly value="${orders.company_name}"  class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">价格</label>

                                <div class="col-sm-10">
                                    <input type="text" name="order_price" readonly value="${orders.order_price}"  class="form-control">
                                    <p class="form-control-static">机建费:￥50</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">飞行时长</label>

                                <div class="col-sm-10">
                                    <input type="text" name="flight_time" readonly value="${orders.flight_time}" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择乘客
                                </label>
                                <div class="col-sm-10">
                                    <a class="btn btn-outline btn-link" href="<%=basePath%>/aviation/addpeople.jsp" type="button">
                                        <i class="fa fa-plus"></i>&nbsp;添加乘客
                                    </a>
                                    <c:forEach items="${peopleList}" var="people">
                                        <div class="radio">
                                            <label>
                                                <input type="radio" checked="" value="${people.people_id}"  name="people_id">姓名：${people.people_name}<br><span>身份证号：${people.people_number}</span></label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button class="btn btn-primary" type="submit">提交订单</button>
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
