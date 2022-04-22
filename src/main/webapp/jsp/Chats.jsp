<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chats</title>
</head>

<h2>Входящие сообщения</h2>

<c:forEach items="${requestScope.message}" var="item">
        <p>${item}</p>
    </c:forEach>

<input type="button" onclick="history.back();" value="Назад"/>

<body>
</html>