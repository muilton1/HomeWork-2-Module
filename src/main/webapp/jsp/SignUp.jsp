<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SignUp</title>
</head>
<body>

<h2>Пройдите простую регистрацию для использования возможностей мессенджера!</h2>

<form action="${pageContext.request.contextPath}/api/user" method="POST">
    <p>Логин: <input type="text" name="login" /></p>
    <p>Пароль: <input type="text" name="password"/></p>
    <p>Ф.И.О.: <input type="text" name="name"/></p>
    <p>Дата рождения: <input type="text" name="birthday"/></p>
    <p><input type="submit" value="Submit"></p>
</form>

<a href="${pageContext.request.contextPath}/ui/signIn"> Залогинься, если уже зарегистрирован </a>
<input type="button" onclick="history.back();" value="Назад"/>

</body>
</html>