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


    <title> 订单信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=basePath%>/aviation/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="<%=basePath%>/aviation/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/plugins/toastr/toastr.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-sm-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>订单列表</h5>
                        </div>
                        <div class="ibox-content">

                            <table class="table table-striped table-bordered table-hover dataTables-example">
                                <thead>
                                        <tr>
                                            <th>航空公司</th>
                                            <th>起点</th>
                                            <th>终点</th>
                                            <th>票价</th>
                                            <th>日期</th>
                                            <th>座位</th>
                                            <th>支付状态</th>
                                            <c:if test="${sessionScope.user.role == '2'}">
                                            <th>操作</th>
                                            </c:if>
                                        </tr>
                                    </thead>
                                    <tbody id="flights">
                                    <c:forEach items="${ordersList}" var="orders">
                                        <tr class="gradeX">
                                            <td>${orders.company_name}</td>
                                            <td>${orders.flight_start}<br>
                                                ${orders.flight_start_time}
                                            </td>
                                            <td>${orders.flight_end}<br>
                                                ${orders.flight_arrive_time}
                                            </td>
                                            <td class="center">￥${orders.order_price}</td>
                                            <td class="center">${orders.flight_date}</td>
                                            <td class="center">${orders.seat_number}</td>
                                            <td class="center">${orders.order_status}</td>
                                            <c:if test="${sessionScope.user.role == '2'}">
                                            <td>
                                                <c:choose>
                                                    <c:when test="${orders.order_status == '未支付'}">
                                                        <a class="btn btn-info btn-rounded" target="_blank" href="/aviation/alipay?order_id=${orders.order_id}">去支付</a>
                                                    </c:when>
                                                    <c:when test="${orders.order_status == '已支付'}">
                                                        <a class="btn btn-info btn-rounded"  href="/aviation/aliRefund?order_id=${orders.order_id}">退款</a>
                                                    </c:when>
                                                </c:choose>
                                                <a class="btn btn-danger btn-rounded"  href="javaScript:void(0)">删除订单
                                                    <span style="display:none;">${orders.order_id}</span>
                                                </a>

                                            </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                <tfoot>
                                <tr>
                                    <th>航空公司</th>
                                    <th>起点</th>
                                    <th>终点</th>
                                    <th>票价</th>
                                    <th>日期</th>
                                    <th>座位</th>
                                    <th>支付状态</th>
                                    <c:if test="${sessionScope.user.role == '2'}">
                                        <th>操作</th>
                                    </c:if>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <!-- 全局js -->
    <script src="<%=basePath%>aviation/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>aviation/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=basePath%>aviation/js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="<%=basePath%>aviation/js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="<%=basePath%>aviation/js/plugins/dataTables/dataTables.bootstrap.js"></script>

    <!-- 自定义js -->
    <script src="<%=basePath%>aviation/js/content.js?v=1.0.0"></script>
    <script src="<%=basePath%>aviation/js/plugins/layer/laydate/laydate.js"></script>
    <script src="<%=basePath%>aviation/js/plugins/toastr/toastr.min.js"></script>
    <script src="<%=basePath%>aviation/js/Orders.js"></script>
    <script>
        //外部js调用
        laydate({
            elem: '#date', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>
    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            });


        });

        function fnClickAddRow() {
            $('#editable').dataTable().fnAddData([
                "Custom row",
                "New row",
                "New row",
                "New row",
                "New row"]);

        }
    </script>

    
    

</body>

</html>
