<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Пользователи</title>
</head>
<body>


<h2>Список всех объявлений<h2>

<a href="/registration">Регистрация</a>
<br>
<a href="/login">Авторизация</a>
<br>
<a href="/ad/new">Добавить своё объявление</a>

<b style="float: right">${pageContext.request.userPrincipal.name}</b>



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

</body>
</html>