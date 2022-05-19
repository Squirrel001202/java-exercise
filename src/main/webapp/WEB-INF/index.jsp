<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"></head>
<body>
<h1>欢迎使用</h1>
<hr>
<form action="${pageContext.request.contextPath}/login" method="post">
    username:<input type="text" name="username"/><br>
    password:<input type="password" name="password"/><br>
    <input type="submit" value="登录"/>
    <input type="checkbox" name="f" value="1">十天内免登录
</form>
</body>
</html>
