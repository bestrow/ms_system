<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateMsproductState" method="post">
    <input type="hidden" name="id" value="${msproduct.id}">
    商家id: ${msproduct.merchantid}
    商品id: ${msproduct.productid}
    商品标题：${msproduct.producttitle}<br>
    商品图片：${msproduct.productpicture}<br>
    原价格: ${msproduct.originalprice}<br>
    秒杀价格: ${msproduct.miaoshaprice}<br>
    秒杀开始时间: ${msproduct.starttimestring}<br>
    秒杀结束时间: ${msproduct.endtimestring}<br>
    秒杀商品数: ${msproduct.productcount}<br>
    剩余库存数: ${msproduct.stockcount}<br>
    描述: ${msproduct.descrioption}<br>
    审核通过：<input type="radio" name="state" value="2"> 审核不通过：<input type="radio" name="state" value="3">
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
