<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="paywithMsorder" method="post">
    支付方式：
    支付宝：<input type="radio" name="paytype" value="1">
    微信：<input type="radio" name="paytype" value="2">
    银联：<input type="radio" name="paytype" value="3"><br>
    支付总金额：${payamount}<br>
    流水号：${tradeserialnumber}<br>
    <input type="hidden" name="userid" value="${userid}">
    <input type="hidden" name="productid" value="${productid}">
    <input type="hidden" name="merchantid" value="${merchantid}">
    <input type="hidden" name="tradeserialnumber" value="${tradeserialnumber}">
    <input type="hidden" name="payamount" value="${payamount}">
    <input type="submit" value="确认提交">
</form>
</body>
</html>