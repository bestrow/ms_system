<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="toadd" >增加商家</a>
<table border="2">
    <tr>
        <td>商家姓名</td>
        <td>商家店铺名称</td>
        <td>商家账号</td>
        <td>商家密码</td>
        <td>商家经营范围</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${msmerchantList}" var="item">
        <tr>
            <td>${item.merchantname}</td>
            <td>${item.merchantshopname}</td>
            <td>${item.merchantaccount}</td>
            <td>${item.merchantpassword}</td>
            <td>${item.merchantscope}</td>
            <td><a href="toupdate?id=${item.id}">修改</a>||<a href="delete?id=${item.id}">删除</a>||<a href="querybyid?id=${item.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
