<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/20
  Time: 下午2:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自定义结果集</title>
    <script src="jquery-3.2.1.js"></script>
</head>
<body>
<form action="login.action">
    验证码:
    <input type="text" name="code">
    <img id="img" src="${pageContext.request.contextPath}/codeImg.action">
    <br>
    <input type="submit" value="go">
    <span style="color: red"><s:actionerror/></span>
</form>

</body>
<script>
    $("#img").click(function () {
        $("#img").attr("src", "${pageContext.request.contextPath}/codeImg.action?a=" + Math.random())
    })
</script>
</html>
