<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    用户姓名:<input type="text" name="username"><br>
    用户账号:<input type="text" name="useraccount"><br>
    用户密码:<input type="text" name="userpassword"><br>
    用户性别:<input type="text" name="usersex"><br>
    用户年龄:<input type="text" name="userage"><br>
    用户地址:<input type="text" name="useraddress"><br>
    用户邮箱:<input type="text" name="useremail"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
