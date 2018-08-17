<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    <input type="hidden" name="id" value="${msmerchant.id}">
    商家姓名：<input type="text" name="merchantname" value="${msmerchant.merchantname}"><br>
    商家店铺名称：<input type="text" name="merchantshopname" value="${msmerchant.merchantshopname}"><br>
    商家账号：<input type="text" name="merchantaccount" value="${msmerchant.merchantaccount}"><br>
    商家密码:<input type="text" name="merchantpassword" value="${msmerchant.merchantpassword}"><br>
    商家经营范围:<input type="text" name="merchantscope" value="${msmerchant.merchantscope}"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
