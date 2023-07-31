<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhili
  Date: 2023/7/27
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="updateCategory" method="post">
请输入你要修改的分类名:
<input type="hidden" value="${c.id}" name="id"><br>
<input type="text" name="name" value="${c.name}"><br>
<input type="submit" value="修改">
</form>
</body>
</html>
