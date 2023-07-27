<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .kun{
            height: 140px;
            width: 140px;
        }
    /*    视口单位  vw vh */
        .container{
            width: 100vw;
            height: 100vh;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>
                    简单登录模块!
                </h1>
<%--                从session中获取errMsg 如果发现不为空 则显示 如果发现为空 则不加载--%>
                <c:if test="${!(empty errMsg)}">
                    ${errMsg}
                </c:if>
                <p>
                    <a class="btn btn-primary btn-large" href="register.jsp">注册</a>
                </p>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-1 column">
            <img alt="140x140" src="imgs/kun.jpg" class="img-circle kun" />
        </div>
        <div class="col-md-10 column">
            <form class="form-horizontal" role="form" action="login" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">账户</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password" name="password" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-default" value="登录" />
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-1 column">
            <img alt="140x140" src="imgs/kun.jpg" class="img-circle kun" />
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <p class="text-center text-warning lead">
                             iweb版权所有,侵权必究！
            </p>
        </div>
    </div>
</div>
</body>
</html>