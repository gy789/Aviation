<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title> 主页</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=basePath%>/aviation/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            ${menu}
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <h2>&nbsp;&nbsp;欢迎进入航空售票管理系统</h2>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="javaScript:void(0)">
                            <i class="fa fa-envelope"></i> <span class="label label-warning">${readnumber}</span>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <a href="<%=basePath%>getMessage?type=0">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> 您有${readnumber}条消息
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                        </ul>

                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="javaScript:void(0)">
                            <i class="fa fa-bell"></i> <span class="label label-primary">${unreadnumber}</span>
                        </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li>
                                    <a href="<%=basePath%>getMessage?type=1">
                                        <div>
                                            <i class="fa fa-envelope fa-fw"></i> 您有${unreadnumber}条未读消息
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                            </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="<%=basePath%>/aviation/index_v2.jsp" frameborder="0" data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<script src="<%=basePath%>/aviation/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>/aviation/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>/aviation/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/aviation/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>/aviation/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="<%=basePath%>/aviation/js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=basePath%>/aviation/js/index.js"></script>

<!-- 第三方插件 -->
<script src="<%=basePath%><%=basePath%>/aviation/js/plugins/pace/pace.min.js"></script>

</body>

</html>
