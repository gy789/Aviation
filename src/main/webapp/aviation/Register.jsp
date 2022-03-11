<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title> - 注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-12">
            <form method="post" action="/register">
                <h2><p class="m-t-md" style="text-align: center;color: #2150ec;">航空售票管理系统</p></h2>
                <h3 class="no-margins" style="text-align: center">注册</h3>
                <input type="text" name="username" class="form-control uname" placeholder="用户名" />
                <input type="password" name="password" class="form-control pword m-b" placeholder="密码" />
                <font style="color: red">${errorMsg}</font><a href="Login.jsp">登录</a>
                <button class="btn btn-success btn-block">注册</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>