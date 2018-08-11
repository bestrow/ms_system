<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
welcome merchant：${msmerchant.merchantaccount}<br>

<a href="/merchantRegisterLoginAction/toregister">商家注册</a>
<a href="/merchantRegisterLoginAction/tologin">商家登录</a>
<a href="/merchantRegisterLoginAction/exit">商家登录退出</a>
<a href="/msorderAction/queryMsorderByMerchantid">订单查询</a>
</body>
</html>
