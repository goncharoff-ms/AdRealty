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

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <a href="/ad/new">Добавить своё объявление</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

    <h4 class="text-right"> ${pageContext.request.userPrincipal.name} |
        <a onclick="document.forms['logoutForm'].submit()">Выйти из аккаунта</a></h4>
</c:if>

<a href="/ad">Всё обьявления</a>

<form:form class="form-signin" method="post" action="/image/add/" commandName="image" enctype="multipart/form-data">
    <input type="hidden" name="adId" value="${adId}">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <input type="file" name="file" id="file" />
    <button class="btn btn-lg btn-primary btn-block" type="submit">Добавить фото</button>
</form:form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>