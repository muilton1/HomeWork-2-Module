<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights</title>
</head>

<h3>Выберите место отправления</h3>

<form action="${pageContext.request.contextPath}/flights" method="POST">

    <p>Выберите аэропорт отправления:
    <select name="fromAirport">
    <option value="" selected></option>
       <option disabled>Выберите аэропорт отправления</option>
                                         <c:forEach items="${airports}" var="item">
                                             <option value="${item}">${item}</option>
                                         </c:forEach>
    </select> </p>

    <p>Выберите дату отправления:
    <input name ="fromDate" type="date"/></td>

    <p>Выберите аэропорт прибытия:
    <select name="toAirport">
    <option value="" selected></option>
        <option disabled>Выберите аэропорт прибытия</option>
                                             <c:forEach items="${airports}" var="item">
                                                 <option value="${item}">${item}</option>
                                             </c:forEach>
    </select> </p>

    <p>Выберите дату прибытия:
    <input name ="toDate" type="date"/></td>

    <p><input type="submit" value="Поиск"></p>
</form>

<body>
</html>