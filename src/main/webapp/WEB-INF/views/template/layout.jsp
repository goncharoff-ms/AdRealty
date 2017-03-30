<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ru">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <meta name="description" content="ONE Bootstrap Theme is incredibly powerfull and responsive template with modern and ONE design. ONE has many great features like: awesome LayerSlider 4 ($50), FlexSlider 2, 400+ Glyphicons PRO ($59), 200+ Font Awesome Icons, Social Icons, Charts, Retina Display Support and many. If you buy now ONE Bootstrap Theme you save $94."/>
    <meta name="keywords" content="Bootstrap Theme, Bootstrap Template, Bootstrap, Responsive Theme, Responsive Template, Retina Display, ONE Design, Glyphicons, LayerSlider, FlexSlider, Font Awesome, Icons, Portfolio, Business, WrapBootstrap, Responsive" />
    <meta name="author" content="Łukasz Holeczek from creativeLabs"/>
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: Facebook Open Graph -->
    <meta property="og:title" content=""/>
    <meta property="og:description" content=""/>
    <meta property="og:type" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:image" content=""/>
    <!-- end: Facebook Open Graph -->

    <!-- start: CSS -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/style-responsive.css" rel="stylesheet" type="text/css">

    <!--[if lt IE 9 ]>
    <link href="/resources/css/styleIE.css" rel="stylesheet">
    <![endif]-->
    <!-- end: CSS -->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- start: Favicon and Touch Icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${contextPath}/resources/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${contextPath}/resources/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${contextPath}/resources/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${contextPath}/resources/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="${contextPath}/resources/ico/favicon.png">
    <!-- end: Favicon and Touch Icons -->
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>

<body>


<header>
    <!--start: Container -->
    <div class="container">
        <!--start: Navigation -->
        <div class="navbar">
            <div class="navbar-inner">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="/index">ONE</a>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <div class="nav-collapse collapse">
                        <ul class="nav scroll-nav">
                            <li><a href="/index">Главная</a></li>
                            <li><a href="/ad">Объявления</a></li>
                            <li><a href="/login">Авторизация</a></li>
                            <li><a href="/registration">Регистрация</a></li>
                            <li><a href="/contacts">Контакты</a></li>
                        </ul>
                    </div>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">

                    <div class="nav-collapse collapse">
                        <ul class="nav scroll-nav">
                            <li><a href="/index">Главная</a></li>
                            <li><a href="/ad">Объявления</a></li>
                            <li><a href="/contacts">Контакты</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext.request.userPrincipal.name}<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/myprofile">Личный кабинет</a></li>
                                    <li><a href="/logout">Выйти</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </c:if>
            </div>
        </div>
        <!-- end: Navigation -->

    </div>
    <!-- end: Container -->
</header>

<!-- start: Body -->
<tiles:insertAttribute name="body"/>
<!-- start: Body -->

<!-- start: Footer -->
<footer>
    <!-- start: Container -->
    <div class="container">
        <!-- start: Row -->
        <div class="row-fluid">
            <!-- start: Footer Navigation -->
            <div class="span12 nav">
            </div>
            <!-- end: Footer Navigation -->
        </div>
        <!-- end: Row -->
        <!-- start: Row -->
        <div class="row-fluid">
        </div>
        <!-- end: Row -->
    </div>
    <!-- end: Container  -->
</footer>
<!-- end: Footer -->
<!-- start: Copyright -->
<div id="copyright">
    <!-- start: Container -->
    <div class="container">
        <!-- start: Row -->
        <div class="row-fluid">

            <!-- start: Owner -->
            <div id="owner" class="span6">

                &copy; 2013, <a href="http://bootstrapmaster.com" alt="Bootstrap Themes">creativeLabs</a>.
                Designed by <a href="http://bootstrapmaster.com" alt="Bootstrap Templates">Bootstrap Master</a> in Poland
                <img src="${contextPath}/resources/img/poland.png" class="img-retina" alt="Poland" style="margin-top:-4px">

            </div>
            <!-- end: Owner -->

            <!-- start: Follow Us -->
            <div id="follow" class="span6">
                Follow Us:
                <a href="#" class="social-dribbble"></a>
                <a href="http://twitter.com/BootstrapMaster" class="social-twitter"></a>
                <a href="#" class="social-flickr"></a>
                <a href="http://facebook.com/BootstrapMaster" class="social-facebook"></a>
                <a href="#" class="social-youtube"></a>
            </div>
            <!-- end: Follow Us -->
        </div>
        <!-- end: Row -->
    </div>
    <!-- end: Container -->
</div>
<!-- end: Copyright -->
<!-- start: Java Script -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script src="${contextPath}/resources/js/jquery.isotope.min.js"></script>
<script src="${contextPath}/resources/js/jquery.imagesloaded.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/flexslider.js"></script>
<script src="${contextPath}/resources/js/carousel.js"></script>
<script src="${contextPath}/resources/js/jquery.fancybox.js"></script>
<script src="${contextPath}/resources/js/twitter.js"></script>
<script src="${contextPath}/resources/js/jquery.placeholder.min.js"></script>

<script src="${contextPath}/resources/js/jquery-easing-1.3.js"></script>
<script src="${contextPath}/resources/js/jquery-transit-modified.js"></script>
<script src="${contextPath}/resources/js/layerslider.transitions.js"></script>
<script src="${contextPath}/resources/js/layerslider.kreaturamedia.jquery.js"></script>

<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="${contextPath}/resources/js/jquery.gmap.min.js"></script>

<script src="${contextPath}/resources/js/less-1.3.3.min.js"></script>

<script defer="defer" src="${contextPath}/resources/js/modernizr.js"></script>
<script defer="defer" src="${contextPath}/resources/js/custom.js"></script>
<!-- end: Java Script -->

</body>
</html>







