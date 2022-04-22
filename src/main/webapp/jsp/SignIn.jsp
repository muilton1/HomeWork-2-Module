
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>

<h2>Выполните вход в свою учетную запись!</h2>

<form action="${pageContext.request.contextPath}/api/login" method="POST">
    <p>Логин: <input type="text" name="login" /></p>
    <p>Пароль: <input type="text" name="password"/></p>
    <p><input type="submit" value="Submit"></p>
</form>


<input type="button" onclick="history.back();" value="Назад"/>

</body>
</html>
