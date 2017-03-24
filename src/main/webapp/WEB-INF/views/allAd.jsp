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
    <title>Пользователи</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        body {
            padding: 50px 50px;
        }
        div {
            margin-left:auto;
            margin-right:auto;
            background-color: #e8e8e8;
        }
    </style>
</head>
<body>




<h2>Список всех объявлений<h2>

        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="/registration">Регистрация</a>
            <br>
            <a href="/login">Авторизация</a>
            <br>
            <a href="/ad/new">Добавить своё объявление</a>

            <a href="/admin/all/images">Все изображения</a>
        </c:if>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a href="/ad/new">Добавить своё объявление</a>
            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <h4 class="text-right"> ${pageContext.request.userPrincipal.name} |
                <a onclick="document.forms['logoutForm'].submit()">Выйти из аккаунта</a></h4>
        </c:if>




            <h3>Обьявления!</h3>
        <c:if test="${!empty listAd}">
                <c:forEach items="${listAd}" var="ad">
                    <div class="hero-unit center-block">
                        <h2><a href="/ad/${ad.id}">${ad.name}</a></h2>
                        <p>${ad.price}</p>
                        <p class="text-info">${ad.info}</p>
                    </div>
                </c:forEach>
        </c:if>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>