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
    <title>Пользователи</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>




<h2>Список всех объявлений<h2>


        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="/registration">Регистрация</a>
            <br>
            <a href="/login">Авторизация</a>
            <br>
            <a href="/ad/new">Добавить своё объявление</a>
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
            <table class="data">
                <c:forEach items="${listAd}" var="ad">
                    <tr>
                        <td><a href="/ad/${ad.id}">${ad.name}</a></td>
                        <td>${ad.price}</td>
                        <td>${ad.info}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>


            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>