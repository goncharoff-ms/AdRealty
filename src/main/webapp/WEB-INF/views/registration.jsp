<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Регистрация</title>

    <style>
        form {
            text-align:center;
        }
    </style>
</head>
<body>


<h2>Список пользователей</h2>

<a href="/index">Назад</a>

<form:form method="post" action="/registration" commandName="user" modelAttribute="user">

    <form:label path="login">
        Login
    </form:label>
    <form:input path="login"/> <br>

    <form:label path="password">
        Password
    </form:label>
    <form:input type="password" path="password"/> <br>

    <form:label path="name">
        Name
    </form:label>
    <form:input path="name" /> <br>

    <form:label path="email">
        Email
    </form:label>
    <form:input path="email" /> <br>

    <form:label path="phone">
        Phone
    </form:label>
    <form:input path="phone"/> <br>


    <input type="submit" value="GO"/>
</form:form>



</body>
</html>