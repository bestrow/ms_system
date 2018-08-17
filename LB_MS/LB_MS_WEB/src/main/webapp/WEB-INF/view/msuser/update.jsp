<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="update" method="post">
    <input type="hidden" name="id" value="${msuser.id}">
    用户姓名:<input type="text" name="username" value="${msuser.username}"><br>
    用户账号:<input type="text" name="useraccount" value="${msuser.useraccount}"><br>
    用户密码:<input type="text" name="userpassword" value="${msuser.userpassword}"><br>
    用户性别:<input type="text" name="usersex" value="${msuser.usersex}"><br>
    用户年龄:<input type="text" name="userage" value="${msuser.userage}"><br>
    用户地址:<input type="text" name="useraddress" value="${msuser.useraddress}"><br>
    用户邮箱:<input type="text" name="useremail" value="${msuser.useremail}"><br>
    <input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
    function submit(obj) {
        obj.parent.submit();
    }
</script>
</html>
