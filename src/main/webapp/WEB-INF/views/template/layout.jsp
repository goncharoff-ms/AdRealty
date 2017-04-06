<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${contextPath}/resources/ico/favicon.ico">

    <title><tiles:insertAttribute name="title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="${contextPath}/resources/js/modernizr.js"></script>
</head>

<body>

<!-- Fixed navbar -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/ad">AdRealty</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
            <ul class="nav navbar-nav">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a href="/index">ГЛАВНАЯ</a></li>
                    <li><a href="/ad">ОБЪЯВЛЕНИЯ</a></li>
                    <li><a href="contact.html">КОНТАКТЫ</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${pageContext.request.userPrincipal.name}<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="blog.html">ПРОФИЛЬ</a></li>
                            <li><a href="/logout">ВЫЙТИ</a></li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="/index">ГЛАВНАЯ</a></li>
                    <li><a href="/ad">ОБЪЯВЛЕНИЯ</a></li>
                    <li><a href="contact.html">КОНТАКТЫ</a></li>
                    <li><a href="/login">ВОЙТИ</a></li>
                    <li><a href="/registration">РЕГИСТРАЦИЯ</a></li>

                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<!-- *****************************************************************************************************************
 BLUE WRAP
 ***************************************************************************************************************** -->
<div id="blue">
    <div class="container">
        <div class="row">
            <h3><tiles:insertAttribute name="title"/></h3>
        </div><!-- /row -->
    </div> <!-- /container -->
</div><!-- /blue -->


<tiles:insertAttribute name="body"/>



<!-- *****************************************************************************************************************
 FOOTER
 ***************************************************************************************************************** -->
<div id="footerwrap">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <h4>About</h4>
                <div class="hline-w"></div>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.</p>
            </div>
            <div class="col-lg-4">
                <h4>Social Links</h4>
                <div class="hline-w"></div>
                <p>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                    <a href="#"><i class="fa fa-tumblr"></i></a>
                </p>
            </div>
            <div class="col-lg-4">
                <h4>Our Bunker</h4>
                <div class="hline-w"></div>
                <p>
                    Some Ave, 987,<br/>
                    23890, New York,<br/>
                    United States.<br/>
                </p>
            </div>

        </div><! --/row -->
    </div><! --/container -->
</div><! --/footerwrap -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/retina-1.1.0.js"></script>
<script src="${contextPath}/resources/js/jquery.hoverdir.js"></script>
<script src="${contextPath}/resources/js/jquery.hoverex.min.js"></script>
<script src="${contextPath}/resources/js/jquery.prettyPhoto.js"></script>
<script src="${contextPath}/resources/js/jquery.isotope.min.js"></script>
<script src="${contextPath}/resources/js/custom.js"></script>


</body>
</html>

