<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新增学生</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"></head>
<body>
    <h1>欢迎${username}</h1>
    <a href="${pageContext.request.contextPath}/exit">[退出]</a>
    <h1>新增学生</h1>
    <hr>
    <form action="${pageContext.request.contextPath}/insertStudent" method="post">
        学号：<input type="text" name="sno"/><br>
        姓名：<input type="text" name="name"/><br>
        性别：<input type="radio" name="sex" value="男"/>男
        <input type="radio" name="sex" value="女"/>女<br>
        年龄：<input type="text" name="age"/><br>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
