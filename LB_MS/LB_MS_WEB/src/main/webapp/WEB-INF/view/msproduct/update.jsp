<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updateMsproduct" method="post">
    <input type="hidden" name="id" value="${msproduct.id}">
    商品标题：<input type="text" name="producttitle" value="${msproduct.producttitle}"><br>
    商品图片：<input type="text" name="productpicture" value="${msproduct.productpicture}"><br>
    原价格:<input type="text" name="originalprice" value="${msproduct.originalprice}"><br>
    秒杀价格:<input type="text" name="miaoshaprice" value="${msproduct.miaoshaprice}"><br>
    秒杀开始时间:<input type="text" name="starttimestring" value="${msproduct.starttimestring}"><br>
    秒杀结束时间:<input type="text" name="endtimestring" value="${msproduct.endtimestring}"><br>
    秒杀商品数:<input type="text" name="productcount" value="${msproduct.productcount}"><br>
    剩余库存数:<input type="text" name="stockcount" value="${msproduct.stockcount}"><br>
    描述:<input type="text" name="descrioption" value="${msproduct.descrioption}"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
