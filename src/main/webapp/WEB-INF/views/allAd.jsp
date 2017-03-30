<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Список всех объявлений<h2>

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
    