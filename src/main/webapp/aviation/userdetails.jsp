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


    <title>用户详细信息</title>
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
                        <h5>用户信息</h5>
                       
                    </div>
                    <div class="ibox-content">
                        <form method="post" action="updateuser" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>

                                <div class="col-sm-10">
                                    <input type="text" name="username" value="${users.username}" class="form-control">
                                    <input type="text" name="uid" style="display: none" value="${users.uid}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
							<div class="form-group">
                                <label class="col-sm-2 control-label">密码</label>

                                <div class="col-sm-10">
                                    <input type="text" name="password" value="${users.password}" class="form-control">
                                </div>
                            </div>
							<div class="hr-line-dashed"></div>
                            <c:if test="${user.role == 0}">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">角色</label>
                                <div class="col-sm-10">
                                    <select class="form-control m-b" name="role">
                                        <option class="role" disabled selected hidden value="${users.role}"></option>
                                        <option class="role" value="0"></option>
                                        <option class="role" value="2"></option>
                                        <option class="role" value="1"></option>
                                    </select>
                                </div>
                            </div>
                            </c:if>
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
    <script src="<%=basePath%>/aviation/js/User.js"></script>

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
