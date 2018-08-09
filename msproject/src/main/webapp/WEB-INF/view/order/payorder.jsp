<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="payorder">
    商品名称:${msproductdetail.productname}<br>
    购买数量:${productnum}<br>
    支付总额:${payamount}<br>
    <input type="hidden" name="productid" value="${msproduct.id}">
    <input type="hidden" name="userid" value="${userid}">
    <input type="hidden" name="merchantid" value="${msproduct.merchantid}">
    <input type="hidden" name="payamount" value="${payamount}">
    <input type="hidden" name="num" value="${productnum}">
    收货人地址:<input type="text" name="receivingadress"><br>
    收货人电话:<input type="text" name="receivingphone"><br>
    收货人名称:<input type="text" name="receivingname"><br>
    <input type="submit" value="立即付款">
</form>
</body>
</html>
