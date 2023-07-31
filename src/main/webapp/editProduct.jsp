<%--
  Created by IntelliJ IDEA.
  User: zhili
  Date: 2023/7/28
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateProduct" method="post">
    请输入你要修改的商品名：
    <input type="hidden" value="${p.id}" name="id"><br>
    <input type="text" value="${p.name}" name="name"><br>
    请输入你要修改的价格：
    <input type="text" value="${p.price}"name="price"><br>
    请输入你要修改的库存：
    <input type="text" value="${p.stock}" name="stock"><br>
    请输入你要修改的cname：
    <input type="text" value="${p.cname}" name="cname"><br>
    <input type="submit" value="修改">
</form>


</body>
</html>
