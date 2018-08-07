<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="toadd" >增加用户</a>
<table border="2">
    <tr>
        <td>用户姓名</td>
        <td>用户账号</td>
        <td>用户密码</td>
        <td>用户性别</td>
        <td>用户年龄</td>
        <td>用户地址</td>
        <td>用户邮箱</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${msuserList}" var="item">
        <tr>
            <td>${item.username}</td>
            <td>${item.useraccount}</td>
            <td>${item.userpassword}</td>
            <td>${item.usersex}</td>
            <td>${item.userage}</td>
            <td>${item.useraddress}</td>
            <td>${item.useremail}</td>
            <td><a href="toupdate?id=${item.id}">修改</a>||<a href="delete?id=${item.id}">删除</a>||<a href="querybyid?id=${item.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
