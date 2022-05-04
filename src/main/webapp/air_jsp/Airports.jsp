<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Airports</title>
</head>

<h2>Список аэропортов</h2>

<c:forEach items="${requestScope.airports}" var="item">
        <p>${item}</p>
    </c:forEach>

<input type="button" onclick="history.back();" value="Назад"/>

<body>
</html>
