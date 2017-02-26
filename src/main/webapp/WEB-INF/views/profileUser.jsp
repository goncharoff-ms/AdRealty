<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Личная страница</title>
</head>
<body>


<h2>Данные о пользователе ${user.name}</h2>

<a href="/registration">Регистрация</a>
<br>
<a href="/index">Главная</a>




    <table class="data">
        <tr>
            <th>Логин</th>
            <th>Пароль</th>
            <th>Email</th>
            <th>Телефон</th>
        </tr>
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
            </tr>
    </table>

</body>
</html>