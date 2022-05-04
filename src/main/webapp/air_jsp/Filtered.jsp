<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Filtered</title>
</head>

<h2>Список рейсов</h2>

<c:forEach items="${pages}" var="item">
        <p>${item}</p>
    </c:forEach>

<c:if test="${filtered.size()>25}">
<c:set var="page" value="${page+1}"/>
    <a href="flights?page=2">Вторая страница</a>
</c:if>

<input type="button" onclick="history.back();" value="Назад"/>

<body>
</html>