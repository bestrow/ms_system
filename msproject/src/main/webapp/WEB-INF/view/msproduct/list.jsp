<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="toApplymsproduct" >申请秒杀商品</a>
<table border="2">
    <tr>
        <td>商品id</td>
        <td>商品标题</td>
        <td>商品图片</td>
        <td>原价格</td>
        <td>秒杀价格</td>
        <td>商家id</td>
        <td>申请日期</td>
        <td>审核状态</td>
        <td>秒杀开始时间</td>
        <td>秒杀结束时间</td>
        <td>秒杀商品数</td>
        <td>剩余库存数</td>
        <td>描述</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${msproductList}" var="item">
        <tr>
            <td>${item.productid}</td>
            <td>${item.producttitle}</td>
            <td>${item.productpicture}</td>
            <td>${item.originalprice}</td>
            <td>${item.miaoshaprice}</td>
            <td>${item.merchantid}</td>
            <td>${item.applydate}</td>
            <td>${item.auditstate}</td>
            <td>${item.starttime}</td>
            <td>${item.endtime}</td>
            <td>${item.productcount}</td>
            <td>${item.stockcount}</td>
            <td>${item.descrioption}</td>
            <td><a href="toupdateMsproduct?id=${item.id}">修改</a>||
                <a href="deleteMsproductById?id=${item.id}">删除</a>||
                <a href="queryMsproductById?id=${item.id}">查看</a>||
                <a href="toupdateMsproductState?id=${item.id}">审核</a>||
                <a href="/msproductdetailAction/toinsertMsproductdetail?productid=${item.productid}&&merchantid=${item.merchantid}">添加商品详情</a>||
                <a href="/msproductdetailAction/queryMsproductdetailById?productid=${item.productid}">查看商品详情</a>||
                <a href="/msproductdetailAction/toupdateMsproductdetail?productid=${item.productid}">修改商品详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
