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


    <title> - 文章页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=basePath%>/aviation/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="<%=basePath%>/aviation/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/aviation/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight article">
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="ibox">
                <div class="ibox-content">
                    <div class="pull-right">
                        <button class="btn btn-white btn-xs" type="button">${news.create_time}</button>
                    </div>
                    <div class="text-center article-title">
                        <h1>
                            ${news.aviation_news_title}
                        </h1>
                    </div>
                    <p>${news.aviation_news_info}
                        </p>
                    <hr>


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





</body>

</html>

