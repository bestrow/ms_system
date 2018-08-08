<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateMsproductdetail" method="post">
    <input type="hidden" name="id" value="${msproductdetail.id}">
    <input type="hidden" name="productid" value="${msproductdetail.productid}">
    <input type="hidden" name="merchantid" value="${msproductdetail.merchantid}">
    商品产地：<input type="text" name="productplace" value="${msproductdetail.productplace}"><br>
    商品名称：<input type="text" name="productname" value="${msproductdetail.productname}"><br>
    品牌名称：<input type="text" name="brandname" value="${msproductdetail.brandname}"><br>
    商品重量:<input type="text" name="productweight" value="${msproductdetail.productweight}"><br>
    规格和包装:<input type="text" name="specification" value="${msproductdetail.specification}"><br>
    商品详情图片地址:<input type="text" name="productdetailpicture" value="${msproductdetail.productdetailpicture}"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
