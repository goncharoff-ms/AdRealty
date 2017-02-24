<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Новое объявление</title>

    <style>
        form {
            text-align:center;
        }
    </style>
</head>
<body>


<h2>Объявление!</h2>

<a href="/index">Назад</a>

<form:form method="post" action="/ad/new" modelAttribute="ad">

    <form:label path="name">
        Имя обьявления
    </form:label>
    <form:input path="name"/> <br>

    <form:label path="info">
        Описание
    </form:label>
    <form:input type="textarea" path="info"/> <br>

    <form:label path="price">
        Цена
    </form:label>
    <form:input path="price" /> <br>

    <input type="submit" value="GO"/>
</form:form>



</body>
</html>