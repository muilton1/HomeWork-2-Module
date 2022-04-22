<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistic</title>
</head>
<body>

<h2>Статистика</h2>

<p>Кол-во отправленных сообщений: ${requestScope.messages}</p>
<p>Кол-во активных пользователей: ${requestScope.loggedUsers}</p>
<p>Кол-во зарегистрированных пользователей: ${requestScope.allUsers}</p>

<input type="button" onclick="history.back();" value="Назад"/>

</body>
</html>