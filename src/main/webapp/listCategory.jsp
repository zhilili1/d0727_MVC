<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhili
  Date: 2023/7/27
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${!(empty categorya)}">
    ${categorya}
</c:if><br>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td><a href="listProduct?name=${c.name}">${c.name}</a>></td>
            <td><a href="editCategory?id=${c.id}">编辑</a></td>
            <td><a href="deleteCategory?id=${c.id}">删除</a></td>

        </tr>
    </c:forEach>
    <form action="addCategory" method="post">
        <input type="text" name="name"><br>
        <input type="submit" value="新增">
    </form>
</table>
</body>
</html>
