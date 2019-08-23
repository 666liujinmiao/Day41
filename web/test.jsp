<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/8/22
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>GET方式提交</h2>
<form action="login" method="get">
    用户名：<input type="text" name="username" value="张三"><br>
    密码：<input type="password" name="password" value="123"><br>
    <input type="submit" value="登录">
</form>
<hr>
<h2>POST方式提交</h2>
<form action="login" method="post">
    用户名：<input type="text" name="username" value="admin"><br>
    密码：<input type="password" name="password" value="123"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
