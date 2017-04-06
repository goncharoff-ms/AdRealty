<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>

<div class="container mtb">
    <div class="row">

        <! -- SINGLE POST -->
        <div class="col-lg-8">
            <! -- Blog Post 1 -->

            <p> <c:if test="${ad.haveImage == null}">
                <img class="img-responsive" src="/resources/img/post03.jpg">
                </c:if>

                <c:if test="${ad.haveImage == 1}">
                    <img class="img-responsive" src="/image/${ad.id}">
                </c:if>
            </p>
            <a href="/ad/${ad.id}"><h3 class="ctitle">${ad.name}</h3></a>
            <p><csmall>Размещено: ${ad.date}</csmall> | <csmall2>Просмотров: ${ad.numberShow}</csmall2></p>
            <p>
                Тип объявления : ${ad.typeAd}
            </p>
            <p>
                Тип недвижемости : ${ad.realty}
            </p>
            <p>
                Дополнительная информация: ${ad.info}
            </p>
            <p>
                Площадь: ${ad.sqare}
            </p>
            <p>
                Город : ${ad.sity} <br>
                Улица : ${ad.street} <br>
                Дом/Квартира : ${ad.houseNumber}
            </p>
            <div class="spacing"></div>
            <h6>SHARE:</h6>
            <p class="share">
                <a href="#"><i class="fa fa-twitter"></i></a>
                <a href="#"><i class="fa fa-facebook"></i></a>
                <a href="#"><i class="fa fa-tumblr"></i></a>
                <a href="#"><i class="fa fa-google-plus"></i></a>
            </p>

        </div><! --/col-lg-8 -->


        <! -- SIDEBAR -->
        <div class="col-lg-4">
            <h4>Информация о владельце: </h4>
            <div class="hline"></div>
            <p>
                Автор объявления: ${owner.name}
            </p>
            <p>
                Email: ${owner.email}
            </p>
            <p>
                Телефон: ${owner.phone}
            </p>
        </div>
    </div><! --/row -->
</div><! --/container -->
