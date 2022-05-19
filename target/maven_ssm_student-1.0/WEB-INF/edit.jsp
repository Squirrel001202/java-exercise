<%@ page import="org.example.pojo.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <title>修改学生</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"></head>
<body>
<script>
    window.onload = function (){
        if("${student.sex}" == "男"){
            document.getElementById("man").checked = true;
        }else{
            document.getElementById("woman").checked = true;
        }
    }
</script>
    <h1>欢迎${username}</h1>
    <a href="${pageContext.request.contextPath}/exit">[退出]</a>
    <h1>修改学生</h1>
    <hr>
    <form action='${pageContext.request.contextPath}/updateFinish' method='post'>
      学号：<input type='text' name='sno' readonly value='${student.sno}'/><br>
      姓名：<input type='text' name='name' value='${student.name}'/><br>
      性别：<input type='radio' name='sex' value='男' id="man"/>男
        <input type='radio' name='sex' value='女' id="woman"/>女<br>
      年龄：<input type='text' name='age' value='${student.age}'/><br>
      <input type='submit' value='提交'/>
    </form>
</body>
</html>
