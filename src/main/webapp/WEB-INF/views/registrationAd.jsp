<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Новое объявление</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <style>
        form {
            text-align:center;
        }
    </style>
</head>
<body>


<h2>Объявление!</h2>

<a href="/index">Назад</a>

<form:form class="form-signin" method="post" action="/ad/new" modelAttribute="ad">

    <form:label path="name">
        Имя обьявления
    </form:label>
    <form:input class="form-control" path="name"/> <br>

    <form:label path="info">
        Описание
    </form:label>
    <form:input class="form-control" type="textarea" path="info"/> <br>

    <form:label  path="price">
        Цена
    </form:label>
    <form:input  class="form-control" path="price" /> <br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрировать</button>
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>