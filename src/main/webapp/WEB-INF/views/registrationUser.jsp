<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <title>Регистрация</title>

    <style>
        form {
            text-align:center;
        }
    </style>
</head>
<body>


<h2>Введите данные вашего аккаунта!</h2>

<a href="/index">Назад</a>

<form:form class="form-signin" method="post" action="/registration" commandName="user" modelAttribute="user">
    <form:label path="login">
        Login
    </form:label>
    <form:input class="form-control" path="login"/>
    <form:errors cssClass="has-error" path="login"/>
    <br>

    <form:label path="password">
        Password
    </form:label>
    <form:input class="form-control" type="password" path="password"/> <br>

    <form:label path="name">
        Name
    </form:label>
    <form:input class="form-control" path="name" /> <br>

    <form:label path="email">
        Email
    </form:label>
    <form:input class="form-control" path="email" /> <br>

    <form:label path="phone">
        Phone
    </form:label>
    <form:input class="form-control" path="phone"/> <br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Зарегистрировать пользователя</button>
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</body>
</html>