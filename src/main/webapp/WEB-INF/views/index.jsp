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


<h2>Список пользователей</h2>

<a href="/registration">Регистрация</a>




<h3>Users</h3>

<c:if test="${!empty userList}">
    <table class="data">
        <tr>
            <th>Логин</th>
            <th>Пароль</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>