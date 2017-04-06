<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://tiles.apache.org/tags-tiles" %>

<div id="addAd" class="container">
    <div class="col-md-8"></div>
    <div class="col-md-4"><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/ad/new" ><b>+</b>ПОДАТЬ ОБЪЯВЛЕНИЕ</a></div>
</div>


<!-- Page Content -->
<div class="container">
    <c:if test="${!empty listAd}">
        <c:forEach items="${listAd}" var="ad">
            <div class="row">
                <div class="col-md-7">
                    <a href="/ad/${ad.id}">
                        <c:if test="${ad.haveImage == 1}">
                            <img class="img-fluid rounded mb-3 mb-md-0" src="/image/${ad.id}"/>
                        </c:if>
                        <c:if test="${ad.haveImage != 1}">
                            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/800x300"/>
                        </c:if>
                    </a>
                </div>
                <div class="col-md-5">
                    <h3>${ad.name}</h3>
                    <p>${ad.price}</p>
                    <p class="ssv-small-label">${ad.price}$</p>
                    <a class="btn btn-primary" href="/ad/${ad.id}">Открыть</a>
                </div>
            </div>
            <!-- /.row -->
            <hr>
        </c:forEach>
    </c:if>


    <!--
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>
        <li class="page-item">
            <a class="page-link" href="#">1</a></li>
        <li class="page-item">
            <a class="page-link" href="#">2</a></li>
        <li class="page-item">
            <a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>
    -->
</div>
<!-- /.container -->










