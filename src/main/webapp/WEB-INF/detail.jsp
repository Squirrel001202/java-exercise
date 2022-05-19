<%@ page import="org.example.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>学生详情</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"></head>
<body>
    <h1>欢迎${username}</h1>
    <a href="${pageContext.request.contextPath}/exit">[退出]</a>
    <h1>学生详情</h1>
    <hr>
        学号：${student.sno}<br>
        姓名：${student.name}<br>
        性别：${student.sex}<br>
        年龄：${student.age}<br>
    <input type='button' value='返回' onclick='window.history.back()'>
</body>
</html>
