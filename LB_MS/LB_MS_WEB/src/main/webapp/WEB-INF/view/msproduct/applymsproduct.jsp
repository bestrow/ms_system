<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="applymsproduct" method="post">
    商品id：<input type="text" name="productid"><br>
    商品标题：<input type="text" name="producttitle"><br>
    商品图片：<input type="text" name="productpicture"><br>
    原价格:<input type="text" name="originalprice"><br>
    秒杀价格:<input type="text" name="miaoshaprice"><br>
    商家id:<input type="text" name="merchantid"><br>
    秒杀开始时间:<input type="text" name="starttimestring"><br>
    秒杀结束时间:<input type="text" name="endtimestring"><br>
    秒杀商品数:<input type="text" name="productcount"><br>
    剩余库存数:<input type="text" name="stockcount"><br>
    描述:<input type="text" name="descrioption"><br>

    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>