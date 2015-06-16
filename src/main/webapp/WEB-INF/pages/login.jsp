<%--
  Created by IntelliJ IDEA.
  User: ilovey
  Date: 5/16/15
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<s:url value="/submit" var="authUrl" />
<form method="POST" class="signin" action="${authUrl}">
    <input type="text" placeholder="请输入用户名" name="username"/>
    <input type="password" placeholder="请输入密码" name="password"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
