<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Messenger</title>
</head>

<h2>Введите текст сообщения</h2>

<form action="${pageContext.request.contextPath}/api/message" method="POST">
    <p>Кому: <input type="text" name="toUser" /></p>
    <p>Текст: <input type="text" name="message"/></p>
    <p><input type="submit" value="Submit"></p>
</form>

<a href="${pageContext.request.contextPath}/ui/user/chats"> Перейти во входящие сообщения </a>
<a href="${pageContext.request.contextPath}/ui/admin/statistics"> Посмотреть статистику(доступо только админу!) </a>

<input type="button" onclick="history.back();" value="Назад"/>

<body>