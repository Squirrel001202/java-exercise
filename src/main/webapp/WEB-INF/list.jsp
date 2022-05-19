<%@ page import="org.example.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>学生列表</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
</head>
<body>
<script type='text/javascript'>
    function del(sno){
        var ok = window.confirm('确认删除？');
        if(ok){
            document.location.href='${pageContext.request.contextPath}/deleteStudent?sno='+ sno
        }
    }
</script>
<h1>欢迎${username}</h1>
<a href="${pageContext.request.contextPath}/exit">[退出]</a>
<h1 align='center'>学生列表</h1>
<hr>
<table border='1px' align='center' >
    <tr>
        <th>序号</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${students}" var="student" varStatus="id">
        <tr>
            <td>${id.count}</td>
            <td>${student.sno}</td>
            <td>${student.name}</td>
            <td>${student.sex}</td>
            <td>${student.age}</td>
            <td>
                <a href='javascript:void(0)' onclick='del(${student.sno})'>删除</a>
                <a href='${pageContext.request.contextPath}/updateStudent?sno=${student.sno}'>修改</a>
                <a href='${pageContext.request.contextPath}/detailStudent?sno=${student.sno}'>详情</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<a href='${pageContext.request.contextPath}/insertStudentList'>新增</a>
</body>
</html>
