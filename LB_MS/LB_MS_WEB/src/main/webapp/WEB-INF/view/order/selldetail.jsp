<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/msorderAction/topayorder" method="post">
    购买数量：<input type="text" name="num">
    <input type="hidden" name="id" value="${msproduct.id}">
    <table border="1">
        <tr>
            <td>商品标题</td>
            <td>商品图片</td>
            <td>原价格</td>
            <td>秒杀价格</td>
            <td>秒杀开始时间</td>
            <td>秒杀结束时间</td>
            <td>秒杀商品数</td>
            <td>库存</td>
        </tr>
        <tr>
            <td>${msproduct.producttitle}</td>
            <td>${msproduct.productpicture}</td>
            <td>${msproduct.originalprice}</td>
            <td>${msproduct.miaoshaprice}</td>
            <td>${msproduct.starttime}</td>
            <td>${msproduct.endtime}</td>
            <td>${msproduct.productcount}</td>
            <td>${msproduct.stockcount}</td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <td>商品产地</td>
            <td>商品名称</td>
            <td>品牌名称</td>
            <td>商品重量</td>
            <td>规格和包装</td>
            <td>商品详情图片地址</td>
        </tr>
        <tr>
            <td>${msproductdetail.productplace}</td>
            <td>${msproductdetail.productname}</td>
            <td>${msproductdetail.brandname}</td>
            <td>${msproductdetail.productweight}</td>
            <td>${msproductdetail.specification}</td>
            <td>${msproductdetail.productdetailpicture}</td>
        </tr>
    </table>
    <input type="button" value="立即购买" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
