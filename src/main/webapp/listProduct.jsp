<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhili
  Date: 2023/7/28
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${ (!empty producta)}">
    ${producta}<br>
</c:if>
<form action="addProduct" method="post">
    请输入商品名：
    <input type="text" name="name"><br>
    请输入商品价格
    <input type="text" name="price"><br>
    请输入库存：
    <input type="text" name="stock"><br>
    请输入商品类：
    <input type="text" name="cname"><br>
    <input type="submit" value="增加">
</form>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>stock</td>
        <td>cname</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${plist}" var="p" varStatus="st">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.stock}</td>
            <td>${p.cname}</td>
            <td><a href="editProduct?id=${p.id}">编辑</a></td>
            <td><a href="deleteProduct?id=${p.id}">删除</a></td>

        </tr>
    </c:forEach>
<%--    <form action="addCategory" method="post">--%>
<%--        <input type="text" name="name"><br>--%>
<%--        <input type="submit" value="新增">--%>
<%--    </form>--%>
</table>
</body>
</html>
