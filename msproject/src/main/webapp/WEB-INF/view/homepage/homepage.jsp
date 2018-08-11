<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
welcome ${msuser.useraccount}<br>

<a href="/userRegisterLoginAction/toregister">注册</a>
<a href="/userRegisterLoginAction/tologin">登录</a>
<a href="/userRegisterLoginAction/exit">退出</a>
<a href="/msorderAction/queryMsorderByUserid">订单查询</a>

<table border="2">
    <c:forEach items="${msproductList}" var="item">
        <tr>
            <td>${item.producttitle}</td>
            <td>${item.productpicture}</td>
            <td>${item.originalprice}</td>
            <td>${item.miaoshaprice}</td>
            <td>${item.starttime}</td>
            <td>${item.endtime}</td>
            <td><a href="viewproductdetail?id=${item.id}">查看</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
