<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>${ad.name}</title>
</head>
<body>


<a href="/ad">Всё обьявления</a>
<b style="float: right">${pageContext.request.userPrincipal.name}</b>
<h2>${ad.name}<h2>
    <h3>${ad.info}</h3>
    <h3>${ad.price}</h3>
    <h3>Данные владельца</h3>
    <h3>${owner.name}</h3>
    <h3>${owner.email}</h3>
    <h3>${owner.phone}</h3>

</body>
</html>