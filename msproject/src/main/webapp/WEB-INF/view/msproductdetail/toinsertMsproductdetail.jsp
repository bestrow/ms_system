<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="insertMsproductdetail" method="post">
    <input type="hidden" name="productid" value="${productid}">
    <input type="hidden" name="merchantid" value="${merchantid}">
    商品产地：<input type="text" name="productplace"><br>
    商品名称：<input type="text" name="productname"><br>
    品牌名称：<input type="text" name="brandname"><br>
    商品重量:<input type="text" name="productweight"><br>
    规格和包装:<input type="text" name="specification"><br>
    商品详情图片地址:<input type="text" name="productdetailpicture"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
